package com.cg.lab.client;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;






import com.cg.lab.bean.Employee;
import com.cg.lab.service.EmployeeService;
import com.cg.lab.service.IEmployeeService;

public class Client {
public static void main(String[] args) {
	Resource resource=new ClassPathResource("employee.xml");
	BeanFactory factory=new XmlBeanFactory(resource);
    IEmployeeService employeeService=(IEmployeeService) factory.getBean("employee1");
    System.out.println("Enter Id");
    Scanner scanner=new Scanner(System.in);
    int id=scanner.nextInt();
    List<Employee> list=employeeService.getEmpDetails(id); 
    //System.out.println("**"+list);
}
}
