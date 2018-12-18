<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="" method="post" modelAttribute="employee">
Enter Id:<form:input path="id"/><br>
Enter name:<form:input path="name"/><br>
<input type="submit"value="Register">
</form:form>
</body>
</html>