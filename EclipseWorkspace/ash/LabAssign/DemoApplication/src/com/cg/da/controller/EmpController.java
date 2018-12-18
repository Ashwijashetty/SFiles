package com.cg.da.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.da.beans.Employee;
import com.cg.da.exceptions.CustomException;
import com.cg.da.service.IService;

@Controller
public class EmpController {
	@Autowired
	IService service;

	public IService getService() {
		return service;
	}

	public void setService(IService service) {
		this.service = service;
	}
	@RequestMapping("/showLoginPage")
	public String showLoginPage() {
		return "login";
	}
	@RequestMapping("/showIndexPage")
	public String showIndexPage() {
		return "index";
	}

	@RequestMapping("/addEmpForm")
	public String addEmpForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "addEmpForm";
	}

	@RequestMapping("/addDetails")
	public ModelAndView addDetails(
			@ModelAttribute("employee") @Valid Employee employee,
			BindingResult result) throws CustomException {
		ModelAndView model = null;
		try{
		if (!result.hasErrors()) {
			service.addEmployee(employee);
			model = new ModelAndView("success");
			model.addObject("employeeId", employee.getEmployeeId());
			model.addObject("employeeName", employee.getEmployeeName());
			model.addObject("salary", employee.getSalary());
			model.addObject("employeeDepartment", employee.getEmployeeDepartment());

		} else {

			model = new ModelAndView("addEmpForm", "employee", employee);
		}}catch(Exception e){
			throw new CustomException("ID already exists");
		}
		return model;
	}

	@RequestMapping("/deleteEmpForm")
	public String deleteEmpForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "deleteEmpForm";
	}

	@RequestMapping("/showdeleteDetails")
	public ModelAndView showDeleteEmp(@ModelAttribute("employee") Employee employee) throws CustomException {
		try{
		Employee employees=service.getDetails(employee.getEmployeeId());
		ModelAndView model = new ModelAndView("showDeleteDetails","employees",employees);
		model.addObject("employeeId", employees.getEmployeeId());
		model.addObject("employeeName", employees.getEmployeeName());
		model.addObject("salary", employees.getSalary());
		model.addObject("employeeDepartment", employees.getEmployeeDepartment());
		return model;
		}catch(Exception e){
			throw new CustomException("No such ID exists!!!");
		}
	}

	@RequestMapping("/deleteDetails")
	public ModelAndView viewDeleteDetails(
			@ModelAttribute("employee") Employee employee) {
		ModelAndView model = null;
		service.deleteDetails(employee.getEmployeeId());
		model = new ModelAndView("deletesuccess");
		model.addObject("id", employee.getEmployeeId());
		return model;
	}
	@RequestMapping("/modifyEmpForm")
	public String modifyEmpForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "modifyEmpForm";
	}
	@RequestMapping("/showmodifyDetails")
	public ModelAndView showModifyEmp(@ModelAttribute("employee") Employee employee) throws CustomException {
		try{
			Employee employees=service.getDetails(employee.getEmployeeId());
			ModelAndView model = new ModelAndView("showModifyDetails","employees",employees);
			model.addObject("employeeId", employees.getEmployeeId());
			model.addObject("employeeName", employees.getEmployeeName());
			model.addObject("salary", employees.getSalary());
			model.addObject("employeeDepartment", employees.getEmployeeDepartment());
			return model;
		
		}catch(Exception e){
			throw new CustomException("No such ID to Update!!");
		}
		}
	@RequestMapping("/modifyDetails")
	public ModelAndView getModifyDetails(
			@ModelAttribute("employee") Employee employee) {
		ModelAndView model = null;
		Employee employees=service.modifyDetails(employee.getEmployeeId(),employee);
		model = new ModelAndView("modifysuccess");
		model.addObject("employeeName", employees.getEmployeeName());
		model.addObject("salary", employees.getSalary());
		model.addObject("employeeDepartment", employees.getEmployeeDepartment());
		return model;
	}
	@RequestMapping("/getAllDetails")
	public String getDetails(Model model){
		List<Employee> list=service.getAll();
		model.addAttribute("list",list);
		return "getdetails";
	}
	@RequestMapping("/getEmpForm")
	public String getEmpForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "getEmpForm";
	}
	@RequestMapping("/getDetailsbyId")
	public ModelAndView getEmp(@ModelAttribute("employee") Employee employee) throws CustomException {
		try{
		Employee employees=service.getDetails(employee.getEmployeeId());
		ModelAndView model = new ModelAndView("getIdDetails","employees",employees);
		model.addObject("employeeId", employees.getEmployeeId());
		model.addObject("employeeName", employees.getEmployeeName());
		model.addObject("salary", employees.getSalary());
		model.addObject("employeeDepartment", employees.getEmployeeDepartment());
		return model;
		}catch(Exception e){
			throw new CustomException("No such ID exists!!!");
		}
	}
}
