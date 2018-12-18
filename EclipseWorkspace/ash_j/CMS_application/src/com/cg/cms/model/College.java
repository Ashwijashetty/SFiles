package com.cg.cms.model;

import java.util.Date;

public class College {
private int id;
private String name;
private double phoneNum;
private String email;
private Date date;
public College() {
	super();
	// TODO Auto-generated constructor stub
}
public College(int id, String name, double phoneNum, String email, Date date) {
	super();
	this.id = id;
	this.name = name;
	this.phoneNum = phoneNum;
	this.email = email;
	this.date = date;
}
public College(String name, double phoneNum, String email, Date date) {
	super();
	this.name = name;
	this.phoneNum = phoneNum;
	this.email = email;
	this.date = date;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getPhoneNum() {
	return phoneNum;
}
public void setPhoneNum(double phoneNum) {
	this.phoneNum = phoneNum;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
}
