
var session ="true";

/**
 * 返回上一页
 * @return
 */
function historyback(){
	history.back();
}

$(function(){	
	$('#back').click(function(){
		historyback();		
	});		
$.post("readProperties.action",function(data){	
		$('#sysSendmail').val(data.sysSendmail);
		$('#sysMailSmtp').val(data.sysMailSmtp);
		$('#sysMailPort').val(data.sysMailPort);
		$('#smtpusername').val(data.smtpusername);
		$('#smtppwd').val(data.smtppwd);
	});
	
	$('#submit').click(function(){
		var sysSendmail=$('#sysSendmail').val();
		var sysMailSmtp=$('#sysMailSmtp').val();
		var sysMailPort=$('#sysMailPort').val();
		var smtpusername=$('#smtpusername').val();
		var smtppwd=$('#smtppwd').val();
		$.post("updateEmailProperties.action",{"sysSendmail":sysSendmail,"sysMailSmtp":sysMailSmtp,"sysMailPort":sysMailPort,"smtpusername":smtpusername,"smtppwd":smtppwd},function(){
//			if(data.flag){
//				JAlert("修改成功","信息提示");
//			window.location.href="";			
//			}else{
//				JAlert("修改失败","信息提示");
//				window.location.href="";
//			}
			window.location.href='sysemaillist.jsp?session='+session+"#settings";
		});
	});
});