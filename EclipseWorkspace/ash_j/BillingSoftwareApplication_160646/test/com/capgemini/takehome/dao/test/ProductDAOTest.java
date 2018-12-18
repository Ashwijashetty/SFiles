package com.capgemini.takehome.dao.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.takehome.bean.ProductBean;
import com.capgemini.takehome.dao.ProductDAO;
import com.capgemini.takehome.exceptions.BSAException;

public class ProductDAOTest {
ProductDAO productDao=null;
	@Before
	public void setUp() throws Exception {
		productDao=new ProductDAO();
	}

	@After
	public void tearDown() throws Exception {
		productDao=null;
	}

	
	@Test
	public void testGetDetailsProduct1() throws BSAException {
		List<ProductBean> list=new ArrayList<ProductBean>();
		int productCode=1001;
		list=productDao.getDetailsProduct(productCode);
		assertNull(list);
		
	}@Test
	public void testGetDetailsProduct() throws BSAException {
		List<ProductBean> list=new ArrayList<ProductBean>();
		int productCode=1001;
		list=productDao.getDetailsProduct(productCode);
		assertNotNull(list);
		
	}

}
