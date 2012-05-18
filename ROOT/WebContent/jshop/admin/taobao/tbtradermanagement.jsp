<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content") != null ? request.getParameter("content") : "";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>评论用户营销</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=basePath%>jshop/admin/themes/default/easyui.css" type="text/css" rel="stylesheet" />
    <link href="<%=basePath%>jshop/admin/css/form.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>jshop/admin/js/flexigrid/css/flexigrid/flexigrid_blue.css"/>
    <link rel="stylesheet" href="<%=basePath%>jshop/admin/js/jquery.alerts/jquery.alerts.css" type="text/css" media="screen" />
	<script type="text/javascript" src="<%=basePath%>jshop/admin/js/jquery-1.6.2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jshop/admin/js/jquery.alerts/jquery.alerts.js"></script>
    <script type="text/javascript" src="<%=basePath %>jshop/admin/js/jquery1.4.2.js"></script>
    <script type="text/javascript" src="<%=basePath %>jshop/admin/js/jquery.tools.min.js"></script>
   	<script type="text/javascript" src="<%=basePath %>jshop/admin/js/kindeditor-min.js"></script>
    <script type="text/javascript" src="<%=basePath %>jshop/admin/js/flexigrid/flexigrid.js"></script>
    <script type="text/javascript" src="<%=basePath%>jshop/admin/js/jqueryplugin/jquery.query.js"></script>
   	<script type="text/javascript" src="<%=basePath %>jshop/admin/js/taobao/tbtradermanagementjs.js"></script>
 
 	<style type="text/css">
		td{font-size:9pt;line-height:120%;color:#353535} 
		body{font-size:9pt;line-height:120%} 
    </style>
  </head>
  
  <body>
      <table width="98%" border="0" cellpadding="1" cellspacing="1" align="center">
 		<tr> 
   			<td class="panel-header">单个上线商品评价列表</td>
  		</tr>
   	  </table>
   	  
   	    <!-- flexigrid -->
	  <div id="flextbonsaleitemsmanagement" style="width:98%;margin-left:15px;">
        <table id="tbonsaleitemsmanagement" style="display:none;" ></table>
	  </div>

 	 
	  <table width="98%" border="0" align="center" cellpadding="0" cellspacing="1">
  		<tr> 
    		<td class="panel-header">操作注意事项及说明</td>
  		</tr>
  		<tr> 
    		<td bgcolor="#FFFFFF"> 
			<table width="80%" border="0" align="center" cellpadding="5" cellspacing="0">
        		<tr> 
          		<td height="20"><font color="#FF6600">·通过评论过你商品的用户来进行邮件营销。<br></font></td>
        		</tr>
      		</table>
      		</td>
  		</tr>
	  </table>
  </body>
</html>
<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>