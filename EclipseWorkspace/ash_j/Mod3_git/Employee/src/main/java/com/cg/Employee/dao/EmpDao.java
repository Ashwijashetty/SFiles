package com.cg.Employee.dao;

import java.util.List;

import com.cg.Employee.entity.Employee;

public interface EmpDao {

public	Employee addEmployee(Employee employee);

public List<Employee> getAll();

public Employee getById(String emp_id);

}
