package com.cg.lab.dao;

import java.util.List;

import com.cg.lab.bean.Employee;

public interface IEmployeeDao {
	public List<Employee> getEmpl();
	//public void getEmpDetails(int i);

	public List<Employee> getEmpDetails(int i);
}
