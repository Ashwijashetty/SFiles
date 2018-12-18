package com.cg.da.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.da.beans.Employee;
import com.cg.da.dao.IDao;
@Service
@Transactional
public class ServiceImpl implements IService{

	@Autowired
	IDao dao;
	
	public IDao getDao() {
		return dao;
	}


	public void setDao(IDao dao) {
		this.dao = dao;
	}


	@Override
	public void addEmployee(Employee employee) {
		dao.addEmployee(employee);
		
	}


	@Override
	public Employee getDetails(int employee) {
		
		return dao.getDetails(employee);
	}


	@Override
	public void deleteDetails(Integer employeeId) {
	dao.deleteDetails(employeeId);
		
	}


	@Override
	public Employee modifyDetails(Integer employeeId, Employee employee) {
		
		return dao.modifyDetails(employeeId,employee);
	}


	@Override
	public List<Employee> getAll() {
		
		return dao.getAll();
	}

}
