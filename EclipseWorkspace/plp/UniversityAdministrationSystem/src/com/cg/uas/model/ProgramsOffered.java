package com.cg.uas.model;

public class ProgramsOffered {
private String programName;
private String description;
private String applicantEligibility;
private int duration;
private String DegreeCertificateOffered;

public ProgramsOffered(String programName, String description,
		String applicantEligibility) {
	super();
	this.programName = programName;
	this.description = description;
	this.applicantEligibility = applicantEligibility;
}
public String getProgramName() {
	return programName;
}
public void setProgramName(String programName) {
	this.programName = programName;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getApplicantEligibility() {
	return applicantEligibility;
}
public void setApplicantEligibility(String applicantEligibility) {
	this.applicantEligibility = applicantEligibility;
}
public int getDuration() {
	return duration;
}
public void setDuration(int duration) {
	this.duration = duration;
}
public String getDegreeCertificateOffered() {
	return DegreeCertificateOffered;
}
public void setDegreeCertificateOffered(String degreeCertificateOffered) {
	DegreeCertificateOffered = degreeCertificateOffered;
}
public ProgramsOffered() {
	super();
	// TODO Auto-generated constructor stub
}
public ProgramsOffered(String programName, String description,
		String applicantEligibility, int duration,
		String degreeCertificateOffered) {
	super();
	this.programName = programName;
	this.description = description;
	this.applicantEligibility = applicantEligibility;
	this.duration = duration;
	DegreeCertificateOffered = degreeCertificateOffered;
}
public ProgramsOffered(String cname) {
	// TODO Auto-generated constructor stub
}

}
