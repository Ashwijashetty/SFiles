package com.cg.ems.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.ems.exceptios.EMSException;
import com.cg.ems.model.Employee;

public class UIClass {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		EmployeeDAO dao = new EmployeeDAO();
		/*try {
			boolean flag = dao.createEmployeeTable();
			if (flag) {
				System.out.println("table created..");
			} else {
				System.out.println("not created");
			}
		} catch (EMSException e) {
			System.out.println(e.getMsg());
		}*/
		 //Employee employee=new Employee();
		
		//Multiple employee insert
		/* List<Employee> list=new ArrayList<>();
		System.out.println("Enter number of employee details :");
		int n=scanner.nextInt();
		for(int i=0;i<=n;i++){
		  System.out.println("Enter details"); 
		  scanner.nextLine();
		  System.out.println("Enter name :"); 
		  String name=scanner.nextLine();
		  System.out.println("Enter desig :"); 
		  String desig=scanner.nextLine();
		  System.out.println("Enter city :"); 
		  String city=scanner.nextLine();
		  System.out.println("Enter salary :"); 
		  double salary=scanner.nextDouble();
		 Employee employee =new Employee(name,desig,city,salary);
		 list.add(employee);
		 
		  employee.setName(name);
		  employee.setDesig(desig);
		  employee.setCity(city);
		  employee.setSalary(salary);
		  }
		  int result;
		  try {
			result=dao.addemployee(employee);
			if(result > 0){
				System.out.println("Inserted..");
							}else{
								System.out.println("Not inserted");
							}
		} catch (EMSException e) {
			System.err.println("ERROR not inserted");
		}*/
		
	}
}
