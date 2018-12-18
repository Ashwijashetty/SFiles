package com.cg.TDS.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TDSException extends RuntimeException{
public TDSException(String exception){
	super(exception);
}
}
