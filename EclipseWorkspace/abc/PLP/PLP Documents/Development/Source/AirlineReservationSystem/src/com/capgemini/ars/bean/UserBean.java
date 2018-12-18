package com.capgemini.ars.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Users")
public class UserBean {
	@Id
	@NotEmpty(message = "Field is Mandatory")
	private String userName;

	@NotEmpty(message = "Field is Mandatory")
	private String password;
	private String role;
	private String mobileNo;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "UserBean [userName=" + userName + ", password=" + password
				+ ", role=" + role + ", mobileNo=" + mobileNo + "]";
	}

}
