package com.cg.Employee.exception;

public class ErrorDetails {
private String message;

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public ErrorDetails(String message) {
	super();
	this.message = message;
}

public ErrorDetails() {
	super();
	// TODO Auto-generated constructor stub
}

}
