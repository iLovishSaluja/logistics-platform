package com.lovish.logistic.platform.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterRequestDto {

	@NotBlank(message = "username cannot be empty")
	@Size(min = 5, max = 30, message = "username must be between 5 and 30 characters")
	private String username;

	@NotBlank(message = "email cannot be empty")
	@Email(message = "invalid email format")
	private String email;

	@NotBlank(message = "password is mandatory")
	@Size(min = 8, message = "password must have at least 8 characters")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&]).*$", message = "Password must contain uppercase, lowercase, number and special character")
	private String password;

	public RegisterRequestDto() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}