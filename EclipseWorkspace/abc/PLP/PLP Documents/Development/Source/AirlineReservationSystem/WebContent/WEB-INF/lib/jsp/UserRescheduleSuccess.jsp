<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<section class="contentarea">
		<table id ="table">
			<thead>
			<tr>
					<th><h4>Booking has been successfully done...</h4></th>
			</tr>
			<tr>
					<th><h4>Your ticket information has been given below and has also been send to your email address...</h4></th>
			</tr>
			</thead>
			<tbody>
				<tr>
					<td>Booking Id:</td>
					<td>${bookBean.getBookingId()}</td>
				</tr>
				<tr>
					<td>Flight Number:</td>
					<td>${selectedFlight}</td>
				</tr>
				<tr>
					<td>Email Id:</td>
					<td>${bookBean.getCustEmail()}</td>
				</tr>
				<tr>
					<td>No. of passengers:</td>
					<td>${bookBean.getNoOfPassengers()}</td>
				</tr>
				<tr>
					<td>Class Type:</td>
					<td>${bookBean.getClassType()}</td>
				</tr>
				<tr>
					<td>Total fare:</td>
					<td>${bookBean.getTotalFare()}</td>
				</tr>
				<tr>
					<td>Seat Numbers:</td>
					<td>${bookBean.getSeatNumber()}</td>
				</tr>
				<tr>
					<td>Source City:</td>
					<td>${bookBean.getSrcCity()}</td>
				</tr>
				<tr>
					<td>Destination City:</td>
					<td>${bookBean.getDestCity()}</td>
				</tr>
			</tbody>
		</table>
	</section>
	<br />
	<footer class="footer"> Copyright Reserved &copy;<br />
	<a href="#Faq">FAQ</a> | <a href="#Terms&Conditions">Terms & Conditions</a> | <a href="#FeedBack">FeedBack</a> | | <a href="#CustomerSupport">24*7CustomerSupport</a>
	</footer>
</body>
</html>