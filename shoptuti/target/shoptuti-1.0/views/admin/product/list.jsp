<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin list product</title>
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
<link rel="stylesheet"
	href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/css/ace.min.css' />"
	class="ace-main-stylesheet" id="main-ace-style" />
<script
	src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type='text/javascript'
	src='<c:url value="/template/admin/js/jquery-2.2.3.min.js" />'></script>
<script
	src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script
	src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>

<script src="<c:url value='/ckeditor/ckeditor.js' />"></script>
</head>
<body class="no-skin">
	<!-- header -->
	<%@ include file="/common/admin/header.jsp"%>
	<!-- header -->

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>
		<!-- menu -->
		<%@ include file="/common/admin/menu.jsp"%>
		<!-- menu -->
		<!-- body -->
		<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a
							href="<c:url value='/admin-home'/>">Home</a></li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<form action="<c:url value='/admin-List-Product'/>" id="formSubmit" method="get">
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
								<a href="<c:url value='/admin-Insert-Product'/>">Add Product</a>
								<div class="row">
									<div class="col-xs-12">
										<div class="table-reponsive">
											<table class="table table-bordered">
												<tr>
													<th>Product ID</th>
													<th>Name</th>
													<th>Image</th>
													<th>Quantity</th>
													<th>Price</th>
													<th>ManufacturedDate</th>
													<th>Status</th>
													<th>Description</th>
													<th></th>
													<th></th>
												</tr>
												<c:forEach var="entity" items="${products}">
													<tr>
														<td>${entity.productId}</td>
														<td>${entity.name}</td>
														<td><img width="50px" height="50px"
															src="<c:url value='/img/${entity.image}'/>"
															alt="${entity.image}"></td>
														<td>${entity.quantity}</td>
														<td>${entity.price}$</td>
														<td>${entity.manufacturedDate}</td>
														<td>${entity.status}</td>
														<td>${entity.description}</td>
														<td><a
															href="<c:url value='/admin-Edit-Product?id=${entity.productId}'/>"><i
																class="fa fa-pencil-square-o" aria-hidden="true"></i>Edit|</a></td>
														<td><a
															href="<c:url value='/admin-Delete-Product?id=${entity.productId}'/>"><i
																class="fa fa-trash" aria-hidden="true"></i>Delete|</a></td>
													</tr>
												</c:forEach>
											</table>
											<div align="center">
											<ul  class="pagination" id="pagination"></ul>
											<input type="hidden" value="" id="page" name="page"/>
											<input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
											</div>
										</div>
									</div>
								</div>
						</div>
					</div>
				</div>
				</form>
			</div>
			<!-- /.main-content -->
		</div>
		<!-- /.main-content -->
		<!-- pagination -->

		<!-- pagination -->

		<!-- body -->

		<!-- footer -->
		<%@ include file="/common/admin/footer.jsp"%>
		<!-- footer -->
		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse display"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	
		<script>
			var totalPages = ${totalpage};
			var currentPage = ${page};
			var limit =5;
			$(function () {
				window.pagObj = $('#pagination').twbsPagination({
					totalPages: totalPages,
					visiblePages: 5,
					startPage: currentPage,
					onPageClick: function (event, page) {
						if (currentPage != page) {
							$('#maxPageItem').val(limit);
							$('#page').val(page);
							$('#formSubmit').submit();
						}
					}
				});
			});
	</script>
	<script
		src="<c:url value='/template/admin/assets/js/bootstrap.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/ace-elements.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/ace.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/bootstrap.min.js'/>"></script>

	<!-- page specific plugin scripts -->
	<script
		src="<c:url value='/template/admin/assets/js/jquery-ui.min.js'/>"></script>
	<!-- pading -->

	<!-- pading -->
</body>
</html>


