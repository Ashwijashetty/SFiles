package com.cg.sms;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import com.cg.sms.service.IStudentService;

public class Client {
public static void main(String[] args) throws Exception {
	ApplicationContext factory = new ClassPathXmlApplicationContext("sms.xml");
IStudentService student = (IStudentService) factory.getBean("studentService");
List<String> list=student.getNames();
}
}
