package com.cg.example6.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import com.cg.example6.bean.UserDetailsBean;
import com.cg.example6.exception.EException;
import com.cg.example6.util.SqlQueries;

public class EmployeeDaoImpl implements IEmployeeDao {

	@Override
	public boolean verify(UserDetailsBean userDetailsBean) throws EException {
		boolean result = false;
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(SqlQueries.Query);
			preparedStatement.setString(1, userDetailsBean.getName());
			preparedStatement.setString(2, userDetailsBean.getPass());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				result = true;
			}
		} catch (SQLException e) {
			throw new EException(EException.error2);
		}
		return result;
	}

}
