package com.cg.ems.service;

import java.util.List;

import com.cg.ems.entity.Employee;

public interface IEmployeeService {

	Employee addDetails(Employee employee);

	List<Employee> getDetails();

	Employee getsingleDetail(Integer id);

}
