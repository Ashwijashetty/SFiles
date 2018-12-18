package com.capgemini.ars.service;

import java.sql.Date;
import java.util.ArrayList;

import com.capgemini.ars.bean.FlightInformationBean;
import com.capgemini.ars.exception.AirlineException;

public interface IAirlineExecutiveService {

	public ArrayList<FlightInformationBean> fetchGivenCityFlights(
			String srcCity, String destCity) throws AirlineException;

	public ArrayList<String> getCityList() throws AirlineException;

	ArrayList<FlightInformationBean> fetchGivenPeriodFlights(String airline,
			Date deptDate, String deptTime, Date arrDate, String arrTime)
			throws AirlineException;
}
