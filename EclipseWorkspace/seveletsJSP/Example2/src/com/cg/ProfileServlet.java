package com.cg;

import java.io.IOException;  
import java.io.PrintWriter;  

import javax.servlet.ServletException;  
  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;
public class ProfileServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        
		/*if(Session session=request.getSession(false))
        {
        	
        }
        String name=(String)session.getAttribute("uname");  
        out.print("Hello "+name);  */
        
        out.close();  
    } 
}  