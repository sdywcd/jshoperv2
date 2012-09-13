var a=false;
var session=true;
$(function(){	
$('#confirm').click(function(){
	var ecouponstate=$('#ecouponstate').val();	
	if(ecouponstate=="3"){		
		
		$('#good').hide();
		return;
	}
	if(ecouponstate=="2"){
	
		$('#good').show();
		return;
	}
	if(ecouponstate=="1"){	
		$('#good').show();
		
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
	var goodsname=$('#goodsname').val();
	var goodsid=$('#goodsid').val();
	$.post("addEcouponT.action",{"goodsid":goodsid,"goodsname":goodsname,"state":state,"ecouponstate":ecouponstate,"favourableprices":favourableprices,"pricededuction":pricededuction,"begintime":begintime,"endtime":endtime,"note":note},function(data){
		if(data.flag){
			jAlert("添加成功","信息提示");
			window.location.href='ecoupontmanagement.jsp?session' +session+ "#goods";
			return ;
		}
	});
	}
});

});
function validate(){
	var ecouponstate=$('#ecouponstate').val();
	var favourableprices=$('#favourableprices').val();
	var pricededuction=$('#pricededuction').val();
	var begintime=$('#begintime').val();
	var endtime=$('#endtime').val();
	var note=$('#note').val();
	var goodsname=$('#goodsname').val();
	var goodsid=$('#goodsid').val();
	if(ecouponstate==""){
		jAlert("请选择模式","信息提示");
		return false;
	}
	if(ecouponstate=="2" || ecouponstate=="1"){
		if(goodsname=="" || goodsid==""){
			jAlert("请选择商品","信息提示");
			return false;
		}		
	}
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
function eco(){
	var ecouponstate=$('#ecouponstate').val();	
	if(ecouponstate=="3"){		
		
		$('#good').hide();
		return;
	}
	if(ecouponstate=="2"){
	
		$('#good').show();
		return;
	}
	if(ecouponstate=="1"){	
		$('#good').show();
		
		return;
	}	
}