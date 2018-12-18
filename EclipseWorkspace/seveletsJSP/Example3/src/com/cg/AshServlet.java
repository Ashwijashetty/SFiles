package com.cg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AshServlet")
public class AshServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AshServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie=new Cookie("Ashwija", "bwbw");
		Cookie cookie2=new Cookie("Shetty", "mwmw");
		response.addCookie(cookie);
		response.addCookie(cookie2);
		response.setContentType("text/html");
		response.getWriter().print(" cookies sent successfully ");
	}

}
