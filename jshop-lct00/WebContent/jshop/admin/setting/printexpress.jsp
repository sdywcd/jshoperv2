<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>打印快递单</title>

	<link href="<%=basePath%>jshop/admin/themes/default/easyui.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>jshop/admin/js/flexigrid/css/flexigrid/flexigrid_blue.css"/>
   <link rel="stylesheet"
			href="<%=basePath%>jshop/admin/js/jquery.alerts/jquery.alerts.css"
			type="text/css" media="screen" />
		<script type="text/javascript"
			src="<%=basePath%>jshop/admin/js/jquery-1.6.2.min.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>jshop/admin/js/jquery.alerts/jquery.alerts.js"></script>
		
    <script type="text/javascript" src="<%=basePath %>jshop/admin/js/jquery1.4.2.js"></script>
    <script type="text/javascript" src="<%=basePath %>jshop/admin/js/jqueryplugin/jquery.query.js"></script>
    <script type="text/javascript" src="<%=basePath %>jshop/admin/js/printexpressjs.js"></script>
	<style type="text/css">
		td{font-size:9pt;line-height:120%;color:#353535} 
		body{font-size:9pt;line-height:120%} 
    </style>
  </head>
  
  <body>
	   
	     
   	 
	 
  </body>
</html>
