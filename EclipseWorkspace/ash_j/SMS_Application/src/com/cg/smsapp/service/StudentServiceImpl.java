package com.cg.smsapp.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cg.smsapp.dao.StudentDAO;
import com.cg.smsapp.dao.StudentDAOImpl;
import com.cg.smsapp.model.Student;

public class StudentServiceImpl implements StudentService {

	StudentDAO studentDao = new StudentDAOImpl();
	@Override
	public int addStudent(Student student)throws ClassNotFoundException, SQLException, FileNotFoundException, IOException  {
		// TODO Auto-generated method stub
		return studentDao.addStudent(student);
	}

	@Override
	public int deleteStudent(int id) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		
		int res2=studentDao.deleteStudent(id);
		return res2;
	}
public int updateStudent(Student student) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
	int res= studentDao.updateStudent(student);
	return res;
}
public List<Student> getAllStudents()throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
	List<Student> list=studentDao.getAllStudents();
	return list;
}

}
