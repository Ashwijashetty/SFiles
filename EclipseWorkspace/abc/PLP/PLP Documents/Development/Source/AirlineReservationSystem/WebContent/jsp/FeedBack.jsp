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
					<h2 class="title">Feedback Form</h2>
					<div class="entry">
					<section class="contentarea">
				<form action="/action_page.php">
                 <table   align="center">
           <tbody>
                <tr>
                  <td >
                    Name </td><td>              
                   <select id="nm" name="nm"  >
                     <option value="MR">Mr.</option>
                    <option value="MRS">Mrs.</option>
		            <option value="MS">Ms.</option>
		             <option value="DR">Dr.</option>
		            <option value="PRO">Prof.</option>
                    </select>
             <input type="text" id="name" name="name" required/>

                       
                  </td><td></td><td></td>
                 </tr>

               <tr>
                  <td>
                        E-mail Address</td><td><input type="email" id="emailAdd" name="emailAdd" required maxlength="25" />
                       
                  </td><td></td><td></td>
                 </tr>
				<tr>
                 <td>Mobile Number </td>        
                        <td><input type="text" id="phone" name="phone"   placeholder="Phone Number" /></td>                                 
                </tr>
 </tbody>
          
       <tbody>
                <tr>
                  <td>                       
                         Date of Travel </td><td>
           <input type="date" id="dob" name="dob" min="1975-01-01" max="2016-12-31"/>
                      
                  </td>
                 </tr>
               <tr>
                  <td>                  
                        Ticket Number</td><td><input type="text" id="add" name="add"/>  
                  </td>
                 </tr>

          </tbody>		  		 
		 <tbody>
                <tr>
                  <td>
                      Category </td><td>
         <select id="ctg" name="ctg"  >
          <option value="">--select Category--</option>
          <option value="RES">Reservations</option>
          <option value="ATS">Airport Services</option>
		  <option value="BAGG">Baggage</option>
		  <option value="DEL">Delay</option>
		  <option value="OTH">Others</option>
        </select>
                  </td>
                 </tr>
			<tr>
                  <td>                        
                         Content </td><td><input type="text" id="add" name="add" required/>
                       
                  </td>
           </tr>
				
                <tr>
                   <th colspan="2"><input type="submit" value="Submit" /></th>
               </tr>

          </tbody>            
</table>
</form>
				
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