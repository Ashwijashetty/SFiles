package com.cg.TDS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.TDS.dao.TDSDao;
import com.cg.TDS.entity.TdsDetail;
@Service
public class TDSServiceImpl implements TDSService{
@Autowired
	TDSDao tdsDao;

/*
 * Method name   - getDetail by ID
 *  Arguments    - unique Id 
 *  Return type  - TdsDetails
 *  Author       - Capgemini 
 *  CreationDate - 3/12/2018 
 *  Purpose - this method is to return tdsdetail based on id to controller from DAO.
 */
	@Override
	public TdsDetail fetchTdsDetail(int uniqueId) {
		
		return tdsDao.fetchTdsDetail(uniqueId);
	}

}
