package com.capgemini.ars.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.ars.bean.FlightInformationBean;
import com.capgemini.ars.exception.AirlineException;
import com.capgemini.ars.service.IAirlineExecutiveService;

@Controller(value = "*.exc")
public class AirlineExecutiveController {
	@Autowired
	IAirlineExecutiveService execServ;
	ArrayList<String> cityList;
	Logger logger=Logger.getLogger(AirlineExecutiveController.class);
	public AirlineExecutiveController() {
	}

	@RequestMapping(value = "/showFlightOccupancyPeriod")
	public String displayFlightOccupancyPeriodPage(Model model) {
		FlightInformationBean flight = new FlightInformationBean();
		model.addAttribute("flight", flight);
		LocalDate date1 = LocalDate.now().plusDays(1);
		LocalDate date2 = date1.plusMonths(2);
		model.addAttribute("minDate",date1);
		model.addAttribute("maxDate",date2);
		return "FlightPeriodHome";
	}

	@RequestMapping(value = "/showFlightOccupancyCity")
	public String displayFlightOccupancyCityPage(Model model) {
		FlightInformationBean flight = new FlightInformationBean();
		cityList = new ArrayList<String>();
		try {
			cityList = execServ.getCityList();
			model.addAttribute("cityList", cityList);
			model.addAttribute("flight", flight);
		} catch (AirlineException e) {
			logger.info(e.getMessage());
			String errObj = e.getMessage();
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		return "FlightCityHome";
	}

	@RequestMapping(value = "/flightPeriodDisplay")
	public String viewFlightOccupancyBasedOnPeriodAction(
			@ModelAttribute("flight") FlightInformationBean flight, Model model) {
		ArrayList<FlightInformationBean> list = new ArrayList<FlightInformationBean>();
		Date date1 = Date.valueOf(flight.getTempDeptDate());
		Date date2 = Date.valueOf(flight.getTempArrDate());
		flight.setDeptDate(date1);
		flight.setArrDate(date2);
		try {
			list = execServ.fetchGivenPeriodFlights(flight.getAirline(),
					flight.getDeptDate(), flight.getDeptTime(),
					flight.getArrDate(), flight.getArrTime());
		} catch (AirlineException e) {
			logger.info(e.getMessage());
			String errObj = e.getMessage();
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		if (list.size()>0) {
			model.addAttribute("list", list);

		} else {
			logger.info("No record Found");
			String errObj = "No records Found......";
			model.addAttribute("errObj", errObj);
			return "Error";
		}

		return "FlightOccupancy";
	}

	@RequestMapping(value = "/flightCityDisplay")
	public String viewFlightOccupancyBasedOnCityAction(
			@ModelAttribute("flight") FlightInformationBean flight, Model model) {
		ArrayList<FlightInformationBean> list = null;
		try {
			list = execServ.fetchGivenCityFlights(flight.getDeptCity(),
					flight.getArrCity());
		} catch (AirlineException e) {
			logger.info(e.getMessage());
			String errObj = e.getMessage();
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		if (list.size() > 0) {
			model.addAttribute("list", list);
		} else {
			logger.info("No record found");
			String errObj = "No records Found......";
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		return "FlightOccupancy";
	}

	@RequestMapping(value = "/showExecutiveMenu")
	public String displayAdminMenu(Model model) {
		return "AirlineExecutiveHome";
	}
}
