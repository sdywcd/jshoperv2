//function IFrameResize(){
// 	 var obj = parent.document.getElementById("frm_main"); 
// 	 obj.height = this.document.body.scrollHeight+100; 
// 	}
$(function(){
	var invoicetempleteid=$.query.get('invoicetempleteid');
	$.post("findInvoicetempleteById.action",{"invoicetempleteid":invoicetempleteid},function(data){
		KE.html("invoiceCode",data.beanlist.kindeditorCode);
		$('#hidinvoicetempleteid').val(data.beanlist.invoicetempleteid);
	});
});

$(function(){
	var invoiceCode="";
	/**
	 *更新操作
	 */
	$("#submit").click(function(){
		invoiceCode=KE.html("invoiceCode");
		var invoicetempleteid=$('#hidinvoicetempleteid').val();
		$.post("UpdateInvoicetempleteT.action",{"invoiceCode":invoiceCode,"invoicetempleteid":invoicetempleteid,"state":"1"},function(data){
			window.location.href="jshop/admin/order/invoicetempletemanagement.jsp";
			return;
		});
	});
});
