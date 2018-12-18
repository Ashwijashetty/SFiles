package com.cg.ems.presentation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.ems.exceptios.EMSException;
import com.cg.ems.model.Employee;
import com.cg.ems.utility.DBUtility;

public class EmployeeDAO {
	Connection connection = null;
	PreparedStatement statement = null;

	public boolean createEmployeeTable() throws EMSException {
		connection = DBUtility.getConnection();

		String createQuery = "create table emp_table(id number primary key,name varchar2(20),desig varchar2(20),city varchar2(20),salary number)";

		boolean flag;
		try {
			statement = connection.prepareStatement(createQuery);
			statement.execute();
			flag = true;
		} catch (SQLException e) {
			throw new EMSException("some error in create query");
		}
		return flag;
	}

	public int addemployee(Employee employee) throws EMSException {
	int result;
	List<Employee> list=new ArrayList<>();
	connection = DBUtility.getConnection();
	String insertQuery="insert into emp_table values(id_sequence.nextval,?,?,?,?)";
	try {
		statement = connection.prepareStatement(insertQuery);
		/*statement.setString(1, employee.getName());
		statement.setString(2, employee.getDesig());
		statement.setString(3, employee.getCity());
		statement.setDouble(4, employee.getSalary());*/

		for(Employee employee1:list){
			statement.setString(1, employee1.getName());
			statement.setString(2, employee1.getDesig());
			statement.setString(3, employee1.getCity());
			statement.setDouble(4, employee1.getSalary());
		}
		
		result=statement.executeUpdate();
	} catch (SQLException e) {
	throw new EMSException("some error in insert query");
	}
		return result;
	}
}
