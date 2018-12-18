package com.cg.lab13;

import org.springframework.beans.factory.*;
import org.springframework.beans.factory.xml.*;
import org.springframework.core.io.*;
public class Client {
public static void main(String[] args) {
	Resource res=new ClassPathResource("sbu.xml");
	BeanFactory factory=new XmlBeanFactory(res);
	SBUnit sbUnit=(SBUnit) factory.getBean("SbUnit");
	sbUnit.getDetails();
	sbUnit.getById(102);
}
}
