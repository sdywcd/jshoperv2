<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>


		<title>增加/编辑模板</title>
	</head>

	<body onload="findTableByid();">
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
							增加/编辑模板
						</h5>
					</div>
					
						<div class="form">
							<div class="fields">
								<div class="field  field-first">
									<div class="label">
										<label for="select">
											餐桌号码:
										</label>
									</div>
									<div class="input">
	
										<input id="tableNumber" name="tableNumber" value="" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" />
												
									</div>

								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											包房名:
										</label>
									</div>
									<div class="input">
										<input id="roomName" name="roomName" type="text" value="" class="small"/>
									</div>
								</div>
								
								<div class="field">
									<div class="label">
										<label for="input-small">
											楼层:
										</label>
									</div>
									<div class="input">
										<input id="floor" name="floor" type="text" value=""  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" class="small" />
									</div>
								</div>

								<div class="field">
									<div class="label">
										<label for="input-small">
											可容纳人数:
										</label>
									</div>
									<div class="input">
										<input id="nop" name="nop" type="text" value=""  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" class="small" />
									</div>

								</div>
								

								<div class="field">
									<div class="label label-textarea">
										<label for="textarea">
											备注:
										</label>
									</div>
									<div class="input" >
										<input id="note" name="note" type="text" clsaa="small" />
									</div>
								</div>

							</div>
						</div>
						<div class="form">
							<div class="fields">
								<div class="field field-first">
									<div class="input">
										<div class="button highlight">
											<input type="hidden" id="tableid" name="tableid" value="" />
											<input type="hidden" id="tablestate" name="tablestate" value=""/>
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
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/electablemanagement.js"></script>
		
	</body>
</html>
