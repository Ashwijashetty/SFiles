<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Airline Reservation System</title>
<link href="http://fonts.googleapis.com/css?family=Abel|Arvo" rel="stylesheet" type="text/css" />
<link href="css/MainCss.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dropotron-1.0.js"></script>
<script type="text/javascript" src="js/jquery.slidertron-1.0.js"></script>

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
		<div id="banner">
			<div id="slider"> <a href="#" class="button previous-button">&lt;</a> <a href="#" class="button next-button">&gt;</a>
				<div class="viewer">
					<div class="reel">
						<div class="slide">
							
							<p>Lotus Temple (New Delhi)</p>
							<a class="link" href="#">Full story ...</a><img src="pics/lotusTemple.jpg" width="900" height="350" alt="" /></div>
						<div class="slide">
						
							<p>Golden Temple (Amritsar)</p>
							<a class="link" href="#">Full story ...</a><img src="pics/GoldenTemple2.JPG" width="900" height="350" alt="" /></div>
					
						<div class="slide">
				        	<p>Taj Mahal (Agra)</p>
							<a class="link" href="#">Full story ...</a><img src="pics/tajMahal.jpg" width="900" height="350" alt="" /></div>
							
					</div>
				</div>
				<div class="indicator">
					<ul>
						<li class="active">1</li>
						<li>2</li>
						<li>3</li>
					</ul>
				</div>
			</div>
			<script type="text/javascript">
				$('#slider').slidertron({
					viewerSelector: '.viewer',
					reelSelector: '.viewer .reel',
					slidesSelector: '.viewer .reel .slide',
					advanceDelay: 3000,
					speed: 'slow',
					navPreviousSelector: '.previous-button',
					navNextSelector: '.next-button',
					indicatorSelector: '.indicator ul li',
					slideLinkSelector: '.link'
				});
			</script> 
		</div>
	</div>
	

	<!-- end #header -->
	<div id="page2">
		<div id="content">
			<div class="contentbg">
				<div class="postImg">
					<a href="showBookFlight.usr"><img src="pics/booking.jpg"></a><br/>
					<a href="showUserManageHome.usr"><img src="pics/manage.jpg"></a><br/>
					<a  href="showViewFlightStatus.usr"><img src="pics/flightStatus.jpg"></a>
					
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
</body>
</html>