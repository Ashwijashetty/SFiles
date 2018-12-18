package com.cg.tms.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "trainees")
public class TraineeBean {

	@Id
	//@NotEmpty(message="Enter Id")
	//@Pattern(regexp="[0-9]{6}",message="Enter 6 digit code")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int traineeId;

	@NotEmpty(message = "Please Enter Trainee Name")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Trainee name must contain only alphabets")
	private String traineeName;
	@NotEmpty(message = "Please Enter Domain Name")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Domain name must contain only alphabets")
	private String traineeDomain;
	@NotEmpty(message = "Please Enter Location")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Name of location must contain only alphabets")
	private String traineeLocation;
	public int getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public String getTraineeDomain() {
		return traineeDomain;
	}
	public void setTraineeDomain(String traineeDomain) {
		this.traineeDomain = traineeDomain;
	}
	public String getTraineeLocation() {
		return traineeLocation;
	}
	public void setTraineeLocation(String traineeLocation) {
		this.traineeLocation = traineeLocation;
	}
	public TraineeBean(int traineeId, String traineeName, String traineeDomain,
			String traineeLocation) {
		super();
		this.traineeId = traineeId;
		this.traineeName = traineeName;
		this.traineeDomain = traineeDomain;
		this.traineeLocation = traineeLocation;
	}

	public TraineeBean() {
		// TODO Auto-generated constructor stub
	}

}
