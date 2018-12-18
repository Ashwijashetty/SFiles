package com.cg.pcm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pcm.entity.Project;
import com.cg.pcm.service.IProjectService;

@RestController
@RequestMapping("/project")
public class ApplicationController {
	@Autowired
	IProjectService service;

	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public Project create(@Valid @RequestBody Project project) {
		return service.insertData(project);
	}
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public List<Project> getAll() {
		return service.getAllDetails();
	}
	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	public Project getById(@PathVariable int id) {
		return service.getDetailsById(id);
	}
	@RequestMapping(value="/update/{id}",method=RequestMethod.PUT)
	public Project updateById(@PathVariable int id,@RequestBody Project project) {
		return service.updateDetailsById(id,project);
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public Project deleteById(@PathVariable int id) {
		return service.deleteDetailsById(id);
	}
}
