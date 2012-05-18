<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("invoiceCode") != null ? request.getParameter("invoiceCode") : "";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>发货单模板设定</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
    <script type="text/javascript" src="<%=basePath %>jshop/admin/js/kindeditor-min.js"></script>
    <script type="text/javascript" src="<%=basePath %>jshop/admin/js/flexigrid/flexigrid.js"></script>
	<script type="text/javascript" src="<%=basePath %>jshop/admin/js/invoicetempletesetjs.js"></script>
	<style type="text/css">
		td{font-size:9pt;line-height:120%;color:#353535} 
		body{font-size:9pt;line-height:120%}
		
    </style>
    <script type="text/javascript">
 		KE.show({
			id : 'invoiceCode',
			imageUploadJson : '<%=basePath%>jshop/admin/js/jsp/upload_json.jsp',
			fileManagerJson : '<%=basePath%>jshop/admin/js/jsp/file_manager_json.jsp',
			allowFileManager : true,
			wyswygMode : true,
			afterCreate : function(id) {
				KE.event.ctrl(document, 13, function() {
					KE.util.setData(id);
				});
			}
		});
 		
 	</script>
  </head>
  
  <body>
	   <table width="98%" border="0" cellpadding="1" cellspacing="1" align="center">
	 		<tr> 
	   			<td class="panel-header">发货单模板设定</td>
	  		</tr>
	   </table>
	   <s:form action="addInvoiceTemplete" namespace="/jshop_system" method="post" theme="simple">
	   <table width="98%" border="0" cellpadding="1" cellspacing="1" align="center">
	 		<tr> 
	 			
	   			<td class="panel-header">

	   				<input id="submit" name="submit" type="submit" value="提交"/>
	   			</td>
	  		</tr>
	  	
	   </table>  
	   <div id="movediv">
	   		
	   </div>
   	
   	 
	  <div id="invoicetempletesetarea" style="width:98%;margin-left:15px;">
       
		<textarea id=invoiceCode name="invoiceCode" cols="100" rows="8" style="width:100%;height:700px;visibility:hidden;"><%=htmlspecialchars(htmlData)%></textarea>
       
	  </div>
	 </s:form>
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