package com.capgemini.ars.daoTest;

import java.util.List;

import com.capgemini.ars.dao.*;
import com.capgemini.ars.exception.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.capgemini.ars.bean.*;
import com.capgemini.ars.service.*;

public class DaoTest 
{
	IAirlineDao airlineDao;
		
	@Before
	public void setUp() throws MobileException
	{
		airlineDao = new AirlineDaoImpl();
	}
	
	@After
	public void tearDown() throws Exception 
	{
		airlineDao=null; 
	}
	
	//@Test(expected = AirlineException.class)
	@Ignore
	public void testIsValidUserLoginWithInvalidUsername() throws AirlineException
	{
		try 
		{
			UserBean bean = new UserBean();
			bean.setUserName("rajat1");
			bean.setPassword("rajat123");
			UserBean test = airlineDao.isValidUserLogin(bean);
			assertNull(bean);
		} 
		catch (AirlineException e) 
		{
			fail("Exception not expected");
		}
	} 
	
	@Test(expected = AirlineException.class)
	//@Ignore
	public void testIsValidUserLoginWithInvalidPassword() throws AirlineException
	{
		try 
		{
			UserBean bean = new UserBean();
			bean.setUserName("rajat");
			bean.setPassword("rajat");
			UserBean test = airlineDao.isValidUserLogin(bean);
			assertNull(bean);
		} 
		catch (AirlineException e) 
		{
			fail("Exception not expected");
		}
	}  
	
//---------------------------------------------	
	@Ignore
	//@Test
	public void testIsValidUserLoginWithValidData() throws AirlineException
	{
		try 
		{
			UserBean bean = new UserBean();
			bean.setUserName("rajat");
			bean.setPassword("rajat123");
			UserBean test = airlineDao.isValidUserLogin(bean);
			assertNotNull(bean);
		} 
		catch (AirlineException e) 
		{
			fail("Exception not expected");
		}
	}
	
	@Ignore
	//@Test(expected = AirlineException.class)
	public void testBookFlightWithInvalidData() throws AirlineException
	{
		try
		{
			BookingInformationBean bean = new BookingInformationBean();
			bean.setFlightNo(34);
			bean.setCustEmail("asd@cdcom");
			bean.setNoOfPassengers(1);
			bean.setClassType("first");
			bean.setTotalFare(232);
			bean.setSeatNumber("ff");
			bean.setCreditCardInfo("34434");
			bean.setSrcCity("3434");
			bean.setDestCity("4544");
			int b = airlineDao.bookFlight(bean);
			assertFalse(b > 0);
		}
		catch (AirlineException e) 
		{
			fail("Exception not expected");
		}
	}

	
	@Ignore
	//@Test
	public void testBookFlightWithValidData() throws AirlineException
	{
			BookingInformationBean bean = new BookingInformationBean();
			bean.setFlightNo(1001);
			bean.setCustEmail("asd@cdcom");
			bean.setNoOfPassengers(1);
			bean.setClassType("first");
			bean.setTotalFare(23245.0);
			bean.setSeatNumber("f45");
			bean.setCreditCardInfo("3443434434");
			bean.setSrcCity("delhi");
			bean.setDestCity("Bangalore");
			int b = airlineDao.bookFlight(bean,bean.getNoOfPassengers());
			assertTrue(b > 0);
	}

	
	@Ignore
	//@Test(expected = AirlineException.class)
	public void testRetrieveFlightDetailsWithInvalidFlightNo() throws AirlineException
	{
		try
		{	
			int flight= 45;
			FlightInformationBean bean = airlineDao.retrieveFlightDetails(flight);
			assertNull(bean);
		}
		catch (AirlineException e) 
		{
			fail("Exception not expected");
		}
	}

	@Ignore
	//@Test
	public void testRetrieveFlightDetailsWithValidFlightNo() throws AirlineException
	{	
			int flight= 1001;
			FlightInformationBean bean = airlineDao.retrieveFlightDetails(flight);
			assertNotNull(bean);
	}
	
}
