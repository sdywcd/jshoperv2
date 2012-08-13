<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>邮箱设置</title>

	
	

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

					<div class="title">
						<h5>
							邮件设置
						</h5>
					</div>
					<form id="form" action="addSystemMail.action" method="post">
						<div class="form">
							<div class="fields">
								<div class="field field-first">
									<div class="label">
										<label for="input-small">
											发件人邮箱：
										</label>
									</div>
									<div class="input">
										<input id="sysSendmail" name="sysSendmail" type="text" value="" class="small" />

									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											SMTP服务器地址：
										</label>
									</div>
									<div class="input">
										<input type="text" id="sysMailSmtp" name="sysMailSmtp" class="small" />
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											SMTP服务器端口：
										</label>
									</div>
									<div class="input">
										<input type="text" id="sysMailPort" name="sysMailPort" class="small" />
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											SMTP用户名：
										</label>
									</div>
									<div class="input">
										<input type="text" id="smtpusername" name="smtpusername" class="small" />
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											SMTP密码：
										</label>
									</div>
									<div class="input">
										<input type="text" id="smtppwd" name="smtppwd" class="small" />
									</div>
								</div>

								<div class="buttons">

									<div class="highlight">
										<input id="userid" name="userid" value="" type="hidden" />
										<input type="submit" id="submit" name="submit" value="提交" />
										
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
			<script type="text/javascript" src="<%=basePath%>jshop/admin/js/jshopsysmailsetjs.js"></script>
		
	</body>
</html>