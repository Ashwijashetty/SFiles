package com.cg.uas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cg.uas.exceptions.UASException;
import com.cg.uas.model.ProgramsOffered;
import com.cg.uas.model.ProgramsScheduled;
import com.cg.uas.utility.JdbcUtility;

public class AdminDaoImpl implements IAdminDao {
	Connection connection=null;
	PreparedStatement statement=null;
	ResultSet resultSet=null;
	
	@Override
	public String addSchedule(ProgramsScheduled scheduled) throws UASException {
		String id=null;
		int check=0;
		/*
			Date date=account.getDate();
			long ms=date.getTime();
			
			java.sql.Date date2=new java.sql.Date(ms);
			statement.setDate(4, date2);*/
		Date startDate=scheduled.getStartDate();
		long ms1=startDate.getTime();
		java.sql.Date date1=new java.sql.Date(ms1);
		Date endDate=scheduled.getEndDate();
		long ms2=endDate.getTime();
		java.sql.Date date2=new java.sql.Date(ms2);
		
		
		try {
			connection=JdbcUtility.getconnection();
			statement=connection.prepareStatement(QueryConstants.addSchedule);
			statement.setString(1, scheduled.getScheduledProgramId());
			statement.setString(2, scheduled.getProgramName());
			statement.setString(3, scheduled.getLocation());
			statement.setDate(4, date1);
			statement.setDate(5, date2);
			statement.setInt(6, scheduled.getSessonsPerWeek());
			check=statement.executeUpdate();
			if(check>0)
				id=scheduled.getScheduledProgramId();
		} catch (SQLException e) {
			throw new UASException("sql6");
		}finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new UASException("problem while closing");
			}
		}
		
		return id;
	}

	
	@Override
	public ProgramsOffered getByName(String cName) throws UASException {
	
			connection=JdbcUtility.getconnection();
			ProgramsOffered proffered=new ProgramsOffered();
		
		try {
			statement=connection.prepareStatement(QueryConstants.getProgramById);
			statement.setString(1, cName);
			resultSet=statement.executeQuery();
		
			if(resultSet.next()){
			proffered.setProgramName(resultSet.getString(1));
			proffered.setDescription(resultSet.getString(2));
			proffered.setApplicantEligibility(resultSet.getString(3));
			proffered.setDuration(resultSet.getInt(4));
			proffered.setDegreeCertificateOffered(resultSet.getString(5));
			
			}
		} catch (SQLException e) {
			throw new UASException("sql 5");
		}finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new UASException("problem while closing");
			}
		}return proffered;
	
	}
	@Override
	public List<ProgramsOffered> getAllCourses() throws UASException {
		connection=JdbcUtility.getconnection();
		List<ProgramsOffered> list=new ArrayList<ProgramsOffered>();
		try {
			statement=connection.prepareStatement(QueryConstants.viewCourse);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next()){
				String proName=resultSet.getString(1);
				String desc=resultSet.getString(2);
				String applEg=resultSet.getString(3);
				int duration=resultSet.getInt(4);
				String certificate=resultSet.getString(5);
				
				ProgramsOffered offered=new ProgramsOffered(proName,desc,applEg,duration,certificate);
				list.add(offered);
			}
		} catch (SQLException e) {
			throw new UASException("sql4");
		}finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new UASException("problem while closing");
			}
		}
		return list;
	}
	
	@Override
	public String addCourse(ProgramsOffered offered) throws UASException {
String pName=null;

int check=0;

	try {
		connection=JdbcUtility.getconnection();
		statement=connection.prepareStatement(QueryConstants.addCourse);
	 
		statement.setString(1, offered.getProgramName());
		statement.setString(2, offered.getDescription());
		statement.setString(3, offered.getApplicantEligibility());
		statement.setInt(4, offered.getDuration());
		statement.setString(5, offered.getDegreeCertificateOffered());
		check=statement.executeUpdate();

		if(check>0)
			pName=offered.getProgramName();
	} catch (SQLException e) {
		throw new UASException("error in sql of admin");
	}finally {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new UASException("problem while closing");
		}
	}
		return pName;
	}

	@Override
	public int updateCourse(ProgramsOffered offered) throws UASException {
		int res=0;
		
		try {
			connection=JdbcUtility.getconnection();
			statement=connection.prepareStatement(QueryConstants.updateCourse);
			statement.setString(1, offered.getDescription());
			statement.setString(2, offered.getApplicantEligibility());
			statement.setString(3, offered.getProgramName());
			System.out.println(offered.getProgramName()+offered.getApplicantEligibility()+offered.getDescription()+res);
		    res=statement.executeUpdate();
		
		} catch (SQLException e) {
			throw new UASException("admin sql 2");
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new UASException("problem while closing");
			}
		}
		
		return res;
	}

	@Override
	public int removeCourse(String cname)throws UASException {
		int res=0;
		
		try {
			connection=JdbcUtility.getconnection();
			statement=connection.prepareStatement(QueryConstants.removeCourse);
			statement.setString(1, cname);
			System.out.println(cname+"**");
			res=statement.executeUpdate();
		} catch (SQLException e) {
			throw new UASException("sql-delete");
		}
		finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new UASException("problem while closing");
			}
		}
		return res;
	}


	@Override
	public int ScheduleDelete(String programName) throws UASException {
		int res=0;

		try {
			connection=JdbcUtility.getconnection();
			statement=connection.prepareStatement(QueryConstants.removeSchedule);
			statement.setString(1, programName);
			res=statement.executeUpdate();
		} catch (SQLException e) {
			throw new UASException("sql7");
		}finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				throw new UASException("problem while closing");
			}
		}

		return res;
	}
	
	

	

	

}
