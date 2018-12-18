package com.cg.smsapp.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cg.smsapp.model.Student;

public interface StudentService {
public int addStudent(Student student)throws ClassNotFoundException, SQLException, FileNotFoundException, IOException ;
public int  deleteStudent(int id)throws ClassNotFoundException, SQLException, FileNotFoundException, IOException ; 
public int updateStudent(Student student) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
public List<Student> getAllStudents()throws ClassNotFoundException, SQLException, FileNotFoundException, IOException; 

}
