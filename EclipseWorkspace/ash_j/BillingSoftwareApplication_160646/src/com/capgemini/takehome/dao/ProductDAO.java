package com.capgemini.takehome.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.takehome.bean.ProductBean;
import com.capgemini.takehome.exceptions.BSAException;
import com.capgemini.takehome.ui.Client;
import com.capgemini.takehome.utility.JdbcUtility;

public class ProductDAO implements IProductDAO {
	static Logger logger = Logger.getLogger(Client.class);
	
	
	Connection connection = null;
	PreparedStatement statement = null;

	/*
	 * Method name - getProductDetails 
	 * Arguments   - productCode object 
	 * Return type - List 
	 * Author      - Capgemini CreationDate -16/10/2018
	 * Purpose     - this method is to get product details from database for given product Code and DAO 
	 *               operation is logged into a file test.log using Log4J.
	 */
	
	@Override
	public List<ProductBean> getDetailsProduct(int productCode)
			throws BSAException {
		PropertyConfigurator.configure("resources/log4j.properties");

		logger.info("log4j configured");
		List<ProductBean> list = new ArrayList<>();

		connection = JdbcUtility.getconnection();
		logger.info("Connection Established Succesfully");
	
		try {
			statement = connection.prepareStatement(QueryConstants.selectQuery);
			statement.setInt(1, productCode);
			ResultSet resultset = statement.executeQuery();
			
			while (resultset.next()) {
				logger.info("In iteration mode");
				int productCode1 = resultset.getInt(1);
				String productName = resultset.getString(2);
				String productCategory = resultset.getString(3);
				String productDescription = resultset.getString(4);
				long productPrice = resultset.getLong(5);
				
				ProductBean product = new ProductBean(productCode1,
						productName, productCategory, productDescription,
						productPrice);
				
				list.add(product);
			
			}logger.info("list is stored with required data and returned");
		if(list !=null){
			logger.info("List has some contents"+list);
		}
		} catch (SQLException e) {
			logger.debug("QUERY not correct");
			throw new BSAException("Not Successful");
		}finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new BSAException("problem while closing resultSet");
			}

			JdbcUtility.closeConnection();

		}
		return list;
	}

}
