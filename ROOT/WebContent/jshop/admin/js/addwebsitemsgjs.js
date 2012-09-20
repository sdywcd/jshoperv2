var f=false;
function validate(){
	var  title= $('#title').val();
	var msgtousername=$('#msgtousername').val();
	var msgstate=$('#msgstate').val();
	var text = $('#text').val();
	if(title==""){
		jAlert("标题不能为空","信息提示");
		return false;
	}
	if(msgtousername==""){
		jAlert("收件人不能为空","信息提示");
		return  false;
	}
	if(text==""){
		jAlert("内容不能为空","信息提示");
		return false;
	}
	return f=true;
}
$(function(){
	$('#add').click(function(){
		validate();
		if(f){
			var  title= $('#title').val();
			var msgtousername=$('#msgtousername').val();
			var msgstate=$("input[name='msgstate']:checked").val();
			var text = $('#text').val();
			$.post("addWebsiteMsg.action",{"title":title,"msgtousername":msgtousername,"msgstate":msgstate,"text":text},function(){
				
			});
		}
		
	});
	
});