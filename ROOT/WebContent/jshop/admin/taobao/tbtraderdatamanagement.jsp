<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getParameter("content") != null ? request.getParameter("content") : "";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>180内用户评论列表</title>


		<!-- stylesheets -->
		<link rel="stylesheet" type="text/css" href="<%=basePath%>jshop/admin/resources/css/reset.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>jshop/admin/resources/css/style.css" media="screen" />
		<link id="color" rel="stylesheet" type="text/css" href="<%=basePath%>jshop/admin/resources/css/colors/blue.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>jshop/admin/js/flexigrid/css/flexigrid/flexigrid_gray.css" />
		<link rel="stylesheet" href="<%=basePath%>jshop/admin/js/jquery.alerts/jquery.alerts.css" type="text/css" media="screen" />
		<!-- scripts (jquery) -->
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/jquery-1.6.2.min.js"></script>
		<!--[if IE]><script language="javascript" type="text/javascript" src="<%=basePath%>jshop/admin/resources/scripts/excanvas.min.js"></script><![endif]-->
		<script src="<%=basePath%>jshop/admin/resources/scripts/jquery-ui-1.8.custom.min.js" type="text/javascript"></script>
		<script src="<%=basePath%>jshop/admin/resources/scripts/jquery.ui.selectmenu.js" type="text/javascript"></script>
		<script src="<%=basePath%>jshop/admin/resources/scripts/jquery.flot.min.js" type="text/javascript"></script>
		<script src="<%=basePath%>jshop/admin/resources/scripts/tiny_mce/tiny_mce.js" type="text/javascript"></script>
		<script src="<%=basePath%>jshop/admin/resources/scripts/tiny_mce/jquery.tinymce.js" type="text/javascript"></script>
		<!-- scripts (custom) -->
		<script src="<%=basePath%>jshop/admin/resources/scripts/smooth.js" type="text/javascript"></script>
		<script src="<%=basePath%>jshop/admin/resources/scripts/smooth.menu.js" type="text/javascript"></script>
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/jquery.alerts/jquery.alerts.js"></script>
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/kindeditor-min.js"></script>
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/flexigrid/flexigrid.js"></script>
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/jqueryplugin/jquery.query.js"></script>
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/taobao/tbtraderdatamanagementjs.js"></script>
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/highcharts/js/highcharts.js"></script>
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/highcharts/js/modules/exporting.js"></script>


	</head>

	<body>





		<!-- header 包含头部导航-->
		<%@include file="/jshop/admin/header.jsp"%>
		<!-- end header -->
		<!-- content -->
		<div id="content">
			<!-- end content / left -->
			<%@include file="/jshop/admin/left.jsp"%>
			<!-- end content / left -->
			<!-- content / right -->
			<div id="right">
				<!-- table -->
				<div class="box">
					<!-- box / title -->
					<div class="title">
						<h5>
							180内用户评论列表
						</h5>
					</div>
					<!-- flexigrid -->
					<div class="table">
						<div id="container" style="width: 98%; margin-left: 15px;">

						</div>
					</div>
					<!-- end box / title -->
					<div class="table">
						<!-- flexigrid -->
						<div id="flextbonsaleitemsmanagement" style="width: 98%; margin-left: 15px;">
							<table id="tbonsaleitemsmanagement" style="display: none;"></table>
						</div>

					</div>
				</div>
				<!-- end table -->


			</div>
			<!-- end content / right -->
		</div>
		<!-- end content -->
		<!-- footer -->
		<%@include file="/jshop/admin/footer.jsp"%>
		<!-- end footert -->
	</body>
</html>
<%!private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}%>