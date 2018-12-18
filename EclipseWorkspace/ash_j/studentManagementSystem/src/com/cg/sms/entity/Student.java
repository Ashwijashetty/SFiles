package com.cg.sms.entity;

import java.util.Scanner;



public class Student {
private String studentName;
private long studentId;
private long studentPhoneNum;
private String studentEmailId;
private String studentCity;

public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public long getStudentId() {
	return studentId;
}
public void setStudentId(long studentId) {
	this.studentId = studentId;
}
public long getStudentPhoneNum() {
	return studentPhoneNum;
}
public void setStudentPhoneNum(long studentPhoneNum) {
	this.studentPhoneNum = studentPhoneNum;
}
public String getStudentEmailId() {
	return studentEmailId;
}
public void setStudentEmailId(String studentEmailId) {
	this.studentEmailId = studentEmailId;
}
public String getStudentCity() {
	return studentCity;
}
public void setStudentCity(String studentCity) {
	this.studentCity = studentCity;
}
public Student(String studentName, int studentId, int studentPhoneNum,
		String studentEmailId, String studentCity) {
	super();
	this.studentName = studentName;
	this.studentId = studentId;
	this.studentPhoneNum = studentPhoneNum;
	this.studentEmailId = studentEmailId;
	this.studentCity = studentCity;
}
public Student() {
	super();
}	
}

