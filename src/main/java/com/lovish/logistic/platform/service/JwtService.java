package com.lovish.logistic.platform.service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.lovish.logistic.platform.config.JwtConfig;
import com.lovish.logistic.platform.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	private final JwtConfig jwtConfig;

	public JwtService(JwtConfig jwtConfig) {
		this.jwtConfig = jwtConfig;
	}

	private SecretKey getSigningKey() {
		return Keys.hmacShaKeyFor(jwtConfig.getSecret().getBytes(StandardCharsets.UTF_8));
	}

	private Claims extractAllClaims(String token) {

		if (token != null && token.startsWith("Bearer ")) {
			token = token.substring(7).trim();
		}

		return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload();
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {

		final Claims claims = extractAllClaims(token);

		return claimsResolver.apply(claims);
	}

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public String extractRole(String token) {
		return extractClaim(token, claims -> claims.get("role", String.class));
	}

	public String extractTokenType(String token) {
		return extractClaim(token, claims -> claims.get("type", String.class));
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	public boolean isTokenValid(String token, UserDetails userDetails) {

		final String username = extractUsername(token);

		return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
	}

	public String generateAccessToken(User user) {

		return Jwts.builder().subject(user.getUsername()).claim("role", user.getRole().name()).claim("type", "ACCESS")
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + jwtConfig.getAccessTokenExpiration()))
				.signWith(getSigningKey()).compact();
	}

	public String generateRefreshToken(User user) {

		return Jwts.builder().subject(user.getUsername()).claim("role", user.getRole().name()).claim("type", "REFRESH")
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + jwtConfig.getRefreshTokenExpiration()))
				.signWith(getSigningKey()).compact();
	}
}