package com.cg.lab.service;

//import com.cg.lab.Employee;

import java.util.List;

import com.cg.lab.bean.Employee;
import com.cg.lab.dao.EmployeeDao;
import com.cg.lab.dao.IEmployeeDao;

public class EmployeeService implements IEmployeeService {

private IEmployeeDao dao;

public IEmployeeDao getDao() {
	return dao;
}

public void setDao(IEmployeeDao dao) {
	this.dao = dao;
}


public List<Employee> getEmpDetails(int i) {
	return dao.getEmpDetails(i);

	
}
}
