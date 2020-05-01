<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<html>
<head>
<title>Shopping cart</title>
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
	<c:set var="cart" value="${sessionScope.cart}"/>

	<!-- header -->
	<%@ include file="/common/web/header.jsp"%>
	<!-- header -->

	<!-- body -->
	<h1 align="center" class="my-4">Shopping Cart</h1>
	
		<div class="container mb-4">
			<div class="row">
				<div class="col-12">
					<div class="table-responsive">
					<form action="<c:url value='/Update-Cart?action=update'/>" method="post"  >
						<table class="table table-striped">
								<tr>
									<th scope="col"></th>
									<th scope="col">Product</th>
									<th scope="col">Status</th>
									<th scope="col" class="text-center">Quantity</th>
									<th scope="col" class="text-right">Price</th>
									<th></th>
								</tr>
							<c:forEach var="item" items="${cart.cartdetailList}">
								<tr>
									<td><img width="100" height="100" src="<c:url value='/img/${item.product.image}'/>"/></td>
									<td>${item.product.name}</td>
									<td>${item.product.status}</td>
									<td><input class="form-control" type="number" name="quantity" value="${item.quantity}"></td>
									<td class="text-right">${item.price}$</td>
									<td class="text-right">
										<button type="submit" class="btn btn-sm btn-danger"><i class="fa fa-refresh" aria-hidden="true"></i></button>
										<a href="<c:url value='/Delete-Cart?itemname=${item.product.name}'/>" class="btn btn-sm btn-danger"><i class="fa fa-trash"></i></a>
									</td>
								</tr>
							</c:forEach>	
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td><strong>Total</strong></td>
									<td class="text-right"><strong>${total}$</strong></td>
								</tr>
						</table>
						</form>
					</div>
				</div>
				<div class="col mb-2">
					<div class="row">
						<div class="col-sm-12  col-md-6">
							<c:if test="${ListCate!=null}">
							<a href="<c:url value='/Danh-sach-san-pham?cateid=${cate.categoryId}'/>">Continue Shopping</a>
							</c:if>
							<a href="<c:url value='/trang-chu'/>">Continue Shopping</a>
						</div>
						
						<div class="col-sm-12 col-md-6 text-right">
							<a href="<c:url value='/CheckOut'/>" class="btn btn-lg btn-block btn-success text-uppercase">Checkout</a>
						</div>
						<c:if test="${not empty message}">
						<div align="center">
							<h3 style="color: green;">
								<strong>${message}</strong>
							</h3>
						</div>
					</c:if>
					</div>
				</div>
			</div>
		</div>
		<!-- /.container -->
		<!-- body -->
	
	<!-- footer -->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- footer -->

	<script type="text/javascript"
		src="<c:url value='/template/web/jquery/jquery.min.js' />"></script>
	<script type="text/javascript"
		src="<c:url value='/template/web/bootstrap/js/bootstrap.bundle.min.js' />"></script>
</body>
</html>