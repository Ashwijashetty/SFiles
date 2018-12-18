package com.cg;
import java.io.IOException;  
import java.io.PrintWriter;  

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
      //  request.getRequestDispatcher("link.html").include(request, response);  
          
        String name=request.getParameter("uname");  
        String password=request.getParameter("pwd");  
          
        if(name.trim().equals("ash")&& password.trim().equals("ash123")){  
            out.print("You are successfully logged in!");  
            out.print("<br>Welcome "+name);  
            
            HttpSession session=request.getSession();  
            session.setAttribute("uname",name);  
      
            out.print("<a href='ProfileServlet'>To see inbox</a>"); 
             
        }else{  
            out.print("username or password error!!!");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }  
          
        out.close();  
    }  
  
} 
