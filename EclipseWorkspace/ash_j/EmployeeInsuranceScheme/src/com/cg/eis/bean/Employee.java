package com.cg.eis.bean;

public class Employee {
private long id;
private String name;
private long salary;
private String designation;
private String insuranceScheme;
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Employee(long id, String name, long salary, String designation,
		String insuranceScheme) {
	super();
	this.id = id;
	this.name = name;
	this.salary = salary;
	this.designation = designation;
	this.insuranceScheme = insuranceScheme;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getSalary() {
	return salary;
}
public void setSalary(long salary) {
	this.salary = salary;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public String getInsuranceScheme() {
	return insuranceScheme;
}
public void setInsuranceScheme(String insuranceScheme) {
	this.insuranceScheme = insuranceScheme;
}
}
