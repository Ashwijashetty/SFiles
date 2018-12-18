<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Form</title>
</head>
<body>
<form:form action="showDetails.obj" method="post" modelAttribute="dataInfo">
<table>
<tr bgcolor="#DCDCDC">
<td>Employee Id:<span style="color: red;">*</span></td>
<td><form:input path="id"/></td>
<td style="color: red;"></td>
</tr>
<tr align="center">
<td colspan="2"><input type="submit" name="submit"
value="Search"></input></td>
</tr>
</table>
</form:form>
</body>
</html>