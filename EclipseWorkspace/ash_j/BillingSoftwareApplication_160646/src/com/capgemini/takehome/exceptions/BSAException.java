package com.capgemini.takehome.exceptions;

public class BSAException extends Exception {
	public String message = "Invalid";

	public BSAException() {
		super();

	}

	public BSAException(String string) {

	}

	public String getMessage() {
		return message;
	}

}
