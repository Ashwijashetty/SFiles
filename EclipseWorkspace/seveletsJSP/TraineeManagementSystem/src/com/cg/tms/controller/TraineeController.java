package com.cg.tms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.tms.bean.TraineeBean;
//import com.cg.tms.bean.User;
import com.cg.tms.service.ITraineeService;

@Controller
public class TraineeController {
	@Autowired
private ITraineeService traineeservice;

public ITraineeService getTraineeservice() {
	return traineeservice;
}

public void setTraineeservice(ITraineeService traineeservice) {
	this.traineeservice = traineeservice;
}
/*public String processForm(@Valid User user,BindingResult bindingResult){
if(bindingResult.hasErrors()){
	return "failure";
}else{
return "success";
}}*/
/*String val=traineeservice.processForm();
if(val.equals("success")){

return "index1";
}else{
return "index1";
}*/


@RequestMapping("/showHomePage")
public String showHomePage() {
	return "index";
	
}
@RequestMapping("/showAddTraineeForm")
public ModelAndView showAddTrainee() {
	// Create an attribute of type Question
	TraineeBean trainee = new TraineeBean();
	// Add the attribute to the model and set the viewname and return it
	return new ModelAndView("addTraineeForm", "trainee", trainee);
}
@RequestMapping("/addTrainee")
public ModelAndView addDonation(
		@ModelAttribute("trainee") @Valid TraineeBean trainee,
		BindingResult result) {

	ModelAndView mv = null;

	if (!result.hasErrors()) {
		trainee = traineeservice.addTrainee(trainee);
		mv = new ModelAndView("addSuccess");
		mv.addObject("traineeId", trainee.getTraineeId());
		mv.addObject("traineeName", trainee.getTraineeName());
		
	} else {
		mv = new ModelAndView("addTraineeForm", "trainee", trainee);
	}

	return mv;
}
}
