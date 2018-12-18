package com.cg.sms.service;

import com.cg.sms.beans.Student;
import com.cg.sms.exception.StudentException;





public class StudentServiceIMPL implements StudentService{
	
			@Override
			public void addStudentinfo(Student student) throws StudentException {
				
			}

			public void viewDetails(Student student) throws StudentException {
				
				System.out.println("Student name: "+student.getStudentName()+"\nID: "+student.getStudentId()
						+"\nPhone num: "+student.getStudentPhoneNum()+"\n EmailId: "+student.getStudentEmailId()
						+"City :"+student.getStudentCity());
			}
			

		}
