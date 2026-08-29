package com.lovish.logistic.platform.exception;

public class EmailAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmailAlreadyExistsException(String email) {
		super(email + "already exists");
	}
}
