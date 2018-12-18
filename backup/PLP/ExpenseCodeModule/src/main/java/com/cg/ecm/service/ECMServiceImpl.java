package com.cg.ecm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ecm.dao.EMCDao;
import com.cg.ecm.entity.ExpenseDetails;
import com.cg.ecm.exception.ECMException;
@Service
public class ECMServiceImpl implements ECMService{
@Autowired
	private EMCDao dao;
	@Override
	public ExpenseDetails addDetails(ExpenseDetails expdetails) throws ECMException {
		
		return dao.addDetails(expdetails);
	}
	@Override
	public List<ExpenseDetails> getAllDetails() throws ECMException {
		
		return dao.getAllDetails();
	}
	@Override
	public ExpenseDetails getByCode(int expenseCode) {
		// TODO Auto-generated method stub
		return dao.getByCode(expenseCode);
	}
	@Override
	public ExpenseDetails DeleteByCode(int expenseCode) {
		return dao.DeleteByCode(expenseCode);
	}
	@Override
	public ExpenseDetails updateDetails(ExpenseDetails expdetails) throws ECMException {
		// TODO Auto-generated method stub
		return dao.updateDetails(expdetails);
	}

}
