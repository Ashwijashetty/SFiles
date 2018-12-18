package com.cg.ecdm.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Employee {

	private String employeeId;

	private String employeeName;
	
	private String employeePan;
	
	private String employeeDesignation;
	
	private String employeeDomain;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date employeeDOJ;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date employeeDOB;
	
	private double employeeSalary;
	
	private String employeeMailId;
	
	private String employeePassword;

	public Employee() {
	}

	public Employee(String employeeId, String employeeName, String employeePan,
			String employeeDesignation, String employeeDomain,
			Date employeeDOJ, Date employeeDOB, double employeeSalary,
			String employeeMailId, String employeePassword) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeePan = employeePan;
		this.employeeDesignation = employeeDesignation;
		this.employeeDomain = employeeDomain;
		this.employeeDOJ = employeeDOJ;
		this.employeeDOB = employeeDOB;
		this.employeeSalary = employeeSalary;
		this.employeeMailId = employeeMailId;
		this.employeePassword = employeePassword;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePan() {
		return employeePan;
	}

	public void setEmployeePan(String employeePan) {
		this.employeePan = employeePan;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public String getEmployeeDomain() {
		return employeeDomain;
	}

	public void setEmployeeDomain(String employeeDomain) {
		this.employeeDomain = employeeDomain;
	}

	public Date getEmployeeDOJ() {
		return employeeDOJ;
	}

	public void setEmployeeDOJ(Date employeeDOJ) {
		this.employeeDOJ = employeeDOJ;
	}

	public Date getEmployeeDOB() {
		return employeeDOB;
	}

	public void setEmployeeDOB(Date employeeDOB) {
		this.employeeDOB = employeeDOB;
	}

	public double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public String getEmployeeMailId() {
		return employeeMailId;
	}

	public void setEmployeeMailId(String employeeMailId) {
		this.employeeMailId = employeeMailId;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", employeePan=" + employeePan
				+ ", employeeDesignation=" + employeeDesignation
				+ ", employeeDomain=" + employeeDomain + ", employeeDOJ="
				+ employeeDOJ + ", employeeDOB=" + employeeDOB
				+ ", employeeSalary=" + employeeSalary + ", employeeMailId="
				+ employeeMailId + ", employeePassword=" + employeePassword
				+ "]";
	}

}

