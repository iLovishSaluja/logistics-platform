package com.lovish.logistic.platform.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashGenerator {

	public static void main(String[] args) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String password1 = "Admin@12345";

		String password2 = "Agent@12345";

		String password3 = "HubOperator@123";
		
		String password4 = "Agent@001";

		String hash1 = encoder.encode(password1);
		String hash2 = encoder.encode(password2);
		String hash3 = encoder.encode(password3);
		String hash4 = encoder.encode(password4);

		System.out.println("Password: " + password4);
		System.out.println("BCrypt Hash4: " + hash4);
		System.out.println("Matches: " + encoder.matches(password4, hash4));
	}
}