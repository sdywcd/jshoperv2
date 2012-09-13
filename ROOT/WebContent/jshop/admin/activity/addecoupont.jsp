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
										<select id="ecouponstate" name="ecouponstate" onchange="eco()">
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
								
				</div>
				</div>
				</div>
				</div>			

		 <div class="form" " id="one"  >
						<div class="fields">
						<div  id="good" style="display: none">
							<div class="field field-first" >
								<div class="label">
									<label for="input-small">
										商品名称:
									</label>
								</div>
								<div class="input">
									<input readonly="readonly" type="text" id="goodsname" name="goodsname" class="small"   autocomplete="off"  />									
								</div>
								<div class="button highlight">
								<input type="submit" id="serach" name="serach" value="搜索"/>
								</div>
							</div>
							<div class="field field-first" >
								<div class="label">
									<label for="input-small">
										商品ID:
									</label>
								</div>
								<div class="input">
									<input readonly="readonly" type="text" id="goodsid" name="goodsid" class="small"   autocomplete="off" />									
								</div>
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
									<input type="text" id="favourableprices" name="favourableprices" class="small" autocomplete="off" />
									
								</div>
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										减免价:
									</label>
								</div>
								<div class="input">
									<input type="text" id="pricededuction" name="pricededuction" class="small" autocomplete="off"  />
									
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
									<input  autocomplete="off" type="text" id="begintime" name="begintime" class="small" not-null=false onfocus="WdatePicker({startDate:'%y-%M 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUserStartDate:true})"/>
									
								</div>
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										结束时间：
									</label>
								</div>
								<div class="input">
									<input autocomplete="off" type="text" id="endtime" name="endtime" class="small" onfocus="WdatePicker({startDate:'%y-%M 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUserStartDate:true})" />
									
								</div>
							</div>	
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										注释:
									</label>
								</div>
								<div class="input">
									<textarea autocomplete="off"  id="note" name="note" class="small"  style="width: 239px; height: 70px;" ></textarea>
									
								</div>
							</div>						
						
												
							</div>					
							
				</div>
					<div class="table" id="goods" style="display: none">
						<!-- flexigrid -->
						<div id="flexgoodsmanagement" style="width: 98%; margin-left: 15px;">
							<table id="goodsmanagement" style="display: none;"></table>
							
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
				<!-- end table -->
				
			<!-- end content / right -->
		</div>
		<!-- end content -->
		<!-- footer -->
		<script type="text/javascript" src="<%=basePath%>/jshop/admin/js/regme.js"></script>		
		<script type="text/javascript" src="<%=basePath %>/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="<%=basePath%>/jshop/admin/js/addecoupontjs.js"></script>
		<script type="text/javascript" src="<%=basePath%>/jshop/admin/js/goodsBlockUIjs.js"></script>
		<script type="text/javascript" src="<%=basePath%>/jshop/admin/js/jquery.blockUI.js"></script>
		
		<%@include file="/jshop/admin/footer.jsp"%>
		<!-- end footert -->
 	<script type="text/javascript">
 		$('#serach').click(function(){
 			$.blockUI({
 				message:$('#goods'),
 				css:{
 					top:'50%',
 					left:'50%',
 					textAlign:'left',
 					marginleft:'-320px',
 					marginTop:'-280px',
 					width:'600px',
 					backgroud:'none'
 				}
 			});
 			$('.blockOverlay').attr('title','信息提示').click($.unblockUI);
 			
 		});
 		
 	</script>
</body>
</html>
