<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<table>
<tr><th>Employee Id</th><th>Name</th><th>Project Name</th><th>Salary</th></tr>
<c:forEach var="empList" items="${list}">
<tr><td>${empList.id}</td><td>${empList.name}</td><td>${empList.projectName}</td>
<td>${empList.salary}</td>

</c:forEach>
</table>
<a href="showHomePage.obj.obj">Click Here To Go to Home</a>
</center>
</body>
</html>