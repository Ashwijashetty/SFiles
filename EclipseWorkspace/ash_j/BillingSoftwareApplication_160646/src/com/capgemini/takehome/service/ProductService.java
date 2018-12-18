package com.capgemini.takehome.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.takehome.bean.ProductBean;
import com.capgemini.takehome.dao.IProductDAO;
import com.capgemini.takehome.dao.ProductDAO;
import com.capgemini.takehome.exceptions.BSAException;

public class ProductService implements IProductService {
	IProductDAO dao = new ProductDAO();

	/*
	 * Method name - getProductDetails 
	 * Arguments   - productCode object 
	 * Return type - List 
	 * Author      - Capgemini CreationDate -16/10/2018
	 * Purpose     - this method is to get product details from database for given product Code.
	 */
	@Override
	public List<ProductBean> getProductDetails(int productCode)
			throws BSAException {
		return dao.getDetailsProduct(productCode);
	}

	/*
	 * Method name  - isValidproductCode 
	 * Arguments    -productCode object
	 * Return type  -boolean 
	 * Author       -Capgemini 
	 * CreationDate -16/10/2018 purpose - this method is to validate productCode.
	 */
	@Override
	public boolean isValidproductCode(int productCode) {

		String pCode = Integer.toString(productCode);
		Pattern pattern = Pattern.compile("[0-9]{4}");
		Matcher matcher = pattern.matcher(pCode);
		return matcher.matches();

	}
}
