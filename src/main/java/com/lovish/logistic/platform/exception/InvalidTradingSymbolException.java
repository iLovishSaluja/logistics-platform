package com.lovish.logistic.platform.exception;

public class InvalidTradingSymbolException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidTradingSymbolException(String message) {
		super(message);
	}
}
