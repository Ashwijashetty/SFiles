package com.cg.tms.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.tms.bean.TraineeBean;

@Repository
@Transactional
public class TraineeDao implements ITraineeDao{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public TraineeBean addTrainee(TraineeBean trainee) {
		entityManager.persist(trainee);
		entityManager.flush();
		return trainee;
	}

}
