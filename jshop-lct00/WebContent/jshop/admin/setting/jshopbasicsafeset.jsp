<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>安全设置</title>

		
		
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
							商城安全
						</h5>

					</div>
					<form action="UpdatesafeSet.action" method="post">
						<div class="form">
							<div class="fields">

								<div class="field">
									<div class="label">
										<label for="select">
											会员注册设置：
										</label>
									</div>
									<div class="select">
										<select id="isusercanregister" name="isusercanregister">
											<option value="1">
												开放注册
											</option>
											<option value="0">
												关闭注册
											</option>
										</select>
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="select">
											是否自动锁定用户：
										</label>
									</div>
									<div class="select">
										<select id="isautolockaccount" name="isautolockaccount">
											<option value="1">
												是
											</option>
											<option value="0">
												否
											</option>
										</select>
									</div>
								</div>
								<div id="maxloginnump" class="field">
									<div class="label">
										<label for="input-small">
											连续登录失败最大次数：
										</label>
									</div>
									<div class="input">
										<input type="text" id="maxloginnum" name="maxloginnum" class="small" />
									</div>
								</div>
								<div id="unlocktimep" class="field">
									<div class="label">
										<label for="input-small">
											自动解锁时间（小时）：
										</label>
									</div>
									<div class="input">
										<input type="text" id="unlocktime" name="unlocktime" class="small" />
									</div>
								</div>
								<div class="form">
									<div class="fields">
										<div class="field field-first">
											<div class="input">
												<div class="button highlight">
													<input type="submit" name="submit" value="提交" />
												</div>
											</div>
										</div>
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
<script type="text/javascript" src="<%=basePath%>jshop/admin/js/jshopbasicsafesetjs.js"></script>


	</body>
</html>