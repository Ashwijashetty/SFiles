package com.cg.pcm.service;

import java.util.List;

import javax.validation.Valid;

import com.cg.pcm.entity.Project;

public interface IProjectService {

	Project insertData(@Valid Project project);

	List<Project> getAllDetails();

	Project getDetailsById(int id);

	Project updateDetailsById(int id, Project project);

	Project deleteDetailsById(int id);

}
