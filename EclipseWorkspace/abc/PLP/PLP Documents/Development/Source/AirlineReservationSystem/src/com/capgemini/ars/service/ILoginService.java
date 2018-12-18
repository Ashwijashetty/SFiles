package com.capgemini.ars.service;

import com.capgemini.ars.bean.UserBean;
import com.capgemini.ars.exception.AirlineException;

public interface ILoginService {

	public UserBean isValidUserLogin(UserBean userDetails)
			throws AirlineException;
}
