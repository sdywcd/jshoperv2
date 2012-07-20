<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Complex Layout - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jshop/admin/js/jquery-easyui-1.2.6/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jshop/admin/js/jquery-easyui-1.2.6/themes/icon.css"/>
	<script type="text/javascript" src="<%=basePath%>jshop/admin/js/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jshop/admin/js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
	<script>
		$(function(){
			$('#tt2').datagrid({
				title:'My Title',
				iconCls:'icon-save',
				width:600,
				height:350,
				nowrap: false,
				striped: true,
				fit: true,
				url:'<%=basePath%>jshop/admin/js/jquery-easyui-1.2.6/demo/datagrid_data.json',
				sortName: 'code',
				sortOrder: 'desc',
				idField:'code',
				frozenColumns:[[
	                {field:'ck',checkbox:true},
	                {title:'code',field:'code',width:80,sortable:true}
				]],
				columns:[[
			        {title:'Base Information',colspan:3},
					{field:'opt',title:'Operation',width:100,align:'center', rowspan:2,
						formatter:function(value,rec){
							return '<span style="color:red">Edit Delete</span>';
						}
					}
				],[
					{field:'name',title:'Name',width:120},
					{field:'addr',title:'Address',width:120,rowspan:2,sortable:true},
					{field:'col4',title:'Col41',width:150,rowspan:2}
				]],
				pagination:true,
				rownumbers:true
			});
		});
	</script>
</head>
<body class="easyui-layout">
	<div region="north" title="" split="true" style="height:100px;padding:10px;">
		<h1>欧斯塔克网络商城管理系统</h1>
	</div>
	<div region="south" title="South Title" split="true" style="height:100px;padding:10px;background:#efefef;">
		
	</div>
	
	<div region="west" split="true" title="West Menu" style="width:280px;padding1:1px;overflow:hidden;">
		<div class="easyui-accordion" fit="true" border="false">
			<div title="Title1" selected="true" style="padding:10px;overflow:auto;">
				<p>content1</p>
				<p>content1</p>
				<p>content1</p>
				<p>content1</p>
				<p>content1</p>
				<p>content1</p>
				<p>content1</p>
				<p>content12</p>
			</div>
			<div title="Title2"  style="padding:10px;">
				content2
			</div>
			<div title="Title3" style="padding:10px">
				content3
			</div>
		</div>
	</div>
	<div region="center" title="Main Title" style="overflow:hidden;">
		<div class="easyui-tabs" fit="true" border="false">
			<div title="Tab1" style="padding:20px;overflow:hidden;"> 
				<div style="margin-top:20px;">
					<h3>jQuery EasyUI framework help you build your web page easily.</h3>
					<li>easyui is a collection of user-interface plugin based on jQuery.</li> 
					<li>using easyui you don't write many javascript code, instead you defines user-interface by writing some HTML markup.</li> 
					<li>easyui is very easy but powerful.</li> 
				</div>
			</div>
			<div title="Tab2" closable="true" style="padding:20px;">This is Tab2 width close button.</div>
			<div title="Tab3" iconCls="icon-reload" closable="true" style="overflow:hidden;padding:5px;">
				<table id="tt2"></table> 
			</div>
		</div>
	</div>
</body>
</html>