package com.capgemini.ars.bean;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "FlightInformation")
public class FlightInformationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "flightSeq", sequenceName = "FLIGHT_NO_SEQ", initialValue = 1230, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flightSeq")
	@Column(unique = true)
	private int flightNo;

	@Pattern(regexp = "[A-Za-z ]{5,30}", message = "Must be in characters only in range of 5 to 30 !!")
	private String airline;

	@Column(name = "dept_city")
	private String deptCity;

	@Column(name = "arr_city")
	private String arrCity;

	@Column(name = "dept_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deptDate;

	@Transient
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate tempDeptDate;

	@Transient
	private String classType;

	@Transient
	private int passengers;

	@Transient
	private String ccno;

	@Transient
	private String email;

	@Column(name = "arr_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date arrDate;

	@Transient
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate tempArrDate;

	@NotEmpty
	@Column(name = "dept_time")
	@Pattern(regexp = "^[0-9]{4}$", message = "Must be entered in format: HHMM !!")
	private String deptTime;

	@NotEmpty
	@Column(name = "arr_time")
	@Pattern(regexp = "^[0-9]{4}$", message = "Must be entered in format: HHMM !!")
	private String arrTime;

	@NotNull(message = "Please fill out this field")
	// @Size(min=2,max=2,message="Should be in 2 digits only")
	private Integer firstSeats;

	@NotNull(message = "Please fill out this field")
	// @Size(min=3,max=6,message="Should be between 3-6 digits")
	private Double firstSeatsFare;

	@NotNull(message = "Please fill out this field")
	// @Size(min=2,max=2,message="Should be in 2 digits only")
	private Integer bussSeats;

	@NotNull(message = "Please fill out this field")
	// @Size(min=3,max=6,message="Should be between 3-6 digits")
	private Double bussSeatsFare;

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getDeptCity() {
		return deptCity;
	}

	public void setDeptCity(String deptCity) {
		this.deptCity = deptCity;
	}

	public String getArrCity() {
		return arrCity;
	}

	public void setArrCity(String arrCity) {
		this.arrCity = arrCity;
	}

	public Date getDeptDate() {
		return deptDate;
	}

	public void setDeptDate(Date deptDate) {
		this.deptDate = deptDate;
	}

	public Date getArrDate() {
		return arrDate;
	}

	public void setArrDate(Date arrDate) {
		this.arrDate = arrDate;
	}

	public String getDeptTime() {
		return deptTime;
	}

	public void setDeptTime(String deptTime) {
		this.deptTime = deptTime;
	}

	public String getArrTime() {
		return arrTime;
	}

	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}

	public Integer getFirstSeats() {
		return firstSeats;
	}

	public void setFirstSeats(Integer firstSeats) {
		this.firstSeats = firstSeats;
	}

	public Double getFirstSeatsFare() {
		return firstSeatsFare;
	}

	public void setFirstSeatsFare(Double firstSeatsFare) {
		this.firstSeatsFare = firstSeatsFare;
	}

	public Integer getBussSeats() {
		return bussSeats;
	}

	public void setBussSeats(Integer bussSeats) {
		this.bussSeats = bussSeats;
	}

	public Double getBussSeatsFare() {
		return bussSeatsFare;
	}

	public void setBussSeatsFare(Double bussSeatsFare) {
		this.bussSeatsFare = bussSeatsFare;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	public String getCcno() {
		return ccno;
	}

	public void setCcno(String ccno) {
		this.ccno = ccno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getTempDeptDate() {
		return tempDeptDate;
	}

	public void setTempDeptDate(LocalDate tempDeptDate) {
		this.tempDeptDate = tempDeptDate;
	}

	public LocalDate getTempArrDate() {
		return tempArrDate;
	}

	public void setTempArrDate(LocalDate tempArrDate) {
		this.tempArrDate = tempArrDate;
	}

	@Override
	public String toString() {
		return "FlightInformationBean [flightNo=" + flightNo + ", airline="
				+ airline + ", deptCity=" + deptCity + ", arrCity=" + arrCity
				+ ", deptDate=" + deptDate + ", arrDate=" + arrDate
				+ ", deptTime=" + deptTime + ", arrTime=" + arrTime
				+ ", firstSeats=" + firstSeats + ", firstSeatsFare="
				+ firstSeatsFare + ", BussSeats=" + bussSeats
				+ ", BussSeatsFare=" + bussSeatsFare + "]";
	}

}
