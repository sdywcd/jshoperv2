<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getParameter("detail") != null ? request.getParameter("detail") : "";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
							增加优惠模式
						</h5>

					</div>
					<div class="form">
					<div class="fields">	
					<div class="field ">
					<div class="field field-first">
								<div class="label">
									<label for="select">
										优惠模式:
									</label>
								</div>
								<div class="select">
										<select id="ecouponstate" name="ecouponstate">
											<option value="0">
												---请选择---
											</option>
											<option value="1">
												购物抵扣模式
											</option>
											<option value="2">
												现金购物模式
											</option>
											<option value="3">
												现金抵扣模式
											</option>
										</select>
								</div>
								<div class="button highlight">										
										<input type="button" id="confirm" name="confirm" value="确认"  />										
								</div>
				</div>
				</div>
				</div>
				</div>
			
		 <div class="form" style="display: none" id="three"  >
							<div class="fields">
							
							
							<div class="field ">
								<div class="label label-radio">
									<label for="input-small">
										状态:
									</label>
								</div>
								<div class="radios">
								<div class="radio">									
									<input type=radio id="state" name="state" class="small" value="1" />	
									<label>开启</label>
									<input type=radio id="state" name="state" class="small" checked="checked" value="0"/>	
									<label>关闭</label>
								</div>	
								</div>
							</div>
							
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										满足价格:
									</label>
								</div>
								<div class="input">
									<input type="text" id="favourableprices" name="favourableprices" class="small" />
									
								</div>
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										减免价:
									</label>
								</div>
								<div class="input">
									<input type="text" id="pricededuction" name="pricededuction" class="small" />
									
								</div>
							</div>
							<div id="box-mainpicture" class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide">
					
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										开始时间:
									</label>
								</div>
								<div class="input">
									<input type="text" id="begintime" name="begintime" class="small" not-null=false onfocus="WdatePicker({startDate:'%y-%M 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUserStartDate:true})"/>
									
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
										注释:
									</label>
								</div>
								<div class="input">
									<textarea  id="note" name="note" class="small"  style="width: 239px; height: 70px;" ></textarea>
									
								</div>
							</div>						
						
												
							</div>
								<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="input">
									<div class="button highlight">	
										<input type="hidden" id="eid" name="eid" />									
										<input type="button" id="add" name="add" value="提交"  />										
									</div>
								</div>
							</div>
						</div>
					</div>
							
				</div>
		 <div class="form" style="display: none" id="two"  >
							<div class="fields">
							<div class="field field-first" >
								<div class="label">
									<label for="input-small">
										商品名称:
									</label>
								</div>
								<div class="input">
									<input type="text" id="goodsname" name="goodsname" class="small" />
									
								</div>
							</div>
							<div class="field field-first" >
								<div class="label">
									<label for="input-small">
										商品ID:
									</label>
								</div>
								<div class="input">
									<input type="text" id="goodsid" name="goodsid" class="small" />
									
								</div>
							</div>
							
							<div class="field ">
								<div class="label label-radio">
									<label for="input-small">
										状态:
									</label>
								</div>
								<div class="radios">
								<div class="radio">									
									<input type=radio id="state" name="state" class="small" value="1" />	
									<label>开启</label>
									<input type=radio id="state" name="state" class="small" checked="checked" value="0"/>	
									<label>关闭</label>
								</div>	
								</div>
							</div>
							
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										满足价格:
									</label>
								</div>
								<div class="input">
									<input type="text" id="favourableprices" name="favourableprices" class="small" />
									
								</div>
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										减免价:
									</label>
								</div>
								<div class="input">
									<input type="text" id="pricededuction" name="pricededuction" class="small" />
									
								</div>
							</div>
							<div id="box-mainpicture" class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide">
					
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										开始时间:
									</label>
								</div>
								<div class="input">
									<input type="text" id="begintime" name="begintime" class="small" not-null=false onfocus="WdatePicker({startDate:'%y-%M 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUserStartDate:true})"/>
									
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
										注释:
									</label>
								</div>
								<div class="input">
									<textarea  id="note" name="note" class="small"  style="width: 239px; height: 70px;" ></textarea>
									
								</div>
							</div>						
						
												
							</div>
						
					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="input">
									<div class="button highlight">	
										<input type="hidden" id="eid" name="eid" />									
										<input type="button" id="add" name="add" value="提交"  />										
									</div>
								</div>
							</div>
						</div>
					</div>
							
				</div>
				
		 <div class="form" style="display: none" id="one"  >
						<div class="fields">
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										商品名称:
									</label>
								</div>
								<div class="input">
									<input type="text" id="goodsname" name="goodsname" class="small"  />
									
								</div>
							</div>
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
							
							<div class="field ">
								<div class="label label-radio">
									<label for="input-small">
										状态:
									</label>
								</div>
								<div class="radios">
								<div class="radio">									
									<input type=radio id="state" name="state" class="small" value="1" />	
									<label>开启</label>
									<input type=radio id="state" name="state" class="small" checked="checked" value="0"/>	
									<label>关闭</label>
								</div>	
								</div>
							</div>
							
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										满足价格:
									</label>
								</div>
								<div class="input">
									<input type="text" id="favourableprices" name="favourableprices" class="small" />
									
								</div>
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										减免价:
									</label>
								</div>
								<div class="input">
									<input type="text" id="pricededuction" name="pricededuction" class="small" />
									
								</div>
							</div>
							<div id="box-mainpicture" class="ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide">
					
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										开始时间:
									</label>
								</div>
								<div class="input">
									<input type="text" id="begintime" name="begintime" class="small" not-null=false onfocus="WdatePicker({startDate:'%y-%M 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUserStartDate:true})"/>
									
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
										注释:
									</label>
								</div>
								<div class="input">
									<textarea  id="note" name="note" class="small"  style="width: 239px; height: 70px;" ></textarea>
									
								</div>
							</div>						
						
												
							</div>
								<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="input">
									<div class="button highlight">	
										<input type="hidden" id="eid" name="eid" />									
										<input type="button" id="add" name="add" value="提交"  />										
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
		<script type="text/javascript" src="<%=basePath%>/jshop/admin/js/regme.js"></script>		
		<script type="text/javascript" src="<%=basePath %>/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="<%=basePath%>/jshop/admin/js/addecoupontjs.js"></script>
		<%@include file="/jshop/admin/footer.jsp"%>
		<!-- end footert -->


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