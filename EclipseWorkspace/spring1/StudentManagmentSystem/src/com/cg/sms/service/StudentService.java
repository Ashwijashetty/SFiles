package com.cg.sms.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.sms.dao.IStudentDao;
import com.cg.sms.dao.StudentDao;
@Component("studentService")
public class StudentService implements IStudentService{
	
	public StudentService() {
		System.out.println("StudentServiceImpl()");
	}
	@Autowired
	
	private IStudentDao studentDao;
	@Override
	public List<String> getNames() {
		return studentDao.getNames();
	}

}
