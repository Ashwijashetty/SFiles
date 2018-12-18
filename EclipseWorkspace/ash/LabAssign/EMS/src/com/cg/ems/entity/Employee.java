package com.cg.ems.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "employee_table")
public class Employee {
	@Id
	@Range(min = 100000, max = 999999, message = "Id Number Should Accept Only 6 digits")
	private Integer id;

	@Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain only alphabets")
	private String name;
	//@Pattern(regexp = "^[0-9]+$", message = " ID should contain only digits")
	@Range(min = 1, max = 999999, message = "Salary Should be digits only")
	private Integer salary;
	@NotEmpty(message = "Please Enter Project Name")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Project Name must contain only alphabets")
	private String projectName;



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
				+ ", projectName=" + projectName + "]";
	}

	public Employee(Integer id, String name, Integer salary, String projectName) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.projectName = projectName;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}
