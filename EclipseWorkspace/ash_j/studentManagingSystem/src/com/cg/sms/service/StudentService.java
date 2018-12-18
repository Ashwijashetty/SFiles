package com.cg.sms.service;

import com.cg.sms.beans.Student;
import com.cg.sms.exception.StudentException;


public interface StudentService {

	public void addStudentinfo(Student student) throws StudentException;

	public void viewDetails(Student student) throws StudentException;

}
