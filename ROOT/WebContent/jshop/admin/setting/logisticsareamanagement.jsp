<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>物流商区域价格设置</title>

	
	
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
							物流商区域价格设置
						</h5>
					</div>
					<div class="table">
						<!-- flexigrid -->
						<div id="flexlogisticsareamanagement" style="width: 98%; margin-left: 15px;">
							<table id="logisticsareamanagement" style="display: none;"></table>
						</div>
					</div>
					<!-- box / title -->
					<div class="title">
						<h5>
							增加/编辑物流商区域价格
						</h5>

					</div>
					<form action="addLogisticsbusinessarea.action" method="post">
						<div class="form">
							<div class="fields">
								<div class="field">
									<div class="label">
										<label for="select">
											物流商范围：
										</label>
									</div>
									<div class="select">
										<select id="areaname" name="areaname">
											<option value="1">
												全国
											</option>
											<option value="2">
												国际
											</option>
										</select>
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="select">
											计算模式：
										</label>
									</div>
									<div class="select">
										<select id="costway" name="costway">
											<option value="1">
												按重量计算
											</option>
											<option value="2">
												按件计算
											</option>
										</select>
									</div>
								</div>
								<div class="field field-first">
									<div class="label">
										<label for="input-small">
											购物费用最小值:
										</label>
									</div>
									<div class="input">
										<input type="text" id="needcostmin" name="needcostmin" class="small" />

									</div>

								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											购物费用最大值:
										</label>
									</div>
									<div class="input">
										<input type="text" id="needcostmax" name="needcostmax" class="small" />

									</div>

								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											标准费用:
										</label>
									</div>
									<div class="input">
										<input type="text" id="normalcost" name="normalcost" class="small" value="5" />
										<label>
											例如：在按重量计算模式下，最低运费为5元。在按件计算模式下：每件最低运费5元
										</label>
									</div>

								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											设定标准费用的重量或者件数:
										</label>
									</div>
									<div class="input">
										<input type="text" id="overvalue" name="overvalue" class="small" />
										<label>
											例如：在满1kg才收5元运费，如果全场免运费可以设定成999999
										</label>
									</div>

								</div>

								<div class="field">
									<div class="label">
										<label for="input-small">
											每千克超出标准费用的价格(元):
										</label>
									</div>
									<div class="input">
										<input type="text" id="overcost" name="overcost" class="small" value="1" />
										<label>
											例如：如果标准运费的重量或者件数的值是999999，那么忽略本列的值。否则将按照每千克加收运费
										</label>
									</div>
								</div>

								<div style="display: none;" class="field">
									<div class="label">
										<label for="input-small">
											免运费额度:
										</label>
									</div>
									<div class="input">
										<input type="text" id="freecount" name="freecount" class="small" />

									</div>

								</div>
								<div class="field">
									<div class="label">
										<label for="input-medium">
											配送范围:
										</label>
									</div>
									<div class="input">
										<input type="text" id="sendarea" name="sendarea" class="medium" />
										<label>
											多个配送范围用','号隔开。例如：上海，北京，四川
										</label>
									</div>

								</div>

								<div class="form">
									<div class="fields">
										<div class="field field-first">
											<div class="input">
												<div class="button highlight">
													<input type="submit" id="submit" name="submit" value="增加配送区域价格" />
													<input type="hidden" id="logisticsid" name="logisticsid" value=""></input>
													<input type="hidden" name="logbusareaid" value=""></input>
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
	<script type="text/javascript" src="<%=basePath%>jshop/admin/js/logisticsareamanagementjs.js"></script>


	
	</body>
</html>