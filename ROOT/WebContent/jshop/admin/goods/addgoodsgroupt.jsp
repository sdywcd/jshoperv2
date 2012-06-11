<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getParameter("detail") != null ? request
			.getParameter("detail") : "";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
							增加/编辑商品类型
						</h5>

					</div>

					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										商品ID:
									</label>
								</div>
								<div class="input">
									<input type="text" id="goodsid" name="goodsid" class="small" />
									
								</div>
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										商品名称:
									</label>
								</div>
								<div class="input">
									<input type="text" id="goodsname" name="goodsname" class="small" />
									
								</div>
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										状态:
									</label>
								</div>
								<div class="input">
									<input type="text" id="state" name="state" class="small" />
									
								</div>
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										商品积分:
									</label>
								</div>
								<div class="input">
									<input type="text" id="sendpoint" name="sendpoint" class="small" />
									
								</div>
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										商品价格:
									</label>
								</div>
								<div class="input">
									<input type="text" id="priceladder" name="priceladder" class="small" />
									
								</div>
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										开始时间:
									</label>
								</div>
								<div class="input">
									<input type="text" id="begintime" name="begintime" class="small" onfocus="WdatePicker({startDate:'%y-%M 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUserStartDate:true})"/>
									
								</div>
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										结束时间：
									</label>
								</div>
								<div class="input">
									<input type="text" id="endtime" name="endtime" class="small" onfocus="WdatePicker({startDate:'%y-%M 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUserStartDate:true})" />
									
								</div>
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										可售数量:
									</label>
								</div>
								<div class="input">
									<input type="text" id="salequantity" name="salequantity" class="small" />
									
								</div>
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										成功订购量:
									</label>
								</div>
								<div class="input">
									<input type="text" id="sordercount" name="sordercount" class="small" />
									
								</div>
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										保证金制度:
									</label>
								</div>
								<div class="input">
									<input type="text" id="cashstate" name="cashstate" class="small" />
									
								</div>
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										限购数量:
									</label>
								</div>
								<div class="input">
									<input type="text" id="limitbuy" name="limitbuy" class="small" />
									
								</div>
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										总订购数:
									</label>
								</div>
								<div class="input">
									<input type="text" id="totalordercount" name="totalordercount" class="small" />
									
								</div>
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										保证金额度:
									</label>
								</div>
								<div class="input">
									<input type="text" id="cashlimit" name="cashlimit" class="small" />
									
								</div>
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										商品说明:
									</label>
								</div>
								<div style="margin: 0 0 0 200px;">
										<textarea id="detail" name="detail" cols="50" rows="12" style="width: 100%; height: 600px; visibility: hidden;"><%=htmlspecialchars(htmlData)%></textarea>
								</div>
							</div>
							<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="input">
									<div class="button highlight">

										<input type="button" id="add" name="add" value="提交" />
										<input type="button" id="update" name="update" value="更新" style="display: none;" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
							
						</div>
					</div>	
				</div>
				<!-- end table -->
				
			<!-- end content / right -->
		</div>
		<!-- end content -->
		<!-- footer -->
		<script type="text/javascript" src="<%=basePath%>/jshop/admin/js/addgoodsgroupjs.js"></script>
		<%@include file="/jshop/admin/footer.jsp"%>
		<!-- end footert -->
	<script type="text/javascript">
 		 function createUploader(){ 
             var uploader = new qq.FileUploader({
                 element: document.getElementById('file-uploader-demo1'),
                 action: '<%=basePath%>/ajaxFileUploads.action;jsessionid=<%=session.getId()%>',
                 debug: true,
                 minSizeLimit:1024,
                 sizeLimit: 1073741824,
                 allowedExtensions: ['jpeg','jpg','gif','png'],
                 onComplete: function(id, fileName, responseJSON){
                	//var pcpath="<%=basePath%>"+responseJSON.success;
  					var pcpath=responseJSON.success;
  					var htm="<img id='"+id+"' src='"+pcpath+"' rel='#"+fileName+"'/>";
  					var checkpc="<input id='"+id+"' name='pcpath' type='checkbox' value='"+pcpath+"' checked='true'/> "
  					$("#triggers").append(htm).append(checkpc);
                 },
               
             });           
         }
 		window.onload = createUploader; 
 	</script>

		<script type="text/javascript">
 		KE.show({
			id : 'detail',
		    imageUploadJson : '<%=basePath%>/jshop/admin/js/jsp/upload_json.jsp',
			fileManagerJson : '<%=basePath%>/jshop/admin/js/jsp/file_manager_json.jsp',
			allowFileManager : true,
			afterCreate : function(id) {
				KE.event.ctrl(document, 13, function() {
					KE.util.setData(id);
				});
			}
		});
 		KE.show({
			id : 'commoditylist',
			items : ['fontname', 'fontsize', '|', 'textcolor', 'bgcolor', 'bold', 'italic', 'underline',
					'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist','insertunorderedlist']
		});
 		
 		 $().ready(function(){  
 		   $('#addbelinked').click(function() {  
 		    return !$('#select1 option:selected').remove().appendTo('#select2');  
 		   });
 		   $('#removebelinked').click(function() {  
 		    return !$('#select2 option:selected').remove().appendTo('#select1');  
 		   });  
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