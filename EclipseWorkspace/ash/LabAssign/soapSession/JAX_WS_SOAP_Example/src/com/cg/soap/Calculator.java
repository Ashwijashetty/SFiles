package com.cg.soap;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style=Style.RPC)
public interface Calculator {
public int add(int num1, int num2);
public int sub(int num1, int num2);
}
