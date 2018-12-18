package com.cg.ems.exceptios;

public class EMSException extends Exception {

	private String msg;

	public EMSException(String msg) {

		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}
