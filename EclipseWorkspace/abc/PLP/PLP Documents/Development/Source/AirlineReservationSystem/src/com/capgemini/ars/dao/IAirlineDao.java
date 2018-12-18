package com.capgemini.ars.dao;

import java.sql.Date;
import java.util.ArrayList;

import com.capgemini.ars.bean.BookingInformationBean;
import com.capgemini.ars.bean.FlightInformationBean;
import com.capgemini.ars.bean.UserBean;
import com.capgemini.ars.exception.AirlineException;

public interface IAirlineDao {

	public ArrayList<FlightInformationBean> fetchAvailableFlights(
			FlightInformationBean flightInfo, String classType,
			int noOfPassengers) throws AirlineException;

	public int bookFlight(BookingInformationBean bookingInfo, int passengers)
			throws AirlineException;

	public BookingInformationBean retrieveBookingDetails(int bookingId)
			throws AirlineException;

	public UserBean isValidUserLogin(UserBean userDetails)
			throws AirlineException;

	public ArrayList<FlightInformationBean> fetchGivenCityFlights(
			String srcCity, String destCity) throws AirlineException;

	public int insertFlight(FlightInformationBean flightInfo)
			throws AirlineException;

	public ArrayList<FlightInformationBean> retrieveAllFlights()
			throws AirlineException;

	public FlightInformationBean retrieveFlightDetails(int flightNo)
			throws AirlineException;

	public boolean deleteFlight(int flightNo) throws AirlineException;

	boolean cancelBooking(int bookingId, int passengers)
			throws AirlineException;

	int updateFlight(FlightInformationBean bean) throws AirlineException;

	public ArrayList<String> getCityList() throws AirlineException;

	boolean rescheduleBooking(BookingInformationBean bookingInfo, int flightNo,
			int passengers) throws AirlineException;

	ArrayList<FlightInformationBean> fetchGivenPeriodFlights(String airline,
			Date deptDate1, String deptTime1, Date deptDate2, String deptTime2)
			throws AirlineException;
}
