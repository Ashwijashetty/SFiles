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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.ars.bean.BookingInformationBean;
import com.capgemini.ars.bean.FlightInformationBean;
import com.capgemini.ars.exception.AirlineException;
import com.capgemini.ars.service.IUserService;

@Controller
public class UserController {
	@Autowired
	IUserService userServ;
	ArrayList<String> cityList;
	Logger logger=Logger.getLogger(UserController.class);
	public IUserService getUserServ() {
		return userServ;
	}

	public void setUserServ(IUserService userServ) {
		this.userServ = userServ;
	}

	public UserController() {
	}

	@RequestMapping(value = "/showBookFlight")
	public String displayUserBookFlightPage(Model model) {
		cityList = new ArrayList<String>();
		try {
			cityList = userServ.getCityList();
			model.addAttribute("cityList", cityList);
		} catch (AirlineException e) {
			logger.info(e.getMessage());
			String errObj = e.getMessage();
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		FlightInformationBean flightInfo = new FlightInformationBean();
		model.addAttribute("flightInfo", flightInfo);
		LocalDate date1 = LocalDate.now().plusDays(1);
		LocalDate date2 = date1.plusMonths(2);
		model.addAttribute("minDate",date1);
		model.addAttribute("maxDate",date2);
		return "UserBookFlight";
	}

	@RequestMapping(value = "/fetchFlightDetails", method = RequestMethod.POST)
	public String addBookingDetailsAction(
			@ModelAttribute("flightInfo") FlightInformationBean flightInfo,
			Model model) {
		Date date1 = Date.valueOf(flightInfo.getTempDeptDate());
		flightInfo.setDeptDate(date1);
		flightInfo.setArrDate(date1);
		ArrayList<FlightInformationBean> flightList = null;
		try {
			flightList = userServ.fetchAvailableFlights(flightInfo,
					flightInfo.getClassType(), flightInfo.getPassengers());
		} catch (AirlineException e) {
			logger.info("Due to some technical problems,flight schedule cannot be displayed..");
			String errObj = "Due to some technical problems,flight schedule cannot be displayed..";
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		
		if (flightList.size()>0) {
			model.addAttribute("flightInfo", flightInfo);
			model.addAttribute("flightList", flightList);
		} else {
			logger.info("No Flights are available....");
			String errObj = "No Flights are available....";
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		return "UserFlightSchedule";
	}

	@RequestMapping(value = "/insertBookingDetails")
	public String insertBookingDetailsAction(
			@ModelAttribute("selectedFlight") @Valid FlightInformationBean flightInfo,
			BindingResult result, Model model) {
		int bookingId;
		FlightInformationBean selectedFlight = null;
		int flight = flightInfo.getFlightNo();
		try {
			selectedFlight = userServ.retrieveFlightDetails(flight);
		} catch (AirlineException e) {
			logger.info("Due to some technical problems, booking cannot be done..");
			String errObj = "Due to some technical problems, booking cannot be done..";
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		int bussSeats = selectedFlight.getBussSeats();
		int firstSeats = selectedFlight.getFirstSeats();
		BookingInformationBean bookBean = new BookingInformationBean();
		bookBean.setClassType(flightInfo.getClassType());
		bookBean.setCreditCardInfo(flightInfo.getCcno());
		bookBean.setCustEmail(flightInfo.getEmail());
		bookBean.setDestCity(selectedFlight.getArrCity());
		bookBean.setSrcCity(selectedFlight.getDeptCity());
		bookBean.setFlightNo(selectedFlight.getFlightNo());
		bookBean.setNoOfPassengers(flightInfo.getPassengers());
		int passengers = flightInfo.getPassengers();
		String classType = flightInfo.getClassType();
		StringBuilder seatNo = new StringBuilder();
		if (classType.equalsIgnoreCase("first")) {
			for (int i = 1; i <= passengers; i++, --firstSeats) {
				seatNo.append("F");
				seatNo.append(firstSeats);
				seatNo.append(" ");
			}
		} else {
			for (int i = 1; i <= passengers; i++, --bussSeats) {
				seatNo.append("B");
				seatNo.append(bussSeats);
				seatNo.append(" ");
			}

		}
		String seatNumber = seatNo.toString();
		bookBean.setSeatNumber(seatNumber);
		if (classType.equalsIgnoreCase("first")) {
			bookBean.setTotalFare(selectedFlight.getFirstSeatsFare()
					* flightInfo.getPassengers());
		} else {
			bookBean.setTotalFare(selectedFlight.getBussSeatsFare()
					* flightInfo.getPassengers());
		}
		try {
			bookingId = userServ.bookFlight(bookBean, passengers);
		} catch (AirlineException e) {
			logger.info(e.getMessage());
			String errObj = e.getMessage();
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		bookBean.setBookingId(bookingId);
		model.addAttribute("bookBean", bookBean);
		if (bookBean.getBookingId() == 0) {
			logger.info("Booking Failed");
			String errObj = "Booking failed";
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		return "UserBookSuccess";

	}

	@RequestMapping(value = "/showPaymentPage")
	public String showPaymentPageAction(
			@ModelAttribute("flightInfo") FlightInformationBean flightInfo,
			Model model) {
		FlightInformationBean selectedFlight = null;
		int flight = flightInfo.getFlightNo();
		try {
			selectedFlight = userServ.retrieveFlightDetails(flight);
		} catch (AirlineException e) {
			logger.info("Due to some technical problems, booking cannot be done..");
			String errObj = "Due to some technical problems, booking cannot be done..";
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		selectedFlight.setPassengers(flightInfo.getPassengers());
		selectedFlight.setClassType(flightInfo.getClassType());
		model.addAttribute("selectedFlight", selectedFlight);
		return "Payment";
	}

	@RequestMapping(value = "/showUserManageHome")
	public String displayUserManageHomePage(Model model) {
		return "UserManageHome";
	}

	@RequestMapping(value = "/showRescheduleBookingHomeDetails")
	public String displayUserRescheduleHomePage(Model model) {
		BookingInformationBean bookBean = new BookingInformationBean();
		model.addAttribute("bookBean", bookBean);
		return "UserRescheduleHome";
	}

	@RequestMapping(value = "/showRescheduleBookingDetails")
	public String rescheduleBookingHomeDetailsAction(
			@ModelAttribute("bookBean") BookingInformationBean bookBean,
			Model model) {
		int bookingId = bookBean.getBookingId();
		BookingInformationBean rescheduleBookInfoBean = new BookingInformationBean();
		try {
			rescheduleBookInfoBean = userServ.retrieveBookingDetails(bookingId);
		} catch (AirlineException e) {
			logger.info(e.getMessage());
			String errObj = e.getMessage();
			model.addAttribute("errObj", errObj);
			return "Error";
		}

		if (rescheduleBookInfoBean != null) {
			/*
			 * flightBean =
			 * userServ.retrieveFlightDetails(rescheduleBookInfoBean
			 * .getFlightNo()); model.addAttribute("flightBean",flightBean);
			 */
			model.addAttribute("rescheduleBookInfoBean", rescheduleBookInfoBean);
			// BookingInformationBean booking = new BookingInformationBean();
			// model.addAttribute("booking",booking);
		} else {
			logger.info("No record Found....Please Enter valid booking id");
			String errObj = "No record Found....Please Enter valid booking id";
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		return "UserReschedule";
	}

	@RequestMapping(value = "/rescheduleBookingDetails")
	public String rescheduleBookingDetailsAction(
			@ModelAttribute("rescheduleBookInfoBean") BookingInformationBean rescheduleBookInfoBean,
			Model model) {
		char reschedule = rescheduleBookInfoBean.getStatus();
		if (reschedule == 'y' || reschedule == 'Y') {
			model.addAttribute("rescheduleBookInfoBean", rescheduleBookInfoBean);
			LocalDate date1 = LocalDate.now().plusDays(1);
			LocalDate date2 = date1.plusMonths(2);
			model.addAttribute("minDate",date1);
			model.addAttribute("maxDate",date2);
			return "UserRescheduleFlightHome";
		} else
			return "UserRescheduleHome";
	}

	@RequestMapping(value = "/rescheduleBookingGetInfoDetails")
	public String rescheduleBookingGetInfoDetailsAction(
			@ModelAttribute("rescheduleBookInfoBean") BookingInformationBean rescheduleBookInfoBean,
			Model model) {
		FlightInformationBean flightInfo = new FlightInformationBean();
		Date date1 = Date.valueOf(rescheduleBookInfoBean.getTempDeptDate());
		flightInfo.setDeptDate(date1);
		flightInfo.setFlightNo(rescheduleBookInfoBean.getFlightNo());
		flightInfo.setDeptCity(rescheduleBookInfoBean.getSrcCity());
		flightInfo.setArrCity(rescheduleBookInfoBean.getDestCity());
		String classType = rescheduleBookInfoBean.getClassType();
		int noOfPassengers = rescheduleBookInfoBean.getNoOfPassengers();
		ArrayList<FlightInformationBean> flightList = null;
		try {
			flightList = userServ.fetchAvailableFlights(flightInfo, classType,
					noOfPassengers);
		} catch (AirlineException e) {
			logger.info(e.getMessage());
			String errObj = e.getMessage();
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		if (flightList != null) {
			/*
			 * int index=0; Iterator itr = flightList.iterator();
			 * while(itr.hasNext()) { FlightInformationBean flight =
			 * (FlightInformationBean)itr.next(); if(flight.getFlightNo()==
			 * flightInfo.getFlightNo()) {
			 * 
			 * flightList.remove(index); } index++; }
			 */

			model.addAttribute("classType", classType);
			model.addAttribute("flightList", flightList);
			model.addAttribute("passengers", noOfPassengers);
			model.addAttribute("previousFlight",
					rescheduleBookInfoBean.getFlightNo());
			model.addAttribute("rescheduleBookInfoBean", rescheduleBookInfoBean);
		} else {
			logger.info("No flights are available");
			String errObj = "No Flights are available....";
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		return "UserRescheduleFlight";
	}

	@RequestMapping(value = "/rescheduleBookingChooseFlightDetails.usr")
	public String rescheduleBookingChooseFlightDetailsAction(
			@RequestParam("flight") int flightNo,
			@ModelAttribute("rescheduleBookInfoBean") BookingInformationBean rescheduleBookInfoBean,
			Model model) {
		try {
			int tempFlight = rescheduleBookInfoBean.getFlightNo();
			rescheduleBookInfoBean.setFlightNo(flightNo);
			flightNo = tempFlight;

			if (userServ.rescheduleBooking(rescheduleBookInfoBean, flightNo,
					rescheduleBookInfoBean.getNoOfPassengers())) {
				rescheduleBookInfoBean.setFlightNo(flightNo);
				model.addAttribute("rescheduleBookInfoBean",
						rescheduleBookInfoBean);
				return "UserRescheduleSuccess";
			}
		} catch (AirlineException e) {
			logger.info(e.getMessage());
			String errObj = e.getMessage();
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		String errObj = "Due to technical Problems,Reschedule cannot be initiated..";
		model.addAttribute("errObj", errObj);
		return "Error";

	}

	@RequestMapping(value = "/showCancelBookingHomeDetails.usr")
	public String displayUserCancelHomePage(Model model) {
		BookingInformationBean cancelBookInfoBean = new BookingInformationBean();
		model.addAttribute("cancelBookInfoBean", cancelBookInfoBean);
		return "UserCancelHome";
	}

	@RequestMapping(value = "/showCancelBookingDetails")
	public String cancelBookingHomeDetailsAction(
			@ModelAttribute("cancelBookInfoBean") BookingInformationBean cancelBookInfoBean,
			Model model) {
		try {
			cancelBookInfoBean = userServ
					.retrieveBookingDetails(cancelBookInfoBean.getBookingId());
		} catch (AirlineException e) {
			logger.info(e.getMessage());
			String errObj = e.getMessage();
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		if (cancelBookInfoBean != null) {
			model.addAttribute("cancelBookInfoBean", cancelBookInfoBean);
		} else {
			logger.info("No record Found....Please Enter valid booking id");
			String errObj = "No record Found....Please Enter valid booking id";
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		return "UserCancel";
	}

	@RequestMapping(value = "/cancelBookingDetails")
	public String cancelBookingDetailsAction(
			@ModelAttribute("cancelBookInfoBean") BookingInformationBean cancelBookInfoBean,
			Model model) {
		if (cancelBookInfoBean.getStatus() == 'Y'
				|| cancelBookInfoBean.getStatus() == 'y') {
			try {
				userServ.cancelBooking(cancelBookInfoBean.getBookingId(),
						cancelBookInfoBean.getNoOfPassengers());
				String msgObj = "Your booking with booking Id: "
						+ cancelBookInfoBean.getBookingId()
						+ " has been cancelled Successfully";
				model.addAttribute("msgObj", msgObj);
				return "UserCancelSuccess";
			} catch (AirlineException e) {
				logger.info(e.getMessage());
				String errObj = e.getMessage();
				model.addAttribute("errObj", errObj);
				return "Error";
			}
		} else {
			return "UserManageHome";
		}
	}

	@RequestMapping(value = "/showViewFlightStatus")
	public String displayViewFlightStatusPage(Model model) {
		BookingInformationBean viewFlight = new BookingInformationBean();
		model.addAttribute("viewFlight", viewFlight);
		return "ViewFlightStatus";
	}

	@RequestMapping(value = "/viewFlightStatus")
	public String viewFlightStatusAction(
			@ModelAttribute("viewFlight") BookingInformationBean viewFlight,
			Model model) {
		BookingInformationBean viewBookInfoBean = new BookingInformationBean();
		try {
			viewBookInfoBean = userServ.retrieveBookingDetails(viewFlight
					.getBookingId());
		} catch (AirlineException e) {
			logger.info(e.getMessage());
			String errObj = e.getMessage();
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		if (viewBookInfoBean != null) {
			FlightInformationBean viewFlightBean = new FlightInformationBean();
			try {
				viewFlightBean = userServ
						.retrieveFlightDetails(viewBookInfoBean.getFlightNo());
			} catch (AirlineException e) {
				logger.info(e.getMessage());
				String errObj = e.getMessage();
				model.addAttribute("errObj", errObj);
				return "Error";
			}
			model.addAttribute("bookInfoBean", viewBookInfoBean);
			model.addAttribute("viewFlightBean", viewFlightBean);
		} else {
			logger.info("Booking Id doesn't exist.Please enter a valid booking id");
			String errObj = "Booking Id doesn't exist.Please enter a valid booking id";
			model.addAttribute("errObj", errObj);
			return "Error";
		}
		return "ViewFlightSuccess";
	}
}