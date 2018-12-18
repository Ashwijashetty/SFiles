<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<table align="center">
<form:form action="addEmpForm.obj" method="post" modelAttribute="employee">
<input type="submit" value="Register"/><br/><br/><br/>
</form:form>
<form:form action="deleteEmpForm.obj" method="post" modelAttribute="employee">
<input type="submit" value="Delete"/><br/><br/><br/>
</form:form>
<form:form action="modifyEmpForm.obj" method="post" modelAttribute="employee">
<input type="submit" value="Update"/><br/><br/><br/>
</form:form>
<form:form action="getAllDetails.obj" method="post" modelAttribute="employee">
<input type="submit" value="GetAllDetails"/><br/><br/><br/>
</form:form>
<form:form action="getEmpForm.obj" method="post" modelAttribute="employee">
<input type="submit" value="GetDetailsById"/><br/><br/><br/>
</form:form>
</table>
</body>
</html>