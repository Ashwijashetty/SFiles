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
	<form:form action="showIndexPage.obj" method='post'>
		<center>
			Username<input type="text" name="name" placeholder ="Username" required pattern="[A-Za-z0-9+@-._]{5,}"/><br />Password<input
				type="password" name="pass" placeholder = "Password" required pattern="[A-Za-z0-9]{5,}"/><br /> <input type="submit"
				value="login!" name="login!" />
		</center>
	</form:form>
</body>
</html>