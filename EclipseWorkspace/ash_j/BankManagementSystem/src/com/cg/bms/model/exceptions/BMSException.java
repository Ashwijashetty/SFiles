package com.cg.bms.model.exceptions;

public class BMSException extends Exception {
private String message;

public BMSException(String message) {
	super();
	this.message = message;
}

public String getMessage() {
	return message;
}


}
