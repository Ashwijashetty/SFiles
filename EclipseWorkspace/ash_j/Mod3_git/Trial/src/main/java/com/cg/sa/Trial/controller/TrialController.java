package com.cg.sa.Trial.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sa.Trial.model.Student;
import com.cg.sa.Trial.service.TrialService;

@RestController
public class TrialController {
	/*@Autowired
	private TrialService Service;*/
	
	@RequestMapping(value = "/create-data", method = RequestMethod.POST)
	@ResponseBody
    public Student createStudentData(@RequestBody Student student){
		return student;
	}
	@RequestMapping(value = "/read-data", method = RequestMethod.GET)
    @ResponseBody
    public List<Student> readData(){
		return null;
    }
}
