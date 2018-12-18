package com.cg.uas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.uas.exceptions.UASException;
import com.cg.uas.model.Users;
import com.cg.uas.utility.JdbcUtility;

public class UserDao implements IUserDao {
	Connection connection=null;
	PreparedStatement statement=null;
	ResultSet resultSet=null;

	@Override
	public Users getUserById(String loginId) throws UASException {
		Users users=null;
		connection=JdbcUtility.getconnection();
		
		try {
			statement=connection.prepareStatement(QueryConstants.getById);
			statement.setString(1, loginId);
			resultSet=statement.executeQuery();
			if(resultSet.next()){
				users=new Users();
				users.setLoginId(resultSet.getString(1));
				users.setPassword(resultSet.getString(2));
				users.setRole(resultSet.getString(3));
			}
		} catch (SQLException e) {
			throw new UASException("Sql Exception$$");
		}finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new UASException("problem while closing resultSet");
			}
		
		
		
	}return users;
	}}


