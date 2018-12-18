package com.cg.dms.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class HandleException {
	@ExceptionHandler(value={Exception.class})
public ModelAndView handleException(Exception e){
	String msg=e.getMessage();
	return new ModelAndView("error","message",msg);
	
}
}
