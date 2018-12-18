package com.cg.employeecodemodule.service;

import java.util.List;

import com.cg.employeecodemodule.models.Employee;

public interface IEmployeeService {

	Employee createData(Employee employee);

	Employee updateData(long employeeId, Employee employee);

	List<Employee> readAll();

	Employee deleteData(long employeeId);

	Employee readData(long employeeId);;

}
