package com.cg.ems.model;

import java.io.Serializable;

public class Employee implements Serializable {
	private int id;
	private String name;
	private String desig;
	private String city;
	private double salary;

	public Employee(int id, String name, String desig, String city,
			double salary) {
		super();
		this.id = id;
		this.name = name;
		this.desig = desig;
		this.city = city;
		this.salary = salary;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(String name, String desig, String city, double salary) {
		super();
		this.name = name;
		this.desig = desig;
		this.city = city;
		this.salary = salary;
	}

}
