<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="menubar"> 
	<a class="menuitem" href="welcome.do">Home</a> |
	<a class="menuitem" href="about">AboutUs</a> | 
	<a class="menuitem" href="contactus">ContactUs</a>
</nav>

<section class="contentarea">
		<form action="retrieveIdFlight.adm" method="post" >
				<h2 align="center">Enter New Flight Details</h2>
				<table border="1" align="center">
					<tr>
						<th>Flight Number </th>
							<td><input type="text" name="flightNo" pattern = "[0-9]{4,4}" title = "Must be of 4 digits !!" required/></td>
					</tr>
					
					<tr>
						<th><input type="submit" value="See Flight" /></th>
						<th><input type="reset" value="Reset" /></th>
					</tr>
				</table>
		</form>
</section>
</body>
</html>