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
    
    <title>抵用券管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=basePath%>jshop/admin/themes/default/easyui.css" type="text/css" rel="stylesheet" />
	<link href="<%=basePath%>jshop/admin/css/form.css" type="text/css" rel="stylesheet" />
	<link href="<%=basePath%>jshop/admin/css/datalarge.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>jshop/admin/js/flexigrid/css/flexigrid/flexigrid_blue.css"/>
     <link rel="stylesheet"  href="<%=basePath%>jshop/admin/js/jquery.alerts/jquery.alerts.css" type="text/css" media="screen" />
    <script type="text/javascript" src="<%=basePath %>jshop/admin/js/jquery-1.6.2.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>jshop/admin/js/jquery.alerts/jquery.alerts.js"></script>
    <script type="text/javascript" src="<%=basePath %>jshop/admin/js/jquery.tools.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>jshop/admin/js/flexigrid/flexigrid.js"></script>
   	<script type="text/javascript" src="<%=basePath %>jshop/admin/js/vouchersmanagementjs.js"></script>
 	<style type="text/css">
		td{font-size:9pt;line-height:120%;color:#353535} 
		body{font-size:9pt;line-height:120%} 
    </style>
   
  </head>
  
  <body>
    <table width="98%" border="0" cellpadding="1" cellspacing="1" align="center">
 		<tr> 
   			<td class="panel-header">抵用券管理</td>
  		</tr>
   	  </table>
   	    <!-- flexigrid -->
	  <div id="flexvouchersmanagement" style="width:98%;margin-left:15px;">
        <table id="vouchersmanagement" style="display:none;" ></table>
	  </div>
      <table width="98%" border="0" cellpadding="1" cellspacing="1" align="center">
 		<tr> 
   			<td class="panel-header">可选商品</td>
  		</tr>
   	  </table>
   	  <!-- flexigrid -->
	  <div id="flexgoodsmanagement" style="width:98%;margin-left:15px;">
        <table id="goodsmanagement" style="display:none;" ></table>
	  </div>
	 
	  
   	  <!-- 编辑品牌区域 -->
 	  <table width="98%" border="0" cellpadding="1" cellspacing="1" align="center">
 		<tr> 
   			<td class="panel-header">增加/编辑抵用券</td>
  		</tr>
   	  </table>
  	 <table  width="98%" border="0" cellpadding="1" cellspacing="1" align="center">
   	  <div id="goodsdiv" style="margin-left:12px; width:98%">
		<div class="css-panes skin2">
			<!-- 基础属性区 --> 
			<div class="notice" style="visible=false">
				<p>
					<label>抵扣内容类型*</label>
					<select id="contentstate" name="contentstate">
						<option value="0" selected>商品</option>
						<option value="1">金额</option>
					</select>
				</p>
      			<p>
         			<label>抵用券/优惠券编码*</label>
         		  	<input id="vouchersname" name="vouchersname" type="text" size="40" maxlength="40"/>
         		  	<button id="refresh" name="refresh">刷新编码</button>
      			</p>
      			<p>
      				<label id="voucherscontentlabel" style="display:none;">抵用券内容（金额或者商品编号）</label>
      				<input id="voucherscontent" name="voucherscontent" type="text" size="10" maxlength="10" style="display:none;"/>
      			</p>
      			<p>
      				<label>使用金额上限*</label> 
         			<input id="limitprice" name="limitprice"  type="text" size="10" maxlength="10" ></input>
      			</p>
				<p>
					<label>抵用券种类*</label>
					<select  name="voucheruseway" id="voucheruseway">
						<option value="1">赠送</option>
						<option value="0" selected>绑定</option>
					</select>
				</p>
				<p>
					<label>开始时间*</label>
					<input type="date" name="begintime" id="begintime"/>
				</p>
				<p>
					<label>结束时间*</label>
					<input type="date" name="endtime" id="endtime"/>
				</p>
				 <script>
					$(":date").dateinput();
				</script>
    
      			<p style="margin-left:35px;">
      			<button id="addvouchers" name="addvouchers" >增加抵用券</button>
      			
      				<span id="errormsg"></span>
      				<s:property value="#request.errormsg"/> 
      			</p>
      			
			</div> 
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