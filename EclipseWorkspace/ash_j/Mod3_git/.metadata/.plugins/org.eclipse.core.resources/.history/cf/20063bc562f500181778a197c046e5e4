package com.cg.Employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.cg.Employee.entity.Employee;

@Repository
public class EmpDaoImpl implements EmpDao{
@Autowired
	private MongoTemplate mongotemplate;
	@Override
	public Employee addEmployee(Employee employee) {
		mongotemplate.save(employee);
		return employee;
	}
	@Override
	public List<Employee> getAll() {
		
		return mongotemplate.findAll(Employee.class);
	}
	@Override
	public Employee getById(String emp_id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(emp_id));
		return mongotemplate.findOne(query, Employee.class);
		
	}

}
