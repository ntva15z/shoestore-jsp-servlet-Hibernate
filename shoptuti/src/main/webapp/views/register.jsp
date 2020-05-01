<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Colorlib Templates">
<meta name="author" content="Colorlib">
<meta name="keywords" content="Colorlib Templates">
<title>Register page</title>
<link
	href="<c:url value='/template/register/vendor/mdi-font/css/material-design-iconic-font.min.css'/>"
	rel="stylesheet" media="all">
<link
	href="<c:url value='/template/register/vendor/font-awesome-4.7/css/font-awesome.min.css'/>"
	rel="stylesheet" media="all">
<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<link
	href="<c:url value='/template/register/vendor/select2/select2.min.css'/>"
	rel="stylesheet" media="all">
<link
	href="<c:url value='/template/register/vendor/datepicker/daterangepicker.css'/>"
	rel="stylesheet" media="all">
<link href="<c:url value='/template/register/css/main.css'/>"
	rel="stylesheet" media="all">
</head>
<body style="background-color: #666666;">
	<!-- body -->
	
	<div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
		<div class="wrapper wrapper--w680">
			<div class="card card-4">
				<div class="card-body">
					<h2 class="title">Registration Form</h2>
					<c:if test="${not empty message}">
					<h3 style="color: red;">
							${message}
					</h3>
					</c:if>
					<form action="<c:url value='/Register-Customer'/>" method="POST">
						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<label class="label">User name</label> <input
										class="input--style-4" type="text" name="username" value="${username}">
								</div>
							</div>
							<div class="col-2">
								<div class="input-group">
									<label class="label">Full name</label> <input
										class="input--style-4" type="text" name="fullname" value="${fullname}">
								</div>
							</div>
						</div>
						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<label class="label">Birth Day</label> <input
										class="input--style-4" type="text" name="birthday" value="${birthday}">
								</div>
							</div>
							<div class="col-2">
								<div class="input-group">
									<label class="label">Gender</label>
									<div class="p-t-10">
										<label class="radio-container m-r-45">Male <input
											type="radio" checked="checked" name="gender" value="Male">
											<span class="checkmark"></span>
										</label> <label class="radio-container">Female <input
											type="radio" name="gender" value="Female"> <span
											class="checkmark"></span>
										</label>
									</div>
								</div>
							</div>
						</div>
						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<label class="label">Email</label> <input
										class="input--style-4" type="email" name="email" value="${email}">
								</div>
							</div>
							<div class="col-2">
								<div class="input-group">
									<label class="label">Phone Number</label> <input
										class="input--style-4" type="text" name="phone" value="${phone}">
								</div>
							</div>
						</div>
						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<label class="label">Password</label> <input
										class="input--style-4" type="password" name="password" value="${password}">
								</div>
							</div>
							<div class="col-2">
								<div class="input-group">
									<label class="label">Confirm</label> <input
										class="input--style-4" type="password" name="confirm">
								</div>
							</div>
						</div>
						<div class="p-t-15">
							<button class="btn btn--radius-2 btn--blue" >Submit</button>
						</div>
						<div align='right'  class="text-center p-t-46 p-b-20">
						<span class="txt2">
							<a style="text-decoration: none;color: blue;" href="<c:url value='/Register-Customer?click=reset'/>">Reset</a>
						</span>
					</div>
						<div align='center'  class="text-center p-t-46 p-b-20">
						<span class="txt2">
							<a style="text-decoration: none;color: black;" href="<c:url value='/trang-chu'/>">Back to Home page</a>
						</span>
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- body -->

	<!-- Vendor JS-->
	<script src="<c:url value='/template/login/vendor/jquery/jquery-3.2.1.min.js'/>"></script>
	<script
		src="<c:url value='/template/register/vendor/select2/select2.min.js'/>"></script>
	<script
		src="<c:url value='/template/register/vendor/datepicker/moment.min.js'/>"></script>
	<script
		src="<c:url value='/template/register/vendor/datepicker/daterangepicker.js'/>"></script>
	<script src="<c:url value='/template/register/js/global.js'/>"></script>
</body>
</html>