package com.cg.employeecodemodule.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.employeecodemodule.exceptions.IDExistsException;
import com.cg.employeecodemodule.models.Employee;
import com.cg.employeecodemodule.repository.EmployeeRepository;

@Repository
public class EmployeeDaoIMPL implements IEmployeeDao{
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee createData(Employee employee) {
		employee.setEmployeeId(employee.getEmployeeId());
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateData(Employee employee) {
		String employeeId = String.valueOf(employee.getEmployeeId());
		Employee employee2 =employeeRepository.findOne(employeeId);
		if(employee2.equals(null)){
			throw new IDExistsException("Entered Employee Id is Wrong"); 
		}
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> readAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee deleteData(long employeeId) {
		String employeeId1 = String.valueOf(employeeId);
		Employee employee = employeeRepository.findOne(employeeId1);
		if(employee.equals(null)){
			throw new IDExistsException("Entered Employee Id is Wrong"); 
		}
		employeeRepository.delete(employee);
		return employee;
	}

	@Override
	public Employee readData(long employeeId) {
		String employeeId1 = String.valueOf(employeeId);
		Employee employee = employeeRepository.findOne(employeeId1);
		if(employee.equals(null)){
			throw new IDExistsException("Entered Employee Id is Wrong"); 
		}
		return employee;
	}

}
