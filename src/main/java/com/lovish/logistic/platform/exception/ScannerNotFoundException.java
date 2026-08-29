package com.lovish.logistic.platform.exception;

public class ScannerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ScannerNotFoundException(String id) {
		super("no scanner found with given id" + id);
	}
}
