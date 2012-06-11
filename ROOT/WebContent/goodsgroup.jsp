<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="/jshop/admin/header.jsp"%>
<script type="text/javascript">
	function lxfendTime(){
		$(".lcftime").each(function(){
			var lxfday=$(this).attr("lxfday");
			var nowTime = new Date().getTime();
			var begintime=$(this).attr("begintime").getTime();
			var endtime=$(this).attr("endtime").getTime();
			var grouptime=endtime-begintime;
			var seconds= grouptime/1000;
			var minutes = Math.floor(seconds/60);
			var hours = Math.floor(minutes/60);
			var days = Math.floor(hours/24);
			var cday = days;
			var chour=hours % 24;
			var cminute=minute % 60;
			var csecond=Math.floor(seconds%60);
			if(endtime<=nowTime){
				$(this).html("已过期");
			}
			if(begintime==nowTime){
				$(this).html("团购正在进行中 <tr><i>剩余时间：</i><span>"+cday+"</span> 天 <span>"+chour+"</span> 时 <span>"+cminute+"</span> 分 <span>"+csecond+"</span>秒	</tr>");
			}
			if(begintime<nowTime){
				$(this).html("团购即将开始");
			}
						
		});
		setTimeout("lxfendTime()",1000);
	};
	$(function(){
		lxfendTime();
	});
</script>
</body>
</html>