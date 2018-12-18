<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee Details</title>
</head>
<body>
<center>
<h1 style="color: #0066CC">Add Employee Details</h1><br/><br/>
<h2>Please Enter Details</h2>
<form:form action="addDetails.obj" method="post" modelAttribute="employee">
<table>
<tr bgcolor="#DCDCDC">
<td>Employee Name:<span style="color: red;">*</span></td>
<td><form:input path="employeeName"/></td>
<td style="color: red;"><form:errors path="employeeName"></form:errors></td>
</tr>
<tr bgcolor="#DCDCDC">
<td>Employee Salary:<span style="color: red;">*</span></td>
<td><form:input path="salary"/></td>
<td style="color: red;"><form:errors path="salary"></form:errors></td>
</tr>
<tr bgcolor="#DCDCDC">
<td>Department:<span style="color: red;">*</span></td>
<td><form:input path="employeeDepartment"/></td>
<td style="color: red;"><form:errors path="employeeDepartment"></form:errors></td>
</tr>
<tr align="center">
<td colspan="2"><input type="submit" name="submit"
value="Register"></input></td>
</tr>
</table>
</form:form>
</center>
</body>
</html>