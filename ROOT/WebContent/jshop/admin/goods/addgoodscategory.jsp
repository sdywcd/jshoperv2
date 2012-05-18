<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>商品分类管理</title>
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
							增加/编辑商品分类
						</h5>
					</div>
					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										分类名称:
									</label>
								</div>
								<div class="input">
									<input id="name" name="name" type="text" value="" class="small" />
								</div>
							</div>
							<div id="addfl" class="field">
								<div class="label">
									<label for="select">
										分类选择:
									</label>
								</div>
								<div class="select">
									<div>
										<select id="parentId" name="parentId">

										</select>
										<select id="parentId1" name="parentId1">

										</select>
									</div>
								</div>

							</div>
							<div id="fater" class="field">
								<div class="label">
									<label for="select">
										上级分类:
									</label>
								</div>
								<div class="select">
									<div id="modfl">

										<input type="text" id="parentName" name="parentName" value="" readonly />
									</div>
								</div>

							</div>

							<div class="field">
								<div class="label">
									<label for="select">
										商品类型:
									</label>
								</div>
								<div class="select">
									<span id="goodstypetnselect"></span>
								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										标示:
									</label>
								</div>
								<div class="input">
									<input id="sign" name="sign" type="text" value="" reg="^[A-Za-z]+$" tip="只能由英文组成" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										排序:
									</label>
								</div>
								<div class="input">
									<input id="sort" name="sort" value="" reg="^\d+$" tip="只能是数字" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										页面关键字:
									</label>
								</div>
								<div class="input">
									<input id="metaKeywords" name="metaKeywords" value="" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label label-textarea">
									<label for="textarea">
										页面描述:
									</label>
								</div>
								<div class="textarea textarea-editor">
									<textarea id="metaDes" name="metaDes" cols="50" rows="12"></textarea>
								</div>
							</div>
						</div>
					</div>



					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="input">
									<div class="button highlight">
										<input type="hidden" id="hidgoodsCategoryTid" name="hidgoodsCategoryTid" value="" />
										<input type="button" id="submit" name="submit" value="提交" />
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
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/goodscategorymanagementjs.js"></script>
	
	</body>
</html>
