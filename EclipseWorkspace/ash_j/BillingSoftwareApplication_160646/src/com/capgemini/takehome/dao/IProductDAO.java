package com.capgemini.takehome.dao;

import java.util.List;

import com.capgemini.takehome.bean.ProductBean;
import com.capgemini.takehome.exceptions.BSAException;

public interface IProductDAO {

	List<ProductBean> getDetailsProduct(int productCode) throws BSAException;

}
