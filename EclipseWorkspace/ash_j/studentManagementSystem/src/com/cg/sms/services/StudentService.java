package com.cg.sms.services;

import com.cg.sms.entity.Student;
import com.cg.sms.exception.StudentException;


public interface StudentService {


	public void addStudentinfo(Student student) throws StudentException;

	public void viewDetails(Student student) throws StudentException;

}