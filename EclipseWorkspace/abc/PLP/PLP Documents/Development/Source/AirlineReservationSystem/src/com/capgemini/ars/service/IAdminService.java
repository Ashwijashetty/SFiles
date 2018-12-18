package com.capgemini.ars.service;

import java.util.ArrayList;

import com.capgemini.ars.bean.FlightInformationBean;
import com.capgemini.ars.exception.AirlineException;

public interface IAdminService {

	public int insertFlight(FlightInformationBean flightInfo)
			throws AirlineException;

	public ArrayList<FlightInformationBean> retrieveAllFlights()
			throws AirlineException;

	public FlightInformationBean retrieveFlightDetails(int flightNo)
			throws AirlineException;

	public boolean deleteFlight(int flightNo) throws AirlineException;

	int updateFlight(FlightInformationBean bean) throws AirlineException;

	public ArrayList<String> getCityList() throws AirlineException;
}
