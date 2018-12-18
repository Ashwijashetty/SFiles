package com.cg.lab.service;

import java.util.List;

import com.cg.lab.bean.Employee;
import com.cg.lab.dao.EmployeeDao;

public interface IEmployeeService {

	public List<Employee> getEmpDetails(int i);
	//public EmployeeDao getDao();
}
