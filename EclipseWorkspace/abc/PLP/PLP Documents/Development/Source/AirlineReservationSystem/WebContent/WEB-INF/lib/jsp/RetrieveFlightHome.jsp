<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel ="stylesheet" href="css/HomePageStyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AirlineReservationSystem</title>
</head>
<jsp:include page="Header.jsp"/>
<body>
<nav class="menubar"> 
	<a class="menuitem" href="welcome.do">Home</a> |
	<a class="menuitem" href="about">AboutUs</a> | 
	<a class="menuitem" href="contactus">ContactUs</a>
</nav>

<section class="contentarea">

				<h2 align="center">Enter New Flight Details</h2>
				<table border="1" align="center">
					<tr>
						<th><a href ="retrieveAllFlights.adm">Show All Flights</a></th>
					
						<th><a href ="retrieveFlight.adm">Show Particular Flight</a></th>
					</tr>
				</table>
</section>
</body>
</html>