<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src ="js/HomeScript.js"></script>
<link rel ="stylesheet" href ="css/HomePageStyle.css">
<title>Airline Reservation System</title>
</head>
<jsp:include page="Header.jsp"/>
<body>
	<nav class="menubar"> 
	<a class="menuitem" href="welcome.do">Home</a> |
	<a class="menuitem" href="about">AboutUs</a> | 
	<a class="menuitem" href="contactus">ContactUs</a>
	</nav>
	<%-- <aside class ="sidebar">
	<table>
        <tr><td>${selectedFlight.getFlightNo()}</td></tr>
		<tr><td>${selectedFlight.getDeptTime()} to ${selectedFlight.getArrTime()}</td></tr>		
		<tr><td>Price Summary</td></tr>
		<tr></tr>
		<tr>
		<c:if test="${classType.equalsIgnoreCase('first')}">
		<c:set var= "fare" value="${selectedFlight.getFirstSeatsFare()}" scope ="session" />
		</c:if>
		<c:if test="${classType.equalsIgnoreCase('Business')}">
		<c:set var= "fare" value="${selectedFlight.getBussSeatsFare()}" scope ="session" />
		</c:if>
		<td>1  Adult (Base Fare)</td>	
		<c:out value ="${fare}" ></c:out>
		</tr>
		<tr></tr>
		<tr>
		<td>Airline Fuel Surcharge</td>	
		<td>775.00</td>
		</tr>
		<tr></tr>
		<tr>
		<td>Airport Arrival Tax â Arrival (AAT)</td>
		<td>477.00</td>
		</tr>
		<tr></tr>
		<tr>
		<td>Passenger Service Fee</td>
		<td>150.00</td>
		</tr>
		<tr></tr>
		<tr>
		<td>User Development Fee â Departure (UDF)</td>	
		<td>191.00</td></tr>
		<tr></tr>
		<tr><td>Government Service Tax</td>	
		<td>172.00</td></tr>
		<tr></tr>
		<tr>
		<td>Krishi Kalyan Cess</td>	
		<td>6.00</td></tr>
	</table>
	</aside> --%>
	<section class="contentarea">
	<h1>Welcome to Payment Gateway</h1>
	<form method="post" action="insertBookingDetails.usr" name = "frm">
		<table id ="table">
			<thead>
			<tr>
					<th><h2>In Order to initiate booking,you have to enter some details..</h2></th>
			</tr>
			</thead>
			<tbody>
				<tr>
					<td>Enter your Email:</td>
					<td><input type="email" name="email" id="emailid" title="Must be an valid email id" required /></td>
				</tr>
				<tr>
					<td>Enter your 10 digit Credit card Number:</td>
					<td><input type="text" name="ccno" id="ccno" pattern="[0-9]{10,10}" title="Must be of 10 digits only" required/></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="3">
						<button type="submit" id="btnsub">Submit</button>
						<button type="reset" id="btnreset">Reset</button>
					</th>
				</tr>
			</tfoot>
		</table>
	</form>
	</section>
	<br />
	<footer class="footer"> Copyright Reserved &copy;<br />
	<a href="#Faq">FAQ</a> | <a href="#Terms&Conditions">Terms & Conditions</a> | <a href="#FeedBack">FeedBack</a> | | <a href="#CustomerSupport">24*7CustomerSupport</a>
	</footer>
</body>
</html>