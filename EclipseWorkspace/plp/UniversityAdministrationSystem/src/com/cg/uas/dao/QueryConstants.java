package com.cg.uas.dao;

public class QueryConstants {
public static final String getById="select * from Users where login_Id=?";
public static final String addCourse = "insert into programs_offered values(?,?,?,?,?)";
public static final String updateCourse = "update programs_offered set description=?,applicant_eligibility=? where program_name=?";
public static final String removeCourse = "delete from programs_offered where program_name=?";
public static final String viewCourse = "select * from programs_offered";
public static final String getProgramById = "select * from programs_offered where program_name=?";
public static final String addSchedule = "insert into programs_scheduled values(?,?,?,?,?,?)";
public static final String removeSchedule = "delete from programs_scheduled where program_name=?";
}
