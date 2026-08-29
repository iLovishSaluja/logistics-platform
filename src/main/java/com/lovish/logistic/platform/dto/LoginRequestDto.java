package com.lovish.logistic.platform.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequestDto {

	@NotBlank(message = "enter username or email")
	private String emailOrUsername;

	@NotBlank(message = "password is mandatory")
	private String password;

	public LoginRequestDto() {
	}

	public String getEmailOrUsername() {
		return emailOrUsername;
	}

	public void setEmailOrUsername(String emailOrUsername) {
		this.emailOrUsername = emailOrUsername;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}