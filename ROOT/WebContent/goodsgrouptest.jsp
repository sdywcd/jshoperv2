<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
   <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>

</head>
<body>
<form action="" id="form1" name="form1">
<div class="field field-first">
								<div class="label">
									<label for="input-small">
										开始时间:
									</label>
								</div>
								<div class="input">
									<input type="text" id="begintime" name="begintime" class="small" onfocus="WdatePicker({startDate:'%y-%M 00:00:00',dateFmt:'MM/dd/yyyy HH:mm:ss',alwaysUserStartDate:true})"/>
									
								</div>
							</div>
							<div class="field field-first">
								<div class="label">
									<label for="input-small">
										结束时间：
									</label>
								</div>
								<div class="input">
									<input type="text" id="endtime" name="endtime" class="small" onfocus="WdatePicker({startDate:'%y-%M 00:00:00',dateFmt:'MM/dd/yyyy HH:mm:ss',alwaysUserStartDate:true})" />
									
								</div>
							</div>
							<input type="text" id="newtime" name="newtime"  />
							<input type="button" id="but" name="but" value="开始" onclick="lxfendTime()" />
							</form>
<script type="text/javascript">
	function lxfendTime(){
		// $(".lcftime").each(function(){
			var temp=null;
			//var lxfday=$(this).attr("lxfday");
			var nowTime = new Date().getTime();			
			// var begin=document.form1.begintime.value;
			var begintime=new Date(document.form1.begintime.value).getTime();
			var endtime=new Date(document.form1.endtime.value).getTime();
			var grouptime=endtime-nowTime;
			var seconds= grouptime/1000;
			var minutes = Math.floor(seconds/60);
			var hours = Math.floor(minutes/60);
			var days = Math.floor(hours/24);
			var cday = days;
			var chour=hours % 24;
			var cminute=minutes % 60;
			var csecond=Math.floor(seconds%60);
			if(endtime<=nowTime){
				temp="已过期";
			}
			if(endtime>=nowTime && nowTime>begintime){
				temp=cday+" 天 "+chour+" 时 "+cminute+"分 "+csecond+"秒";
			}
		//	if(begintime>nowTime){
		//	 	temp="团购即将开始";
		//	}
			document.form1.newtime.value=temp;
						
		// });
		setTimeout("lxfendTime()",1000);
	};	
	$(function(){
		lxfendTime();
	});
</script>

							
</body>
		<script type="text/javascript" src="<%=basePath %>/My97DatePicker/WdatePicker.js"></script>
		
</html>