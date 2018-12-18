package com.capgemini.ars.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ars.bean.BookingInformationBean;
import com.capgemini.ars.bean.FlightInformationBean;
import com.capgemini.ars.dao.IAirlineDao;
import com.capgemini.ars.exception.AirlineException;

@Service("userServ")
public class UserServiceImpl implements IUserService {
	@Autowired
	IAirlineDao airlineDao;

	public IAirlineDao getAirlineDao() {
		return airlineDao;
	}

	public void setAirlineDao(IAirlineDao airlineDao) {
		this.airlineDao = airlineDao;
	}

	public UserServiceImpl() {
	}

	@Override
	public ArrayList<FlightInformationBean> fetchAvailableFlights(
			FlightInformationBean flightInfo, String classType,
			int noOfPassengers) throws AirlineException {
		return airlineDao.fetchAvailableFlights(flightInfo, classType,
				noOfPassengers);
	}

	@Override
	public int bookFlight(BookingInformationBean bookingInfo, int passengers)
			throws AirlineException {
		return airlineDao.bookFlight(bookingInfo, passengers);
	}

	@Override
	public boolean rescheduleBooking(BookingInformationBean bookingInfo,
			int flightNo, int passengers) throws AirlineException {

		return airlineDao.rescheduleBooking(bookingInfo, flightNo, passengers);
	}

	@Override
	public boolean cancelBooking(int bookingId, int passengers)
			throws AirlineException {

		return airlineDao.cancelBooking(bookingId, passengers);
	}

	@Override
	public BookingInformationBean retrieveBookingDetails(int bookingId)
			throws AirlineException {

		return airlineDao.retrieveBookingDetails(bookingId);
	}

	@Override
	public FlightInformationBean retrieveFlightDetails(int selectedFlight)
			throws AirlineException {
		return airlineDao.retrieveFlightDetails(selectedFlight);

	}

	@Override
	public ArrayList<String> getCityList() throws AirlineException {
		ArrayList<String> cityList = airlineDao.getCityList();
		return cityList;
	}

}
