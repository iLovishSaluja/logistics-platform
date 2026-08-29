package com.lovish.logistic.platform.exception;

public class StockNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StockNotFoundException(String symbol) {
		super("No stock found with symbol" + symbol);
	}
}
