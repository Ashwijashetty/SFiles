package com.capgemini.takehome.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.capgemini.takehome.exceptions.BSAException;

public class JdbcUtility {
	private static Connection connection = null;

	public static Connection getconnection() throws BSAException {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(new File(
					"resources/jdbc.properties")));
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);

		} catch (IOException e) {
			throw new BSAException("Unable to read the file...");

		} catch (ClassNotFoundException e) {
			throw new BSAException("unable to load class..");
		} catch (SQLException e) {
			throw new BSAException("connection not established..");
		}
		return connection;

	}

	public static void closeConnection() throws BSAException {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new BSAException("unable to close Connection");
		}

	}
}
