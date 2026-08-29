package com.lovish.logistic.platform.mapper;

import com.lovish.logistic.platform.dto.AuthResponseDto;
import com.lovish.logistic.platform.dto.ProfileResponse;
import com.lovish.logistic.platform.dto.RegisterRequestDto;
import com.lovish.logistic.platform.dto.UserResponseDto;
import com.lovish.logistic.platform.entity.User;
import com.lovish.logistic.platform.enums.AuthProvider;
import com.lovish.logistic.platform.enums.Role;

public class UserMapper {

	public static User toEntity(RegisterRequestDto userDto) {

		User user = new User();

		user.setUsername(userDto.getUsername());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());

		// Defaults for normal registration
		user.setRole(Role.CUSTOMER);
		user.setAuthProvider(AuthProvider.LOCAL);
		user.setEnabled(true);

		return user;
	}

	public static UserResponseDto toResponseDto(User user) {

		UserResponseDto response = new UserResponseDto();

		response.setId(user.getId());
		response.setUsername(user.getUsername());
		response.setEmail(user.getEmail());
		response.setRole(user.getRole());
		response.setAuthProvider(user.getAuthProvider());
		response.setEnabled(user.isEnabled());

		return response;
	}

	public static ProfileResponse toProfileResponse(User user) {

		ProfileResponse response = new ProfileResponse();

		response.setId(user.getId());
		response.setUsername(user.getUsername());
		response.setEmail(user.getEmail());
		response.setRole(user.getRole());
		response.setAuthProvider(user.getAuthProvider());
		response.setEnabled(user.isEnabled());

		return response;
	}

	public static AuthResponseDto toAuthResponse(User user, String accessToken, String refreshToken) {

		AuthResponseDto response = new AuthResponseDto();

		response.setAccessToken(accessToken);
		response.setRefreshToken(refreshToken);
		response.setUsername(user.getUsername());
		response.setEmail(user.getEmail());
		response.setRole(user.getRole());
		response.setAuthProvider(user.getAuthProvider());

		return response;
	}
}