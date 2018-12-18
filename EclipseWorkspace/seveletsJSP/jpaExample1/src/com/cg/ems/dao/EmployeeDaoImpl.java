package com.cg.ems.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.ems.entities.EmployeeBean;

public class EmployeeDaoImpl {
	
public void InsertEmployee(EmployeeBean bean){
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("abc");
	EntityManager entityManager=factory.createEntityManager();
	entityManager.getTransaction().begin();
	
	entityManager.persist(bean);
	
	entityManager.getTransaction().commit();
	entityManager.close();
}

public EmployeeBean getEmployee(Integer empid){
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("abc");
	EntityManager entityManager=factory.createEntityManager();
	entityManager.getTransaction().begin();
	
EmployeeBean bean2=	entityManager.find(EmployeeBean.class,empid);
	
	entityManager.getTransaction().commit();
	entityManager.close();
	return bean2; 
}
public void merEmployee(){
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("abc");
	EntityManager entityManager=factory.createEntityManager();
	entityManager.getTransaction().begin();

	EmployeeBean bean1= new EmployeeBean(104,"Ram",10000d,"Java");
    entityManager.merge(bean1);

	entityManager.getTransaction().commit();
	entityManager.close();
	
}
public void delEmployee(Integer empid){
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("abc");
	EntityManager entityManager=factory.createEntityManager();
	entityManager.getTransaction().begin();
	EmployeeBean bean3=	entityManager.find(EmployeeBean.class,empid);
    entityManager.remove(bean3);
	entityManager.getTransaction().commit();
	entityManager.close();
	
}
public List<EmployeeBean> getallEmp(){
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("abc");
	EntityManager entityManager=factory.createEntityManager();
	entityManager.getTransaction().begin();
	List<EmployeeBean> list=new ArrayList<EmployeeBean>();
    String query="select e from EmployeeBean e";
	TypedQuery<EmployeeBean> tq= entityManager.createQuery(query,EmployeeBean.class);
    list=tq.getResultList();
	entityManager.close();
	
	return list; 
}
public List<EmployeeBean> getallemp1(Integer empId){
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("abc");
	EntityManager entityManager=factory.createEntityManager();
	entityManager.getTransaction().begin();
	List<EmployeeBean> lt=new ArrayList<EmployeeBean>();
	String query1="select e from EmployeeBean e where e.empId=:pempId";

	TypedQuery<EmployeeBean> tq1=entityManager.createQuery(query1,EmployeeBean.class);
    tq1.setParameter("pempId",empId);
	lt=tq1.getResultList();
	return lt;
	
}
}