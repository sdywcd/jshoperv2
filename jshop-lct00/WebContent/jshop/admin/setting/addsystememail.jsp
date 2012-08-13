<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html  xmlns="http://www.w3.org/1999/xhtml">
  <head>
    
    <title>邮箱设置</title>
    
  
   
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
							系统邮箱及修改
						</h5>
					</div>
					
					
						<div class="form">
							<div class="fields">
								<div class="field field-first">
									<div class="label">
										<label for="input-small">
											发件人邮箱：
										</label>
									</div>
									<div class="input">
										<input id="sysSendmail" name="sysSendmail" type="text"  class="small"  />

									</div>
								</div>
								<div class="field ">
									<div class="label">
										<label for="input-small">
											SMTP服务器地址:
										</label>
									</div>
									<div class="input">
										<input id="sysMailSmtp" name="sysMailSmtp" type="text"  class="small" />

									</div>
								</div>
								<div class="field ">
									<div class="label">
										<label for="input-small">
											SMTP服务器端口:
										</label>
									</div>
									<div class="input">
										<input id="sysMailPort" name="sysMailPort" type="text"  class="small"  />

									</div>
								</div>
								<div class="field ">
									<div class="label">
										<label for="input-small">
											SMTP用户名：
										</label>
									</div>
									<div class="input">
										<input id="smtpusername" name="smtpusername" type="text"  class="small" />

									</div>
								</div>
								<div class="field ">
									<div class="label">
										<label for="input-small">
											SMTP密码：
										</label>
									</div>
									<div class="input">
										<input id="smtppwd" name="smtppwd" type="password"  class="small"  />

									</div>
								</div>
								
								<div class="buttons">

									<div class="highlight">
										<input  type="button" id="submit" name="submit" value="提交"/>
      									<input type="button" id="back" name="back" value="返回"/>
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
  	<script type="text/javascript" src="<%=basePath %>jshop/admin/js/systememailmanagementjs.js"></script>
  
  </body>
</html>