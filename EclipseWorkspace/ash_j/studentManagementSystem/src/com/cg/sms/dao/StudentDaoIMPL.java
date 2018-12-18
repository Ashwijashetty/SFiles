package com.cg.sms.dao;

import java.util.Scanner;
import com.cg.sms.entity.Student;
import com.cg.sms.exception.StudentException;

public class StudentDaoIMPL implements StudentDAO {

	@Override
	public void addStudentinfo(Student student) throws StudentException {
	
			 System.out.println("Name : "+student.getStudentName()+"Id: "+student.getStudentId()+"Phone number:"+student.getStudentPhoneNum()+
					 "Email Id: "+student.getStudentEmailId()+"city"+student.getStudentCity());
			 
	}

	@Override
	public void viewDetails(Student student) throws StudentException {
		// TODO Auto-generated method stub
		System.out.println("Student details are:");
		System.out.println("_____________________");
		System.out.println("Name : "+student.getStudentName()+"Id: "+student.getStudentId()+"Phone number:"+student.getStudentPhoneNum()+
					 "Email Id: "+student.getStudentEmailId()+"city"+student.getStudentCity());
		
	}
}
