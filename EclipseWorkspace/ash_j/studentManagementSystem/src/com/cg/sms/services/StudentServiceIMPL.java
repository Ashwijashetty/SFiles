package com.cg.sms.services;

import com.cg.sms.dao.StudentDAO;
import com.cg.sms.dao.StudentDaoIMPL;
import com.cg.sms.entity.Student;
import com.cg.sms.exception.StudentException;

public class StudentServiceIMPL implements StudentService {
StudentDAO student1=new StudentDaoIMPL();
	
	@Override
	public void addStudentinfo(Student student) throws StudentException {
		// TODO Auto-generated method stub
		student1.addStudentinfo(student);
	}

	public void viewDetails(Student student) throws StudentException {
		// TODO Auto-generated method stub
		student1.viewDetails(student);
	}
	

}
