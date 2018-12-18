               package com.cg.bms.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.cg.bms.dao.AccountDaoImpl;
import com.cg.bms.dao.IAccountDao;
import com.cg.bms.model.Account;
import com.cg.bms.model.exceptions.BMSException;
import com.cg.bms.presentation.BMSMain;

public class AccountServiceImpl implements IAccountService {
	static Logger logger = Logger.getLogger(AccountServiceImpl.class);
	IAccountDao accountdao = new AccountDaoImpl();

	/*
	 * method name -createAccount arguments -Account object return type -boolean
	 * Author -capgemini CreationDate -12/10/2018 purpose - this method is to
	 * insert the account data into database
	 */
	@Override
	public int getMaxId() throws BMSException {
		
		return accountdao.getMaxId();
	}
	@Override
	public boolean createAccount(Account account) throws BMSException {
		logger.info("In Account service class..");
		return accountdao.createAccount(account);
	}

	@Override
	public boolean validateAccount(Account account) throws BMSException {
		boolean flag = false;
		List<String> list = new ArrayList<>();
		if (!isNameValid(account.getCustomerName())) {
			list.add("\nCustomer name should contain min of 5 amd max 20 letters");
		}
		if (!isBalanceValid(account.getBalance())) {
			list.add("\nAccount balance is less than min balance of 10000");
		}
		if (!isDateValid(account.getDate())) {
			list.add("\nDate should be in yyyy-MM-dd format.\n");
		}
		if (!list.isEmpty()) {
			logger.debug("List is not empty");
			throw new BMSException(list + "");
		} else {
			logger.debug("List is empty//imply all validations are working");
			flag = true;
		}
		logger.debug("result from account validation"+flag);
		return flag;
	}

	public boolean isNameValid(String name) {

		logger.info("Name validation method");
		String nameRegEx = "[A-Za-z]{5,20}";
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(name);
		logger.debug("name validation" + matcher.matches());
		return matcher.matches();

	}

	public boolean isBalanceValid(double balance) {
		boolean balanceflag = false;
		logger.info("Balance validation method");
		if (balance >= 10000) {
			balanceflag = true;
		}
		logger.debug("balance validation" + balanceflag);
		return balanceflag;

	}

	public boolean isDateValid(Date date) {
		logger.info("Date validation method");
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String newDate=format.format(date);
		
		
		String dateRegEx = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
		Pattern pattern = Pattern.compile(dateRegEx);
		Matcher matcher = pattern.matcher(newDate);
		logger.debug("date validation" + matcher.matches());
		return matcher.matches();
	}

	

}
