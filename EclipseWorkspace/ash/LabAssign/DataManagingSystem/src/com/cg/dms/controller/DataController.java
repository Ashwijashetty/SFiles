package com.cg.dms.controller;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.dms.beans.DataInfo;
import com.cg.dms.exception.DMSException;
import com.cg.dms.service.IService;

@Controller
public class DataController {
	@Autowired
	private IService service;
	
	public IService getService() {
		return service;
	}

	public void setService(IService service) {
		this.service = service;
	}

	@RequestMapping("/showHomePage")
	public String showHomePage() {
		return "index";
	}
	
	@RequestMapping("/addDetails")
	public ModelAndView addDet(){
		DataInfo dataInfo=new DataInfo();
		
		return new ModelAndView("addForm","dataInfo",dataInfo);
	}
	
	@RequestMapping("/addDet")
	public ModelAndView addDet(@ModelAttribute ("dataInfo") @Valid DataInfo dataInfo, BindingResult result) throws DMSException{
		ModelAndView mv=null;
		//try{
		if(!result.hasErrors()){
			dataInfo=service.addDetails(dataInfo);
			mv=new ModelAndView("addSuccess");
			mv.addObject("id",dataInfo.getId());
			
		}else{
			mv=new ModelAndView("addForm","datainfo",dataInfo);
		}/*}catch(Exception e){
			throw new DMSException("Exists already");
		}
		*/return mv;
	}
	/*@RequestMapping("/showDetails")
	public ModelAndView showDetails(){
		DataInfo dataInfo=new DataInfo();
		ModelAndView mv = new ModelAndView("viewDetails");
		mv.addObject("dataInfo",dataInfo);
		mv.addObject("isFirst", "true");
		return mv;
		
	}
	@RequestMapping("/viewADetail")
	public ModelAndView viewADetail(@ModelAttribute("dataInfo") DataInfo dataInfo){
	ModelAndView mv=new ModelAndView();
	DataInfo data=new DataInfo();
	data=service.viewDetails(dataInfo.getId());
	if(data!=null){
		mv.setViewName("viewDetails");
		mv.addObject("data",data);
		
	}return mv;
	}
*/@RequestMapping("/viewDetails")
public String deleteEmpForm(Model model) {
	DataInfo  dataInfo=new DataInfo();
	model.addAttribute("dataInfo", dataInfo);
	return "viewDetails";
}
@RequestMapping("/showDetails")
public ModelAndView showDeleteEmp(@ModelAttribute("dataInfo") DataInfo dataInfo) throws DMSException {
	try{
		DataInfo data=service.viewDetails(dataInfo.getId());
	
	ModelAndView model = new ModelAndView("showADetail","data",data);
	model.addObject("id", data.getId());
	model.addObject("name",data.getName());
	model.addObject("email",data.getEmail());
	model.addObject("phoneNum",data.getPhoneNum());

	return model;
	}catch(Exception e){
		throw new DMSException("No such ID exists!!!");
	}
}
	}
