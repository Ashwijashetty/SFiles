package com.capgemini.ars.exception;

public class AirlineException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;

	public AirlineException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}
