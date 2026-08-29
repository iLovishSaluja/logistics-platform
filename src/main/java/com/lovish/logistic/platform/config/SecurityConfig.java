package com.lovish.logistic.platform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.lovish.logistic.platform.oauth.GoogleOAuth2SuccessHandler;
import com.lovish.logistic.platform.security.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {

	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	private final GoogleOAuth2SuccessHandler googleOAuth2SuccessHandler;

	public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter,
			GoogleOAuth2SuccessHandler googleOAuth2SuccessHandler) {

		this.jwtAuthenticationFilter = jwtAuthenticationFilter;
		this.googleOAuth2SuccessHandler = googleOAuth2SuccessHandler;
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())

				.cors(Customizer.withDefaults())

				.authorizeHttpRequests(auth -> auth

						// Public authentication endpoints
						.requestMatchers("/auth/**", "/oauth2/**", "/login/**").permitAll()

						// Admin-only endpoints
						.requestMatchers("/api/admin/**").hasRole("ADMIN")

						// Delivery agent endpoints
						.requestMatchers("/api/delivery/**").hasAnyRole("DELIVERY_AGENT", "ADMIN")

						// Customer endpoints
						.requestMatchers("/api/customer/**").hasAnyRole("CUSTOMER", "ADMIN")

						// Everything else requires authentication
						.anyRequest().authenticated())

				.httpBasic(httpBasic -> httpBasic.disable())

				// Google OAuth2 login
				.oauth2Login(oauth2 -> oauth2.successHandler(googleOAuth2SuccessHandler))

				// JWT authentication
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}