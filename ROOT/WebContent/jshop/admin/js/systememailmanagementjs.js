/**
 * Global variables
 */
var session="true";
/*===========================================Gorgeous split-line==============================================*/
/**
 * ui
 */
$(function(){
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
/*===========================================Gorgeous split-line==============================================*/
/**
 * Function
 */
/**
 * 返回上一页
 * @return
 */
function historyback(){
	history.back();
}

/**
 * Required to initialize the page data
 */
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
});
/**
 * flexigrid list 
 */
	$(function() {

		$("#systememailmanagement").flexigrid( {
			url : 'findAllSystemMail.action',
			dataType : 'json',
			cache : false,
			colModel : [{
				display:'发件人邮箱',
				name:'sysSendmail',
				width:120,
				sortable:true,
				align:'center'
			},{ 
				display:'SMTP服务器',
				name:'sysMailSmtp',
				width:100,
				sortable:true,
				align:'center'
			},{
				display:'SMTP端口',
				name:'sysMailPort',
				width:100,
				sortable:true,
				align:'center'
			},{
				display:'SMTP用户名',
				name:'smtpusername',
				width:120,
				sortable:true,
				align:'center'
			},{
				display:'SMTP密码',
				name:'smtppwd',
				width:60,
				sortable:true,
				align:'center'
			},{
				display:'状态',
				name:'state',
				width:60,
				sortable:true,
				align:'center'
			},{
				display:'淘宝序号',
				name:'userid',
				width:100,
				sortable:true,
				align:'center'
			},{
				display:'淘宝用户名',
				name:'nick',
				width:100,
				sortable:true,
				align:'center'
			}],
			buttons : [{
				name : '添加邮箱设置',
				bclass : 'add',
				onpress : action
			},{
				name:'设置成系统邮箱',
				bclass:'edir',
				onpress:action
			},{
				name:'发送活动邮件',
				bclass:'add',
				onpress:action
			},{
				name:'查看现系统邮箱并修改',
				bclass:'edit',
				onpress:action
			},{
				separator : true
			} ],			
			sortname : "createtime",
			sortorder : "desc",
			usepager : true,
			title : '邮箱列表',
			useRp : true,
			rp : 20,
			rpOptions : [ 20, 60,200, 1000 ],
			showTableToggleBtn : true,
			width :'auto',
			height : 'auto',
			pagestat : '显示{from}到{to}条，共{total}条记录',
			procmsg : '正在获取数据，请稍候...',
			checkbox:true
		});
		function action(com, grid) {
			if (com == '添加邮箱设置') {
				window.location.href="jshopsysmailset.jsp?session="+session+"#settings";
				return;

			}else if(com=='设置成系统邮箱'){
				if ($('.trSelected', grid).length == 1) {
					jConfirm('确定编辑此项吗?', '信息提示', function(r) {
						if (r) {
							var str = $('.trSelected', grid)[0].id.substr(3);
							$.post("setEmailToSysmail.action",{"smailid":str},function(data){
								if(data.sucflag){
									jAlert('设置系统邮箱成功','信息提示');
									return true;
								}
							});
						}
					});
				} else {
					jAlert('请选择一条信息', '信息提示');
					return false;
				}
			}else if(com=="发送活动邮件"){
				window.location.href='sendactivityemail.jsp?session='+session+"#settings";
				return;
			}else if(com=="查看现系统邮箱并修改"){
				window.location.href='addsystememail.jsp?session='+session+"#settings";
				return;
			}
		}
});
	/*===========================================Gorgeous split-line==============================================*/

/**
 * Add Function
 */
$(function(){
	$('#submit').click(function(){
		var sysSendmail=$('#sysSendmail').val();
		var sysMailSmtp=$('#sysMailSmtp').val();
		var sysMailPort=$('#sysMailPort').val();
		var smtpusername=$('#smtpusername').val();
		var smtppwd=$('#smtppwd').val();
		$.post("updateEmailProperties.action",{"sysSendmail":sysSendmail,"sysMailSmtp":sysMailSmtp,"sysMailPort":sysMailPort,"smtpusername":smtpusername,"smtppwd":smtppwd},function(){

			window.location.href='sysemaillist.jsp?session='+session+"#settings";
		});
	});
	
	$('#submitactivity').click(function(){
		var detail = $('#detail').val();
		if(detail==""){
			jAlert("内容不能为空","信息提示");
			return false;
		}
		$.post("sendActivityEmail.action",{"detail":detail},function(data){
		
		});
	});
});

