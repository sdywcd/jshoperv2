//function IFrameResize(){
// 	 var obj = parent.document.getElementById("frm_main"); 
// 	 obj.height = this.document.body.scrollHeight+100; 
// 	}

$(function() {

	var orderid=$.query.get('orderid');
	$.post("InitPrintInvoice.action",{"orderid":orderid},function(data){
		if(data.sprintinvoiceflag){
			$("body").html(data.pi.kindeditorCode);
			$("#hiddiv").html(data.pi.kindeditorCode);
			var detailgoodsarea=$("#hiddiv").find("#detailgoodsarea");
			
			$("#purchasetime").append(data.pi.purchasetime);
			$("#orderid").append(data.pi.orderid);
			$("#hasprintfpinvoice").append(data.pi.hasprintfpinvoice);
			$("#amount").text(data.pi.amount);
			$("#shouldpay").text(data.pi.shouldpay);
			$("#freight").text(data.pi.freight);
			$("#invoicenumber").append(data.pi.invoicenumber);
			$("#shippingusername").append(data.pi.shippingusername);
			$("#country").text(data.pi.country+",省:"+data.pi.province+",市:"+data.pi.city);
			//$("#province").append(data.pi.province);
			//$("#city").append(data.pi.city);
			$("#district").text(data.pi.district+",邮政编码:"+data.pi.postcode);
			$("#street").append(data.pi.street);
			//$("#postcode").append(data.pi.postcode);
			var trtd="";
			$.each(data.invoicerows,function(n,value){

		           var tr="<tr>" +
		           		"<td id='id'>"+n+"</td>" +
		           		"<td id='goodsname' colspan='2'>"+value.goodsname+"</td>"+
		           		"<td id='usersetnum'>"+value.usersetnum+"</td>"+
		           		"<td id='favorable'>"+value.favorable+"</td>"+
		           		"<td id='needquantity'>"+value.needquantity+"</td>"+
		           		"<td id='subtotal'>"+value.subtotal+"</td>"+
		           		"</tr>";
		           trtd+=tr;
		    });
			$("#afterappend").after(trtd);
		}
	});
	
	
	
	function changeCss(){
		$("#sendname").css("border","0");   
	}
});
