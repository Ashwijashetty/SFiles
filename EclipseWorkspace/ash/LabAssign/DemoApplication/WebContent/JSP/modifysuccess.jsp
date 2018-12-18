<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><marquee>Updated Successfully</marquee></h1>
<br/><br/>
<h2><marquee>Updated Details Are</marquee></h2>
<div>
Employee Name:${employee.employeeName}
Employee Salary:${employee.salary}
Employee Department:${employee.employeeDepartment}
</div>
<a href="showIndexPage.obj">Go Back</a>
</body>
</html>