package com.lovish.logistic.platform.exception;


public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException() {
		super("no user found with this id:");
	}
}
