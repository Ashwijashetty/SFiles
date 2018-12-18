package com.cg.bms.service;

import com.cg.bms.model.Account;
import com.cg.bms.model.exceptions.BMSException;

public interface IAccountService {

	public boolean validateAccount(Account account) throws BMSException;

	public boolean createAccount(Account account) throws BMSException;
	public int getMaxId() throws BMSException;
}
