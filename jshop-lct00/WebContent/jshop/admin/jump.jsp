<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>">
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/jquery-1.6.2.min.js"></script>
		<title>jump</title>
	</head>
	<script type="text/javascript">
	$(document).ready(function() {
		var pathnamearray=window.location.pathname.split("/");
		var pathname=pathnamearray[1]+"/";
		if(pathname=="jshop/"){
			pathname="";
		}
		top.location.href="http://"+window.location.host+"/"+pathname+"jshop/admin/adminlogin.jsp";
	})
</script>
	<body>
		<div id="hidjumptologin">
			正在跳转请稍后...
		</div>
		
	</body>
</html>
