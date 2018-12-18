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
<script type="text/javascript" src="js/HomeScript.js"></script>
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
					<h2 class="title">Enter New Flight Details</h2>
					<div class="entry">
		<section class="contentarea">
		<form:form action="addFlightDetail.adm" modelAttribute="insertFlight" method="post" name="frm" onsubmit="return validateArrCity(this)" >
				<table align="center">
					<tr>
						<th>Airline </th>
						<td><form:input path="airline" required="true" title="Must be in characters in range of 5 to 30 !!" pattern="[A-Za-z ]{5,30}" /></td>
						<td><form:errors path="airline" /></td>
					</tr>

					<tr>
						<th>Departure City </th>
						<td>
							<form:select id="deptCity" path="deptCity" required="true">
							<form:option value="">--Please Select--</form:option>
							<form:options items="${cityList}" />
							</form:select>
						</td>
						<td><form:errors path="deptCity"/></td>
					</tr>

					<tr>
						<th>Arrival City </th>
						<td>
							<form:select id="arrCity" path="arrCity" required="true">
							<form:option value="">--Please Select--</form:option>
							<form:options items="${cityList}" />
							</form:select>
						</td>
						<td><form:errors path="arrCity" /></td>
					</tr>

					<tr>
						<th>Departure Date </th>
						<td><form:input type="date" id="myDate" path="tempDeptDate" min="${minDate}" max="${maxDate}" required="true"/></td>
						<td><form:errors path="tempDeptDate"/></td>
					</tr>
					<tr>
						<th>Arrival Date </th>
						<td><form:input type="date" id="myDate" path="tempArrDate" required="true"/></td>
						<td><form:errors path="tempArrDate"/></td>
					</tr>

					<tr>
						<th>Departure Time </th>
						<td><form:input path="deptTime" required="true" pattern="[0-9]{4}" title="Must be in this format: HHMM !!"/></td>
						<td><form:errors path="deptTime"/></td>
					</tr>
	
					<tr>
						<th>Arrival Time </th>
						<td><form:input path="arrTime" required="true" pattern="[0-9]{4}" title="Must be in this format: HHMM !!"/></td>
						<td><form:errors path="arrTime"/></td>
					</tr>
					<tr>
						<th>First Class Seats </th>
						<td><form:input path="firstSeats" required="true" pattern="[0-9]{2}" title="Must be in 2 digits only !!"/></td>
						<td><form:errors path="firstSeats"/></td>
					</tr>

					<tr>
						<th>First Class Seat Fare </th>
						<td><form:input path="firstSeatsFare" required="true" pattern="[0-9]{3,6}" title="Must be in digits in range of 3 to 6 !!"/></td>
						<td><form:errors path="firstSeatsFare" /></td>
					</tr>

					<tr>
						<th>Business Class Seats </th>
						<td><form:input path="bussSeats" required="true" pattern="[0-9]{2}" title="Must be in 2 digits only !!"/></td>
						<td><form:errors path="bussSeats"/></td>
					</tr>

					<tr>
						<th>Business Class Seat Fare </th>
						<td><form:input path="bussSeatsFare" required="true" pattern="[0-9]{3,6}" title="Must be in digits in range of 3 to 6 !!"/></td>
						<td><form:errors path="bussSeatsFare" /></td>
					</tr>

					<tr>
						<td><button type="submit" id="btnsub">Submit</button></td>
						<td><button type="reset" id="btnreset">Reset</button></td>
					</tr>

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