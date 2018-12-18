package com.cg.employeecodemodule.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;

import com.cg.employeecodemodule.models.Employee;
import com.cg.employeecodemodule.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	IEmployeeService employeeService;
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Employee createData(@RequestBody @Valid Employee employee){
		System.out.println("In Create Data");
		return employeeService.createData(employee);
	}
	
	/*@RequestMapping(value="/sample")
	public ModelAndView homePage(){
		System.out.println("132456789");
		ModelAndView view = null;
		view = new ModelAndView("home");
		return view;
	}*/
	
	@RequestMapping(value="/modify/{employeeId}",method=RequestMethod.PUT)
	public Employee updateData(@PathVariable long employeeId, @RequestBody Employee employee){
		return employeeService.updateData(employeeId,employee);
	}
	
	@RequestMapping(value="/readall",method=RequestMethod.GET)
	public List<Employee> readAllData(){
		return employeeService.readAll();
	}
	
	@RequestMapping(value="/read/{employeeId}",method=RequestMethod.GET)
	public Employee readData(@PathVariable long employeeId){
		return employeeService.readData(employeeId);
	}
	
	@RequestMapping(value="/delete/{employeeId}",method=RequestMethod.DELETE)
	public Employee deleteData(@PathVariable long employeeId){
		return employeeService.deleteData(employeeId);
	}

}
