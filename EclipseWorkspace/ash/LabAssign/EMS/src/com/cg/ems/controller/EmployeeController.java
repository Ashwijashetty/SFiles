package com.cg.ems.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.ems.entity.Employee;
import com.cg.ems.service.IEmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private IEmployeeService service;

	/*public IEmployeeService getService() {
		return service;
	}

	public void setService(IEmployeeService service) {
		this.service = service;
	}*/

	@RequestMapping("/showHomePage")
	public String showHomePage() {
		return "index";
	}

	@RequestMapping("/addtheDetails")
	public ModelAndView addtheDetails() {

		Employee employee = new Employee();

		return new ModelAndView("addDetailsForm", "employee", employee);

	}

	@RequestMapping("/addDetails")
	public ModelAndView addDetails(
			@ModelAttribute("employee") @Valid Employee employee,
			BindingResult result) {
		ModelAndView mv = null;
		if (!result.hasErrors()) {
			employee = service.addDetails(employee);
			mv = new ModelAndView("addSuccess");
			mv.addObject("id", employee.getId());
			mv.addObject("name", employee.getName());
		} else {
			mv = new ModelAndView("addDetailsForm", "employee", employee);
		}

		return mv;

	}
	@RequestMapping("/viewtheDetails")
	public ModelAndView viewtheDetails(){
		ModelAndView mv=new ModelAndView();
		List<Employee> list=service.getDetails();
		if(list.isEmpty()){
			String msg="NO Details to Show";
			mv.setViewName("myErrors");
			mv.addObject("msg",msg);
		}else{
			mv.setViewName("view1");
			mv.addObject("list",list);
		}
		return mv;
	}
	
@RequestMapping("/getempDetail2")
public ModelAndView getempDetail(){
	Employee employee=new Employee();
	ModelAndView mv=new ModelAndView("viewDetail2");
	mv.addObject("employee",employee);
	mv.addObject("isFirst","true");
	return mv;
}
	/*@RequestMapping("/viewDonation")
	public ModelAndView viewDonation(@ModelAttribute("donor") DonorBean donor) {

		ModelAndView mv = new ModelAndView();

		DonorBean dBean = new DonorBean();
		dBean = donorService.getDonationDetails(donor.getDonorId());

		if (dBean != null) {
			mv.setViewName("viewDonation");
			mv.addObject("dBean", dBean);
		} else {
			String msg = "Enter a Valid Id!!";
			mv.setViewName("myError");
			mv.addObject("msg", msg);
		}

		return mv;
	}
	*/
@RequestMapping("/viewDetail2")
public ModelAndView viewDetail2(@ModelAttribute("employee") Employee employee){
	ModelAndView mv=new ModelAndView();
	Employee employee2=new Employee();
	employee2=service.getsingleDetail(employee.getId());
	return null;
	
}
}
