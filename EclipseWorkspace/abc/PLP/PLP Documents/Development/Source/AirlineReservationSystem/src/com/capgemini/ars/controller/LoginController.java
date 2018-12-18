package com.capgemini.ars.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capgemini.ars.bean.UserBean;
import com.capgemini.ars.exception.AirlineException;
import com.capgemini.ars.service.ILoginService;

@Controller
public class LoginController {
	@Autowired
	ILoginService logServ;
	Logger logger=Logger.getLogger(LoginController.class);
	public ILoginService getLogSer() {
		return logServ;
	}

	public void setLogSer(ILoginService logServ) {
		this.logServ = logServ;
	}

	@RequestMapping(value = "/openExecutiveHome.do")
	public String displayExecutiveLoginPage(HttpServletRequest request,
			Model model) {
		HttpSession session = request.getSession();
		UserBean user = new UserBean();
		user.setRole("executive");
		model.addAttribute("userObj", user);
		if (session != null) {
			session.invalidate();
		}
		return "Login";
	}

	@RequestMapping(value = "/openAdminHome.do")
	public String displayAdminLoginPage(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		UserBean user = new UserBean();
		user.setRole("Admin");
		model.addAttribute("userObj", user);
		if (session != null) {
			session.invalidate();
		}
		return "Login";
	}

	@RequestMapping(value = "welcome.do")
	public String displayWelcomePage(Model model) {
		return "Welcome";
	}

	@RequestMapping(value = "/openUserHome.do")
	public String displayUserHomePage(Model model) {
		return "UserHome";
	}

	@RequestMapping(value = "/validateLogin.do", method = RequestMethod.POST)
	public String validateLogin(
			@ModelAttribute("userObj") @Valid UserBean user,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "Login";
		}

		try {
			UserBean userInfo = logServ.isValidUserLogin(user);
			if (userInfo != null) {
				if (userInfo.getRole().equalsIgnoreCase("executive")) {
					return "AirlineExecutiveHome";
				} else if (userInfo.getRole().equalsIgnoreCase("admin")) {
					return "AdminHome";
				}
			} else {
				return "Login";
			}
		} catch (AirlineException e) {
			logger.info(e.getMessage());
			String errObj = e.getMessage();
			model.addAttribute("errObj", errObj);
			return "Error";

		}
		return "Login";
	}
	

	@RequestMapping(value = "/showFaq.do")
	public String displayFaqPage(Model model) {
		return "Faq";
	}
	
	@RequestMapping(value = "/showFeedback.do")
	public String displayFeedBackPage(Model model) {
		return "FeedBack";
	}
	
	@RequestMapping(value = "/showAboutUs.do")
	public String displayAboutUsPage(Model model) {
		return "AboutUs";
	}
	
	@RequestMapping(value = "/showContactUs.do")
	public String displayContactUsPage(Model model) {
		return "ContactUs";
	}
}
