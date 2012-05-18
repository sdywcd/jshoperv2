<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>


		<title>增加/编辑模板主题</title>
	</head>

	<body>
		<!-- 编辑会员区域 -->
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
							增加/编辑模板主题
						</h5>
					</div>
					
						<div class="form">
							<div class="fields">
								<div class="field field-first">
									<div class="label">
										<label for="input-small">
											主题名称:
										</label>
									</div>
									<div class="input">
										<input id="themename" name="themename" type="text" value="" class="small" reg="^[A-Za-z0-9]+$" tip="主题名称只能由数字和字母组成"/>
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											说明:
										</label>
									</div>
									<div class="input">
										<input id="note" name="note" type="text" value="" class="small" />
									</div>
								</div>

								<div class="field">
									<div class="label">
										<label for="input-small">
											标示:
										</label>
									</div>
									<div class="input">
										<input id="sign" name="sign" type="text" value="" class="small" reg="^[A-Za-z0-9]+$" tip="标示只能由数字和字母组成"/>
									</div>
								</div>
								
								<div class="field">
									<div class="label label-checkbox">
										<label>
											是否启用:
										</label>
									</div>
									<div class="checkboxes">
										<input id="status" name="status" type="checkbox" checked="checked"/>
											<label>
												是
											</label>
									</div>
								</div>
							
							</div>
						</div>
						<div class="form">
							<div class="fields">
								<div class="field field-first">
									<div class="input">
										<div class="button highlight">
											<input type="hidden" id="ttid" name="ttid" value="" />
											<input type="submit" id="submit" name="submit" value="提交" />
											<input type="button" id="modify" name="modify" value="更新" style="display: none;" />
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
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/templatethememanagementjs.js"></script>


	</body>
</html>
