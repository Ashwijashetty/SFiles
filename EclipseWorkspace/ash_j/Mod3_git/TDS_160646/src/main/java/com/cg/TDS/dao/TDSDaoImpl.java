package com.cg.TDS.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.cg.TDS.Exception.TDSException;
import com.cg.TDS.entity.TdsDetail;
@Repository
public class TDSDaoImpl implements TDSDao{
	@Autowired
private MongoTemplate mongoTemplate;


	/*
	 * Method name   - getDetail by ID
	 *  Arguments    - unique Id
	 *  Return type  - TdsDetails
	 *  Author       - Capgemini 
	 *  CreationDate - 3/12/2018 
	 *  Purpose - this method is to return tdsdetail based on id to service from mongoDB database.
	 */
	
	@Override
	public TdsDetail fetchTdsDetail(int uniqueId) {

			Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(uniqueId));
	
		TdsDetail tdsDetail= mongoTemplate.findOne(query, TdsDetail.class);
		if(tdsDetail == null){
		throw new TDSException("ID not found, wrong ID:"+uniqueId );
	}
		return tdsDetail;



}
	}
