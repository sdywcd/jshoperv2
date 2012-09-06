<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>网站生成信息反馈</title>

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
							网站生成信息反馈
						</h5>
					</div>


					<div class="form">
						<div class="fields">
							<!-- <div class="field">
								<div class="label label-radio">
									<label>进度信息: </label>
								</div>
								<div class="input">
									<span class="progressbar" id="uploadprogressbar">0%</span>	
								</div>
							</div>
							 -->
							<div class="field">
								<div class="label label-textarea">
										<label for="textarea">
											反馈信息:
										</label>
									</div>
								
									
									<div id="backinfo" style="border:1px solid #ccc;margin: 0 0 0 200px; height:auto;">
										
									</div>
							</div>
						
						</div>
					</div>
					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="input">
									<div class="button highlight">
										<input type="button" id="buildhtmlsubmit" name="buildhtmlsubmit" value="开始生成"  onclick="buildAllHtml();"/>
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
		<script type="text/javascript">

		
		</script>

	</body>
</html>