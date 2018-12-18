<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Airline Reservation System</title>
<link href="http://fonts.googleapis.com/css?family=Abel|Arvo" rel="stylesheet" type="text/css" />
<link href="css/MainCss.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dropotron-1.0.js"></script>
</head>
<body>
<div id="wrapper">
	<div id="header-wrapper">
		<div id="header">
			<div id="logo">
				<h1><a href="#">Airline Reservation System</a></h1>
			</div>
		</div>
		<div id="menu-wrapper">
			<ul id="menu">
				<li class="current_page_item"><a href="welcome.do"><span>Homepage</span></a></li>
				<li><a href="showAboutUs.do"><span>About Us</span></a></li>
                                <li><span>Support</span>
					<ul>
						<li class="first"> <a href="showFaq.do">FAQs</a> </li>
						<li> <a href="showFeedback.do">Feedback</a> </li>
						<li class="last"> <a href="showContactUs.do">Contact Us</a> </li>
					</ul>
				</li>
                                <li><span>Users</span>
					<ul>
						<li class="first"> <a href="openUserHome.do">Customer</a> </li>
						<li> <a href="openAdminHome.do">Administrator</a> </li>
						<li class="last"> <a href="openExecutiveHome.do">Airline Executive</a> </li>
					</ul>
				</li>

			</ul>
			<script type="text/javascript">
			$('#menu').dropotron();
		</script> 
		</div>
		<!-- end #menu -->
	<div id="page">
		<div id="content">
			<div class="contentbg">
				<div class="post">
					<h2 class="title">Cancel Booking</h2>
					<div class="entry">
					   <section class="contentarea">
	<form:form method="post" action="cancelBookingDetails.usr" modelAttribute="cancelBookInfoBean" name = "frm" onsubmit="return validateHome(this)">
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
					<td><form:hidden path="bookingId"/></td>
					<td><form:hidden path="noOfPassengers"/></td>
				</tr>
				<tr>
				<td>Are you sure you want to Cancel your booking: 
				<form:radiobutton id="yes" path="status" value="Y"/>Yes
				<form:radiobutton id="no" path="status" value="N" checked="true"/>No</td>
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
	</form:form>
	</section>
					</div>
				</div>
				<div style="clear: both;">&nbsp;</div>
			</div>
		</div>
		
		<div style="clear: both;">&nbsp;</div>
	</div>
	<!-- end #page --> 
</div>
<div id="footer">
	<p>2017. Copyright reserved &copy;. Designed by <a href="https://www.in.capgemini.com/" rel="nofollow">Capgemini</a></p>
</div>
<!-- end #footer -->
</div>
</body>
</html>