package com.cg.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.dao.IEmployeeDao;
import com.cg.ems.entity.Employee;
@Service
public class EmployeeService implements IEmployeeService{
@Autowired
	private IEmployeeDao dao;

	/*public IEmployeeDao getDao() {
	return dao;
}

public void setDao(IEmployeeDao dao) {
	this.dao = dao;
}*/

	@Override
	public Employee addDetails(Employee employee) {
		
		return dao.addDetails(employee);
	}

	@Override
	public List<Employee> getDetails() {
		
		return dao.getDetails();
	}

	@Override
	public Employee getsingleDetail(Integer id) {
		
		return dao.getsingleDetail(id);
	}

}
