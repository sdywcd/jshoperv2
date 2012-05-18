<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		
		<title>权限信息错误</title>
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/jquery-1.6.2.min.js"></script>
	</head>
	<script type="text/javascript">
		function a(){
			alert("1");
		}
	</script>
	<body>
		<div id="authorityfail">
			对不起你没有操作此项的权利
			<script type="text/javascript">
			window.location="1.jsp";
			</script>
		</div>
	
	</body>
</html>
