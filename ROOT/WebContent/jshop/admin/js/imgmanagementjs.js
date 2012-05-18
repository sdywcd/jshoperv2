var session ="true";



//点击删除图片
function delImgT(imgHref,imgId){
	$.post("delImgT.action",{"imgHref":imgHref,"imgId":imgId},function(data){
		if(data.sucflag){
			jAlert('图片删除成功','信息提示');
			
		    window.location.href="findAllImgT.action";
		}else{
			jAlert('该图片已经被引用不能删除','信息提示');
			
			return false;
		}
	});
}

function getRelship(imgName){
	window.location.href="jshop/admin/goods/imgrelationshipmanagement.jsp?imgName="+imgName;
}


$(function(){
	$('#tbgoodsimg').click(function(){
		$(this).expose();
		$.post("OneKeyAddImgT.action",function(data){
			if(data.sucflag){
				jAlert('同步成功点击确定读取数据','信息提示');
				
			    window.location.href="findAllImgT.action";
			}else{
				jAlert('同步失败','信息提示');
				
				return false;
			}
		});
	});
	
	$.post("readSeverFile.action",function(data){
		
	});
	
});

