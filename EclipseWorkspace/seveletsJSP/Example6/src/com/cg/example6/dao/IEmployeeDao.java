package com.cg.example6.dao;

import com.cg.example6.bean.UserDetailsBean;
import com.cg.example6.exception.EException;

public interface IEmployeeDao {

	boolean verify(UserDetailsBean userDetailsBean) throws EException;

}
