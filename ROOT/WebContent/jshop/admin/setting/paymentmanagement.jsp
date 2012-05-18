<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>


		<title>支付方式设置</title>
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
							支付方式
						</h5>

					</div>
					<div class="table">
						<!-- flexigrid -->
						<div id="flexpaymentmanagement" style="width: 98%; margin-left: 15px;">
							<table id="paymentmanagement" style="display: none;"></table>
						</div>
					</div>
					<!-- box / title -->
					<div class="title">
						<h5>
							增加/编辑支付方式
						</h5>

					</div>
					<form action="addPayment.action" method="post">
						<div class="form">
							<div class="fields">
								<div class="field field-first">
									<div class="label">
										<label for="input-small">
											支付方式名称:
										</label>
									</div>
									<div class="input">
										<input type="text" id="paymentname" name="paymentname" class="small" />

									</div>

								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											支付方式代码:
										</label>
									</div>
									<div class="input">
										<input type="text" id="paymentCode" name="paymentCode" class="small"/>

									</div>

								</div>

								<div class="field">
									<div class="label">
										<label for="select">
											接口类型(支付宝)：
										</label>
									</div>
									<div class="select">
										<select id="paymentInterface" name="paymentInterface">
											<option value="1">
												即时到帐交易接口
											</option>
											<option value="2">
												担保交易接口
											</option>
											<option value="3">
												双功能接口
											</option>
										</select>
									</div>
								</div>

								<div class="field">
									<div class="label">
										<label for="input-small">
											账号：
										</label>
									</div>
									<div class="input">
										<input type="text" id="account" name="account" class="small" />
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											安全效验码：
										</label>
									</div>
									<div class="input">
										<input type="text" id="safecode" name="safecode" class="small" />
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											合作者身份ID：
										</label>
									</div>
									<div class="input">
										<input type="text" id="partnerid" name="partnerid" class="small" />
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											描述：
										</label>
									</div>
									<div class="input">
										<input type="text" id="des" name="des" class="small" />
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
											<option value="2">
												不支持
											</option>
										</select>
									</div>
								</div>


								<div class="field">
									<div class="label">
										<label for="select">
											是否支持在线交易：
										</label>
									</div>
									<div class="select">
										<select id="isOnline" name="isOnline">
											<option value="1">
												支持
											</option>
											<option value="2">
												不支持
											</option>
										</select>
									</div>
								</div>


								<div class="field">
									<div class="label">
										<label for="select">
											是否开启：
										</label>
									</div>
									<div class="select">
										<select id="state" name="state">
											<option value="1">
												开启
											</option>
											<option value="2">
												禁止
											</option>
										</select>
									</div>
								</div>

								<div class="form">
									<div class="fields">
										<div class="field field-first">
											<div class="input">
												<div class="button highlight">
													<input type="submit" id="submit" name="submit" value="增加支付方式" />
													<input type="button" style="display: none;" id="editpayment" name="editpayment" value="更新支付方式"></input>
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
<script type="text/javascript" src="<%=basePath%>jshop/admin/js/paymentmanagementjs.js"></script>
	
	</body>
</html>
