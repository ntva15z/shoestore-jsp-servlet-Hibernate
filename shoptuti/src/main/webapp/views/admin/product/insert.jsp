<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin insert product</title>
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
<script type="text/javascript">
		function encodeImageFileAsURL(element) {
			var file = element.files[0];
			if(file===undefined){
				$('#preview-img').attr('src');
				return false;
			}
			var reader = new FileReader();
			reader.onloadend = function(){
				$('#preview-img').attr('src',reader.result)
			}
			reader.readAsDataURL(file);
		}
	</script>
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
								href="<c:url value='/admin-home'/>">Trang chủ</a></li>
						</ul>
						<!-- /.breadcrumb -->
					</div>
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<c:if test="${not empty message}">
								<div class="alert alert-${alert}">
									${message}
								</div>
								</c:if>
								<form class="form-horizontal" role="form" action="admin-Insert-Product" method="post" enctype="multipart/form-data">
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-select-1"> Category ID </label>
										<div class="col-sm-9">
										<select name="categoryId">
											<c:forEach var="category" items="${categories}">
												<option value="${category.categoryId}">${category.name}</option>
											</c:forEach>	
										</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Name Product </label>
										<div class="col-sm-9">
											<input type="text" name="name" id="form-field-1"  class="col-xs-10 col-sm-5"  value="${name }">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>
										<div class="col-sm-9">
											<img width="150px" height="150px" id="preview-img" src="" />
										</div>
									</div>		
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Image </label>
										<div class="col-sm-9">
											<input type="file" name="image" id="form-field-1"  class="col-xs-10 col-sm-5" onchange="encodeImageFileAsURL(this)">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Quantity </label>
										<div class="col-sm-9">
											<input type="number" name="quantity" id="form-field-1"  class="col-xs-10 col-sm-5" value="${quantity}">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Price </label>

										<div class="col-sm-9">
											<input type="number" name="price" id="form-field-1"  class="col-xs-10 col-sm-5" value="${price}">
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Status </label>
										<div class="col-sm-9">
											<input type="text" name="status" id="form-field-1" class="col-xs-10 col-sm-5" value="${status}">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Description </label>
										<div class="col-sm-9">
											<input type="text" name="description" id="form-field-1"  class="col-xs-10 col-sm-5" value="${description }">
										</div>
									</div>
									<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
												<input class="btn btn-info" type="submit" name="submit" value="submit"></input>
											&nbsp; &nbsp; &nbsp;
											<button class="btn" type="reset" name="reset"> 
												<i class="ace-icon fa fa-undo bigger-110"></i>
												Reset
											</button>
										</div>
									</div>
									</form>
							</div>
						</div>
					</div>
				</div>
				<!-- /.main-content -->
			</div>
		<!-- /.main-content -->

		<!-- body -->

		<!-- footer -->
		<%@ include file="/common/admin/footer.jsp"%>
		<!-- footer -->
		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse display"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	
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
	<script src="<c:url value='/template/login/vendor/bootstrap/js/popper.js'/>"></script>
	<script
		src="<c:url value='/template/admin/assets/js/bootstrap.min.js'/>"></script>

	<!-- page specific plugin scripts -->
	<script
		src="<c:url value='/template/admin/assets/js/jquery-ui.min.js'/>"></script>
	<!-- pading -->
	
	<!-- pading -->
</body>
</html>


