package com.cg.ems.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.ems.exceptios.EMSException;

public class DBUtility {
	private static Connection connection = null;

	public static Connection getConnection() throws EMSException {
		Properties properties = new Properties();
		File file = new File("resources/jdbc.properties");

		try {
			FileInputStream inputStream;
			inputStream = new FileInputStream(file);
			properties.load(inputStream);

			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");

			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);

			System.out.println("connected...");
			return connection;
		} catch (ClassNotFoundException | SQLException | IOException e) {
			throw new EMSException("DataBase ERROR");
		}
	}
}
