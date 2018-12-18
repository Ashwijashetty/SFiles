package com.cg.bms.dao.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.bms.dao.AccountDaoImpl;
import com.cg.bms.model.Account;

public class AccountDaoImplTest {
	AccountDaoImpl accountdao;
	@Before
	public void setUp() throws Exception {
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateAccount() {
		Account account =new Account("savings","shivaram",20000,new Date(2018,10,12));
		try{
			
			boolean result=accountdao.createAccount(account);
			assertTrue(result);
		}catch(Exception e){
			}
		}

}
