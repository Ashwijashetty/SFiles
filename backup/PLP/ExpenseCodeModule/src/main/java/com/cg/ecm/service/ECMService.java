package com.cg.ecm.service;

import java.util.List;

import com.cg.ecm.entity.ExpenseDetails;
import com.cg.ecm.exception.ECMException;

public interface ECMService {

	ExpenseDetails addDetails(ExpenseDetails expdetails) throws ECMException;

	List<ExpenseDetails> getAllDetails() throws ECMException;

	

	ExpenseDetails getByCode(int expenseCode);

	ExpenseDetails DeleteByCode(int expenseCode);

	ExpenseDetails updateDetails(ExpenseDetails expdetails) throws ECMException;

}
