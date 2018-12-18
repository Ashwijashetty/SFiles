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
		<form action="addFlightDetail.adm" method="post" >
				<h2 align="center">Enter New Flight Details</h2>
				<table border="1" align="center">
					<tr>
						<th>Flight Number </th>
							<td><input type="text" name="flightno" pattern="[0-9]{4,4}" title="Must be in 4 digits only !!" required/></td>
					</tr>

					<tr>
						<th>Airline </th>
						<td><input type="text" name="airline" pattern="[A-za-z ]{5,30}" title="Must be in characters only in range of 5 to 30 !!" required/></td>
					</tr>

					<tr>
						<th>Departure City </th>
						<td><input type="text" name="deptCity" pattern="[A-za-z]{5,20}" title="Must be in characters only in range of 5 to 20 !!" required/></td>
					</tr>

					<tr>
						<th>Arrival City </th>
						<td><input type="text" name="arrCity" pattern="[A-za-z]{5,20}" title="Must be in characters only in range of 5 to 20 !!" required/></td>
					</tr>

					<tr>
						<th>Departure Date </th>
						<td><input type="text" name="deptDate" required/></td>
					</tr>

					<tr>
						<th>Departure Time </th>
						<td><input type="text" name="deptTime" pattern="[0-9]{4,4}" title="Must be a valid time in 4 digits in 24 hour format only (without any colon) !!" required/></td>
					</tr>
	
					<tr>
						<th>Arrival Time </th>
						<td><input type="text" name="arrTime" pattern="[0-9]{4,4}" title="Must be a valid time in 4 digits in 24 hour format only (without any colon) !!" required/></td>
				
					<tr>
						<th>First Class Seats </th>
						<td><input type="text" name="firstSeats" pattern="[0-9]{2,2}" title="Must be in 2 digits only !!" required/></td>
					</tr>

					<tr>
						<th>First Class Seat Fare </th>
						<td><input type="text" name="firstSeatsFare" pattern="[0-9]{3,6}" title="Must be in digits in range of 3 to 6 !!" required/></td>

					<tr>
						<th>Business Class Seats </th>
						<td><input type="text" name="bussSeats" pattern="[0-9]{2,2}" title="Must be in 2 digits only !!" required/></td>
					</tr>

					<tr>
						<th>Business Class Seat Fare </th>
						<td><input type="text" name="bussSeatsFare" pattern="[0-9]{3,6}" title="Must be in digits in range of 3 to 6 !!" required/></td>
					</tr>

					<tr>
						<th colspan="2"><input type="submit" value="Add Flight" /></th>
					</tr>

			</table>
		</form>
	</section>
</body>
<footer class="footer"> Copyright Reserved &copy;<br/>
</footer>
</body>
</html>