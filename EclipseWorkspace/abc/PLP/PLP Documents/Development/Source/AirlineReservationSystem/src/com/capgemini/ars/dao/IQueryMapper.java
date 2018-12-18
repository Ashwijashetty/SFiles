package com.capgemini.ars.dao;

public interface IQueryMapper {

	/*************************************** CUSTOMER QUERIES **********************************************/
	public static final String CHECK_FIRST_CLASS_AVAILABILITY = "SELECT f FROM FlightInformationBean f WHERE f.deptCity=:dc AND f.arrCity=:ac AND f.deptDate=:dt AND f.firstSeats>=:fs";
	public static final String CHECK_BUSINESS_CLASS_AVAILABILITY = "SELECT f FROM FlightInformationBean f WHERE f.deptCity=:dc AND f.arrCity=:ac AND f.deptDate=:dt AND f.bussSeats>=:bs";
	public static final String DEC_FIRST_CLASS_OCCUPANCY = "UPDATE FlightInformationBean f SET firstSeats=firstSeats-:pn WHERE flightNo=:fn";
	public static final String DEC_BUSINESS_CLASS_OCCUPANCY = "UPDATE FlightInformationBean f SET bussSeats=bussSeats-:pn WHERE flightNo=:fn";
	public static final String UPDATE_BOOKING_INFORMATION = "UPDATE BookingInformationBean b SET b.flightNo=:fn WHERE b.bookingId=:bi";
	public static final String INC_FIRST_CLASS_OCCUPANCY = "UPDATE FlightInformationBean f SET firstSeats=firstSeats+:pn WHERE flightNo=:fn";
	public static final String INC_BUSINESS_CLASS_OCCUPANCY = "UPDATE FlightInformationBean f SET bussSeats=bussSeats+:pn WHERE flightNo=:fn";

	/*************************************** AIRLINE EXECUTIVE QUERIES **********************************************/

	public static final String FETCH_FLIGHT_GIVEN_AIRLINE_AND_PERIOD = "SELECT f FROM FlightInformationBean f WHERE f.airline=:air AND dept_date BETWEEN :fd AND :ld AND dept_time BETWEEN :ft AND :lt";
	public static final String FETCH_FLIGHT_GIVEN_SOURCE_AND_DESTINATION = "SELECT f FROM FlightInformationBean f WHERE dept_city=:dc AND arr_city=:ac";

	/*************************************** ADMINISTRATOR QUERIES **********************************************/
	public static final String RETRIEVE_ALL_FLIGHTS = "SELECT f FROM FlightInformationBean f";
	public static final String UPDATE_FLIGHT_DETAILS = "UPDATE FlightInformationBean SET dept_city=:dc,arr_city=:ac,dept_date=:dd,arr_date=:ad,dept_time=:dt,arr_time=:at,firstSeats=:fs,firstseatsfare=:fsf,bussseats=:bs,bussseatsfare=:bsf WHERE flightNo =:fn";
	public static final String RETRIEVE_ALL_LOCATIONS = "SELECT f.city FROM LocationBean f";

}
