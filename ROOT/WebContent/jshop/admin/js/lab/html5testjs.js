var session;
$(function() {
	$.post("CheckLogin.action", function(data) {
		if (data.slogin) {
			top.location.href = "../adminlogin.jsp";
		} else {
			session = data.usession;
		}
	});
	$("h6").each(function() {
		$(this).removeClass("selected");
	});
	$("ul").each(function() {
		$(this).removeClass("opened");
		$(this).addClass("closed");
	});
	$("#h-menu-pagecontent").addClass("selected");
	$("#menu-pagecontent").removeClass("closed");
	$("#menu-pagecontent").addClass("opened");
});

/**
 * 对FileReader接口操作
 */
$(function(){
	if(typeof FileReader=='undefined'){
		$('#readfileresult').html("抱歉，你的浏览器不支持FileReader,请使用FireFox3.6+或者Chrome 6.0+");
		$('#file').attr("disabled",'disabled');
	}else{
		$('#readfileresult').html("恭喜，你的浏览器支持FileReader");
	}
	
	//读取图片文件
	$('#readpicture').click(function(){
		var file=document.getElementById("file").files[0];
		if(!/image\/\w+/.test(file.type)){
			jAlert('请确保文件是图片类型', '信息提示');
			return false;
		}
		var reader=new FileReader();
		//将文件以Data URL形式读入页面
		reader.readAsDataURL(file);
		reader.onload=function(e){
			var readfileresult=document.getElementById("readfileresult");
			$('#readfileresult').html('<img src="'+this.result+'" alt=""/>');
		}
	});
	
	//读取二进制文件
	$('#read2dll').click(function(){
		var file=document.getElementById("file").files[0];
		var reader=new FileReader();
		reader.readAsBinaryString(file);
		reader.onload=function(f){
			var readfileresult=document.getElementById("readfileresult");
			$('#readfileresult').html(this.result);
		}
		
	});
	
	//读取文本文件
	$('#readtext').click(function(){
		var file=document.getElementById("file").files[0];
		var reader=new FileReader();
		reader.readAsText(file);
		reader.onload=function(f){
			var readfileresult=document.getElementById("readfileresult");
			$('#readfileresult').html(this.result);
		}
		
	});
	
	//读取网页
	$('#readhtml').click(function(){
		var file=document.getElementById("file").files[0];
		var reader=new FileReader();
		//将文件以Data URL形式读入页面
		reader.readAsDataURL(file);
		reader.onload=function(e){
			var readfileresult=document.getElementById("readfileresult");
			$('#readfileresult').html(this.result);
		}
	});
});

/**
 * 拖动操作
 */
$(function(){
	var source=document.getElementById("dragme");
	var dest=document.getElementById("dragmetext");
	source.addEventListener("dragstart",function(e){
		var dt=e.dataTransfer;
		dt.effectAllowed='all';
		dt.setData("text/html",this.innerHTML);
	},false);
	dest.addEventListener("dragend",function(e){
		e.preventDefault();
	},false);
	dest.addEventListener("drop",function(e){
		var dt=e.dataTransfer;
		var text=dt.getData("text/html");
		dest.textContent+=text+"<br/>";
		e.preventDefault();
		e.stopPropagation();
	},false);
	document.ondragover=function(e){e.preventDefault();};
	document.ondrop=function(e){e.preventDefault();};
});

