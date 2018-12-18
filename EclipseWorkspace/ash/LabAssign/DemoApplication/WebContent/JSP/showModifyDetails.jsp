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
<form:form action="modifyDetails.obj" method="post" modelAttribute="employees">
<table>
<tr bgcolor="#DCDCDC">
<td>Employee Id:<span style="color: red;">*</span></td>
<td><form:input path="employeeId"/></td>
<td style="color: red;"></td>
</tr>
<tr>
<td>Employee Id:</td><td>${employees.employeeId }</td>
</tr>
<tr>
<td>Employee Name:</td><td>${employees.employeeName}</td>
</tr>
<tr>
<td>Employee Salary:</td><td>${employees.salary }</td>
</tr>
<tr>
<td>Department:</td><td>${employees.employeeDepartment }</td>
</tr>
<tr bgcolor="#DCDCDC">
<td>Employee Id:<span style="color: red;">*</span></td>
<td><form:input path="employeeId"/></td>
<td style="color: red;"><form:errors path="employeeId"></form:errors></td>
</tr>
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
value="Update"></input></td>
</tr>
</table>
</form:form>
</body>
</html>