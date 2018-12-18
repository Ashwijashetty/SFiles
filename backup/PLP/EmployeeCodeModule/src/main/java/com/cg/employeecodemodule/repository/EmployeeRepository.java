package com.cg.employeecodemodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.employeecodemodule.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{

}
