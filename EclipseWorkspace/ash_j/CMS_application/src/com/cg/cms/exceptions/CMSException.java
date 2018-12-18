package com.cg.cms.exceptions;

public class CMSException extends Exception {
private String message;

public String getMessage() {
	return message;
}

public CMSException(String message) {
	super();
	this.message = message;
}
}
