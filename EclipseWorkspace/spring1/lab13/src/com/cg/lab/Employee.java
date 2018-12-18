 package com.cg.lab;

public class Employee {
private int EmployeeId;
private String EmployeeName;
private double salary;
private int age;
public int getEmployeeId() {
	return EmployeeId;
}
public void setEmployeeId(int employeeId) {
	EmployeeId = employeeId;
}
public String getEmployeeName() {
	return EmployeeName;
}
public void setEmployeeName(String employeeName) {
	EmployeeName = employeeName;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
@Override
public String toString() {
	return "Employee [EmployeeId=" + EmployeeId + ", EmployeeName="
			+ EmployeeName + ", salary=" + salary + ", age=" + age + "]";
}
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Employee(int employeeId, String employeeName, double salary, int age) {
	super();
	EmployeeId = employeeId;
	EmployeeName = employeeName;
	this.salary = salary;
	this.age = age;
}

}
