<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter Details</title>
</head>
<body>
<center>
<c:url var="myAction" value="/addDetails.obj"></c:url>
<form:form action="${myAction}" method="post" modelAttribute="employee">
<table>

<tr><td>Employee Id:</td>
<td><form:input path="id"/></td>
<td style="color:red;"><form:errors path="id"></form:errors>

<tr><td>Employee Name:</td>
<td><form:input path="name"/></td>
<td style="color:red;"><form:errors path="name"></form:errors></td></tr>

<tr><td>Employee Salary:</td>
<td><form:input path="salary"/></td><td style="color:red;"><form:errors path="salary"></form:errors>
<td style="color:red;"></tr>

<tr><td>Project Name:</td>
<td><form:input path="projectName"/></td>
<td style="color:red;"><form:errors path="projectName"></form:errors></td></tr>

<tr><td><input type="submit" value="add" name="submit"></input></td></tr>

</table>
</form:form>
	<br> <a href="showHomePage.obj">Back To HomePage</a>
</center>
</body>
</html>