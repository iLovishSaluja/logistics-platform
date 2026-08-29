package com.lovish.logistic.platform.exception;

public class InvalidCredentialsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidCredentialsException() {
		super("invalid username/email or password");	
	}
}
