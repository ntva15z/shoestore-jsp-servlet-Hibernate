<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title>Trang Chủ</title>
    <!-- css -->
    <link href="<c:url value='/template/web/bootstrap/css/bootstrap.min.css' />" rel="stylesheet" type="text/css" media="all"/>
    <link href="<c:url value='/template/web/css/style.css' />" rel="stylesheet" type="text/css" media="all"/>
    <link rel="stylesheet" href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />
</head>
<body>
	<!-- header -->
    <%@ include file="/common/web/header.jsp" %>
    <!-- header -->
    
    <div class="container">
    	<!-- body -->
    	<div class="row">

        <div class="col-lg-3">

          <h1 class="my-4">TuTi</h1>
          <div class="list-group">
          <c:forEach var="cate" items="${ListCate}">
            <a href="<c:url value='/Danh-sach-san-pham?cateid=${cate.categoryId}'/>" class="list-group-item">${cate.name}</a>
          </c:forEach>
          </div>

        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

          <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
            <ol class="carousel-indicators">
              <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
		            <div class="carousel-item active" >
		              <img width="825px" style="max-height: 320px" class="d-block img-fluid" src="<c:url value='/img/1.jpg'/>" alt="First slide">
		            </div>
		            <div class="carousel-item">
		              <img width="825px" style="max-height: 320px"  class="d-block img-fluid" src="<c:url value='/img/2.png'/>" alt="Second slide">
		            </div>
		            <div class="carousel-item">
		              <img  width="825px" style="max-height: 320px" class="d-block img-fluid" src="<c:url value='/img/12.png'/>" alt="Third slide">
		            </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>

          <div class="row">
			<c:forEach var="list" items="${listProductDESC}">
            <div class="col-lg-4 col-md-6 mb-4">
              <div class="card h-100">
                <a href="#"><img width="300" height="300" class="card-img-top" src="<c:url value='/img/${list.image}'/>" alt="${list.image}"></a>
                <div class="card-body">
                  <h4 class="card-title">
                    <a href="#">${list.name}</a>
                  </h4>
                  <h5><del>${list.price}</del>$</h5>
                  <p class="card-text">${list.description}</p>
                </div>
                <div class="card-footer">
                  <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                  <a href="<c:url value='/AddToCart?productId=${list.productId}'/>"><i class="fa fa-cart-plus" aria-hidden="true"></i></a>	
                </div>
              </div>
            </div>
           </c:forEach>
          </div>
          <!-- /.row -->

        </div>
        <!-- /.col-lg-9 -->

      </div>
      <!-- /.row -->
    	
    	
    	<!-- body -->
    </div>
	<!-- footer -->
	<%@ include file="/common/web/footer.jsp" %>
	<!-- footer -->
	
	
	<script type="text/javascript" src="<c:url value='/template/web/jquery/jquery.min.js' />"></script>
    <script type="text/javascript" src="<c:url value='/template/web/bootstrap/js/bootstrap.bundle.min.js' />"></script>
</body>
</html>