package com.cg.da.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "employee_121")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@SequenceGenerator(name="employeeId",initialValue=100000,allocationSize=1)
	private Integer employeeId;
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[a-z]{2,}", message = "Name should start with capitals only!!")
	private String employeeName;
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[a-z]{2,}", message = "Department should start with capitals only!!")
	private String employeeDepartment;

	@Range(min = 1, message = "Salary must be greater than 0")
	@NotNull
	private Double salary;

	public Employee(Integer employeeId, String employeeName,
			String employeeDepartment, Double salary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeDepartment = employeeDepartment;
		this.salary = salary;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
