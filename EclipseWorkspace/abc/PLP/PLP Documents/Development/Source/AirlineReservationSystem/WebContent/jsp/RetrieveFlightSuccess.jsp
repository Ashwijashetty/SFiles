<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				 <li><a href="showAdminMenu.adm"><span>Return to Menu</span></a></li>               
                <li><a href="openAdminHome.do"><span>Logout</span></a></li>
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
		<table id ="table">
			<thead>
			
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
                <c:forEach var="flight" items="${flights}">
                <tr>
				<th><c:out value="${flight.getFlightNo()}"></c:out></th>
				<th><c:out value="${flight.getAirline()}"></c:out></th>
				<th><c:out value="${flight.getDeptCity()}"></c:out></th>
				<th><c:out value="${flight.getArrCity()}"></c:out></th>
				<th><c:out value="${flight.getDeptDate()}"></c:out></th>
				<th><c:out value="${flight.getArrDate()}"></c:out></th>
				<th><c:out value="${flight.getDeptTime()}"></c:out></th>
				<th><c:out value="${flight.getArrTime()}"></c:out></th>
				<th><c:out value="${flight.getFirstSeats()}"></c:out></th>
				<th><c:out value="${flight.getFirstSeatsFare()}"></c:out></th>
				<th><c:out value="${flight.getBussSeats()}"></c:out></th>
				<th><c:out value="${flight.getBussSeatsFare()}"></c:out></th>
                </tr>
                </c:forEach>
			</tbody>
			<tfoot>
			</tfoot>
		</table>
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