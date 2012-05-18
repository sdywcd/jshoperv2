<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getParameter("detail") != null ? request.getParameter("detail") : "";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>增加链接</title>
	
		<style type="text/css">
#triggers img {
	cursor: pointer;
	margin: 0 5px;
	background-color: #fff;
	border: 1px solid #ccc;
	padding: 2px;
	width: 200px;
	height: 150px;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
}
</style>
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
							增加新连接
						</h5>
					</div>
					<div class="form">
						<div class="fields">
							<div class="field">
								<div class="label">
									<label for="input-small">
										链接名称:
									</label>
								</div>
								<div class="input">
									<input id="linkName" name="linkName" type="text" class="small"></input>
								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										链接地址:
									</label>
								</div>
								<div class="input">
									<input id="linkUrl" name="linkUrl" type="text" class="small"
									reg="^(http|https|ftp)\://[a-zA-Z0-9\-\.]+\.[a-zA-Z]{2,3}(:[a-zA-Z0-9]*)?/?([a-zA-Z0-9\-\._\?\,\'/\\\+&%\$#\=~])*$" tip="URl格式，允许FTP,HTTP,HTTPS"></input>
								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										排序：
									</label>
								</div>
								<div class="input">
									<input id="sort" name="sort" type="text" class="small"></input>
								</div>

							</div>		
							<div class="field">
								<div class="label">
									<label for="file">
										logo图片:
									</label>
								</div>
								<div class="input input-file">
									<button id="delpc" name="delpc">
										删除图片
									</button>
									<div id="file-uploader-demo1">
										<noscript>
											<p>
												Please enable JavaScript to use file uploader.
											</p>
											<!-- or put a simple form for upload here -->
										</noscript>
									</div>
									<!-- trigger elements -->
									<div id="triggers">
									</div>
								</div>
							</div>
						</div>


					</div>

					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="input">
									<div class="button highlight">
										<input type="button" id="submit" name="submit" value="完成并增加链接"></input>
										<input type="button" id="update" name="update" value="完成并修改链接" style="display:none; "></input>
										<input type="hidden" id="friendlinkid" name="friendlinkid" />
									</div>
								</div>
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
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/friendlinkmanagementjs.js"></script>
	
		<script type="text/javascript">
 		 function createUploader(){            
             var uploader = new qq.FileUploader({
                 element: document.getElementById('file-uploader-demo1'),
                 action: '<%=basePath%>ajaxFileUploads.action;jsessionid=<%=session.getId()%>',
                 debug: true,
                 minSizeLimit:1024,
                 sizeLimit: 1073741824,
                 allowedExtensions: ['jpeg','jpg','gif','png'],
                 onComplete: function(id, fileName, responseJSON){
                	var pcpath="<%=basePath%>"+responseJSON.success;
  					var htm="<img id='"+id+"' src='"+pcpath+"' rel='#"+fileName+"'/>";
  					var checkpc="<input id='"+id+"' name='pcpath' type='checkbox' value='"+pcpath+"' checked='true'/> "
  					$("#triggers").append(htm).append(checkpc);
                 },
               
             });           
         }
 		window.onload = createUploader; 
 	</script>

		<script type="text/javascript">
 		KE.show({
			id : 'detail',
		    imageUploadJson : '<%=basePath%>jshop/admin/js/jsp/upload_json.jsp',
			fileManagerJson : '<%=basePath%>jshop/admin/js/jsp/file_manager_json.jsp',
			allowFileManager : true,
			afterCreate : function(id) {
				KE.event.ctrl(document, 13, function() {
					KE.util.setData(id);
				});
			}
		});
 		
 	</script>
	</body>

</html>
<%!private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}%>