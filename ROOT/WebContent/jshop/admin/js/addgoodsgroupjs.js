var session="true";
var flag=false;
function validatethenpostinfotoaddgoodsgroup(){
	var goodsid=$('#goodsid').val();
	var goodsname=$('#goodsname').val();
	var cashlimit=$('cashlimit').val();		
	var sendpoint=$('#sendpoint').val();	
	var detail=$('#detail').val();
	var state= $('#state').val();
	var begintime=$('#begintime').val();
	var endtime=$('#endtime').val();
	var priceladder=$('#priceladder').val();
	var totalordercount=$('#totalordercount').val();
	var sordercount=$('#sordercount').val();
	var salequantity=$('#salequantity').val();
	var limitbuy=$('#limitbuy').val();
	var cashstate=$('#cashstate').val();
	if(""==goodsid){
		jAlert('商品id不能为空','信息提示');
		return false;
	}
	if(""==cashlimit){
		jAlert('保证金额度不能为空','信息提示');
		return false;
	}
	if(""==state){
		jAlert('状态不能为空','信息提示');
		return false;
	}
	if(""==begintime){
		jAlert('开始时间不能为空','信息提示');
		return false;
	}
	if(""==endtime){
		jAlert('结束时间不能为空','信息提示');
		return false;
	}
	if(""==totalordercount){
		jAlert('总订购数不能为空','信息提示');
		return false;
	}
	if(""==sordercount){
		jAlert('成功订购数不能为空','信息提示');
		return false;
	}
	if(""==salequantity){
		jAlert('可售数量不能为空','信息提示');
		return false;
	}
	if(""==limitbuy){
		jAlert('限购数量不能为空','信息提示');
		return false;
	}
	if(""==cashstate){
		jAlert('保证金制度不能为空','信息提示');
		return false;
	}
	if(""==goodsname){
		jAlert('商品名称不能为空','信息提示');
		return false;
	}
	if(""==sendpoint){
		jAlert('商品积分不能为空','信息提示');
		return false;
	}
	if(""==priceladder){
		jAlert('商品价格不能为空','信息提示');
		return false;
	}
	if(""==detail){
		jAlert('商品说明不能为空','信息提示');
		return false;
	}
	flag=true;
}


$(function(){
	$('#add').click(function(){
		validatethenpostinfotoaddgoodsgroup();
		$('#add').show();
		if(flag){
		var goodsid=$('#goodsid').val();
		var goodsname=$('#goodsname').val();
		var cashlimit=$('cashlimit').val();		
		var sendpoint=$('#sendpoint').val();	
		var detail=$('#detail').val();
		var state= $('#state').val();
		var begintime=$('#begintime').val();
		var endtime=$('#endtime').val();
		var priceladder=$('#priceladder').val();
		var totalordercount=$('#totalordercount').val();
		var sordercount=$('#sordercount').val();
		var salequantity=$('#salequantity').val();
		var limitbuy=$('#limitbuy').val();
		var cashstate=$('#cashstate').val();
		$.post("addGoodsGroupT.action",{"priceladder":priceladder,"totalordercount":totalordercount,"sordercount":sordercount,"salequantity":salequantity,"cashstate":cashstate,"limitbuy":limitbuy,"endtime":endtime,"state":state,"begintime":begintime,"goodsid":goodsid,"goodsname":goodsname,"detail":detail,"sendpoint":sendpoint,"cashlimit":cashlimit},function(data){
			if(data.goodsgroup){
				jAlert('添加成功','信息提示');
				window.location.href='goodsgroupmanagement.jsp?session'+session+"#goods";
			}else{
				jAlert('添加失败','信息提示');
				return false;
			}
		});
		}else{ return false;}
	});
	
});
$(function(){	
	var groupid=$.query.get('groupid');
	if(groupid==null){
		return false;		
	}
	$.post("findGoodsGroupById.action",{"groupid":groupid},function(data){
		$('#goodsid').attr("value",data.groupList.goodsid);
		$('#goodsname').attr("value",data.groupList.goodsname);
		$('#begintime').attr("value",data.groupList.begintime);
		$('#endtime').attr("value",data.groupList.endtime);
		$('#detail').attr("value".data.groupList.detail);
		$('#sendpoint').attr("value",data.groupList.sendpoint);
		$('#cashlimt').attr("value",data.groupList.cashlimit);
		$('#cashstate').attr("value",data.groupList.cashstate);
		$('#limitbuy').attr("value",data.groupList.limitbuy);
		$('#state').attr("value",data.groupList.state);
		$('#salequantity').attr("value",data.groupList.salequantity);
		$('#sordercount').attr("value",data.groupList.sordercount);
		$('#totalordercount').attr("value",data.groupList.totalordercount);
		$('#priceladder').attr("value",data.groupList.priceladder);
		$('#update').show();
		$('#add').hide();
		return;			
	});
	$('#update').click(function(){
		validatethenpostinfotoaddgoodsgroup();
		if(flag){
			var goodsid=$('#goodsid').val();
			var goodsname=$('#goodsname').val();
			var cashlimit=$('cashlimit').val();		
			var sendpoint=$('#sendpoint').val();	
			var detail=$('#detail').val();
			var state= $('#state').val();
			var begintime=$('#begintime').val();
			var endtime=$('#endtime').val();
			var priceladder=$('#priceladder').val();
			var totalordercount=$('#totalordercount').val();
			var sordercount=$('#sordercount').val();
			var salequantity=$('#salequantity').val();
			var limitbuy=$('#limitbuy').val();
			var cashstate=$('#cashstate').val();
		$.post("updateGoodsGroup.action",{"priceladder":priceladder,"totalordercount":totalordercount,"sordercount":sordercount,"salequantity":salequantity,"cashstate":cashstate,"limitbuy":limitbuy,"endtime":endtime,"state":state,"begintime":begintime,"goodsid":goodsid,"goodsname":goodsname,"detail":detail,"sendpoint":sendpoint,"cashlimit":cashlimit},function(data){
			if(data.goodsgroup){
				jAlert('添加成功','信息提示');
				window.location.href='goodsgroupmanagement.jsp?session'+session+"#goods";
			}else{
				jAlert('添加失败','信息提示');
				return false;
			}
		});
		}else{ return false;}
	});
});