package com.lovish.logistic.platform.exception;

public class HistoricalDataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HistoricalDataNotFoundException(String message) {
		super(message);
	}
}
