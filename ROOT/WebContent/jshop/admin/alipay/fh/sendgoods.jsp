<%
	/*
	 功能：支付宝发货信息同步接口的入口页面，生成请求URL
	 *版本：3.0
	 *日期：2010-08-4
	 *说明：
	 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
	 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
	 *************************注意*****************
	 如果不想使用扩展功能请把扩展功能参数赋空值。
	 该页面测试时出现“调试错误”请参考：http://club.alipay.com/read-htm-tid-8681712.html
	 要传递的参数要么不允许为空，要么就不要出现在数组与隐藏控件或URL链接里。
	 各家快递公司都属于EXPRESS（快递）的范畴
	 返回与请求处理程序都在该页面中编写
	 确认发货没有通知页面（notify_url）与返回页面（return_url），发货操作后，该笔交易的状态发生了变更，支付宝会主动发送通知给商户网站，而商户网站在担保交易或双功能的接口中有设置notify_url，因此通知会发到支付接口里参数notify_url对应的通知页面文件。
	 该发货接口仅针对担保交易接口、双功能接口中的担保交易支付里涉及到需要卖家做发货的操作，而不是用即时到帐支付来实现积分充值的自动发货功能。
	 **********************************************
	 */
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.jshop.alipay.fh.config.*"%>
<%@ page import="com.jshop.alipay.fh.util.*"%>
<%@ page import="org.dom4j.Document"%>
<%@ page import="org.dom4j.DocumentException"%>
<%@ page import="org.dom4j.Node"%>
<%@ page import="org.dom4j.io.SAXReader"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.util.List"%>
<%@ page import="com.jshop.action.front.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="<%=basePath %>jshop/admin/js/jquery1.4.2.js"></script>
	<script type="text/javascript" src="<%=basePath %>jshop/admin/js/sendgoodsjs.js"></script>
    <title>支付宝发货</title>
    <style type="text/css">
.font_content{
	font-family:"宋体";
	font-size:14px;
	color:#FF6600;
}
.font_title{
	font-family:"宋体";
	font-size:16px;
	color:#FF0000;
	font-weight:bold;
}
table{
	border: 1px solid #CCCCCC;
}
</style>
  </head>
<%
CallBackAlipayOrderAction cbaction=new CallBackAlipayOrderAction();
    ////////////////////////////////////////////////请求处理/////////////////////////////////////////////////////
	//request.setCharacterEncoding("UTF-8");
	//AlipyConfig.java中配置信息（不可以修改）
	String input_charset = AlipayConfig.CharSet;
	String sign_type = AlipayConfig.sign_type;
	String partner = AlipayConfig.partnerID;
	String key = AlipayConfig.key;
	
	//必填参数
	String trade_no = request.getParameter("trade_no");//支付宝交易号。它是登陆支付宝网站在交易管理中查询得到，一般以8位日期开头的纯数字（如：20100419XXXXXXXXXX） 
	String logistics_name =request.getParameter("logistics_name");//物流公司名称
	String invoice_no = new String(request.getParameter("invoice_no").getBytes("ISO-8859-1"),"utf-8");//物流发货单号
	String transport_type = request.getParameter("transport_type");//物流发货时的运输类型，三个值可选：POST（平邮）、EXPRESS（快递）、EMS（EMS）

	//选填参数
	String seller_ip = "";							//卖家本地电脑IP地址

	//GET方式传递
	String strUrl = AlipayService.CreateUrl(partner,trade_no,logistics_name,invoice_no,transport_type,seller_ip,input_charset,key,sign_type);

	//XML传输
	SAXReader reader = new SAXReader();
	Document doc = reader.read(new URL(strUrl).openStream());
	
	////////////////////////////////////////////////返回处理/////////////////////////////////////////////////////
	//远程XML解析
	String nodeIs_success = "";
	String nodeError = "";
	String nodeTrade_no = "";
	String nodeOut_trade_no = "";
	String nodeTrade_status = "";
	String nodeSend_time = "";
	List<Node> nodeList = doc.selectNodes("//alipay/*");
	StringBuffer buf1 = new StringBuffer();
	for (Node node : nodeList) {
		//获取成功标识is_success
		if (node.getName().equals("is_success")) {
			nodeIs_success = node.getText();
		}
		//获取错误代码 error
		if (node.getName().equals("error")) {
			nodeError = node.getText();
		}
	}
	// 判断是否有成功标示
	if (nodeIs_success.equals("T")){
		//获取request节点下面的子节点信息：支付宝交易号
		List<Node> nodeRequest = doc.selectNodes("//request/*");
		nodeTrade_no = nodeRequest.get(2).getText();
		
		//获取tradeBase节点下面的子节点信息：商家网站唯一订单号、交易状态、操作时间等
		List<Node> nodeTradeBase = doc.selectNodes("//response/tradeBase/*");
		for (Node node2 : nodeTradeBase) {
			if (node2.getName().equals("out_trade_no")) {
				nodeOut_trade_no = node2.getText();
			}
			if (node2.getName().equals("trade_status")) {
				nodeTrade_status = node2.getText();
			}
			if (node2.getName().equals("last_modified_time")) {
				nodeSend_time = node2.getText();
			}
		}
	}
	
	//*************************************************************************************************
	//请在此处编写商户发货成功后的业务逻辑程序代码，以便把商户网站里的该笔订单与支付宝的订单信息同步。
	
	//*************************************************************************************************
%>
  <body onload="checkfh()">
<hr />
<table align="center" width="350" cellpadding="5" cellspacing="0">
  <tr>
    <td align="center" class="font_title" colspan="2">XML返回</td>
  </tr>
  <tr>
    <td class="font_content" align="right">是否发货成功：</td>
    <td class="font_content" align="left" ><span id="nodeissuccess"><%=nodeIs_success %></span></td>
  </tr>
<%
  if(nodeIs_success.equals("T")){
  
  
%>
 <tr>
    <td class="font_content" align="right">订单号：</td>
    <td class="font_content" align="left"><span id="nodeouttradeno"><%=nodeOut_trade_no %></span></td>
  </tr>
  <tr>
    <td class="font_content" align="right">支付宝交易号：</td>
    <td class="font_content" align="left"><%=nodeTrade_no %></td>
  </tr>
  <tr>
    <td class="font_content" align="right">交易状态：</td>
    <td class="font_content" align="left"><%=nodeTrade_status %></td>
  </tr>
  <tr>
    <td class="font_content" align="right">发货时间：</td>
    <td class="font_content" align="left"><%=nodeSend_time %></td>
  </tr>
<%}
else{
 %>
 <tr>
    <td class="font_content" align="right">错误代码：</td>
    <td class="font_content" align="left"><%=nodeError %></td>
  </tr>
<%
}
 %>
</table>
  </body>
</html>
