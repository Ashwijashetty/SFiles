package com.cg.uas.service;

import com.cg.uas.exceptions.UASException;

public interface IUserService {

	String getRole(String loginId, String password) throws UASException;

}
