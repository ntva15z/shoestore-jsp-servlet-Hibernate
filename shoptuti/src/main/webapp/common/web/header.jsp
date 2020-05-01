<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="<c:url value='/trang-chu'/>">Shop TuTi</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="<c:url value='/trang-chu'/>">Trang chủ
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <c:if test="${not empty USERMODEL }">
              <li class="nav-item">
                <a class="nav-link" href='#'>Wellcome, ${USERMODEL.name }</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href='<c:url value="/thoat?action=logout"/>'>Thoát</a>
              </li>
            </c:if>
            <c:if test="${empty USERMODEL }">
              <li class="nav-item">
                <a class="nav-link" href='<c:url value="/dang-nhap?action=login"/>'>Đăng nhập</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href='<c:url value="/dang-ki?action=register"/>'>Đăng ký</a>
              </li>
            </c:if>
            	
              <li class="nav-item">
              <a class="btn btn-success btn-sm ml-3" href="<c:url value="/shopping-cart"/>">
                    <i class="fa fa-shopping-cart"></i> Cart
                    <span class="badge badge-light">${sl}</span>
                </a>
              </li>
          </ul>
        </div>
      </div>
</nav>