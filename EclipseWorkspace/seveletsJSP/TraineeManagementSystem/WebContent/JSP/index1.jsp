<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%> 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trainee Application</title>

</head>
<body>

<sf:form method="POST" modelAttribute="user">

<table cellspacing="0">
<tr><th><sf:label path="username">Username:</sf:label></th>
<td><sf:Input path="username" size="15" maxlength="15"/>
<small id="username_msg">NO spaces , please</small><br/>
<sf:errors path="username"/></td>
</tr>
<tr><th><sf:label path="password">Password:</sf:label></th>
<td><sf:password path="password" size="30" showPassword="true"/>
<small>6 characters or more</small><br/>
<sf:errors path="password"/>
</td>
</tr>
<tr><th></th>
<td><input name="commit" type="submit" value="Save User"/></td></tr>
</table>
</sf:form>
</body>
</html>