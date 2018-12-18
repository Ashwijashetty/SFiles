<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight Schedule</title>
<script src ="js/HomeScript.js"></script>
<link rel ="stylesheet" href ="css/BookPageStyle.css">
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
			<th>Flight Information</th>
			</tr>
			<tr>    
                                <th>Flight Number</th>
                                <th>Airline</th>
				<th>Departure Time</th>
				<th>Arrival Time</th>
                                <th>Departure City</th>
				<th>Arrival City</th>
                                <th>Seat Number</th>
                                <th>Class Type</th>
			</tr>
			</thead>
			<tbody>
				<tr>    
                                <td>${viewFlightBean.getFlightNo()}</td>
                                <td>${viewFlightBean.getAirline()}</td>
				<td>${viewFlightBean.getDeptTime()}</td>
				<td>${viewFlightBean.getArrTime()}</td>
                                <td>${viewFlightBean.getDeptCity()}</td>
				<td>${viewFlightBean.getArrCity()}</td>
                                <td>${bookInfoBean.getSeatNumber()}</td>
                                <td>${bookInfoBean.getClassType()}</td>
			</tr>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="3">
						<button type="submit" id="btnsub">Continue</button>
					</th>
				</tr>
			</tfoot>
		</table>
	</section>
	<br />
	<footer class="footer"> Copyright Reserved &copy;<br />
	<a href="#Faq">FAQ</a> | <a href="#Terms&Conditions">Terms & Conditions</a> | <a href="#FeedBack">FeedBack</a> | | <a href="#CustomerSupport">24*7CustomerSupport</a>
	</footer>
</body>
</html>