package com.cg;
import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
public class LogoutServlet extends HttpServlet {  
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                        throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        request.getRequestDispatcher("link.html").include(request, response);  
          
        out.print("you are successfully logged out!");  
    }  
}  