package com.cg.uas.service;

import java.util.List;

import com.cg.uas.dao.AdminDaoImpl;
import com.cg.uas.dao.IAdminDao;
import com.cg.uas.exceptions.UASException;
import com.cg.uas.model.ProgramsOffered;
import com.cg.uas.model.ProgramsScheduled;

public class AdminServiceImpl implements IAdminService {
IAdminDao adminDao=new AdminDaoImpl();
	@Override
	public String addCouse(ProgramsOffered offered) throws UASException {
	
		return adminDao.addCourse(offered);
	}
	@Override
	public int updateCourse(ProgramsOffered offered) throws UASException {
		
		return adminDao.updateCourse(offered);
		
	}
	@Override
	public int removeCourse(String cname) throws UASException {
		return adminDao.removeCourse(cname);
	}
	@Override
	public List<ProgramsOffered> getAllCourses() throws UASException {
		
		return adminDao.getAllCourses();
	}
	@Override
	public ProgramsOffered getByName(String cName) throws UASException {
		// TODO Auto-generated method stub
		return adminDao.getByName(cName);
	}
	@Override
	public String addSchedule(ProgramsScheduled scheduled) throws UASException {
		// TODO Auto-generated method stub
		return adminDao.addSchedule(scheduled);
	}
	@Override
	public int ScheduleDelete(String programName) throws UASException {
		// TODO Auto-generated method stub
		return adminDao.ScheduleDelete(programName);
	}
	

}
