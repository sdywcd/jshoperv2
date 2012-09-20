<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getParameter("detail") != null ? request.getParameter("detail") : "";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <style>
	#place select{
		width:120px;
		margin-left:0px;
	}
  </style>
<title>Insert title here</title>
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
.abelinked{  
   display: block;  
   border: 1px solid #aaa;  
   text-decoration: none;  
   background-color: #fafafa;  
   color: #123456;  
   margin: 2px;  
   clear:both;  
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
							增加/编辑站内信
						</h5>

					</div>

					<div class="form">
						<div class="fields">
							
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										标题:
									</label>
								</div>
								<div class="input">
									<input type="text" id="title" name="title" class="small" />
									
								</div>
							</div>
							
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										收件人:
									</label>
								</div>
								<div class="input">
									<input type="text" id="msgtousername" name="msgtousername" class="small" />
									
								</div>
							</div>
							<div class="field ">
								<div class="label label-radio">
									<label for="input-small">
										内容状态:
									</label>
								</div>
								<div class="radios">
								<div class="radio">									
									<input type=radio id="msgstate" name="msgstate" class="small" value="1" />	
									<label>开启</label>
									<input type=radio id="msgstate" name="msgstate" class="small" checked="checked" value="0"/>	
									<label>关闭</label>
								</div>	
								</div>
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										内容:
									</label>
								</div>
								<div style="margin: 0 0 0 200px;">
									<div id="cssrefuse">
										<textarea id="text" name="text" cols="50" rows="12" style="width: 100%; height: 600px; visibility: hidden;"><%=htmlspecialchars(htmlData)%></textarea>
									</div>
								</div>
							</div>
							<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="input">
									<div class="button highlight">
										<input type="hidden" id="msgid" name="msgid" />
										<input type="button" id="add" name="add" value="提交"  />
										<input type="button" id="update" name="update" value="更新" style="display: none;" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
							
						</div>
					</div>	
				</div>
				<!-- end table -->
				
			<!-- end content / right -->
		</div>
		<!-- end content -->
		<!-- footer -->
		<script type="text/javascript" src="<%=basePath%>/jshop/admin/js/regme.js"></script>
		<script type="text/javascript" src="<%=basePath%>/jshop/admin/js/regme.js"></script>
	
		<%@include file="/jshop/admin/footer.jsp"%>
		<!-- end footert -->
	


		<script type="text/javascript">
 		KE.show({
			id : 'detail',
		    imageUploadJson : '<%=basePath%>/jshop/admin/js/jsp/upload_json.jsp',
			fileManagerJson : '<%=basePath%>/jshop/admin/js/jsp/file_manager_json.jsp',
			allowFileManager : true,
			afterCreate : function(id) {
				KE.event.ctrl(document, 13, function() {
					KE.util.setData(id);
				});
			}
		});
 		KE.show({
			id : 'commoditylist',
			items : ['fontname', 'fontsize', '|', 'textcolor', 'bgcolor', 'bold', 'italic', 'underline',
					'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist','insertunorderedlist']
		});
 		
 		 $().ready(function(){  
 		   $('#addbelinked').click(function() {  
 		    return !$('#select1 option:selected').remove().appendTo('#select2');  
 		   });
 		   $('#removebelinked').click(function() {  
 		    return !$('#select2 option:selected').remove().appendTo('#select1');  
 		   });  
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