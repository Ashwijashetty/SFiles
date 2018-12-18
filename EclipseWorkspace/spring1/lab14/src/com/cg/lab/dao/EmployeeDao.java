package com.cg.lab.dao;

import java.util.Iterator;
import java.util.List;

import com.cg.lab.bean.Employee;

public class EmployeeDao implements IEmployeeDao{
private List<Employee> empl;

public List<Employee> getEmpl() {
	return empl;
}

public void setEmpl(List<Employee> empl) {
	this.empl = empl;
}

public EmployeeDao() {
	super();
	// TODO Auto-generated constructor stub
}

/*public EmployeeDao(List<Employee> empl) {
	super();
	this.empl = empl;
}*/

public List<Employee> getEmpDetails(int i) {
	for(Employee emp:empl){
		if(emp.getEmployeeId()==i){
		/*	System.out.println(emp.getEmployeeId()+" "+emp.getEmployeeName()
					+" "+emp.getAge()+" "+emp.getSalary());*/
		System.out.println("Details are :"+emp);
		}

}
	return empl;
	}
}
