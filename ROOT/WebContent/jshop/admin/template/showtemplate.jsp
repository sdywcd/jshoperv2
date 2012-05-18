<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  
    <title>模板预览</title>
    
	<script type="text/javascript" src="<%=basePath%>jshop/admin/js/jquery-1.6.2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jshop/admin/js/jqueryplugin/jquery.query.js"></script>
	<script type="text/javascript">
		$(function(){
			var tid=$.query.get('tid');
			if(tid!=""){
				$.post("findTemplateByTid.action",{"tid":tid},function(data){
					
					$("body").append(data.bean.tvalue);
					
				});
			}
		});
	</script>

  </head>
  
  <body>
    
  </body>
</html>
