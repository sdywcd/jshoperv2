//function IFrameResize(){
// 	 var obj = parent.document.getElementById("frm_main"); 
// 	 obj.height = this.document.body.scrollHeight+100; 
// 	}
/**
 * 获取发货是否成功
 * @return
 */
function checkfh(){
	var nodeissuccess=$('#nodeissuccess').text();
	var orderid=$('#nodeouttradeno').text();
	if(nodeissuccess=="T"){
		$.post("CheckFhLocalThenUpdateOrderToShipping.action",{"orderid":orderid},function(data){
			window.location.href="InitOrdersDetail.action?orderid="+data.orderid;
			jAlert('订单发货成功','信息提示');
			
		});
		return;
	}
	if(nodeissuccess=="F"){
		return false;
	}
}