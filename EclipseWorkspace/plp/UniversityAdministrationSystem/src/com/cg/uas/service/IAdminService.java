package com.cg.uas.service;

import java.util.List;

import com.cg.uas.exceptions.UASException;
import com.cg.uas.model.ProgramsOffered;
import com.cg.uas.model.ProgramsScheduled;

public interface IAdminService {

	String addCouse(ProgramsOffered offered) throws UASException;

	int updateCourse(ProgramsOffered offered) throws UASException;

	int removeCourse(String cname) throws UASException;

	List<ProgramsOffered> getAllCourses() throws UASException;

	ProgramsOffered getByName(String cName) throws UASException;

	String addSchedule(ProgramsScheduled scheduled) throws UASException;

	int ScheduleDelete(String programName) throws UASException;



	

}
