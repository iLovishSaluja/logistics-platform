package com.lovish.logistic.platform.exception;

public class MarketDataUnavailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MarketDataUnavailableException(String message) {
		super(message);
	}
}
