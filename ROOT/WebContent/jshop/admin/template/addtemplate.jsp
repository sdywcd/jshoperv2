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

	<body onload="findTemplateByTid();">
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
											主题选择:
										</label>
									</div>
									<div class="select">
	
										<select id="templatetheme" name="templatetheme">
	
										</select>
	
									</div>

								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											模板名称:
										</label>
									</div>
									<div class="input">
										<input id="name" name="name" type="text" value="" class="small" reg="^[A-Za-z0-9]+$" tip="主题名称只能由数字和字母组成"/>
									</div>
								</div>
								
								<div class="field">
									<div class="label">
										<label for="input-small">
											模板路径:
										</label>
									</div>
									<div class="input">
										<input id="url" name="url" type="text" value="WEB-INF/theme/default/shop/" class="small" readonly />
									</div>
								</div>

								<div class="field">
									<div class="label">
										<label for="select">
											类型:
										</label>
									</div>
									<div class="select">

										<select id="type" name="type">
											<option value="0">
												--请选择--
											</option>
											<option value="1">
												页面模板
											</option>
											<option value="2">
												邮件模板
											</option>
											<option value="3">
												打印模板
											</option>
										</select>

									</div>

								</div>
								
								
								<div class="field">
									<div class="label">
										<label for="input-small">
											标示:
										</label>
									</div>
									<div class="input">
										<input id="sign" name="sign" type="text" value="" class="small" readonly/>
										
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											描述:
										</label>
									</div>
									<div class="input">
										<input id="note" name="note" type="text" value="" class="small" />
									</div>
								</div>
								<div class="field">
									<div class="label label-textarea">
										<label for="textarea">
											模板内容:
										</label>
									</div>
									<div class="input" >
										<textarea id="tvalue" name="tvalue" cols="100" rows="80" style="weight:500px;"></textarea>
									</div>
								</div>

							</div>
						</div>
						<div class="form">
							<div class="fields">
								<div class="field field-first">
									<div class="input">
										<div class="button highlight">
											<input type="hidden" id="tid" name="tid" value="" />
											<input type="hidden" id="status" name="status" value=""/>
											<input type="hidden" id="themeid" name="themeid" value=""/>
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
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/templatemanagementjs.js"></script>
		
	</body>
</html>
