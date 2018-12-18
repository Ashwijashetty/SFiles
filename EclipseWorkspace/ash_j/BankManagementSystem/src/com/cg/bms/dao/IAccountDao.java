package com.cg.bms.dao;

import com.cg.bms.model.Account;
import com.cg.bms.model.exceptions.BMSException;

public interface IAccountDao {



public boolean createAccount(Account account)throws BMSException;
public int  getMaxId() throws BMSException;
}
