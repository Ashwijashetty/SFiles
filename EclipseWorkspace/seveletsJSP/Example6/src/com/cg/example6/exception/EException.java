package com.cg.example6.exception;

public class EException extends Exception  {
public static final String error1="internal error with driver";
public static final String error2="internal error with connection";
public EException() {
	super();
}
public EException(String error12) {
	
}

}
