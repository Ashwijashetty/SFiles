package com.cg.bms.model;

import java.util.Date;

public class Account {
private long accountNo;
private String type;
private String customerName;
private double balance;
private Date date;public Account() {
	// TODO Auto-generated constructor stub
}
public long getAccountNo() {
	return accountNo;
}
public void setAccountNo(long accountNo) {
	this.accountNo = accountNo;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public Account(long accountNo, String type, String customerName,
		double balance, Date date) {
	super();
	this.accountNo = accountNo;
	this.type = type;
	this.customerName = customerName;
	this.balance = balance;
	this.date = date;
}
public Account(String type, String customerName, double balance, Date date) {
	super();
	this.type = type;
	this.customerName = customerName;
	this.balance = balance;
	this.date = date;
}

}
