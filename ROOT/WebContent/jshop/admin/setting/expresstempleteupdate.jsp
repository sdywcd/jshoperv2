<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("expressarea") != null ? request.getParameter("expressarea") : "";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    
    
    <title>快递单模板设定</title>
   
	
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
					<div class="title">
						<h5>
							快递单模板设定
						</h5>
					</div>
					<div class="table">
						<!-- flexigrid -->
						<div style="width: 98%; margin-left: 15px;">
							<table width="98%">
								<tr>

									<td class="panel-header">
										请选择物流商
										<select id="logisticsid" name="logisticsid">
											<option value="0">
												--请选择--
											</option>
										</select>
										<input id="submit" name="submit" type="button" value="更新"/>
										 <!-- 影藏的快递单编号 -->
	 <input type="hidden" id="hidexpresstempleteid" name="hidexpresstempleteid" value=""/>
									</td>
								</tr>
								<tr>
									<td class="panel-header">
										寄件方信息：
										<input type="checkbox" id="cbsendname" name="cbsendname" value="sendname" />
										寄件方-姓名（公司）
										<input type="checkbox" id="cbsendcountry" name="cbsendcountry" value="sendcountry" />
										寄件方-国家
										<input type="checkbox" id="cbsendprovince" name="cbsendprovince" value="sendprovince" />
										寄件方-省份
										<input type="checkbox" id="cbsendcity" name="cbsendcity" value="sendcity" />
										寄件方-城市
										<input type="checkbox" id="cbsenddistrict" name="cbsenddistrict" value="senddistrict" />
										寄件方-区县（地区）
										<input type="checkbox" id="cbsendstreet" name="cbsendstreet" value="sendstreet" />
										寄件方-街道（地址）
										<input type="checkbox" id="cbsendtelno" name="cbsendtelno" value="sendtelno" />
										寄件方-联系电话
										<input type="checkbox" id="cbsendmobile" name="cbsendmobile" value="sendmobile" />
										寄件方-手机号码
										<input type="checkbox" id="cbsendcontactor" name="cbsendcontactor" value="sendcontactor" />
										寄件方-联络人
									</td>
								</tr>
								<tr>
									<td class="panel-header">
										收件方信息：
										<input type="checkbox" id="cbrecipientname" name="cbrecipientname" value="recipientname" />
										收件方-姓名（公司）
										<input type="checkbox" id="cbrecipientcountry" name="cbrecipientcountry" value="recipientcountry" />
										收件方-国家
										<input type="checkbox" id="cbrecipientprovince" name="cbrecipientprovince" value="recipientprovince" />
										收件方-省份
										<input type="checkbox" id="cbrecipientcity" name="cbrecipientcity" value="recipientcity" />
										收件方-城市
										<input type="checkbox" id="cbrecipientdistrict" name="cbrecipientdistrict" value="recipientdistrict" />
										收件方-区县（地区）
										<input type="checkbox" id="cbrecipientstreet" name="cbrecipientstreet" value="recipientstreet" />
										收件方-详细街道（详细地址）
										<input type="checkbox" id="cbrecipienttelno" name="cbrecipienttelno" value="recipienttelno" />
										收件方-联系电话
										<input type="checkbox" id="cbrecipientmobile" name="cbrecipientmobile" value="recipientmobile" />
										收件方-手机号码
										<input type="checkbox" id="cbrecipientpostcode" name="cbrecipientpostcode" value="recipientpostcode" />
										收件方-邮编
										<input type="checkbox" id="cbrecipientcontactor" name="cbrecipientcontactor" value="recipientcontactor" />
										收件方-联络人
									</td>
								</tr>
								<tr>
									<td class="panel-header">
										订单的信息：
										<input type="checkbox" id="cbyear" name="cbyear" value="year" />
										当时日期-年
										<input type="checkbox" id="cbmonth" name="cbmonth" value="month" />
										当时日期-月
										<input type="checkbox" id="cbday" name="cbday" value="day" />
										当时日期-日
										<input type="checkbox" id="cbhour" name="cbhour" value="hour" />
										当时日期-时
										<input type="checkbox" id="cbminutes" name="cbminutes" value="minutes" />
										当时日期-分
										<input type="checkbox" id="cborderid" name="cborderid" value="orderid" />
										订单-订单号
										<input type="checkbox" id="cbnotes" name="cbnotes" value="notes" />
										订单-备注
										<input type="checkbox" id="cbsendtime" name="cbsendtime" value="sendtime" />
										订单-送货时间
										<input type="checkbox" id="cbrighttag" name="cbrighttag" value="righttag" />
										√(勾)
										<input type="checkbox" id="cbquantity" name="cbquantity" value="quantity" />
										订单-商品件数
									</td>
								</tr>
							</table>
						</div>
						<div id="movediv">

						</div>

					</div>
					<div id="expresstempletesetarea" class="table">
						<%=htmlData%>

						<textarea id="expressarea" name="expressarea" cols="100" rows="8" style="width: 100%; height: 700px; visibility: hidden;"><%=htmlspecialchars(htmlData)%></textarea>

					</div>
					<!-- box / title -->

				</div>
				<!-- end table -->
			</div>
			<!-- end content / right -->
		</div>
		<!-- end content -->
		<!-- footer -->
		<%@include file="/jshop/admin/footer.jsp"%>
		<!-- end footert -->
	<script type="text/javascript" src="<%=basePath %>jshop/admin/js/expresstempleteupdatejs.js"></script>

	
    <script type="text/javascript">
 		KE.show({
			id : 'expressarea',
			imageUploadJson : '<%=basePath%>jshop/admin/js/jsp/upload_json.jsp',
			fileManagerJson : '<%=basePath%>jshop/admin/js/jsp/file_manager_json.jsp',
			allowFileManager : true,
			wyswygMode : true,
			afterCreate : function(id) {
				KE.event.ctrl(document, 13, function() {
					KE.util.setData(id);
				});
			}
		});
 		
 	</script>
	  	
  </body>
</html>
<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>