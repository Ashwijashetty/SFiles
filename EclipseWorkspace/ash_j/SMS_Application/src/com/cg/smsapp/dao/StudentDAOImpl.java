package com.cg.smsapp.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.smsapp.constants.QueryConstants;
import com.cg.smsapp.model.Student;
import com.cg.smsapp.utility.JdbcUtility;

public class StudentDAOImpl implements StudentDAO  {

	 Connection connection = null;
	 PreparedStatement statement = null;
	@Override
	public int addStudent(Student student)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		connection = JdbcUtility.getConnection();
		//String query = QueryConstants.insertQuery;
		//statement = connection.prepareStatement(query);
		statement = connection.prepareStatement(QueryConstants.insertQuery);
		statement.setString(1, student.getName());
		statement.setDouble(2, student.getSalary());
		int result = statement.executeUpdate();
		
		return result;
	}

	@Override
	public int deleteStudent(int id)throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		connection =JdbcUtility.getConnection();
		statement = connection.prepareStatement(QueryConstants.deleteQuery);
		statement.setInt(1, id);
		int res2=statement.executeUpdate();
		return res2;
	}
	public int updateStudent(Student student) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException
	{
		connection =JdbcUtility.getConnection();
		statement = connection.prepareStatement(QueryConstants.updateQuery);
		statement.setDouble(1, student.getSalary());
		statement.setInt(2, student.getId());
        int res=statement.executeUpdate();
		return res;
	}
	public List<Student> getAllStudents()throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
		List<Student> list=new ArrayList<>();
		connection =JdbcUtility.getConnection();
		statement = connection.prepareStatement(QueryConstants.selectQuery);
		ResultSet resultset=statement.executeQuery();
		
		while(resultset.next()){
			int id=resultset.getInt(1);
			String name=resultset.getString(2);
			double salary=resultset.getDouble(3);
			
			Student student=new Student(id,name,salary);
		    list.add(student);
		}
		return list;
		
	}

}
