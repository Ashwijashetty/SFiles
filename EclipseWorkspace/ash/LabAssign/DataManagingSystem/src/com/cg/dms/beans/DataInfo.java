package com.cg.dms.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="data_info")
public class DataInfo {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer id;

@NotEmpty(message="Enter name")
@Pattern(regexp = "^[A-Za-z]+$", message = "Username must contain only alphabets")
private String name;

@NotEmpty(message="Enter email")
private String email;

@NotEmpty(message="Enter number")
@Size(min=7,max=10,message="Phone Number Should Accept Only 10 digits")
@Pattern(regexp = "^[0-9]{10}+$", message = "Phone Number should contain only 10 digits")
private String phoneNum;

private Date gdate;



public String getPhoneNum() {
	return phoneNum;
}
public void setPhoneNum(String phoneNum) {
	this.phoneNum = phoneNum;
}
@Override
public String toString() {
	return "DataInfo [id=" + id + ", name=" + name + ", email=" + email
			+ ", gdate=" + gdate + "]";
}
public Date getGdate() {
	return gdate;
}
public void setGdate(Date gdate) {
	this.gdate = gdate;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

}
