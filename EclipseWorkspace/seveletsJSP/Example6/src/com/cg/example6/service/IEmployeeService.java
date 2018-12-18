package com.cg.example6.service;

import com.cg.example6.bean.UserDetailsBean;
import com.cg.example6.exception.EException;

public interface IEmployeeService {



	boolean validate(UserDetailsBean userDetailsBean);

	boolean verify(UserDetailsBean userDetailsBean) throws EException;

}
