package com.cg.ems.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.ems.entity.Employee;
@Repository
@Transactional
public class EmployeeDao implements IEmployeeDao{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Employee addDetails(Employee employee) {
		entityManager.persist(employee);
		entityManager.flush();
		return employee;
	}

	@Override
	public List<Employee> getDetails() {
TypedQuery<Employee> query=entityManager.createQuery("select e from Employee e",Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee getsingleDetail(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
