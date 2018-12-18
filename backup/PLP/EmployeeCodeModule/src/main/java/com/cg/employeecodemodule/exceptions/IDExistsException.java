package com.cg.employeecodemodule.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IDExistsException extends RuntimeException {

 private static final long serialVersionUID = 1L;

public IDExistsException(String exception) {
    super(exception);
  }

}