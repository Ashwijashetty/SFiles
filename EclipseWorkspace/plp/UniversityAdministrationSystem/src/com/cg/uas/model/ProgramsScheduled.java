package com.cg.uas.model;

import java.util.Date;

public class ProgramsScheduled {
private String scheduledProgramId;
private String ProgramName;
private String Location;
private Date startDate;
private Date endDate;
private int sessonsPerWeek;

public ProgramsScheduled() {
	super();
	// TODO Auto-generated constructor stub
}
public ProgramsScheduled(String scheduledProgramId, String programName,
		String location, Date startDate, Date endDate, int sessonsPerWeek) {
	super();
	this.scheduledProgramId = scheduledProgramId;
	ProgramName = programName;
	Location = location;
	this.startDate = startDate;
	this.endDate = endDate;
	this.sessonsPerWeek = sessonsPerWeek;
}
public String getScheduledProgramId() {
	return scheduledProgramId;
}
public void setScheduledProgramId(String scheduledProgramId) {
	this.scheduledProgramId = scheduledProgramId;
}
public String getProgramName() {
	return ProgramName;
}
public void setProgramName(String programName) {
	ProgramName = programName;
}
public String getLocation() {
	return Location;
}
public void setLocation(String location) {
	Location = location;
}
public Date getStartDate() {
	return startDate;
}
public void setStartDate(Date startDate) {
	this.startDate = startDate;
}
public Date getEndDate() {
	return endDate;
}
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}
public int getSessonsPerWeek() {
	return sessonsPerWeek;
}
public void setSessonsPerWeek(int sessonsPerWeek) {
	this.sessonsPerWeek = sessonsPerWeek;
}

}
