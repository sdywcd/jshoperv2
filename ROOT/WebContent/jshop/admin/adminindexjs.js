/**
 * ui
 */
$(function(){
	style_path = "resources/css/colors";
	$("#date-picker").datepicker();
	$("#box-tabs, #box-left-tabs").tabs();
});
/*===========================================Gorgeous split-line==============================================*/
/**
 * Function
 */
//一件更新商城
//function showBuildProcess() {
//	$.get("findProcessBar.action", function(data) {
//		if (data.processbar!=""){
//			$("#buildprogressbar").progressBar(data.processbar);
//		}
//	});
//}
function buildAllHtml(){
	$('#backinfo').html("正在生成网站请稍候......");
	$('#buildhtmlsubmit').attr("disabled",true);
//	$("#spaceused1").progressBar();
//	$("#spaceused2").progressBar({ barImage: 'js/jqueryprogressbar/images/progressbg_yellow.gif'} );
//	$("#spaceused3").progressBar({ barImage: 'js/jqueryprogressbar/images/progressbg_orange.gif', showText: false} );
//	$("#spaceused4").progressBar(65, { showText: false, barImage: 'js/jqueryprogressbarimages/progressbg_red.gif'} );
//	$("#buildprogressbar").progressBar();
//	setTimeout("showBuildProcess()", 750);
	$.post("buildAllHtml.action",function(data){
		
		if(data.status=="success"){
			$('#backinfo').append(data.buildlog);
			$('#buildhtmlsubmit').attr("disabled",false);
			return;
		}
	});

	
}

/*===========================================Gorgeous split-line==============================================*/

/**
 * 检测用户是否登录并实行跳转控制
 */
$(function(){
	$.post("CheckLogin.action",function(data){
		if(data.slogin){
			var pathnamearray=window.location.pathname.split("/");
			var pathname=pathnamearray[1]+"/";
			if(pathname=="jshop/"){
				pathname="";
			}
		    top.location.href="http://"+window.location.host+"/"+pathname+"jshop/admin/jump.jsp";
		}else{
			if(data.length>0){
				var pathnamearray=window.location.pathname.split("/");
				var pathname=pathnamearray[1]+"/";
				if(pathname=="jshop/"){
					pathname="";
				}
				top.location.href="http://"+window.location.host+"/"+pathname+"jshop/admin/jump.jsp";
			}else{
				return;
			}
		}

	})
});

/*===========================================Gorgeous split-line==============================================*/
function createSqlite(){
	$.post("createTable.action",function(data){
		if(data.sqlite){
			jAlert('生成成功','信息提示');
			return;
		}else {
			jAlert('生成失败','信息提示');
			return;
		}
	});
}

