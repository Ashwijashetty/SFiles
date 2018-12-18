<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
th {
	color: grey;
	font-size: 16pt;
}
</style>
</head>
<body>
<center>

<h1>Employee List</h1>

<table border=1>
	<tr>
		<th bgcolor="bisque">Employee Id</th>
		<th bgcolor="bisque">Employee Name</th>
		<th bgcolor="bisque">Employee Salary</th>
		<th bgcolor="bisque">Employee Department</th>
	</tr>
	<c:forEach var="employeeList" items="${list}">
		<tr>
			<td>${employeeList.employeeId}</td>
			<td>${employeeList.employeeName}</td>
			<td>${employeeList.salary}</td>
			<td>${employeeList.employeeDepartment}</td>
		</tr>
	</c:forEach>
	<tr>
			<td colspan="5" align="center"><a href="showIndexPage.obj">Click
			Here To Go Back</a></td>
		</tr>
</table>
</center>
</body>
</html>