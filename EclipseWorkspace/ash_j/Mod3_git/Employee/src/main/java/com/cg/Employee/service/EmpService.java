package com.cg.Employee.service;

import java.util.List;

import com.cg.Employee.entity.Employee;

public interface EmpService {

public Employee addEmployee(Employee employee);

public List<Employee> getAll();

public Employee getById(String emp_id);

}
