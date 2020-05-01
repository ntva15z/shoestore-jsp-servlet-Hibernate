<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<html>
<head>
<title>Shoe Men</title>
<!-- css -->
<link
	href="<c:url value='/template/web/bootstrap/css/bootstrap.min.css' />"
	rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value='/template/web/css/style.css' />"
	rel="stylesheet" type="text/css" media="all" />
	<link rel="stylesheet"
	href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />
</head>
<body>
	<!-- header -->
	<%@ include file="/common/web/header.jsp"%>
	<!-- header -->
	<!-- body -->
	<div class="container">

		<!-- Page Heading -->
		<h1 class="my-4">
			Product 
			<c:if test="${catename!=null}">
			<small>${catename.name}</small>
			</c:if>
		</h1>
		<form enctype="multipart/form-data">
		<div class="row">
		<c:forEach var="entity" items="${listProduct}">
			<div class="col-lg-4 col-sm-6 portfolio-item">
				<div class="card h-100">
					<img width="300" height="300" class="card-img-top" src="<c:url value='/img/${entity.image}'/>" alt="${entity.image}">
					<div class="card-body">
						<h4 class="card-title">
							<a href="#">${entity.name}</a>
						</h4>
						<h5><del>${entity.price}</del>$</h5>
						<p class="card-text">${entity.description}</p>
					</div>
					<div class="card-footer">
						<small class="text-muted">&#9733; &#9733; &#9733; &#9733;
							&#9734;</small>
						<a href="<c:url value='/AddToCart?productId=${entity.productId}'/>"><i class="fa fa-cart-plus" aria-hidden="true"></i></a>	
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
		
		</form>
		<!-- /.row -->
		<!-- /.container -->
		<!-- body -->
	</div>

	<!-- footer -->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- footer -->

	<script type="text/javascript"
		src="<c:url value='/template/web/jquery/jquery.min.js' />"></script>
	<script type="text/javascript"
		src="<c:url value='/template/web/bootstrap/js/bootstrap.bundle.min.js' />"></script>
</body>
</html>