<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("detail") != null ? request.getParameter("detail") : "";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    
    <title>发送活动邮件</title>
    
	
   	
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
							发送活动邮件
						</h5>
					</div>
					
					<form id="form"   method="post">
						<div class="form">
							<div class="fields">
								<div class="field field-first">
									<div class="label">
										<label for="input-small">
											发件人邮箱：
										</label>
									</div>
									<div class="input">
										<input id="sysSendmail" name="sysSendmail" type="text" value="" class="small" readonly="readonly" />

									</div>
								</div>
								<div class="field">
								<div class="label label-textarea">
									<label for="textarea">
										邮件内容:
									</label>
								</div>
								<div style="margin:0 0 0 200px;">
									<textarea id="detail" name="detail" cols="50" rows="12" style="width:100%;height:600px;visibility:hidden;"><%=htmlspecialchars(htmlData)%></textarea>
								</div>
							</div>
								<div class="buttons">

									<div class="highlight">
										<input  type="button" id="submitactivity" name="submitactivity" value="发送"/>
									</div>
								</div>
								
							</div>
						</div>

					</form>
				</div>
				<!-- end table -->



			</div>
			<!-- end content / right -->
		</div>
		<!-- end content -->
		<!-- footer -->
		<%@include file="/jshop/admin/footer.jsp"%>
		<!-- end footert -->
<script type="text/javascript" src="<%=basePath %>jshop/admin/js/systememailmanagementjs.js"></script>
  
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
<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>
