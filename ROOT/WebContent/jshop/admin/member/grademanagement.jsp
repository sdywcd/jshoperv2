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

		<title>会员等级管理</title>

	

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
							会员等级管理
						</h5>
					</div>
					<!-- end box / title -->
					<div class="table">
						<!-- flexigrid -->
						<div id="flexgrademanagement" style="width: 98%; margin-left: 15px;">
							<table id="grademanagement" style="display: none;"></table>
						</div>

					</div>
					<div class="title">
						<h5>
							增加/编辑会员等级
						</h5>
					</div>
					<form id="form" action="addGradet.action" method="post">
						<div class="form">
							<div class="fields">

								<div class="field field-first">
									<div class="label">
										<label for="select">
											选择会员类型：
										</label>
									</div>
									<div class="select">
										<select id="gradevalue" name="gradevalue">
											<option value="0">
												--请选择--
											</option>
											<option value="1">
												普通会员
											</option>
											<option value="2">
												银卡会员
											</option>
											<option value="3">
												金卡会员
											</option>
											<option value="4">
												钻石会员
											</option>
											<option value="5">
												至尊会员
											</option>
										</select>
									</div>
								</div>

								<div class="field">
									<div class="label">
										<label for="input-small">
											升级所需金额：
										</label>
									</div>
									<div class="input">
										<input id="needcost" name="needcost" type="text" class="small"></input>
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											折扣：
										</label>
									</div>
									<div class="input">
										<input id="discount" name="discount" type="text" class="small"></input>
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="input-small"></label>
									</div>
									<div class="input">
										<s:property value="#request.errormsg" />
									</div>
								</div>
								<div class="buttons">

									<div class="highlight">
										<input type="submit" id="submit" name="submit" value="增加会员等级" />
										<input style="display: none;" type="button" id="editgrade" name="editgrade" value="更新会员等级" />
										<s:hidden id="gradename" name="gradename" value=""></s:hidden>
										<input type="hidden" id="gradeid" name="gradeid" value="" />
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

		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/grademanagementjs.js"></script>





	</body>
</html>
