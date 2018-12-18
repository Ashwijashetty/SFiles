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
	<form method="post" action="fetchFlightDetails.usr" name = "frm" onsubmit="return validateHome(this)">
		<table id ="table">
			</thead>
			<tbody>
				<tr>
					<td colspan = "2">
					<input type="radio" id="business" name="classType" value="business" checked/>Business Class
					<input type="radio" id="first" name="classType" value="first"/>First Class
					</td>
				</tr>
				<tr>
					<td>Origin</td>
					<td><select id="deptCity" name="deptCity" required>
							<option value=""> --Select--
							</option>
							<option value="Agartala">Agartala
							</option>
							<option value="Ahmedabad">Ahmedabad
							</option>
							<option value="Aizawl">Aizawl
							</option>
							<option value="Amritsar">Amritsar
							</option>
							<option value="Bengaluru">Bengaluru
							</option>
							<option value="Chandigarh">Chandigarh
							</option>
							<option value="Chennai">Chennai
							</option>
							<option value="Dehradun">Dehradun
							</option>
							<option value="Delhi">Delhi
							</option>
							<option value="Goa">Goa
							</option>
							<option value="Guwahati">Guwahati
							</option>
							<option value="Hyderabad">Hyderabad
							</option>
							<option value="Jaipur">Jaipur
							</option>
							<option value="Jammu">Jammu
							</option>
							<option value="Jodhpur">Jodhpur
							</option>
							<option value="Kolkata">Kolkata
							</option>
							<option value="Mumbai">Mumbai
							</option>
							<option value="Pune">Pune
							</option>
							<option value="Srinagar">Srinagar
							</option>
							<option value="Surat">Surat
							</option>
							<option value="Thiruvananthapuram">Thiruvananthapuram
							</option>
							<option value="Udaipur">Udaipur
							</option>
							<option value="Varanasi">Varanasi
							</option>
							
					</select></td>
					<td>Destination</td>
					<td><select id="arrCity" name="arrCity" required>
							<option value=""> --Select--
							</option>
							<option value="Agartala">Agartala
							</option>
							<option value="Ahmedabad">Ahmedabad
							</option>
							<option value="Aizawl">Aizawl
							</option>
							<option value="Amritsar">Amritsar
							</option>
							<option value="Bengaluru">Bengaluru
							</option>
							<option value="Chandigarh">Chandigarh
							</option>
							<option value="Chennai">Chennai
							</option>
							<option value="Dehradun">Dehradun
							</option>
							<option value="Delhi">Delhi
							</option>
							<option value="Goa">Goa
							</option>
							<option value="Guwahati">Guwahati
							</option>
							<option value="Hyderabad">Hyderabad
							</option>
							<option value="Jaipur">Jaipur
							</option>
							<option value="Jammu">Jammu
							</option>
							<option value="Jodhpur">Jodhpur
							</option>
							<option value="Kolkata">Kolkata
							</option>
							<option value="Mumbai">Mumbai
							</option>
							<option value="Pune">Pune
							</option>
							<option value="Srinagar">Srinagar
							</option>
							<option value="Surat">Surat
							</option>
							<option value="Thiruvananthapuram">Thiruvananthapuram
							</option>
							<option value="Udaipur">Udaipur
							</option>
							<option value="Varanasi">Varanasi
							</option>
					</select></td>
					<td id="placerr" class="error"></td>
				</tr>
				<tr>

					<td>Date of Journey</td>
					<td><input type="date" id="doj" name="dateOfJourney" required/></td>
					<td id="daterr" class="error"></td>
				</tr>
				<tr>    
                    <td>Number of Passengers</td>
					<td><select id="adult" name="passengers" required>
							<option value="1">1 Person
							</option>
							<option value="2" >2 Persons
							</option>
							<option value="3" >3 Persons
							</option>
							<option value="4" >4 Persons
							</option>
							<option value="5" >5 Persons
							</option>
							<option value="6" >6 Persons
							</option>
					</select></td>
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