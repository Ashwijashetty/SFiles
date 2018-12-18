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
					<h2 class="title">Flight Information</h2>
					<div class="entry">
		<section class="contentarea">
	<form:form method="post" action="showPaymentPage.usr" modelAttribute="flightInfo" name = "frm" onsubmit="return validateHome(this)">
		<table id ="table">
			<thead>
			<tr>
			<th>Flight Information</th>
			</tr>
			<tr>
				<th>Departure Time</th>
				<th>Arrival Time</th>
				<th>Flights</th>
				<th>Fare</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${flightList}">
                <tr>
				<th><c:out value="${list.getDeptTime()}"></c:out></th>
				<th><c:out value="${list.getArrTime()}"></c:out></th>
				<th><form:radiobutton path="flightNo" value="${list.getFlightNo()}"/>${list.getFlightNo()}:${list.getAirline()}</th>
				<c:if test="${flightInfo.getClassType().equalsIgnoreCase('first')}">
				<th><c:out value="${list.getFirstSeatsFare()}"></c:out></th>
				</c:if>
				<c:if test="${flightInfo.getClassType().equalsIgnoreCase('business')}">
				<th><c:out value="${list.getBussSeatsFare()}"></c:out></th>
				</c:if>
                </tr>
				</c:forEach>
				<tr>
					<th><form:hidden path="classType" /></th>
					<th><form:hidden path="passengers" /></th>
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