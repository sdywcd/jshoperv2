<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>快递单模板设置</title>

		
		
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
					<div class="title">
						<h5>
							快递单模板设置
						</h5>
					</div>
					<div class="table">
						<!-- flexigrid -->
						<div id="flexexpresstempletemanagement" style="width: 98%; margin-left: 15px;">
							<table id="expresstempletemanagement" style="display: none;"></table>
						</div>
					</div>
					<!-- box / title -->

				</div>
				<!-- end table -->
			</div>
			<!-- end content / right -->
		</div>
		<!-- end content -->
		<!-- footer -->
		<%@include file="/jshop/admin/footer.jsp"%>
		<!-- end footert -->
<script type="text/javascript" src="<%=basePath%>jshop/admin/js/expresstempletemanagementjs.js"></script>




	</body>
</html>
