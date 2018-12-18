package com.cg.example6.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.example6.bean.UserDetailsBean;
import com.cg.example6.exception.EException;
import com.cg.example6.service.EmployeeServiceImpl;
import com.cg.example6.service.IEmployeeService;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public EmployeeController() {
        super();       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String choice=request.getParameter("login");
		if(choice.equals("Login")){
		String name=request.getParameter("name").trim();
		String pass=request.getParameter("pass").trim();
		UserDetailsBean userDetailsBean=new UserDetailsBean(); 
		userDetailsBean.setName(name);
		userDetailsBean.setPass(pass);
		IEmployeeService service=new EmployeeServiceImpl();
		if(service.validate(userDetailsBean)){
			try {
				if(service.verify(userDetailsBean)){
					HttpSession session=request.getSession();
					session.setAttribute("username", name);
					getServletContext().getRequestDispatcher("view/welcome.jsp");
				}else{
					request.setAttribute("errmsg", "Login Properly");
					getServletContext().getRequestDispatcher("view/error.jsp").include(request, response);	
				}
			} catch (EException e) {
				request.setAttribute("errmsg", e.getMessage());
				getServletContext().getRequestDispatcher("view/error.jsp").include(request, response);	
		
			}
		}else{
			request.setAttribute("errmsg", "Login Properly");
			getServletContext().getRequestDispatcher("view/error.jsp").include(request, response);
		}
		}//for choice

}}
