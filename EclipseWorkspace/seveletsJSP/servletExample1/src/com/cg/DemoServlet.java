package com.cg;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MyServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DemoServlet() {
    	System.out.println("constructor");
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}

	
	public void destroy() {
		System.out.println("destroy");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost");
	}

}
