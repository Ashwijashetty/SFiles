package com.capgemini.ars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ars.bean.UserBean;
import com.capgemini.ars.dao.IAirlineDao;
import com.capgemini.ars.exception.AirlineException;

@Service("logServ")
public class LoginServiceImpl implements ILoginService {

	@Autowired
	IAirlineDao airlineDao;

	public IAirlineDao getAirlineDao() {
		return airlineDao;
	}

	public void setAirlineDao(IAirlineDao airlineDao) {
		this.airlineDao = airlineDao;
	}

	@Override
	public UserBean isValidUserLogin(UserBean userDetails)
			throws AirlineException {

		return airlineDao.isValidUserLogin(userDetails);
	}

}
