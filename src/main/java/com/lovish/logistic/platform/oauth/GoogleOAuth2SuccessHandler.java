package com.lovish.logistic.platform.oauth;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.lovish.logistic.platform.entity.User;
import com.lovish.logistic.platform.enums.AuthProvider;
import com.lovish.logistic.platform.enums.Role;
import com.lovish.logistic.platform.repository.UserRepository;
import com.lovish.logistic.platform.service.JwtService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class GoogleOAuth2SuccessHandler implements AuthenticationSuccessHandler {

	private final UserRepository userRepository;
	private final JwtService jwtService;

	public GoogleOAuth2SuccessHandler(UserRepository userRepository, JwtService jwtService) {
		this.userRepository = userRepository;
		this.jwtService = jwtService;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();

		String email = oauth2User.getAttribute("email");
		String name = oauth2User.getAttribute("name");

		User user = userRepository.findByEmail(email).orElse(null);

		// 1. First-time Google signup
		if (user == null) {

			user = new User();
			user.setEmail(email);
			user.setUsername(generateUniqueUsername(name, email));
			user.setAuthProvider(AuthProvider.GOOGLE);
			user.setRole(Role.CUSTOMER);
			user.setEnabled(true);
			user.setPassword(null);

			user = userRepository.save(user);

		} else {

			// 2. Existing LOCAL account with same email
			if (user.getAuthProvider() == AuthProvider.LOCAL) {
				response.setContentType("application/json");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				response.getWriter().write(
						"{\"status\":\"ERROR\",\"message\":\"An account already exists with this email using local credentials.\"}");
				return;
			}

			// 3. Existing Google account check if enabled
			if (!user.isEnabled()) {
				response.setContentType("application/json");
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				response.getWriter().write("{\"status\":\"ERROR\",\"message\":\"Account is disabled.\"}");
				return;
			}
		}

		// 4. Generate JWT tokens
		String accessToken = jwtService.generateAccessToken(user);
		String refreshToken = jwtService.generateRefreshToken(user);

		// 5. Return direct JSON response to the browser screen (No frontend required)
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("{" + "\"status\":\"SUCCESS\","
				+ "\"message\":\"User successfully authenticated and stored in MongoDB\"," + "\"accessToken\":\""
				+ accessToken + "\"," + "\"refreshToken\":\"" + refreshToken + "\"," + "\"username\":\""
				+ user.getUsername() + "\"," + "\"email\":\"" + user.getEmail() + "\"" + "}");
	}

	private String generateUniqueUsername(String name, String email) {

		String baseUsername;

		if (name != null && !name.isBlank()) {
			baseUsername = name.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		} else {
			baseUsername = email.substring(0, email.indexOf("@")).toLowerCase();
		}

		if (baseUsername.isBlank()) {
			baseUsername = "googleuser";
		}

		String username = baseUsername;
		int counter = 1;

		while (userRepository.existsByUsername(username)) {
			username = baseUsername + counter;
			counter++;
		}

		return username;
	}
}