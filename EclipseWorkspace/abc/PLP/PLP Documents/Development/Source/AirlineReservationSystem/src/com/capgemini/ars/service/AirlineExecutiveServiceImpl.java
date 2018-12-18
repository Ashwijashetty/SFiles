package com.capgemini.ars.service;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ars.bean.FlightInformationBean;
import com.capgemini.ars.dao.IAirlineDao;
import com.capgemini.ars.exception.AirlineException;

@Service("execServ")
public class AirlineExecutiveServiceImpl implements IAirlineExecutiveService {

	@Autowired
	IAirlineDao airlineDao;

	public IAirlineDao getAirlineDao() {
		return airlineDao;
	}

	public void setAirlineDao(IAirlineDao airlineDao) {
		this.airlineDao = airlineDao;
	}

	public AirlineExecutiveServiceImpl() {
	}

	@Override
	public ArrayList<FlightInformationBean> fetchGivenPeriodFlights(
			String airline, Date deptDate, String deptTime, Date arrDate,
			String arrTime) throws AirlineException {

		return airlineDao.fetchGivenPeriodFlights(airline, deptDate, deptTime,
				arrDate, arrTime);
	}

	@Override
	public ArrayList<FlightInformationBean> fetchGivenCityFlights(
			String srcCity, String destCity) throws AirlineException {

		return airlineDao.fetchGivenCityFlights(srcCity, destCity);
	}

	@Override
	public ArrayList<String> getCityList() throws AirlineException {
		ArrayList<String> cityList = airlineDao.getCityList();
		return cityList;
	}

}
