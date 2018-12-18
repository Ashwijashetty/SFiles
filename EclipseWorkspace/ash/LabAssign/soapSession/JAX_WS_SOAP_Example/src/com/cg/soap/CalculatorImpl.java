package com.cg.soap;

import javax.jws.WebService;

@WebService(endpointInterface="com.cg.soap.Calculator")
public class CalculatorImpl implements Calculator{

	@Override
	public int add(int num1, int num2) {
		return num1+num2;
	}

	@Override
	public int sub(int num1, int num2) {
		return Math.abs(num1-num2);
	}

}
