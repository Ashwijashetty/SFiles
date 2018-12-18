package com.cg.bms.model.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.bms.model.exceptions.BMSException;

public class JdbcUtility {
	private static Connection connection = null;

	public static Connection getconnection() throws BMSException {
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
			throw new BMSException("Unable to read the file...");

		} catch (ClassNotFoundException e) {
			throw new BMSException("unable to load class..");
		} catch (SQLException e) {
			throw new BMSException("connection not established..");
		}
		return connection;

	}

	public static void closeConnection() throws BMSException {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new BMSException("unable to close Connection");
		}

	}
}
