package com.cg.ems.dao;

import java.util.List;

import com.cg.ems.entity.Employee;

public interface IEmployeeDao {

	Employee addDetails(Employee employee);

	List<Employee> getDetails();

	Employee getsingleDetail(Integer id);

}
