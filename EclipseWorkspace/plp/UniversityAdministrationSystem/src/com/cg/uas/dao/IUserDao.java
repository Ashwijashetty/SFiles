package com.cg.uas.dao;

import com.cg.uas.exceptions.UASException;
import com.cg.uas.model.Users;

public interface IUserDao {

	Users getUserById(String loginId) throws UASException;

}
