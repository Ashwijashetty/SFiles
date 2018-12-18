<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="lb" scope="request" class="com.cg.bean.LoginBean"/>
<jsp:setProperty property="username" name="lb"value="ash"/>
<jsp:setProperty property="password" name="lb"value="ash123"/>


<%-- 
<%
getServletContext().getRequestDispatcher("/Recieve").include(request, response);
%> --%>
 
 <jsp:include page="page2.jsp"></jsp:include>
 
 </body>
</html>