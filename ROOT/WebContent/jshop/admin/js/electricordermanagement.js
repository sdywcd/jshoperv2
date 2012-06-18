
/**
 * Global variables
 */
var session="true";
/*===========================================Gorgeous split-line==============================================*/
/**
 * Function
 */
/*
 * To obtain random rid
 */
function getIdforradom(){
	var myDate=new Date();
	rid="1"+myDate.getSeconds().toString()+myDate.getMilliseconds().toString();
}
/*
 * Delete Page elements According to rid 
 */
function delParamPChild(rid){
	$('#add'+rid).remove();
}
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
	$("#h-menu-saletools").addClass("selected");
	$("#menu-saletools").removeClass("closed"); 
	$("#menu-saletools").addClass("opened");

});
