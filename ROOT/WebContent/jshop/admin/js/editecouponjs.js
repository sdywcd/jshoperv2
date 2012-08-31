var session=true;
function ons(){
	var ecouponstate=$('#ecouponstate').val();
	if(ecouponstate=="2" || ecouponstate=="1"){
		$('#goods').show();
		$('#goodss').show();
	}else{
		$('#goods').hide();
		$('#goodss').hide();
	}
}
function validate(){
	var ecouponstate=$('#ecouponstate').val();
	var favourableprices=$('#favourableprices').val();
	var pricededuction=$('#pricededuction').val();
	var begintime=$('#begintime').val();
	var endtime=$('#endtime').val();
	var note=$('#note').val();
	var goodsname=$('#goodsname').val();
	var goodsid=$('#goodsid').val();
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
	}if(ecouponstate==""){
		jAlert("请选择模式","信息提示");
		return false;
	}if(ecouponstate=="2" || ecouponstate=="1"){
		if(goodsname=="" || goodsid==""){
			jAlert("请选择商品","信息提示");
			return false;
		}		
		
	}
	a=true;
}
$(function(){
  var eid=$.query.get('eid');
  if(eid==null){
	  return false;
  }
  $.post("findEcoupontById.action",{"eid":eid},function(data){
	  $('#endtime').attr("value",data.bean.endtime);
	  $('#begintime').attr("value",data.bean.begintime);
	  $('#pricededuction').attr("value",data.bean.pricededuction);
	  $('#favourableprices').attr("value",data.bean.favourableprices);
	  $('#note').attr("value",data.bean.note);
	  $('#eid').attr("value",data.bean.eid);
	  $('#goodsname').attr("value",data.bean.goodsname);
	  $('#goodsid').attr("value",data.bean.goodsid);
	  if("1"==data.bean.state){
		  $('#state').attr("checked","checked");
	  }else{
		  $('#state').attr("checked","");
	  }
	  if("3"==data.bean.ecouponstate){
		 
		  $('#ecouponstate').attr("value","3");
		  $('#goods').hide();
		  $('#goodss').hide();

	  }
	  if("2"==data.bean.ecouponstate){
		 
		  $('#ecouponstate').attr("value","2");
		  $('#goods').show();
		  $('#goodss').show();
	  }
	  if("1"==data.bean.ecouponstate){
		 
		  $('#ecouponstate').attr("value","1");
		  $('#goods').show();
		  $('#goodss').show();
	  }
  });
  $('#update').click(function(){
		validate();
		if(a){
		var ecouponstate=$('#ecouponstate').val();
		var favourableprices=$('#favourableprices').val();
		var pricededuction=$('#pricededuction').val();
		var begintime=$('#begintime').val();
		var endtime=$('#endtime').val();
		var note=$('#note').val();
		var eid=$('#eid').val();
		var goodsname=$('#goodsname').val();
		var goodsid=$('#goodsid').val();
		var state=$("input[name='state']:checked").val();
		$.post("updateEcouponT.action",{"goodsid":goodsid,"goodsname":goodsname,"eid":eid,"state":state,"ecouponstate":ecouponstate,"favourableprices":favourableprices,"pricededuction":pricededuction,"begintime":begintime,"endtime":endtime,"note":note},function(data){
			if(data.flag){
				jAlert("修改成功","信息提示");
				window.location.href='ecoupontmanagement.jsp?session' +session+ "#goods";
			
				return ;
			}
		});
		}
	});
  });