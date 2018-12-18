package com.cg.da.dao;

import java.util.List;

import com.cg.da.beans.Employee;

public interface IDao {

	void addEmployee(Employee employee);

	Employee getDetails(int employee);

	void deleteDetails(Integer employeeId);

	Employee modifyDetails(Integer employeeId, Employee employee);

	List<Employee> getAll();

}
