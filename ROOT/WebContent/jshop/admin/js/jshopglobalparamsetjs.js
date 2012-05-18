
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


$(function(){
		
	$.post("findAllGlobalParam.action",function(data){
		 $.each(data.map,function(key,values){  
		        if(key=="issendactivatemail"){
		        	if(values=="1"){
		        		$("input[name='issendactivatemail']").get(0).checked=true;
		        	}else{
		        		$("input[name='issendactivatemail']").get(1).checked=true;
		        	}
		        	
		        }else if(key=="stockwarning"){
		        	$('#stockwarning').attr("value",values);
		        }else if(key=="integralconversionratio"){
		        	$('#integralconversionratio').attr("value",values);
		        }else if(key=="mobilehost"){
		        	$('#mobilehost').attr("value",values);
		        }
		    }); 
	});
	
	
	/**
	 * 更新全局参数
	 * 
	 */
	$('#submit').click(function(data){
		var issendactivatemail=$("input[name='issendactivatemail']:checked").val();
		var stockwarning=$('#stockwarning').val();
		var integralconversionratio=$('#integralconversionratio').val();
		var mobilehost=$('#mobilehost').val();
		$.post("updateGolbalParamBykey.action",{"issendactivatemail":issendactivatemail,"stockwarning":stockwarning,"integralconversionratio":integralconversionratio,"mobilehost":mobilehost},function(data){
			if(data.sucflag){
				jAlert('更新全局参数成功','信息提示');
				return true;
			}else{
				jAlert('更新全局参数失败','信息提示');
				return false;
			}
		});
		
		
	});
	
});

