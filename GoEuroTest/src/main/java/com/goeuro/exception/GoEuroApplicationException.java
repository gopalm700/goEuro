package com.goeuro.exception;

public class GoEuroApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public GoEuroApplicationException() {
	}

	public GoEuroApplicationException(String message) {
		super(message);
	}

	public GoEuroApplicationException(Throwable throwable) {
		super(throwable);
	}

	public GoEuroApplicationException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
