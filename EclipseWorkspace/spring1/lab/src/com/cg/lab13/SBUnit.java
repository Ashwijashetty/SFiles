package com.cg.lab13;

import java.util.Iterator;
import java.util.List;

public class SBUnit {
private int SbuId;
private String SbuName;
private String SbuHead;
private List<Employee> empl;
public int getSbuId() {
	return SbuId;
}
public void setSbuId(int sbuId) {
	SbuId = sbuId;
}
public String getSbuName() {
	return SbuName;
}
public void setSbuName(String sbuName) {
	SbuName = sbuName;
}
public String getSbuHead() {
	return SbuHead;
}
public void setSbuHead(String sbuHead) {
	SbuHead = sbuHead;
}
public List<Employee> getEmpl() {
	return empl;
}
public void setEmpl(List<Employee> empl) {
	this.empl = empl;
}
public SBUnit(int sbuId, String sbuName, String sbuHead, List<Employee> empl) {
	super();
	SbuId = sbuId;
	SbuName = sbuName;
	SbuHead = sbuHead;
	this.empl = empl;
}
public SBUnit() {
	super();
	// TODO Auto-generated constructor stub
}
public void getDetails() {
	System.out.println("The Details are: ");
	System.out.println("SB Unit Id:"+SbuId+"SB Unit Head: "+SbuHead+"SB Unit Name"+SbuName);
Iterator<Employee> itr=empl.iterator();
while(itr.hasNext()){
	System.out.println(itr.next());
}
}
public void getById(int empId) {
	for(Employee emp:empl){
		if(emp.getEmployeeId()==empId){
			System.out.println(emp.getEmployeeId()+emp.getEmployeeName()
					+emp.getAge()+emp.getSalary());
		}
	}
	
}
 
}
