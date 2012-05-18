var session ="true";
$(function(){
//	$.post("CheckLogin.action",function(data){
//		if(data.slogin){
//			top.location.href="../adminlogin.jsp";
//		}else{
//			session=data.usession;
//		}
//	});
	$("h6").each(function(){
		$(this).removeClass("selected"); 
	});
	$("ul").each(function(){
		$(this).removeClass("opened"); 
		$(this).addClass("closed"); 
	});
	$("#h-menu-settings").addClass("selected");
	$("#menu-settings").removeClass("closed"); 
	$("#menu-settings").addClass("opened");
});

/**
 * 返回上一页
 * @return
 */
	
//$.post("readProperties.action",function(data){	
//		$('#sysSendmail').val(data.sysSendmail);
//		$('#sysMailSmtp').val(data.sysMailSmtp);
//		$('#sysMailPort').val(data.sysMailPort);
//		$('#smtpusername').val(data.smtpusername);
//		$('#smtppwd').val(data.smtppwd);
//	});
$(function(){
	$('#submit').click(function(){
		var sysSendmail=$('#sysSendmail').val();
		var sysMailSmtp=$('#sysMailSmtp').val();
		var sysMailPort=$('#sysMailPort').val();
		var smtpusername=$('#smtpusername').val();
		var smtppwd=$('#smtppwd').val();
		$.post("UpdateProperties.action",{"sysSendmail":sysSendmail,"sysMailSmtp":sysMailSmtp,"sysMailPort":sysMailPort,"smtpusername":smtpusername,"smtppwd":smtppwd},function(){
//			if(data.flag){
//				JAlert("修改成功","信息提示");
//			window.location.href="";			
//			}else{
//				JAlert("修改失败","信息提示");
//				window.location.href="";
//			}
			window.location.href="jshop/admin/setting/sysemail.jsp";
		});
	});
});

