package com.cg.tms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.bean.TraineeBean;
import com.cg.tms.dao.ITraineeDao;

@Service
public class TraineeService implements ITraineeService{

	@Autowired
	ITraineeDao traineeDao;
	
	public ITraineeDao getTraineeDao() {
		return traineeDao;
	}

	public void setTraineeDao(ITraineeDao traineeDao) {
		this.traineeDao = traineeDao;
	}

	@Override
	public TraineeBean addTrainee(TraineeBean trainee) {
		// TODO Auto-generated method stub
		return traineeDao.addTrainee(trainee);
	}

}
