package com.cg.lab1;

import org.springframework.beans.factory.*;
import org.springframework.beans.factory.xml.*;
import org.springframework.core.io.*;

public class EmpClient {

	public static void main(String[] args) {
		Resource res = new ClassPathResource("emp.xml");
		BeanFactory factory = new XmlBeanFactory(res);
		Employee employee = (Employee) factory.getBean("emp");
		
		System.out.println(employee);

	}

}
