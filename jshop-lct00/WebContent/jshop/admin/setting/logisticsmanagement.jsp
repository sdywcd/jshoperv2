<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>物流及配送设置</title>
		

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
							物流及配送设置
						</h5>
					</div>
					<div class="table">
						<!-- flexigrid -->
						<div id="flexlogisticsmanagement" style="width: 98%; margin-left: 15px;">
							<table id="logisticsmanagement" style="display: none;"></table>
						</div>
					</div>
					<!-- box / title -->
					<div class="title">
						<h5>
							增加/编辑物流商
						</h5>

					</div>
					<form action="addLogisticsBusiness.action" method="post">
						<div class="form">
							<div class="fields">
								<div class="field field-first">
									<div class="label">
										<label for="input-small">
											物流商名称:
										</label>
									</div>
									<div class="input">
										<input type="text" id="logisticsname" name="logisticsname" class="small" />

									</div>

								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											城市:
										</label>
									</div>
									<div class="input">
										<input type="text" id="city" name="city" class="small" />

									</div>

								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											联系人:
										</label>
									</div>
									<div class="input">
										<input type="text" id="contractor" name="contractor" class="small" />

									</div>

								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											座机:
										</label>
									</div>
									<div class="input">
										<input type="text" id="telno" name="telno" class="small" />

									</div>

								</div>

								<div class="field">
									<div class="label">
										<label for="input-small">
											传真:
										</label>
									</div>
									<div class="input">
										<input type="text" id="faxno" name="faxno" class="small" />

									</div>

								</div>

								<div class="field">
									<div class="label">
										<label for="input-small">
											邮箱:
										</label>
									</div>
									<div class="input">
										<input type="text" id="email" name="email" class="small" />

									</div>

								</div>
								<div class="field">
									<div class="label">
										<label for="input-medium">
											地址:
										</label>
									</div>
									<div class="input">
										<input type="text" id="address" name="address" class="medium" />

									</div>

								</div>
								<div class="field">
									<div class="label">
										<label for="input-medium">
											网址:
										</label>
									</div>
									<div class="input">
										<input type="text" id="website" name="website" class="medium" reg="^(http|https|ftp)\://[a-zA-Z0-9\-\.]+\.[a-zA-Z]{2,3}(:[a-zA-Z0-9]*)?/?([a-zA-Z0-9\-\._\?\,\'/\\\+&%\$#\=~])*$" tip="URl格式，允许FTP,HTTP,HTTPS" />
									</div>
								</div>

								<div class="field">
									<div class="label">
										<label for="input-small">
											收款人:
										</label>
									</div>
									<div class="input">
										<input type="text" id="receiver" name="receiver" class="small" />

									</div>

								</div>

								<div class="field">
									<div class="label">
										<label for="input-small">
											银行账号:
										</label>
									</div>
									<div class="input">
										<input type="text" id="bankaccount" name="bankaccount" class="small" />

									</div>

								</div>

								<div class="field">
									<div class="label">
										<label for="input-small">
											所属银行:
										</label>
									</div>
									<div class="input">
										<input type="text" id="bankaddress" name="bankaddress" class="small" />
									</div>
								</div>


								<div class="field">
									<div class="label">
										<label for="select">
											是否支持保价：
										</label>
									</div>
									<div class="select">
										<select id="insure" name="insure">
											<option value="1">
												支持
											</option>
											<option value="0">
												不支持
											</option>
										</select>
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="select">
											是否支持货到付款：
										</label>
									</div>
									<div class="select">
										<select id="isCod" name="isCod">
											<option value="1">
												支持
											</option>
											<option value="0">
												不支持
											</option>
										</select>
									</div>
								</div>


								<div class="field">
									<div class="label">
										<label for="select">
											使用范围：
										</label>
									</div>
									<div class="select">
										<select id="state" name="state">
											<option value="1">
												用户可见（前台可见）
											</option>
											<option value="2">
												物流商可见（后台可见）
											</option>
										</select>
									</div>
								</div>


								<div class="field">
									<div class="label">
										<label for="select">
											是否默认显示：
										</label>
									</div>
									<div class="select">
										<select id="visible" name="visible">
											<option value="1">
												是
											</option>
											<option value="0">
												否
											</option>
										</select>
									</div>
								</div>

								<div class="field">
									<div class="label">
										<label for="input-medium">
											描述：
										</label>
									</div>
									<div class="input">
										<input type="text" id="des" name="des" class="medium" />
									</div>
								</div>
								<div class="form">
									<div class="fields">
										<div class="field field-first">
											<div class="input">
												<div class="button highlight">
													<input type="submit" id="submit" name="submit" value="增加物流商" />
													<input id="editlogistics" name="editlogistics" value="更新物流商" style="display: none;"></input>
													<input type="hidden" id="logisticsid" name="logisticsid" value=""></input>
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
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/logisticsmanagementjs.js"></script>





	</body>
</html>