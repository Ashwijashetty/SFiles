package com.capgemini.ars.service;

import java.util.ArrayList;

import com.capgemini.ars.bean.BookingInformationBean;
import com.capgemini.ars.bean.FlightInformationBean;
import com.capgemini.ars.exception.AirlineException;

public interface IUserService {
	public ArrayList<FlightInformationBean> fetchAvailableFlights(
			FlightInformationBean flightInfo, String classType,
			int noOfPassengers) throws AirlineException;

	public int bookFlight(BookingInformationBean bookingInfo, int passengers)
			throws AirlineException;

	public BookingInformationBean retrieveBookingDetails(int bookingId)
			throws AirlineException;

	public FlightInformationBean retrieveFlightDetails(int selectedFlight)
			throws AirlineException;

	boolean rescheduleBooking(BookingInformationBean bookingInfo, int flightNo,
			int passengers) throws AirlineException;

	boolean cancelBooking(int bookingId, int passengers)
			throws AirlineException;

	public ArrayList<String> getCityList() throws AirlineException;
}
