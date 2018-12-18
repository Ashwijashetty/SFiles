package com.cg.sa.Trial.model;

public class Student {
private String name;
private String rollno;
private String age;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRollno() {
	return rollno;
}
public void setRollno(String rollno) {
	this.rollno = rollno;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public Student(String name, String rollno, String age) {
	super();
	this.name = name;
	this.rollno = rollno;
	this.age = age;
}
public Student() {
	super();
	// TODO Auto-generated constructor stub
}

}
