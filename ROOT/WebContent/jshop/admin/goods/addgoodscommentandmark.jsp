<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>设置商品评论和分值</title>
		
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
							选择需要设置的商品
						</h5>


					</div>
					<!-- end box / title -->
					<div class="table">

						<!-- flexigrid -->
						<div id="flexsetgoodscommentmanagement" style="width: 98%; margin-left: 15px;">
							<table id="setgoodscommentmanagement" style="display: none;"></table>
						</div>

					</div>
					<div id="showsetarea">
						<div class="title">
							<h5>
								设置商品评论和分值
							</h5>
						</div>

						<div class="form">
							<div class="fields">
								<div class="field field-first">
									<div class="label">
										<label for="input-small">
											商品星级评分分值：
										</label>
									</div>
									<div class="input">
										<input id="star" name="star" type="text" value="5" class="small" />
										<label>
											(该分值代表商品拥有几颗星星，请输入数字1~5中的任意数字，越大星星越多)
										</label>
									</div>
								</div>
								<div class="buttons">

									<div class="highlight">
										<input class="ui-button ui-widget ui-state-default ui-corner-all" type="button" id="updatestarsum" name="updatestarsum" value="设置商品星级分值" />

									</div>
								</div>


								<div class="field">
									<div class="label">
										<label for="input-small">
											商品总打分人数：
										</label>
									</div>
									<div class="input">
										<input type="text" id="staruser" name="staruser" class="small" />
										<label>
											(该项可以虚拟任意数量的打分人数)
										</label>
									</div>
								</div>
								<div class="buttons">

									<div class="highlight">
										<input class="ui-button ui-widget ui-state-default ui-corner-all" type="button" id="updatestarusersum" name="updatestarusersum" value="设置商品打分人数" />
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="input-small">
											总评论人数：
										</label>
									</div>
									<div class="input">
										<input type="text" id="totalcomment" name="totalcomment" class="small" />
										<label>
											(该项可以虚拟任意数量的评论人数，该虚拟人数并不会在评论系统中增加相应的评论数据)
										</label>
									</div>
								</div>
								<div class="buttons">

									<div class="highlight">
										<input class="ui-button ui-widget ui-state-default ui-corner-all" type="button" id="updatecommentsum" name="updatecommentsum" value="设置商品总评论人数" />
									</div>
								</div>



							</div>
						</div>
						<div class="title">
							<h5>
								此处开始增加评论数据到评论系统中，并可在前台商品详细中显示
							</h5>
						</div>
						<div class="form">
							<div class="fields">
								<div class="field field-first">
									<div class="label">
										<label for="input-small">
											评论人：
										</label>
									</div>
									<div class="input">
										<input id="replyorcommentusername" name="replyorcommentusername" type="text" value="5" class="small" />
										<label>
											(该项可以填写任意用户名称)
										</label>
									</div>
								</div>
								<div class="field">
									<div class="label">
										<label for="input-large">
											评论内容：
										</label>
									</div>
									<div class="input">
										<input type="text" id="commentcontent" name="commentcontent" class="large" />

									</div>
								</div>
								<div class="buttons">

									<input class="ui-button ui-widget ui-state-default ui-corner-all" id="addgoodscomment" name="addgoodscomment" value="增加商品虚拟评论" type="button" />
									<input type="hidden" id="hidgoodsid" name="hidgoodsid" value="" />
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
<script type="text/javascript" src="<%=basePath%>jshop/admin/js/goodscommentmanagementjs.js"></script>



	</body>
</html>
