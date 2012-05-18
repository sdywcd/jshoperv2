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

		<title>增加商城基本信息</title>

		

		<style type="text/css">
#triggers img {
	cursor: pointer;
	margin: 0 5px;
	background-color: #fff;
	border: 1px solid #ccc;
	padding: 2px;
	width: 200px;
	height: 150px;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
}
</style>

		
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
							商城基本信息
						</h5>

					</div>
					<div class="table">
						<!-- flexigrid -->
						<div id="flexjshopbasicinfomanagement" style="width: 98%; margin-left: 18px;">
							<table id="jshopbasicinfomanagement" style="display: none;"></table>
						</div>
					</div>


					<div class="title">
						<h5>
							增加商城基本信息
						</h5>

					</div>

					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										商城名称:
									</label>
								</div>
								<div class="input">
									<input type="text" id="jshopname" name="jshopname" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										商城标语:
									</label>
								</div>
								<div class="input">
									<input type="text" id="jshopslogan" name="jshopslogan" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-medium">
										商城关键字:
									</label>
								</div>
								<div class="input">
									<input type="text" id="metaKeywords" name="metaKeywords" class="medium" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="input-medium">
										商城描述:
									</label>
								</div>
								<div class="input">
									<input type="text" id="metaDes" name="metaDes" class="medium" />
								</div>
							</div>

							<div class="field">
								<div class="label">
									<label for="select">
										所在国家:
									</label>
								</div>
								<div class="select">
									<select id="country" name="country">
										<option value="0">
											----请选择----
										</option>
										<option value="1">
											中国
										</option>
									</select>
								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										所在省份:
									</label>
								</div>
								<div class="input">
									<input type="text" id="province" name="province" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										所在城市:
									</label>
								</div>
								<div class="input">
									<input type="text" id="city" name="city" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										所在区/县:
									</label>
								</div>
								<div class="input">
									<input type="text" id="district" name="district" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-medium">
										详细地址:
									</label>
								</div>
								<div class="input">
									<input type="text" id="street" name="street" class="medium" />
								</div>
							</div>
							
							<div class="field">
								<div class="label">
									<label for="file">
										LOGO:
									</label>
								</div>
								<div class="input input-file">
									<button id="delpc" name="delpc">
										删除图片
									</button>
									<div id="file-uploader-demo1">
										<noscript>
											<p>
												Please enable JavaScript to use file uploader.
											</p>
											<!-- or put a simple form for upload here -->
										</noscript>
									</div>
									<!-- trigger elements -->
									<div id="triggers">
									</div>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										客服QQ号码:
									</label>
								</div>
								<div class="input">
									<input type="text" id="qqservice" name="qqservice" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										客服淘宝旺旺:
									</label>
								</div>
								<div class="input">
									<input type="text" id="taobaowwservice" name="taobaowwservice" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										SKYPE:
									</label>
								</div>
								<div class="input">
									<input type="text" id="skypeservice" name="skypeservice" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										YahooMessenger:
									</label>
								</div>
								<div class="input">
									<input type="text" id="yahooservice" name="yahooservice" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										MSNMessenger:
									</label>
								</div>
								<div class="input">
									<input type="text" id="msnservice" name="msnservice" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										客服邮件地址:
									</label>
								</div>
								<div class="input">
									<input type="text" id="emailservice" name="emailservice" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										客服电话:
									</label>
								</div>
								<div class="input">
									<input type="text" id="phoneservice" name="phoneservice" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="select">
										商城是否开启运作:
									</label>
								</div>
								<div class="select">
									<select id="openstate" name="openstate">
										<option value="0">
											关闭
										</option>
										<option value="1">
											开启
										</option>
									</select>
								</div>
							</div>
							<div class="field">
								<div class="label label-textarea">
									<label for="textarea">
										商城关闭原因:
									</label>
								</div>
								<div style="margin: 0 0 0 200px;">
									<textarea id="siteclosenotes" name="siteclosenotes" cols="50" rows="12"></textarea>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="select">
										是否显示License:
									</label>
								</div>
								<div class="select">
									<select id="licensed" name="licensed">
										<option value="0">
											不显示
										</option>
										<option value="1">
											显示
										</option>
									</select>
								</div>
							</div>
							<div class="field">
								<div class="label label-textarea">
									<label for="textarea">
										用户中心公告:
									</label>
								</div>
								<div style="margin: 0 0 0 200px;">
									<textarea id="usercenternote" name="usercenternote" cols="50" rows="12"></textarea>
								</div>
							</div>
							<div class="field">
								<div class="label label-textarea">
									<label for="textarea">
										商城公告(后台显示):
									</label>
								</div>
								<div style="margin: 0 0 0 200px;">
									<textarea id="jshopnotice" name="jshopnotice" cols="50" rows="12"></textarea>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="select">
										是否关闭注册:
									</label>
								</div>
								<div class="select">
									<select id="registerclose" name="registerclose">
										<option value="0">
											关闭
										</option>
										<option value="1">
											开启
										</option>
									</select>
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										ICP证书或者ICP备案号:
									</label>
								</div>
								<div class="input">
									<input type="text" id="icpnum" name="icpnum" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										寄件方-姓名(公司):
									</label>
								</div>
								<div class="input">
									<input type="text" id="sendName" name="sendName" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										寄件方-国家:
									</label>
								</div>
								<div class="input">
									<input type="text" id="sendCountry" name="sendCountry" class="small" />

								</div>

							</div>

							<div class="field">
								<div class="label">
									<label for="input-small">
										寄件方-省份:
									</label>
								</div>
								<div class="input">
									<input type="text" id="sendProvince" name="sendProvince" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										寄件方-城市:
									</label>
								</div>
								<div class="input">
									<input type="text" id="sendCity" name="sendCity" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										寄件方-区县（地区）:
									</label>
								</div>
								<div class="input">
									<input type="text" id="sendDistrict" name="sendDistrict" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										寄件方-街道（地址）:
									</label>
								</div>
								<div class="input">
									<input type="text" id="sendStreet" name="sendStreet" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										寄件方-联系电话:
									</label>
								</div>
								<div class="input">
									<input type="text" id="sendTelno" name="sendTelno" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										寄件方-手机号码:
									</label>
								</div>
								<div class="input">
									<input type="text" id="sendMobile" name="sendMobile" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										寄件方-联络人:
									</label>
								</div>
								<div class="input">
									<input type="text" id="sendContactor" name="sendContactor" class="small" />

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="select">
										使用状态:
									</label>
								</div>
								<div class="select">
									<select id="state" name="state">
										<option value="0">
											禁用
										</option>
										<option value="1">
											开启
										</option>
									</select>
								</div>
							</div>
						</div>
					</div>



					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="input">
									<div class="button highlight">
										<input type="button" id="submit" name="submit" value="提交" />
										<input style="display: none;" type="button" id="modify" name="modify" value="更新" />
										<s:hidden id="hidbasicinfoid" name="hidbasicinfoid" value=""></s:hidden>
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
<script type="text/javascript" src="<%=basePath%>jshop/admin/js/jshopbasicinfomanagementjs.js"></script>
<script type="text/javascript">
 		function createUploader(){            
             var uploader = new qq.FileUploader({
                 element: document.getElementById('file-uploader-demo1'),
                 action: '<%=basePath%>ajaxFileUploads.action;jsessionid=<%=session.getId()%>',
                 debug: true,
                 minSizeLimit:1024,
                 sizeLimit: 1073741824,
                 allowedExtensions: ['jpeg','jpg','gif','png'],
                 onComplete: function(id, fileName, responseJSON){
                	var pcpath="<%=basePath%>"+responseJSON.success;
  					var htm="<img id='"+id+"' src='"+pcpath+"' rel='#"+fileName+"'/>";
  					var checkpc="<input id='"+id+"' name='pcpath' type='checkbox' value='"+pcpath+"' checked='true'/> "
  					$("#triggers").append(htm).append(checkpc);
                 },
             });           
         }
 		window.onload = createUploader; 
 	</script>


	</body>
</html>