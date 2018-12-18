package com.cg.uas.service;

import com.cg.uas.dao.IUserDao;
import com.cg.uas.dao.UserDao;
import com.cg.uas.exceptions.UASException;
import com.cg.uas.model.Users;

public class UserServiceImpl implements IUserService {
IUserDao dao=new UserDao();
	@Override
	public String getRole(String loginId, String password) throws UASException {
		String role=null;
		Users users=dao.getUserById(loginId);
		if(users==null)
			throw new UASException("No such loginId exists");
		else if(!password.equals(users.getPassword()))
			throw new UASException("Password Mismatch");
		else
			role=users.getRole();
		return role;
	}

}
