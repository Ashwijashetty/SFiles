<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:url var="myAction" value="/addDet.obj"></c:url>
<form:form action="${myAction}" method="post" modelAttribute="dataInfo">
<table>
<%-- <tr>
	<td>ID:</td>
	<td><form:input path="id" required="required" 
	                          pattern="[1-9]{1}[0-9]{3}"
							title="ID should contain exactly 4 digits"/></td>
	<td><form:errors path="id" ></form:errors></td>
</tr> --%>
<tr>
	<td>Name:</td>
	<td><form:input path="name"/></td>
	<td><form:errors path="name"></form:errors></td>
</tr>
<tr>
	<td>email:</td>
	<td><form:input path="email"required="required" type="email"/></td>
	<td><form:errors path="email"></form:errors></td>
</tr>
<tr>
	<td>Phone num:</td>
	<td><form:input path="phoneNum"/>
	</td><td><form:errors path="phoneNum"></form:errors></td>
</tr>
<tr><input type="submit" name="submit" value="Add"/></tr>

</table>
</form:form>
		<br> <a href="showHomePage.obj">Back To HomePage</a>
</body>
</html>