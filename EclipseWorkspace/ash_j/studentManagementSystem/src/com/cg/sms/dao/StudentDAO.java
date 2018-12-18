package com.cg.sms.dao;

import com.cg.sms.entity.Student;
import com.cg.sms.exception.StudentException;

public interface StudentDAO {

void addStudentinfo(Student student)throws StudentException;
void viewDetails(Student student)throws StudentException;

}
