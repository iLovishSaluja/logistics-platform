//
//package com.lovish.logistic.platform.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import com.lovish.logistic.platform.oauth.GoogleOAuth2SuccessHandler;
//import com.lovish.logistic.platform.security.JwtAuthenticationFilter;
//
//import jakarta.servlet.http.HttpServletResponse;
//
//@Configuration
//@EnableMethodSecurity
//public class SecurityConfig {
//
//	private final JwtAuthenticationFilter jwtAuthenticationFilter;
//	private final GoogleOAuth2SuccessHandler googleOAuth2SuccessHandler;
//
//	public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter,
//			GoogleOAuth2SuccessHandler googleOAuth2SuccessHandler) {
//
//		this.jwtAuthenticationFilter = jwtAuthenticationFilter;
//		this.googleOAuth2SuccessHandler = googleOAuth2SuccessHandler;
//	}
//
//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//		http.csrf(csrf -> csrf.disable()).cors(Customizer.withDefaults())
//
//				.authorizeHttpRequests(auth -> auth
//
//						// Public authentication endpoints
//						.requestMatchers("/auth/**", "/oauth2/**", "/login/**").permitAll()
//
//						// Public Razorpay test page
//						.requestMatchers("/razorpay-test.html").permitAll()
//
//						// Public webhook URL: signature is validated in webhook service
//						.requestMatchers(HttpMethod.POST, "/api/webhooks/razorpay").permitAll()
//
//						// Admin-only endpoints
//						.requestMatchers("/api/admin/**").hasRole("ADMIN")
//
//						// Hub Operator endpoints
//						.requestMatchers("/api/hub/**").hasAnyRole("HUB_OPERATOR", "ADMIN")
//
//						// Delivery Agent endpoints
//						.requestMatchers("/api/delivery/**").hasAnyRole("DELIVERY_AGENT", "ADMIN")
//
//						// Customer endpoints
//						.requestMatchers("/api/customer/**").hasAnyRole("CUSTOMER", "ADMIN")
//
//						// Everything else requires authentication
//						.anyRequest().authenticated())
//
//				.exceptionHandling(exception -> exception
//
//						// JSON 401 response for API requests
//						.defaultAuthenticationEntryPointFor((request, response, authException) -> {
//							response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//							response.setContentType("application/json");
//							response.setCharacterEncoding("UTF-8");
//
//							response.getWriter().write("""
//									{
//									  "status": 401,
//									  "error": "Unauthorized",
//									  "message": "Authentication is required"
//									}
//									""");
//						}, new AntPathRequestMatcher("/api/**"))
//
//						// JSON 403 response for insufficient permissions
//						.defaultAccessDeniedHandlerFor((request, response, accessDeniedException) -> {
//							response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//							response.setContentType("application/json");
//							response.setCharacterEncoding("UTF-8");
//
//							response.getWriter().write("""
//									{
//									  "status": 403,
//									  "error": "Forbidden",
//									  "message": "You do not have permission to access this resource"
//									}
//									""");
//						}, new AntPathRequestMatcher("/api/**")))
//
//				.httpBasic(httpBasic -> httpBasic.disable())
//
//				// Google OAuth2 login
//				.oauth2Login(oauth2 -> oauth2.successHandler(googleOAuth2SuccessHandler))
//
//				// JWT authentication
//				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//
//		return http.build();
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//}

package com.lovish.logistic.platform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.lovish.logistic.platform.oauth.GoogleOAuth2SuccessHandler;
import com.lovish.logistic.platform.security.JwtAuthenticationFilter;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableMethodSecurity
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

		http.csrf(csrf -> csrf.disable()).cors(Customizer.withDefaults()).authorizeHttpRequests(auth -> auth

				// Public authentication endpoints
				.requestMatchers("/auth/**", "/oauth2/**", "/login/**").permitAll()

				// Public Razorpay test page
				.requestMatchers("/razorpay-test.html").permitAll()

				// Public webhook URL: match both exact path and trailing slashes
				.requestMatchers(HttpMethod.POST, "/api/webhooks/razorpay", "/api/webhooks/razorpay/**").permitAll()

				// Admin-only endpoints
				.requestMatchers("/api/admin/**").hasRole("ADMIN")

				// Hub Operator endpoints
				.requestMatchers("/api/hub/**").hasAnyRole("HUB_OPERATOR", "ADMIN")

				// Delivery Agent endpoints
				.requestMatchers("/api/delivery/**").hasAnyRole("DELIVERY_AGENT", "ADMIN")

				// Customer endpoints
				.requestMatchers("/api/customer/**").hasAnyRole("CUSTOMER", "ADMIN")

				// Everything else requires authentication
				.anyRequest().authenticated())

				.exceptionHandling(exception -> exception

						// JSON 401 response for API requests
						.defaultAuthenticationEntryPointFor((request, response, authException) -> {
							response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
							response.setContentType("application/json");
							response.setCharacterEncoding("UTF-8");

							response.getWriter().write("""
									{
									  "status": 401,
									  "error": "Unauthorized",
									  "message": "Authentication is required"
									}
									""");
						}, new AntPathRequestMatcher("/api/**"))

						// JSON 403 response for insufficient permissions
						.defaultAccessDeniedHandlerFor((request, response, accessDeniedException) -> {
							response.setStatus(HttpServletResponse.SC_FORBIDDEN);
							response.setContentType("application/json");
							response.setCharacterEncoding("UTF-8");

							response.getWriter().write("""
									{
									  "status": 403,
									  "error": "Forbidden",
									  "message": "You do not have permission to access this resource"
									}
									""");
						}, new AntPathRequestMatcher("/api/**")))

				.httpBasic(httpBasic -> httpBasic.disable())

				// Google OAuth2 login
				.oauth2Login(oauth2 -> oauth2.successHandler(googleOAuth2SuccessHandler))

				// JWT authentication filter
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
