<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.connection.*"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<!-- Mirrored from www.binarytheme.com/BTlivedemos/2014/08/29/horizontal-admin/ by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 14 Jul 2019 14:46:41 GMT -->
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta name="description" content="" />
<meta name="author" content="" />
<!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
<title>Business Management System</title>
<!-- BOOTSTRAP CORE STYLE  -->
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<!-- FONT AWESOME STYLE  -->
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLE  -->
<link href="assets/css/style.css" rel="stylesheet" />
<!-- GOOGLE FONT -->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />

</head>
<body>
	<%
		if (session.getAttribute("uname") != null && session.getAttribute("uname") != "") {
	%>
	<div class="navbar navbar-inverse set-radius-zero">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index-2.html"> <img
					src="assets/img/logo.png" />
				</a>

			</div>

			<div class="right-div">
				<a href="admin-logout.jsp" class="btn btn-danger pull-right">LOG
					ME OUT</a>
			</div>
		</div>
	</div>
	<jsp:include page="adminHeader.jsp"></jsp:include>
	<!-- MENU SECTION END-->
	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="modal-body modal-spa center-block">
				<div class="login-grids">
					<div class="login">
						<div class="login-bottom">
							<h3>Customer Registration</h3>
							<%
								String success = (String) session.getAttribute("success-message");
							if (success != null) {
								session.removeAttribute("success-message");
							%>
							<div class='alert alert-success' id='success' style="width: 680px;">Customer
								Register Successfully.</div>
							<%
								}
							String fail = (String) session.getAttribute("fail-message");
							if (fail != null) {
							session.removeAttribute("fail-message");
							%>
							<div class="alert alert-danger" id='danger' style="width: 680px;">Customer
								Registration Fail,Please try again</div>
							<%
								}
							%>
							<form action="AddCustomer" method="post">
								<div class="sign-up">
									<h4>Customer Name :</h4>
									<input type="text" placeholder="Your Name" required=""
										style="width: 680px;" name="name">
								</div>
								<div class="sign-up">
									<h4>Email :</h4>
									<input type="text" placeholder="Type here" required=""
										style="width: 680px;" name="email">
								</div>
								<div class="sign-up">
									<h4>Password :</h4>
									<input type="password" placeholder="Password" required=""
										style="width: 680px;" name="password">

								</div>
								<div class="sign-up">
									<h4>Phone :</h4>
									<input type="text" placeholder="Type here" required=""
										style="width: 680px;" name="mobile">
								</div>
								<div class="sign-up">
									<h4>Gender :</h4>
									<br> <select class="form-control" style="width: 680px;"
										name="gender">
										<option>Male</option>
										<option>Female</option>
									</select>
								</div>
								<br>
								<div class="sign-up">
									<h4>Address :</h4>
									<input type="text" placeholder="Type here" required=""
										style="min-height: 100px; width: 680px;" name="address">
								</div>

								<div class="sign-up">
									<h4>Pincode :</h4>
									<input type="text" placeholder="Pincode" required=""
										style="width: 680px;" name="pincode">

								</div>
								<div class="sign-up">
									<input type="submit" value="Register" style="width: 680px;">
								</div>

							</form>
						</div>
						<div class="clearfix"></div>
					</div>
					<p>
						<a href="customer-login.jsp">Existing Customer? Log In</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<!-- CONTENT-WRAPPER SECTION END-->
	<jsp:include page="admin-footer.jsp"></jsp:include>
	<!-- FOOTER SECTION END-->
	<!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
	<!-- CORE JQUERY  -->
	<script src="assets/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS  -->
	<script src="assets/js/bootstrap.js"></script>
	<!-- CUSTOM SCRIPTS  -->
	<script src="assets/js/custom.js"></script>
	<script>
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})
				(
						window,
						document,
						'script',
						'../../../../../../www.google-analytics.com/analytics.js',
						'ga');

		ga('create', 'UA-58127580-1', 'auto');
		ga('send', 'pageview');
	</script>
	<%
		} else {
	response.sendRedirect("admin-login.jsp");
	}
	%>
</body>
</html>
