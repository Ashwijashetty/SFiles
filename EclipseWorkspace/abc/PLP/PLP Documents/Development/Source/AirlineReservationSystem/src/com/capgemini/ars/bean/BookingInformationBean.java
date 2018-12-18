package com.capgemini.ars.bean;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BookingInformation")
public class BookingInformationBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "bookingSeq", sequenceName = "BOOKING_ID_SEQ", allocationSize = 1, initialValue = 10001)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookingSeq")
	@Column(unique = true)
	private int bookingId;
	private int flightNo;

	@Column(name = "email")
	@Email(message = "Must be a valid email Id !!")
	private String custEmail;

	@Column(name = "no_of_passengers")
	private int noOfPassengers;

	@Column(name = "class_type")
	private String classType;

	@Column(name = "total_fare")
	private double totalFare;

	@Column(name = "seat_number")
	private String seatNumber;

	@Column(name = "creditcard_information")
	@Pattern(regexp = "[0-9]{10}", message = "Must be of 10 digits only !!")
	private String creditCardInfo;

	@Column(name = "src_city")
	private String srcCity;

	@Column(name = "dest_city")
	private String destCity;

	@Transient
	private char status;

	@Transient
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate tempDeptDate;

	public BookingInformationBean() {
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getCreditCardInfo() {
		return creditCardInfo;
	}

	public void setCreditCardInfo(String creditCardInfo) {
		this.creditCardInfo = creditCardInfo;
	}

	public String getSrcCity() {
		return srcCity;
	}

	public void setSrcCity(String srcCity) {
		this.srcCity = srcCity;
	}

	public String getDestCity() {
		return destCity;
	}

	public void setDestCity(String destCity) {
		this.destCity = destCity;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public LocalDate getTempDeptDate() {
		return tempDeptDate;
	}

	public void setTempDeptDate(LocalDate tempDeptDate) {
		this.tempDeptDate = tempDeptDate;
	}

	@Override
	public String toString() {
		return "BookingInformationBean [bookingId=" + bookingId + ", flightNo="
				+ flightNo + ", custEmail=" + custEmail + ", noOfPassengers="
				+ noOfPassengers + ", classType=" + classType + ", totalFare="
				+ totalFare + ", seatNumber=" + seatNumber
				+ ", creditCardInfo=" + creditCardInfo + ", srcCity=" + srcCity
				+ ", destCity=" + destCity + "]";
	}

}
