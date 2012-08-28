var a=false;
$(function(){	
$('#confirm').click(function(){
	var ecouponstate=$('#ecouponstate').val();	
	if(ecouponstate=="3"){
		$('#three').show();
		$('#two').hide();
		$('#one').hide();
		return;
	}
	if(ecouponstate=="2"){
		$('#three').hide();
		$('#two').show();
		$('#one').hide();
		return;
	}
	if(ecouponstate=="1"){
		$('#three').hide();
		$('#two').hide();
		$('#one').show();
		return;
	}	
	
});	
$('#add').click(function(){
	validate();
	if(a){
	var ecouponstate=$('#ecouponstate').val();
	var favourableprices=$('#favourableprices').val();
	var pricededuction=$('#pricededuction').val();
	var begintime=$('#begintime').val();
	var endtime=$('#endtime').val();
	var note=$('#note').val();
	var state=$("input[name='state']:checked").val();
	$.post("addEcouponT.action",{"state":state,"ecouponstate":ecouponstate,"favourableprices":favourableprices,"pricededuction":pricededuction,"begintime":begintime,"endtime":endtime,"note":note},function(data){
		if(data.flag){
			jAlert("添加成功","信息提示");
			return ;
		}
	});
	}
});

});
function validate(){
	var favourableprices=$('#favourableprices').val();
	var pricededuction=$('#pricededuction').val();
	var begintime=$('#begintime').val();
	var endtime=$('#endtime').val();
	var note=$('#note').val();
	if(note==""){
		jAlert("注释不能为空","信息提示");
		return false;
	}
	if(favourableprices==""){
		jAlert("满足价格不能为空","信息提示");
		return false;
	}
	if(pricededuction==""){
		jAlert("减免价格不能为空","信息提示");
	}
	if(begintime==""){
		jAlert("开始时间不能为空","信息提示");
		return false;
	}
	if(endtime==""){
		jAlert("结束时间不能为空","信息提示");
		return false;
	}
	a=true;
}