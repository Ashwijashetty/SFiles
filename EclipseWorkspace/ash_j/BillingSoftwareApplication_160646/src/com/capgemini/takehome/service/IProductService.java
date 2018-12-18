package com.capgemini.takehome.service;

import java.util.List;

import com.capgemini.takehome.bean.ProductBean;
import com.capgemini.takehome.exceptions.BSAException;

public interface IProductService {

	public List<ProductBean> getProductDetails(int productCode)
			throws BSAException;

	public boolean isValidproductCode(int productCode);

}
