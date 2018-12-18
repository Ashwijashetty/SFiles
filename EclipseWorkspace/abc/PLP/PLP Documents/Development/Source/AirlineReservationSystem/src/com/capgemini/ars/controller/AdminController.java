package com.capgemini.ars.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.ars.bean.FlightInformationBean;
import com.capgemini.ars.exception.AirlineException;
import com.capgemini.ars.service.IAdminService;

@Controller()
@RequestMapping(value = "*.adm")
public class AdminController {
	@Autowired
	IAdminService adminServ;
	ArrayList<String> cityList;
	Logger logger=Logger.getLogger(AdminController.class);
	public AdminController() {
	}

	@RequestMapping(value = "/showInsertFlightHome")
	public String displayInsertFlightPage(Model model) {
		cityList = new ArrayList<String>();
		FlightInformationBean insertFlight = new FlightInformationBean();
		try {
			cityList = adminServ.getCityList();
			model.addAttribute("cityList", cityList);
			model.addAttribute("insertFlight", insertFlight);
			LocalDate date1 = LocalDate.now().plusDays(1);
			LocalDate date2 = date1.plusMonths(2);
			model.addAttribute("minDate",date1);
			model.addAttribute("maxDate",date2);
		} catch (AirlineException e) {
			logger.info(e.getMessage());
			String errObj = e.getMessage();
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		return "InsertFlightHome";
	}

	@RequestMapping(value = "/showRetrieveFlightHome.adm")
	public String displayRetrieveFlightHomePage(Model model) {
		return "RetrieveFlightHome";
	}

	@RequestMapping(value = "/showUpdateFlightHome")
	public String displayUpdateFlightPage(Model model) {
		FlightInformationBean updateFlight = new FlightInformationBean();
		model.addAttribute("updateFlight", updateFlight);
		return "UpdateFlightHome";
	}

	@RequestMapping(value = "/showDeleteFlightHome")
	public String displayDeleteFlightPage(Model model) {
		FlightInformationBean deleteFlight = new FlightInformationBean();
		model.addAttribute("deleteFlight", deleteFlight);
		return "DeleteFlightHome";
	}

	@RequestMapping(value = "/addFlightDetail")
	public String addFlightDetailsAction(
			@ModelAttribute("insertFlight") @Valid FlightInformationBean insertFlight,
			BindingResult result, Model model) {
		Date date1 = Date.valueOf(insertFlight.getTempDeptDate());
		Date date2 = Date.valueOf(insertFlight.getTempArrDate());
		insertFlight.setDeptDate(date1);
		insertFlight.setArrDate(date2);
		if (result.hasErrors()) {
			try {
				cityList = adminServ.getCityList();
				model.addAttribute("cityList", cityList);
				model.addAttribute("insertFlight", insertFlight);
				LocalDate date3 = LocalDate.now().plusDays(1);
				LocalDate date4 = date3.plusMonths(2);
				model.addAttribute("minDate",date3);
				model.addAttribute("maxDate",date4);
			} catch (AirlineException e) {
				logger.info(e.getMessage());
				String errObj = e.getMessage();
				model.addAttribute("errObj", errObj);
				return "Error";
			}
			return "InsertFlightHome";
		}
		try {
			adminServ.insertFlight(insertFlight);
		} catch (AirlineException e) {
			logger.info(e.getMessage());
			String errObj = e.getMessage();
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		String msgObj = "Flight Record has been successfully added with flightNo: "
				+ insertFlight.getFlightNo();
		model.addAttribute("msgObj", msgObj);
		return "AdminSuccess";
	}

	@RequestMapping(value = "/updateFlightHome")
	public String updateFlightHomeDetailsAction(
			@ModelAttribute("updateFlight") FlightInformationBean updateFlight,
			Model model) {
		FlightInformationBean updatedFlight = null;
		cityList = new ArrayList<String>();
		try {
			cityList = adminServ.getCityList();
		} catch (AirlineException e) {
			logger.info(e.getMessage());
			String errObj = e.getMessage();
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		try {
			updatedFlight = adminServ.retrieveFlightDetails(updateFlight
					.getFlightNo());
		} catch (AirlineException e) {
			logger.info(e.getMessage());
			String errObj = e.getMessage();
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		if (updatedFlight != null) {
			model.addAttribute("cityList", cityList);
			model.addAttribute("updatedFlight", updatedFlight);
			LocalDate date1 = LocalDate.now().plusDays(1);
			LocalDate date2 = date1.plusMonths(2);
			model.addAttribute("minDate",date1);
			model.addAttribute("maxDate",date2);
		} else {
			logger.info("flight number doesn't exist");
			String errObj = "Flight number doesn't exist....";
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		return "UpdateFlight";

	}

	@RequestMapping(value = "/updateFlight")
	public String updateFlightDetailsAction(
			@ModelAttribute("updatedFlight") @Valid FlightInformationBean updatedFlight,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			try {
				cityList = adminServ.getCityList();
			} catch (AirlineException e) {
				logger.info(e.getMessage());
				String errObj = e.getMessage();
				model.addAttribute("errObj", errObj);
				return "Error";
			}
			if (updatedFlight != null) {
				model.addAttribute("cityList", cityList);
				model.addAttribute("updatedFlight", updatedFlight);
				LocalDate date1 = LocalDate.now().plusDays(1);
				LocalDate date2 = date1.plusMonths(2);
				model.addAttribute("minDate",date1);
				model.addAttribute("maxDate",date2);
			}
			return "UpdateFlight";
		}
		int valid = -1;
		Date date1 = Date.valueOf(updatedFlight.getTempDeptDate());
		Date date2 = Date.valueOf(updatedFlight.getTempArrDate());
		updatedFlight.setDeptDate(date1);
		updatedFlight.setArrDate(date2);
		try {
			valid = adminServ.updateFlight(updatedFlight);
		} catch (AirlineException e) {
			logger.info(e.getMessage());
			String errObj = e.getMessage();
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		if (valid != 0) {
			logger.info("Flight Record has been successfully updated...");
			String msgObj = "Flight Record has been successfully updated...";
			model.addAttribute("msgObj", msgObj);
		}
		return "AdminSuccess";
	}

	@RequestMapping(value = "/deleteFlight")
	public String deleteFlightDetailsAction(
			@ModelAttribute("deleteFlight") FlightInformationBean deleteFlight,
			Model model) {
		FlightInformationBean flight = null;
		boolean valid = true;
		try {
			flight = adminServ
					.retrieveFlightDetails(deleteFlight.getFlightNo());
		} catch (AirlineException e) {
			logger.info(e.getMessage());
			String errObj = e.getMessage();
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		if (flight == null) {
			deleteFlight = new FlightInformationBean();
			model.addAttribute("deleteFlight", deleteFlight);
			logger.info("Flight no is invalid");
			model.addAttribute("msgObj", "FlightNo is invalid..");
			return "DeleteFlightHome";
		}
		try {
			valid = adminServ.deleteFlight(deleteFlight.getFlightNo());
		} catch (AirlineException e) {
			logger.info(e.getMessage());
			String errObj = e.getMessage();
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		if (valid == true) {
			logger.info("Record has been successfully deleted");
			String msgObj = "Record has been successfully deleted...";
			model.addAttribute("msgObj", msgObj);
		} else 
		{
			logger.info("Flight number doesn't exist");
			String errObj = "Flight number doesn't exist....";
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		return "AdminSuccess";
	}

	@RequestMapping(value = "/retrieveIdFlight")
	public String retrieveOnIdFlightDetailsAction(
			@ModelAttribute("retrieveFlight") FlightInformationBean retrieveFlight,
			Model model) {
		FlightInformationBean bean = null;
		try {
			bean = adminServ
					.retrieveFlightDetails(retrieveFlight.getFlightNo());
		} catch (AirlineException e) {
			logger.info(e.getMessage());
			String errObj = e.getMessage();
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		if (bean != null) {
			ArrayList<FlightInformationBean> flightBean = new ArrayList<FlightInformationBean>();
			flightBean.add(bean);
			model.addAttribute("flights", flightBean);
		} else {
			logger.info("Flight number doesn't exist....");
			String errObj = "Flight number doesn't exist....";
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		return "RetrieveFlightSuccess";
	}

	@RequestMapping(value = "/retrieveAllFlights")
	public String retrieveAllFlightDetailsAction(Model model) {
		ArrayList<FlightInformationBean> list = new ArrayList<FlightInformationBean>();
		String result = null;
		try {
			list = adminServ.retrieveAllFlights();
		} catch (AirlineException e) {
			logger.info(e.getMessage());
			String errObj = e.getMessage();
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		if (list != null) {
			model.addAttribute("flights", list);
			result = "RetrieveFlightSuccess";

		} else {
			logger.info("No record found");
			String errObj = "No Record Found....";
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		return result;
	}

	@RequestMapping(value = "/retrieveFlight")
	public String displayRetrieveFlightPage(Model model) {
		FlightInformationBean retrieveFlight = new FlightInformationBean();
		model.addAttribute("retrieveFlight", retrieveFlight);
		return "RetrieveFlight";
	}

	@RequestMapping(value = "/showSuccessPage")
	public String displayAdminSuccessPage(Model model) {
		return "AdminSuccess";
	}

	@RequestMapping(value = "/showAdminMenu")
	public String displayAdminMenu(Model model) {
		return "AdminHome";
	}

}
