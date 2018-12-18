package com.cg.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.mvc.model.Employee;

@Controller
public class CheckController {
	@RequestMapping("/index")
public String showHomePage(){
	String view="home";
	model.addAttribute("employee",new Employee());
		return view;
}
}
