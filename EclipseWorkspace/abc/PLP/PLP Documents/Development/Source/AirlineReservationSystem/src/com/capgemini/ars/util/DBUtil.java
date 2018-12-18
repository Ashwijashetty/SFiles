package com.capgemini.ars.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.capgemini.ars.exception.AirlineException;

public final class DBUtil {

	private static DBUtil dsp;

	private DataSource dataSource;

	private DBUtil() throws AirlineException {
		try {
			InitialContext context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:/OracleDS");
		} catch (NamingException e) {
			throw new AirlineException(e.getMessage());
		}
	}

	public static synchronized DBUtil obtainConnection()
			throws AirlineException {
		if (dsp == null)
			dsp = new DBUtil();
		return dsp;
	}

	public DataSource getDataSource() {
		return this.dataSource;
	}
}