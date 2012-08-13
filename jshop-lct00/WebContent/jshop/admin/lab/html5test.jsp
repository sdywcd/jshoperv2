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
		<title>html5实验室</title>
		<!-- stylesheets -->
		<link rel="stylesheet" type="text/css" href="<%=basePath%>jshop/admin/resources/css/reset.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>jshop/admin/resources/css/style.css" media="screen" />
		<link id="color" rel="stylesheet" type="text/css" href="<%=basePath%>jshop/admin/resources/css/colors/blue.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>jshop/admin/js/flexigrid/css/flexigrid/flexigrid_gray.css" />
		<link href="<%=basePath%>jshop/admin/js/uploader/fileuploader.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="<%=basePath%>jshop/admin/js/jquery.alerts/jquery.alerts.css" type="text/css" media="screen" />
		<link href="<%=basePath%>jshop/admin/js/easyvalidator/css/validate.css" rel="stylesheet" type="text/css" />
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
		<script src="<%=basePath%>jshop/admin/resources/scripts/smooth.table.js" type="text/javascript"></script>
		<script src="<%=basePath%>jshop/admin/resources/scripts/smooth.form.js" type="text/javascript"></script>
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/easyvalidator/js/easy_validator.pack.js"></script>
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/easyvalidator/js/jquery.bgiframe.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/jquery.alerts/jquery.alerts.js"></script>
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/kindeditor-min.js"></script>
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/flexigrid/flexigrid.js"></script>
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/jqueryplugin/jquery.query.js"></script>
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/uploader/fileuploader.js"></script>
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/lab/html5testjs.js"></script>
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
							html5FileReader接口实现
						</h5>

					</div>

					<div class="form">
						<div class="fields">
							<div class="field field-first">

								<div class="label">
									<label for="file">
										请选择一个文件:
									</label>
								</div>
								<div class="input input-file">
									<input type="file" id="file" name="file" size="40" />
								</div>

							</div>

							<div class="field">
								<div class="label label-textarea">
									<label for="textarea">

									</label>
								</div>
								<div id="readfileresult" name="readfileresult" style="margin: 0 0 0 200px;">

								</div>
							</div>
						</div>
					</div>

					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="input">
									<div class="button highlight">
										<input type="button" id="readpicture" name="readpicture" value="读取图片" />
										<input type="button" id="read2dll" name="read2dll" value="读取二进制数据" />
										<input type="button" id="readtext" name="readtext" value="读取文本文件" />
										<input type="button" id="readhtml" name="readhtml" value="读取网页文件" />
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="title">
						<h5>
							拖放实现
						</h5>

					</div>
					<div class="form">
						<div class="fields">
							<div class="field field-first">

								<div class="label">
									<label for="file">
										<div >尝试拖动</div>
									</label>
								</div>
								<div id="dragme" draggable="true" class="input input-file">
									请拖动我
								</div>

							</div>

							<div class="field">
								<div class="label label-textarea">
									<label for="textarea">
										
									</label>
								</div>
								<div id="dragmetext" name="dragmetext" style="height:200px;width:200px;margin: 0 0 0 200px;border:solid 1px #dfdfdf">
										
								</div>
							</div>
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