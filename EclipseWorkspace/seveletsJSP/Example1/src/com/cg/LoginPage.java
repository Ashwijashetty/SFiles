package com.cg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginPage() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	          
	       // request.getRequestDispatcher("link.html").include(request, response);  
	          
	        String username=request.getParameter("uname");  
	        String password=request.getParameter("pwd");  
	          
	        if(username.equals("ash")&&password.equals("ash123")){  
	            out.print("You are successfully logged in!");  
	            out.print("<html><head><title>Success!</title></head>"
	            		+ "<body>Welcome <b>"+username+"</b></body></html>");
	            request.getRequestDispatcher("servlet2").include(request, response);
	}else{
		out.print(" username or password mismatch!");  
        request.getRequestDispatcher("index3.html").include(request, response);  
	}

	}
	}
