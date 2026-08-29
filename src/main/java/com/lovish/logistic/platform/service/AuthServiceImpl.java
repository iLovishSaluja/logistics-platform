package com.lovish.logistic.platform.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lovish.logistic.platform.dto.AuthResponseDto;
import com.lovish.logistic.platform.dto.LoginRequestDto;
import com.lovish.logistic.platform.dto.RegisterRequestDto;
import com.lovish.logistic.platform.entity.User;
import com.lovish.logistic.platform.exception.EmailAlreadyExistsException;
import com.lovish.logistic.platform.exception.InvalidCredentialsException;
import com.lovish.logistic.platform.exception.UserNotFoundException;
import com.lovish.logistic.platform.exception.UsernameAlreadyExistsException;
import com.lovish.logistic.platform.mapper.UserMapper;
import com.lovish.logistic.platform.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

	private final UserRepository userRepo;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;

	public AuthServiceImpl(UserRepository userRepo, PasswordEncoder passwordEncoder, JwtService jwtService) {

		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
	}

	@Override
	public AuthResponseDto register(RegisterRequestDto dto) {

		if (userRepo.existsByUsername(dto.getUsername())) {
			throw new UsernameAlreadyExistsException(dto.getUsername());
		}

		if (userRepo.existsByEmail(dto.getEmail())) {
			throw new EmailAlreadyExistsException(dto.getEmail());
		}

		User user = UserMapper.toEntity(dto);

		// Hash password before saving
		user.setPassword(passwordEncoder.encode(dto.getPassword()));

		User savedUser = userRepo.save(user);

		String accessToken = jwtService.generateAccessToken(savedUser);
		String refreshToken = jwtService.generateRefreshToken(savedUser);

		return UserMapper.toAuthResponse(savedUser, accessToken, refreshToken);
	}

	@Override
	public AuthResponseDto login(LoginRequestDto dto) {

		User user = userRepo.findByEmailOrUsername(dto.getEmailOrUsername(), dto.getEmailOrUsername())
				.orElseThrow(UserNotFoundException::new);

		// Check whether account is enabled
		if (!user.isEnabled()) {
			throw new InvalidCredentialsException();
		}

		// Verify password
		if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {

			throw new InvalidCredentialsException();
		}

		String accessToken = jwtService.generateAccessToken(user);
		String refreshToken = jwtService.generateRefreshToken(user);

		return UserMapper.toAuthResponse(user, accessToken, refreshToken);
	}
}