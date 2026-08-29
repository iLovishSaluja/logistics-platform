package com.lovish.logistic.platform.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lovish.logistic.platform.entity.User;
import com.lovish.logistic.platform.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepo;

	public CustomUserDetailsService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) {

		User user = userRepo.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));

		String password = user.getPassword();

		// Google users don't have a local password.
		if (password == null) {
			password = "";
		}

		return org.springframework.security.core.userdetails.User.withUsername(user.getUsername()).password(password)
				.roles(user.getRole().name()).disabled(!user.isEnabled()).build();
	}
}