<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Form</title>
</head>
<body>
<form:form action="getDetailsbyId.obj" method="post" modelAttribute="employee">
<table>
<tr bgcolor="#DCDCDC">
<td>Employee Id:<span style="color: red;">*</span></td>
<td><form:input path="employeeId"/></td>
<td style="color: red;"></td>
</tr>
<tr align="center">
<td colspan="2"><input type="submit" name="submit"
value="GetbyId"></input></td>
</tr>
</table>
</form:form>
</body>
</html>