package com.cg.da.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.da.beans.Employee;

@Repository
public class DaoImpl implements IDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void addEmployee(Employee employee) {
		entityManager.persist(employee);
		entityManager.flush();

	}

	@Override
	public Employee getDetails(int employee) {
		Employee employees=entityManager.find(Employee.class, employee);
		return employees;
	}

	@Override
	public void deleteDetails(Integer employeeId) {
		Employee employees=entityManager.find(Employee.class, employeeId);
		entityManager.remove(employees);
	}

	@Override
	public Employee modifyDetails(Integer employeeId, Employee employee) {
		Employee employees=entityManager.find(Employee.class, employeeId);
		entityManager.merge(employee);
		return employees;
	}

	@Override
	public List<Employee> getAll() {
		TypedQuery<Employee> query=entityManager.createQuery("select e from Employee e",Employee.class );
		return query.getResultList();
	}

}
