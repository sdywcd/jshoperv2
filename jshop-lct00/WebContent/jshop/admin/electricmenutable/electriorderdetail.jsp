<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单详细</title>
    

	<link href="<%=basePath%>jshop/admin/themes/default/easyui.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>jshop/admin/js/flexigrid/css/flexigrid/flexigrid_blue.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>jshop/admin/css/orderdetail.css"/>
    <link rel="stylesheet"
			href="<%=basePath%>jshop/admin/js/jquery.alerts/jquery.alerts.css"
			type="text/css" media="screen" />
		<script type="text/javascript"
			src="<%=basePath%>jshop/admin/js/jquery-1.6.2.min.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>jshop/admin/js/jquery.alerts/jquery.alerts.js"></script>
		
    <script type="text/javascript" src="<%=basePath %>jshop/admin/js/jquery1.4.2.js"></script>
    <script type="text/javascript" src="<%=basePath %>jshop/admin/js/flexigrid/flexigrid.js"></script>
	<script type="text/javascript" src="<%=basePath %>jshop/admin/js/electronicorderjs.js"></script>
	<style type="text/css">
		td{font-size:9pt;line-height:120%;color:#353535} 
		body{font-size:9pt;line-height:120%} 
    </style>
  </head>
  
  <body>
  		<!-- 订单状态显示 -->
	   <table width="98%" border="0" cellpadding="1" cellspacing="1" align="center">
	 		<tr> 
	   			<td class="panel-header">订单状态</td>
	  		</tr>
	   </table>
	  <s:if test="#request.electronicOrder!=null">
	
	  <div id="orderstatearea" style="width:98%;">
        <div class="bd">
        	<div class="order_state">

        		<strong>当前订单状态：<span><s:property value="#request.electronicOrder.electronicorder.electronicorderstate"/></span></strong>

        	</div>
        	<div class="order_state">

        		<strong>当前付款状态：<span id="nowpaystate"><s:property value="#request.electronicOrder.electronicorder.paystate"/></span></strong>

        	</div>
        	<div class="order_state">

        		<strong>当前上菜状态：<span><s:property value="#request.electronicOrder.electroniccart.cookingstate"/></span></strong>
        	</div>      
        	<div class="action">       
        		<input type="hidden" id="hidtablenumber" name="hidtablenumber" value="<s:property value="#request.electronicOrder.electronicorder.tableNumber"/>"/> 		
        		<span class="actionbutton"><input type="button" id="confirm_electronicorder" name="confirm_electronicorder" value="确认"/></span>
        		<span class="actionbutton"><input type="button" id="vegetable_electronicorder" name="vegetable_electronicorder" value="菜已上齐"/></span>
        		<span class="actionbutton"><input type="button" id="pay_electronicorder" name="pay_electronicorder" value="付款"/></span>
        	</div>  	

        	
        </div>

		<div id="tbfh">       
        </div>
                <!-- 订单买家信息 -->
        <div id="order_info" class="tabs-container">
        	<ul class="tabnav">
        		<li class="current"><a name="tab0">订单详细</a></li>
        	</ul>
        	<div class="tabs-panels">
        		<div class="info-box">
        			<div class="db">
        				<table>
        					<col width="20%">
							<col width="20%">
							<!-- 宝贝 -->
							<col class="10%">
							<!-- 交易状态 -->
							<col class="10%">
							<!-- 单价（元） -->
							<col class="10%">
							<!-- 数量 -->
							<col class="10%">
							<!-- 优惠 -->
							<col class="10%">
							<!-- 合计（元） -->
							<col class="10%">
							<!-- 运费（元） -->
							<!-- 买/卖家信息 -->					
							<tbody class="contact-info">
								<tr class="sep-row"><td colspan="8"></td></tr>
								<tr>
									<th colspan="1"><h4>餐桌信息信息</h4></th>
								</tr>
								
								<tr>

									<td>餐桌编号：<span><s:property value="#request.electronicOrder.table.tableNumber"/></span></td>

									<td colspan="2">人数：<span><s:property value="#request.electronicOrder.table.nop"/></span></td>
									<td colspan="2">用餐状态：<span><s:property value="#request.electronicOrder.table.tablestate"/></span></td>
									<td colspan="2">就座时间：<span><s:property value="#request.electronicOrder.table.createtime"/></span></td>
								</tr>
								
							</tbody>
							
							<tbody class="contact-info">
								<tr class="sep-row"><td colspan="8"></td></tr>
								<tr class="order-hd">
									<th>商品编号</th>
									<th>商品名称</th>
									<th>商品自定义编号</th>
									
									<th>会员价</th>
									<th>赠送积分</th>
									<th>数量</th>
									<th>商品毛重</th>
									
								</tr>
								<s:iterator id="bean" value="#request.electronicOrder.electronicList" status="electronicList">
								<tr class="order-item">
									<td><s:property value="goodsid"/></td>
									<td>
										<div class="pic-info">
											<div class="pic">
												<a title="商品图片" target="_blank" href="GetGoodsdetailBygoodsid.action?goodsid=<s:property value="goodsid"/>">
													<img src="Uploads/<s:property value="picture"/>" alt="<s:property value="goodsname"/>">
											    </a>
											</div>
										</div>
										<div class="txt-info">
											<div class="desc">
												<span class="name">
												<a target="_blank" title="<s:property value="goodsname"/>" href="GetGoodsdetailBygoodsid.action?goodsid=<s:property value="goodsid"/>"><s:property value="goodsname"/></a>
												</span>
											</div>
										</div>
									</td>
									<td><s:property value="usersetnum"/></td>
									
									<td colspan="1"><s:property value="price"/></td>
									<td colspan="1"><s:property value="points"/></td>
									<td colspan="1"><s:property value="needquantity"/></td>
									<td colspan="1"><s:property value="weight"/></td>
									
								
								</tr>
								</s:iterator>
								<tr class="order-item">
									<td colspan="7"></td>

									<td colspan="1">总价：<span><s:property value="#request.electronicOrder.electronicorder.shouldpay"/></span></td>

								
								</tr>
							</tbody>
							
        				</table>
        				
        			</div>
        		</div>
        	</div>
        </div>
	  </div>
	    
	  </s:if>
	  <!-- 结束订单状态显示 -->
	 
  </body>
</html>
