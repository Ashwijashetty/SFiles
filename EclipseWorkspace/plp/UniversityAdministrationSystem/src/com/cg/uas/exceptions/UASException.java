package com.cg.uas.exceptions;

public class UASException extends Exception{
private String message;
public UASException(String message){
	super();
	this.message=message;
}
public String getMessage(){
	return message;
}
}
