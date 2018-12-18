package com.cg.pcm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.Valid;

import org.springframework.stereotype.Repository;

import com.cg.pcm.entity.Project;
import com.cg.pcm.exception.UserNotFoundException;

@Repository
public class ProjectDAOImpl implements IProjectDAO {
	
	@PersistenceContext
	EntityManager mongo;
	
	@Override
	public Project insertData(@Valid Project project) {
		long startDateSecs=project.getStartDate().getTime();
		long endDateSecs=project.getEndDate().getTime();
		long diff=startDateSecs-endDateSecs;
		if(diff>=0){
			throw new UserNotFoundException("End date should be greater than start date");
		}
		mongo.persist(project);
		mongo.flush();
		return project;
	}

	@Override
	public List<Project> getAllDetails() {
		TypedQuery<Project> query=mongo.createQuery("select p from Project p",Project.class);
		return query.getResultList();
	}

	@Override
	public Project getDetailsById(int id) {
		Project project=mongo.find(Project.class, id);
		if(project==null){
			throw new UserNotFoundException("No such id present : "+id);
		}
		return project;
	}

	@Override
	public Project updateDetailsById(int id, Project project) {
		project.setProductCode(id);
		System.out.println(project.getStartDate()+""+project.getEndDate());
		Project projects=mongo.find(Project.class, id);
		if(project.getStartDate()==null){
			project.setStartDate(projects.getStartDate());
		}
		if(project.getProjectDescription().equals("")){
			project.setProjectDescription(projects.getProjectDescription());
		}
		if(project.getEndDate()==null){
			project.setEndDate(projects.getEndDate());
		}
		if(projects==null){
			throw new UserNotFoundException("No such id present : "+id);
		}
		//project.setProjectDescription(projects.getProjectDescription());
		mongo.merge(project);
		mongo.flush();
	
		return project;
	}

	@Override
	public Project deleteDetailsById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
