package com.cg.bms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Logger;

import com.cg.bms.model.Account;
import com.cg.bms.model.exceptions.BMSException;
import com.cg.bms.model.utility.JdbcUtility;
import com.cg.bms.service.AccountServiceImpl;
import com.cg.bms.service.IAccountService;

public class AccountDaoImpl implements IAccountDao{

	static Logger logger = Logger.getLogger(AccountDaoImpl.class);
	
	/*
	 * method name -createAccount arguments -Account object return type -boolean
	 * Author -capgemini CreationDate -12/10/2018 purpose - this method is to
	 * insert the account data into database
	 */
	Connection connection=null;
	PreparedStatement statement=null;
	ResultSet resultSet=null;
	@Override
	public int getMaxId() throws BMSException {
		int id=0;
		connection=JdbcUtility.getconnection();
		try {
			statement=connection.prepareStatement(QueryConstants.selecMaxId);
			resultSet=statement.executeQuery();
			resultSet.next();
			id=resultSet.getInt(1);
			
		} catch (SQLException e) {
			throw new BMSException("ID not fetched.");
			
		}finally{try {
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			throw   new   BMSException("problem while closing resultSet");
		}
	
		JdbcUtility.closeConnection();
		}
		
		return id;
	}
	@Override
	public boolean createAccount(Account account) throws BMSException {
		boolean flag=false;
		try {
			connection=JdbcUtility.getconnection();
			statement=connection.prepareStatement(QueryConstants.insertAccount);
			statement.setString(1,account.getType());
			statement.setString(2,account.getCustomerName());
			statement.setDouble(3,account.getBalance());
			
			Date date=account.getDate();
			long ms=date.getTime();
			
			java.sql.Date date2=new java.sql.Date(ms);
			statement.setDate(4, date2);
			int result=statement.executeUpdate();
			if(result>0)
			{		flag=true;
			        logger.debug("account created");
			}
			
		} catch (SQLException e) {
			throw new BMSException("statement object not created ");
		}finally{JdbcUtility.closeConnection();}
		
		
		return flag;
	}

	

}
