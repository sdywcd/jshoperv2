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
	//var totalordercount=$('#totalordercount').val();
	
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
		var goodsid="0";
		var goodsname=$('#goodsname').val();
		var cashlimit=$('#cashlimit').val();		
		var sendpoint=$('#sendpoint').val();	
		var detail=$('#detail').val();
		var state= $('#state').val();
		var begintime=$('#begintime').val();
		var endtime=$('#endtime').val();
		var priceladder=$('#priceladder').val();
	//	var totalordercount=$('#totalordercount').val();
		//var sordercount=$('#sordercount').val();
		var salequantity=$('#salequantity').val();
		var limitbuy=$('#limitbuy').val();
		var cashstate=$('#cashstate').val();		
		//获取商品图片路径集合
		var pictureurl="";
		$(":checkbox[name='pcpath'][checked=true]").each(function(){
			pictureurl+=this.value+",";
		});		
		$.post("addGoodsGroupT.action",{"pictureurl":pictureurl,"priceladder":priceladder,"salequantity":salequantity,"cashstate":cashstate,"limitbuy":limitbuy,"endtime":endtime,"state":state,"begintime":begintime,"goodsid":goodsid,"goodsname":goodsname,"detail":detail,"sendpoint":sendpoint,"cashlimit":cashlimit},function(data){
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
		
		$('#goodsname').attr("value",data.groupList.goodsname);
		$('#begintime').attr("value",data.groupList.begintime);
		$('#endtime').attr("value",data.groupList.endtime);
		KE.html("detail",data.groupList.detail);
		$('#sendpoint').attr("value",data.groupList.sendpoint);
		$('#cashlimit').attr("value",data.groupList.cashlimit);
		$('#cashstate').attr("value",data.groupList.cashstate);
		$('#limitbuy').attr("value",data.groupList.limitbuy);
		$('#state').attr("value",data.groupList.state);
		$('#salequantity').attr("value",data.groupList.salequantity);
	//	$('#sordercount').attr("value",data.groupList.sordercount);
		//$('#totalordercount').attr("value",data.groupList.totalordercount);
		$('#priceladder').attr("value",data.groupList.priceladder);
		//图片显示
		var pcpath="";
		var pcurl=data.groupList.pictureurl;
		var htm="";
		var checkpc="";
		var temp=pcurl.split(',');
		var allpcpath="";
		$.each(temp,function(n,value){
			if(""==value){
				return;
			}
			pcpath=value;
			htm="<img id='"+value+"' src='"+pcpath+"'></img>";
			checkpc="<input id='"+value+"' name='pcpath' type='checkbox' value='"+value+"' checked/>";
			allpcpath=htm+checkpc;
			$('#triggers').append(allpcpath);
		});
		$('#update').show();
		$('#add').hide();
		return;			
	});
	$('#update').click(function(){
		validatethenpostinfotoaddgoodsgroup();
		if(flag){
			
			var goodsname=$('#goodsname').val();
			var cashlimit=$('#cashlimit').val();		
			var sendpoint=$('#sendpoint').val();	
			var detail=$('#detail').val();
			var state= $('#state').val();
			var begintime=$('#begintime').val();
			var endtime=$('#endtime').val();
			var priceladder=$('#priceladder').val();
			//var totalordercount=$('#totalordercount').val();
		//	var sordercount=$('#sordercount').val();
			var salequantity=$('#salequantity').val();
			var limitbuy=$('#limitbuy').val();
			var cashstate=$('#cashstate').val();
			//获取商品图片路径集合
			var pictureurl="";
			$(":checkbox[name='pcpath'][checked=true]").each(function(){
				pictureurl+=this.value+",";
			});		
		$.post("updateGoodsGroup.action",{"pictureurl":pictureurl,"priceladder":priceladder,"salequantity":salequantity,"cashstate":cashstate,"limitbuy":limitbuy,"endtime":endtime,"state":state,"begintime":begintime,"goodsname":goodsname,"detail":detail,"sendpoint":sendpoint,"cashlimit":cashlimit},function(data){
			if(data.goodsgroup){
				jAlert('修改成功','信息提示');
				window.location.href='goodsgroupmanagement.jsp?session'+session+"#goods";
			}else{
				jAlert('修改失败','信息提示');
				return false;
			}
		});
		}else{ return false;}
	});
});
//获取图片删除按钮并删除图片
$(function(){
	$("#delpc").click(function(){
		var str="";
		var sum=0;
		$(":checkbox[name='pcpath'][checked=true]").each(function(){
			sum++;
			str=this.value;
		});
		if(sum==0){
			jAlert('只有在选择图片后才能删除', '信息提示');
			return false;
		}
		if(sum>1){
			jAlert('不能选择多个图片', '信息提示');
			return false;
		}
		$('#triggers img').each(function(){
			if(this.id==str){
				this.style.display="none";
				$(":checkbox[name='pcpath'][checked=true]").each(function(){
					if(this.value==str){
						this.style.display="none";
						this.name="dispcpath";
					}
				});
			}
		});  

	});
});