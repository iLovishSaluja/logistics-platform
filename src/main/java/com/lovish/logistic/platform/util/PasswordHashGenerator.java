package com.lovish.logistic.platform.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashGenerator {

	public static void main(String[] args) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String password1 = "Admin@12345";

		String password2 = "Agent@12345";

		String hash1 = encoder.encode(password1);
		String hash2 = encoder.encode(password2);

		System.out.println("Password2: " + password2);
		System.out.println("BCrypt Hash2: " + hash2);
		System.out.println("Matches: " + encoder.matches(password2, hash2));
	}
}