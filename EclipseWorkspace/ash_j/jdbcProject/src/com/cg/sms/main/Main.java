package com.cg.sms.main;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



import oracle.jdbc.OracleDriver;

public class Main {
public static void main(String[] args) {
	/*Driver driver=new OracleDriver();
	try {
		DriverManager.registerDriver(driver);
		System.out.println("loaded..");
	} catch (SQLException e) {
   	e.printStackTrace();  
	}*/
	Connection connection=null;
	Statement statement=null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");//interface for loading driver
		System.out.println("loaded...");
		connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","orcl11g");//url to connect to DB,password,username
	    System.out.println("connected..");
	    //connection =JdbcUtility.getConnection();
	    statement=connection.createStatement();
	    String query="create table cloud_batch_table2(id number primary key,name varchar2(20),salary decimal(8,3))";
	    statement.execute(query);
	    System.out.println("table created..");
	
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
}
