c<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
	<form method="post" action="cancelBookingDetails.usr" name = "frm" onsubmit="return validateHome(this)">
		<table id ="table">
			<thead>
			<tr>
					<th><h4>Your ticket information has been given below..</h4></th>
			</tr>
			</thead>
			<tbody>
				<tr>
					<td>Booking Id:</td>
					<td>${cancelBookInfoBean.getBookingId()}</td>
				</tr>
				<tr>
					<td>Flight Number:</td>
					<td>${cancelBookInfoBean.getFlightNo()}</td>
				</tr>
				<tr>
					<td>Email Id:</td>
					<td>${cancelBookInfoBean.getCustEmail()}</td>
				</tr>
				<tr>
					<td>No. of passengers:</td>
					<td>${cancelBookInfoBean.getNoOfPassengers()}</td>
				</tr>
				<tr>
					<td>Class Type:</td>
					<td>${cancelBookInfoBean.getClassType()}</td>
				</tr>
				<tr>
					<td>Total fare:</td>
					<td>${cancelBookInfoBean.getTotalFare()}</td>
				</tr>
				<tr>
					<td>Seat Numbers:</td>
					<td>${cancelBookInfoBean.getSeatNumber()}</td>
				</tr>
				<tr>
					<td>Source City:</td>
					<td>${cancelBookInfoBean.getSrcCity()}</td>
				</tr>
				<tr>
					<td>Destination City:</td>
					<td>${cancelBookInfoBean.getDestCity()}</td>
				</tr>
				<tr>
				<td>Are you sure you want to Cancel your booking: </td>
				<td><input type="radio" id="yes" name="cancel" value="Y" checked/>Yes
				<input type="radio" id="no" name="cancel" value="N" />No</td>
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
</html>ss