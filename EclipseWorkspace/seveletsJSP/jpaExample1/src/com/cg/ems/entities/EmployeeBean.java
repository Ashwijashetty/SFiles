package com.cg.ems.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp11")
public class EmployeeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "empId")
	private Integer empId;
	@Column(name = "empname")
	private String empName;
	@Column(name = "salary")
	private Double salary;
	@Column(name = "projname")
	private String projName;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public EmployeeBean(Integer empId, String empName, Double salary,
			String projName) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.projName = projName;
	}

	public EmployeeBean() {
		super();
	}

	@Override
	public String toString() {
		return "EmployeeBean [empId=" + empId + ", empName=" + empName
				+ ", salary=" + salary + ", projName=" + projName + "]";
	}

}
