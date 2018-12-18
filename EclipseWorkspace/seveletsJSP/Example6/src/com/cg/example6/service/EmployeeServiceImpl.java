package com.cg.example6.service;

import com.cg.example6.bean.UserDetailsBean;
import com.cg.example6.dao.EmployeeDaoImpl;
import com.cg.example6.dao.IEmployeeDao;
import com.cg.example6.exception.EException;

public class EmployeeServiceImpl implements IEmployeeService {

	

	@Override
	public boolean validate(UserDetailsBean userDetailsBean) {
		boolean result=false;
		if(userDetailsBean.getName().length()>4 && userDetailsBean.getPass().length()>4){
		result=true;	
		}
		
		return result;
	}

	@Override
	public boolean verify(UserDetailsBean userDetailsBean) throws EException {
	
		IEmployeeDao dao=new EmployeeDaoImpl();
		
		return dao.verify(userDetailsBean);
		
	}



}
