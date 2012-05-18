<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getParameter("editareavalue") != null
			? request.getParameter("editareavalue")
			: "";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>添加/编辑自定义页面管理</title>
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
							增加/编辑页面编辑区域
						</h5>

					</div>

					<div class="form">
						<div class="fields">
							<div class="field">
								<div class="label">
									<label for="select">
										选择需要编辑的页面类型:
									</label>
								</div>
								<div class="select">
									<select id="pagetype" name="pagetype">
										<option value="0">
											--请选择--
										</option>
										<option value="sitenavigation">
											导航
										</option>
										<option value="goodscategory">
											商品分类
										</option>
									</select>

								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="select">
										请选择需要自定义导航页面:
									</label>
								</div>
								<div class="select">
									<div>
										<select id="sitenavigationlist" name="sitenavigationlist">

										</select>
									</div>
								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="select">
										请选择需要自定义商品分类页面:
									</label>
								</div>
								<div class="select">
									<div>
										<select id="goodscategorylist" name="goodscategorylist"></select>
									</div>
								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="select">
										请选择需要编辑的区域块号码:
									</label>
								</div>
								<div class="select">

									
									<select id="editflag" name="editflag">
										<option value="1">
											1
										</option>
										<option value="2">
											2
										</option>
										<option value="3">
											3
										</option>
										<option value="4">
											4
										</option>
										<option value="5">
											5
										</option>
										<option value="6">
											6
										</option>
										<option value="7">
											7
										</option>
										<option value="8">
											8
										</option>
										<option value="9">
											9
										</option>
										<option value="10">
											10
										</option>
										<option value="11">
											11
										</option>
										<option value="11">
											12
										</option>
										<option value="11">
											13
										</option>
									</select>
									<label>
										（区域块的选择直接决定前台页面的显示位置）
									</label>
								</div>

							</div>
							<div class="field">
								<div class="label">
									<label for="input-small">
										标题:
									</label>
								</div>
								<div class="input">
									<input type="text" name="editareatitle" id="editareatitle" class="small"/>

								</div>
							</div>
							<div class="field">
								<div class="label label-textarea">
									<label for="textarea">
										可编辑区域:
									</label>
								</div>
								<div style="margin: 0 0 0 200px;">

									<textarea id="editareavalue" name="editareavalue" cols="50" rows="12" style="width: 100%; height: 600px; visibility: hidden;"><%=htmlspecialchars(htmlData)%></textarea>
								</div>
							</div>
						</div>
					</div>
					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="input">
									<div class="button highlight">
										<input type="button" id="submit" name="submit" value="提交编辑" />
										<input type="button" style="display: none;" id="editpagearea" name="editpagearea" value="更新编辑区域" />
										<input type="hidden" id="pagename" name="pagename" value=""/>
										<input type="hidden" id="hidpageeditareaid" name="hidpageeditareaid" value=""/>
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
<script type="text/javascript" src="<%=basePath%>jshop/admin/js/pageeditareamanagementjs.js"></script>
		
		<script type="text/javascript">
 		KE.show({
			id : 'editareavalue',
			imageUploadJson : '<%=basePath%>jshop/admin/js/jsp/upload_json.jsp',
			fileManagerJson :'<%=basePath%>jshop/admin/js/jsp/file_manager_json.jsp',
		allowFileManager : true,
		wyswygMode : false,
		afterCreate : function(id) {
			KE.event.ctrl(document, 13, function() {
				KE.util.setData(id);
			});
		}

		});
 		
 	</script>



	</body>
</html>
<%!private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}%>