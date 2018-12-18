package com.capgemini.ars.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Airport")
public class AirportBean {
	@Id
	private String airportName;
	private String abbreviation;
	private String location;

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "AirportBean [airportName=" + airportName + ", abbreviation="
				+ abbreviation + ", location=" + location + "]";
	}

}
