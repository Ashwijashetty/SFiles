package com.cg.lab;

import java.util.Scanner;

import org.springframework.beans.factory.*;
import org.springframework.beans.factory.xml.*;
import org.springframework.core.io.*;
public class Client {
public static void main(String[] args) {
	Resource res=new ClassPathResource("sbu.xml");
	BeanFactory factory=new XmlBeanFactory(res);
	SBUnit sbUnit=(SBUnit) factory.getBean("SbUnit");
	sbUnit.getDetails();
	System.out.println("Enter id:");
	Scanner scanner=new Scanner(System.in);
	int id=scanner.nextInt();
	sbUnit.getById(id);
}
}
