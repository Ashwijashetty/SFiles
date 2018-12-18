package com.capgemini.ars.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ars.bean.FlightInformationBean;
import com.capgemini.ars.dao.IAirlineDao;
import com.capgemini.ars.exception.AirlineException;

@Service("adminServ")
public class AdminServiceImpl implements IAdminService {

	@Autowired
	IAirlineDao airlineDao;

	public IAirlineDao getAirlineDao() {
		return airlineDao;
	}

	public void setAirlineDao(IAirlineDao airlineDao) {
		this.airlineDao = airlineDao;
	}

	public AdminServiceImpl() {
	}

	@Override
	public int insertFlight(FlightInformationBean flightInfo)
			throws AirlineException {
		return airlineDao.insertFlight(flightInfo);
	}

	@Override
	public ArrayList<FlightInformationBean> retrieveAllFlights()
			throws AirlineException {

		return airlineDao.retrieveAllFlights();
	}

	@Override
	public FlightInformationBean retrieveFlightDetails(int flightNo)
			throws AirlineException {

		return airlineDao.retrieveFlightDetails(flightNo);
	}

	@Override
	public int updateFlight(FlightInformationBean bean) throws AirlineException {

		return airlineDao.updateFlight(bean);
	}

	@Override
	public boolean deleteFlight(int flightNo) throws AirlineException {

		return airlineDao.deleteFlight(flightNo);
	}

	@Override
	public ArrayList<String> getCityList() throws AirlineException {
		ArrayList<String> cityList = airlineDao.getCityList();
		return cityList;
	}

}
