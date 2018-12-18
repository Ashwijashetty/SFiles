package com.cg.ecm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ECMException extends Exception{
public ECMException(String Exception){
	super(Exception);
}
}
