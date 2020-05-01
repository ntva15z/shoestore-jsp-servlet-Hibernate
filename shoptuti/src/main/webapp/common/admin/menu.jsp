<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sidebar"
	class="sidebar                  responsive                    ace-save-state">
	<script type="text/javascript">
		try {
			ace.settings.loadState('sidebar')
		} catch (e) {
		}
	</script>
	<div class="sidebar-shortcuts">
		<div class="sidebar-shortcuts-large">
			<button class="btn btn-success">
				<i class="ace-icon fa fa-signal"></i>
			</button>

			<button class="btn btn-info">
				<i class="ace-icon fa fa-pencil"></i>
			</button>

			<button class="btn btn-warning">
				<i class="ace-icon fa fa-users"></i>
			</button>

			<button class="btn btn-danger">
				<i class="ace-icon fa fa-cogs"></i>
			</button>
		</div>
		<div class="sidebar-shortcuts-mini">
			<span class="btn btn-success"></span> <span class="btn btn-info"></span>

			<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
		</div>
	</div>
	<ul class="nav nav-list">
		<li class=""><a href="#" class="dropdown-toggle"> <i
				class="menu-icon fa fa-list"></i> <span class="menu-text">
					Menu </span> <b class="arrow fa fa-angle-down"></b>
		</a> <b class="arrow"></b>

			<ul class="submenu">
				<li class=""><a href="<c:url value='/admin-List-Customers'/>">
						<i class="menu-icon fa fa-caret-right"></i> Danh sách người dùng
				</a> <b class="arrow"></b></li>

				<li class=""><a href="<c:url value='/admin-List-Product?page=1&maxPageItem=5'/>">
						<i class="menu-icon fa fa-caret-right"></i> Danh sách sản phẩm
				</a> <b class="arrow"></b></li>
				<li class="open"><a href=""> <i
						class="menu-icon fa fa-caret-right"></i> Thống kê doanh thu <b
						class="arrow fa fa-angle-down"></b>

				</a> <b class="arrow"></b>
					<ul class="submenu nav-show" style="display: block;">
						<li class=""><a href="<c:url value='/admin-Chart?id=datebuy'/>"> <i
								class="menu-icon fa fa-leaf green"></i> Doanh thu theo ngày
						</a> <b class="arrow"></b></li>

						<li class=""><a href="<c:url value='/admin-Chart?id=topbuy'/>"
							> <i
								class="menu-icon fa fa-pencil orange"></i> Top khách hàng mua
								nhiều nhất
						</a><b class="arrow"></b></li>
					</ul></li>
			</ul></li>
	</ul>
	<div class="sidebar-toggle sidebar-collapse">
		<i class="ace-icon fa fa-angle-double-left ace-save-state"
			data-icon1="ace-icon fa fa-angle-double-left"
			data-icon2="ace-icon fa fa-angle-double-right"></i>
	</div>
</div>