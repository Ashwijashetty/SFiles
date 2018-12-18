package com.cg.da.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlers {
	@ExceptionHandler(value={Exception.class})
	public ModelAndView exceptionHandler(Exception e) {
		String msg=e.getMessage();
		return new ModelAndView("error","message",msg);
	}
	
	

}
