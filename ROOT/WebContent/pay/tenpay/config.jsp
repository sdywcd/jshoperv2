<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>

<% 

//商户号
String partner = "";

//密钥
String key = "";

//交易完成后跳转的URL
String return_url = "http://localhost:8085/pay/tenpay/payReturnUrl.jsp";

//接收财付通通知的URL
String notify_url = "http://localhost:8085/pay/tenpay/payNotifyUrl.jsp";

%>
