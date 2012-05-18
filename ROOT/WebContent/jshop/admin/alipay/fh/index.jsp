
<%
	/*
	 功能：支付宝发货信息同步接口的入口页面，生成请求URL
	 *版本：3.0
	 *日期：2010-08-4
	 *说明：
	 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
	 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。

	 */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>支付宝发货通道宝发货</title>

<SCRIPT language=JavaScript>

function CheckForm()
{
	if (document.alipayment.trade_no.value.length == 0) {
		alert("请输入支付宝交易号.");
		document.alipayment.trade_no.focus();
		return false;
	}
	if (document.alipayment.logistics_name.value.length == 0) {
		alert("请输入物流公司名称.");
		document.alipayment.logistics_name.focus();
		return false;
	}
	if (document.alipayment.invoice_no.value.length == 0) {
		alert("请输入物流发货单号.");
		document.alipayment.invoice_no.focus();
		return false;
	}
	if (document.alipayment.transport_type.value.length == 0) {
		alert("请输入物流发货时的运输类型.");
		document.alipayment.transport_type.focus();
		return false;
	}

}  
</SCRIPT>
	</head>
<body>
<FORM name=alipayment onSubmit="return CheckForm();" action=sendgoods.jsp 
method=post target="_blank">
<div id="tbfh" style="display:none;">
        <div id="order_info" class="tabs-container">
        	<ul class="tabnav">
        		<li class="current"><a name="tab0">支付宝发货通道</a></li>
        	</ul>
        	<div class="tabs-panels">
        		<div class="info-box">
        			<div class="db">
        				<table>
        					<col width="20%">
							<col width="20%">
							<col class="10%">
							<col class="10%">
							<col class="10%">
							<col class="10%">
							<col class="10%">
							<col class="10%">
							<tbody class="contact-info">
								<tr>
									<th colspan="1"><h4>支付宝发货通道</h4></th>
								</tr>
								<tr>
									<td>支付宝交易号：<span><INPUT  type="text" size=30 name=trade_no maxlength="20"/></span></td>
									<td colspan="2"></td>
									<td colspan="2"></td>
									<td colspan="2"></td>
								</tr>
								<tr>
									<td>发货类型：<span><select name="transport_type">
								                  <option value="EMS">EMS</option>
								                  <option value="POST">平邮</option>
								                  <option value="EXPRESS" selected="selected">快递</option>
								                </select></span></td>
									<td colspan="2"></td>
									<td colspan="2"></td>
									<td colspan="2"></td>
								</tr>
								<tr>
									<td>物流公司名称：<span><INPUT type="text" size=30 name=logistics_name maxlength="30"></span></td>
									<td colspan="2"></td>
									<td colspan="2"></td>
									<td colspan="2"></td>
								</tr>
								<tr>
									<td>物流发货单号：<span><INPUT type="text" size=30 name=invoice_no maxlength="50"></span></td>
									<td colspan="2"></td>
									<td colspan="2"></td>
									<td colspan="2"></td>
								</tr>
								<tr>
									<td><span><input name="alipaysendgoods" id="alipaysendgoods" value="发 货" type="submit"></span></td>
									<td colspan="2"></td>
									<td colspan="2"></td>
									<td colspan="2"></td>
								</tr>
							</tbody>
						
        				</table>
        				
        			</div>
        		</div>
        	</div>
        </div>
        </div>
</FORM>

</BODY>
</html>

