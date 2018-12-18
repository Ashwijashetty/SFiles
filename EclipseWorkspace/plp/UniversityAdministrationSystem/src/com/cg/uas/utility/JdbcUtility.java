package com.cg.uas.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.uas.exceptions.UASException;



public class JdbcUtility {
	private static Connection connection = null;

	public static Connection getconnection() throws UASException {
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
			throw new UASException("Unable to read the file...");

		} catch (ClassNotFoundException e) {
			throw new UASException("unable to load class..");
		} catch (SQLException e) {
			throw new UASException("connection not established..");
		}
		return connection;

	}

	public static void closeConnection() throws UASException {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new UASException("unable to close Connection");
		}

	}
}
