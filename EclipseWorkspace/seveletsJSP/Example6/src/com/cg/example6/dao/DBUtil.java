package com.cg.example6.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.example6.exception.EException;

public class DBUtil {
private static Connection connection=null;
public static Connection getConnection() throws EException {
	if(null==connection){
	/*	synchronized (connection) {
			if(null==connection){*/
				try{
					Class.forName("oracle.jdbc.OracleDriver");
					connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","orcl11g");
					
				}catch(ClassNotFoundException e){
					throw new EException(EException.error1);
				} catch (SQLException e) {
					throw new EException(EException.error2);
				}
			}
	
		//}}
	return connection;
}
}
