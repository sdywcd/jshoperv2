<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>增加/编辑模板文件和系统内容关系设定</title>
	</head>

	<body onload="findTemplatesetTBytsid();">
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
							增加/编辑模板文件和系统内容关系设定
						</h5>
					</div>

					<div class="form">
						<div class="fields">

							<div class="field">
								<div class="label">
									<label for="select">
										系统内容:
									</label>
								</div>
								<div id="xtsy" class="select">
									<p></p>
									<select id="ssystemcontent" name="ssystemcontent">

									</select>
									<input type="button" id="modifysys" name="modifysys" value="编辑系统内容" style="display: none;" />

								</div>
								

							</div>
							<div id="zsys" style="display: none;" class="field">
								<div class="label">
									<label for="input-small">
										自定义系统内容:
									</label>
								</div>
								<div class="input">
									<input id="zsystemcontent" name="zsystemcontent" type="text" value="" class="small" />
								</div>
							</div>
							
							<div class="field">
								<div class="label">
									<label for="select">
										使用的模板文件:
									</label>
								</div>
								<div class="select">

									<select id="templateurl" name="templateurl">
										
									</select>

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										原标示和模板页面:
									</label>
								</div>
								<div class="input">
									<input id="syssign" name="syssign" type="text" value="" class="small" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										新标示:
									</label>
								</div>
								<div class="input">
									<input id="sign" name="sign" type="text" value="" class="small" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										静态页输出路径:
									</label>
								</div>
								<div class="input">
									<input id="buildhtmlpath" name="buildhtmlpath" type="text" value="html/default/shop/" tip="填写规则为：html/主题/shop/页面名称.html" class="small" />
								</div>
							</div>
						</div>
					</div>
					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="input">
									<div class="button highlight">
										<input type="hidden" id="tsid" name="tsid" value="" />
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
		<script type="text/javascript" src="<%=basePath %>jshop/admin/js/templatesetmanagementjs.js"></script>
		
	</body>
</html>
