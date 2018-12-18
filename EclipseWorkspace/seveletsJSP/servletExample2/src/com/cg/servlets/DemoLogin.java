package com.cg.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.presentation.LoginBean;
import com.cg.service.ILoginService;
import com.cg.service.LoginServiceImpl;


@WebServlet("/LoginServlet")
public class DemoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DemoLogin()
	{
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String username=request.getParameter("uname");
	String password=request.getParameter("pwd");
	ILoginService loginService=new LoginServiceImpl();
	LoginBean bean =new LoginBean();
	bean.setUsername(username);
	bean.setPassword(password);
	PrintWriter out=response.getWriter();
	if(loginService.verifyLogin(bean)){
		System.out.println("Welcome "+username);
        out.print("<html><head><title>Success!</title></head><body>Welcome <b>"+username+"</b></body></html>");
	}else{
		System.out.println("Incorrect");
		out.print("<html><head><title>Invalid</title></head><body><b>Try again<a href='index2.html'>click here</a></b></body></html>");
	}
	}
}
