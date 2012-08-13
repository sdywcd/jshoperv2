<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>页面管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=basePath%>jshop/admin/themes/default/easyui.css" type="text/css" rel="stylesheet" />
	<link href="<%=basePath%>jshop/admin/css/form.css" type="text/css" rel="stylesheet" />
	
	<link rel="stylesheet" type="text/css" href="<%=basePath %>jshop/admin/js/flexigrid/css/flexigrid/flexigrid_blue.css"/>
    <link rel="stylesheet"
			href="<%=basePath%>jshop/admin/js/jquery.alerts/jquery.alerts.css"
			type="text/css" media="screen" />
		<script type="text/javascript"
			src="<%=basePath%>jshop/admin/js/jquery-1.6.2.min.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>jshop/admin/js/jquery.alerts/jquery.alerts.js"></script>
		
    <script type="text/javascript" src="<%=basePath %>jshop/admin/js/jquery1.4.2.js"></script>
    <script type="text/javascript" src="<%=basePath %>jshop/admin/js/flexigrid/flexigrid.js"></script>
   	<script type="text/javascript" src="<%=basePath %>jshop/admin/js/pagesmanagementjs.js"></script>
 
 	<style type="text/css">
		td{font-size:9pt;line-height:120%;color:#353535} 
		body{font-size:9pt;line-height:120%} 
    </style>
  </head>
  
  <body>
      <table width="98%" border="0" cellpadding="1" cellspacing="1" align="center">
 		<tr> 
   			<td class="panel-header">页面管理</td>
  		</tr>
   	  </table>
   	  
   	    <!-- flexigrid -->
	  <div id="flexpagesmanagement" style="width:98%;margin-left:15px;">
        <table id="pagesmanagement" style="display:none;" ></table>
	  </div>
	  
   	  <!-- 编辑品牌区域 -->
 	  <table width="98%" border="0" cellpadding="1" cellspacing="1" align="center">
 		<tr> 
   			<td class="panel-header">增加/编辑新页面</td>
  		</tr>
   	  </table>
  	 <table  width="98%" border="0" cellpadding="1" cellspacing="1" align="center">
   	  
   	  <div id="goodsdiv" style="margin-left:12px; width:98%">
		<div class="css-panes skin2">
			<s:form action="addPaget" namespace="/jshop_system" method="post" theme="simple">
			<!-- 基础属性区 --> 
			<div class="notice">
      			<p>
         			<label>页面中文名称*</label>
         		   	<input id="pagename" name="pagename" type="text" size="30" maxlength="30"></input>
      			</p>
      			<p>
      				<label>页面英文名称*</label> 
         			<input id="pagenameen" name="pagenameen"  type="text" size="50" maxlength="40" ></input>
      			</p>
				<p>
					<label>页面地址*</label>
					<input id="url" name="url" type="text" size="100" maxlength="100" ></input>
				</p>
				<p>
					<label>页面范围</label>
					前台<input type="radio" id="rangearea" name="rangearea" value="1"/>
					后台<input type="radio" id="rangearea" name="rangearea" value="2"  checked="checked"/>
				</p>
				<p>
					<label>是否可自定义编辑*</label>
					<select id="canedit" name="canedit">
						<option value="1">可以</option>
						<option value="2">不可以</option>
					</select>
				</p>
				
      			<p>
      				<span id="errormsg"></span>
      				<s:property value="#request.errormsg"/> 
      			</p>
      			<p>
      			<input  type="submit" id="submit" name="submit" value="增加页面"/>
      			<s:hidden id="pageid" name="pageid" value=""></s:hidden>
      			 
      		
      			</p>
			</div> 
			</s:form>	
				<button id="editpage" name="editpage" style="margin-left:30px;display:none;">更新页面</button>
      			
		</div> 
 	 </div> 
 
 	 </table>
	
	  <table width="98%" border="0" align="center" cellpadding="0" cellspacing="1">
  		<tr> 
    		<td class="panel-header">操作注意事项及说明</td>
  		</tr>
  		<tr> 
    		<td bgcolor="#FFFFFF"> 
			<table width="80%" border="0" align="center" cellpadding="5" cellspacing="0">
        		<tr> 
          		<td height="20"><font color="#FF6600">·请注意分类名称不要含有非法字符。<br>
              ·增加一级分类后，些分类将会被列出前台一级分类中。<br>
              ·进行删除操作的同时，会删除此大类下包含的所有小分类和商品。</font></td>
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