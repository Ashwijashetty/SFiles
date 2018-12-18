<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="dataInfo">
<table>

<tr>
<td>Id:</td><td>${data.id }</td>
</tr>
<tr>
<td>Name:</td><td>${data.name}</td>
</tr>
<tr>
<td>Email:</td><td>${data.email }</td>
</tr>
<tr>
<td>Phone Num:</td><td>${data.phoneNum }</td>
</tr>

<tr align="center">
<td colspan="2">
</tr>
</table>
</form:form>
</body>
</html>