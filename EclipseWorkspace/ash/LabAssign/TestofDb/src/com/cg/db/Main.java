package com.cg.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
			Class.forName("com.mysql.jdbc.Driver");//interface for loading driver
			System.out.println("loaded...");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");//url to connect to DB,password,username
		    System.out.println("connected..");
		    //connection =JdbcUtility.getConnection();
		    statement=connection.createStatement();
		    String query="create table cloud_batch_table2(id varchar(20))";
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
