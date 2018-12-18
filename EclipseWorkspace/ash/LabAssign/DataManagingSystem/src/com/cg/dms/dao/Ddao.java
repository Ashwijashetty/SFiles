package com.cg.dms.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.dms.beans.DataInfo;
@Repository
@Transactional
public class Ddao implements IDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public DataInfo addDetails(DataInfo dataInfo) {
		entityManager.persist(dataInfo);
		entityManager.flush();
		return dataInfo;
	}

	@Override
	public DataInfo viewDetails(Integer id) {
		return entityManager.find(DataInfo.class,id);
	
	}

}
