<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight Schedule</title>
<script src ="js/HomeScript.js"></script>
<link rel ="stylesheet" href ="css/HomePageStyle.css">
</head>
<jsp:include page="Header.jsp"/>
<body>
		<nav class="menubar"> 
	<a class="menuitem" href="welcome.do">Home</a> |
	<a class="menuitem" href="about">AboutUs</a> | 
	<a class="menuitem" href="contactus">ContactUs</a>
	</nav>
	<section class="contentarea">
	<form method="post" action="" name = "frm" onsubmit="return validateHome(this)">
		<table id ="table">
			<thead>
			<tr>
			<th>Flight Information</th>
			</tr>
			<tr>
				<th>Flight Number</th>
				<th>Airline</th>
				<th>Departure City</th>
				<th>Arrival City</th>
				<th>Departure Date</th>
				<th>Arrival Date</th>
				<th>Departure Time</th>
				<th>Arrival Time</th>
				<th>First class Seats</th>
				<th>First class Seats Fare</th>
				<th>Bussiness Seats</th>
				<th>Bussiness Seats Fare</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${list}">
                <tr>
				<th><c:out value="${list.getFlightNo()}"></c:out></th>
				<th><c:out value="${list.getAirline()}"></c:out></th>
				<th><c:out value="${list.getDeptCity()}"></c:out></th>
				<th><c:out value="${list.getArrCity()}"></c:out></th>
				<th><c:out value="${list.getDeptDate()}"></c:out></th>
				<th><c:out value="${list.getArrDate()}"></c:out></th>
				<th><c:out value="${list.getDeptTime()}"></c:out></th>
				<th><c:out value="${list.getArrTime()}"></c:out></th>
				<th><c:out value="${list.getFirstSeats()}"></c:out></th>
				<th><c:out value="${list.getFirstSeatsFare()}"></c:out></th>
				<th><c:out value="${list.getBussSeats()}"></c:out></th>
				<th><c:out value="${list.getBussSeatsFare()}"></c:out></th>
                </tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<!-- <tr>
					<th colspan="3">
						<button type="submit" id="btnsub">Continue</button>
					</th>
				</tr> -->
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