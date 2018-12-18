package com.cg.dms.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dms.beans.DataInfo;
import com.cg.dms.dao.IDao;
@Service
public class DService implements IService{
@Autowired
	private IDao dao;


	@Override
	public DataInfo addDetails(DataInfo dataInfo) {
			dataInfo.setGdate(new Date());
		return dao.addDetails(dataInfo);
	}


	@Override
	public DataInfo viewDetails(Integer id) {
		
		return dao.viewDetails(id);
	}

}
