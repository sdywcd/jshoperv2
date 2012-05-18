//function IFrameResize(){
// 	 var obj = parent.document.getElementById("frm_main"); 
// 	 obj.height = this.document.body.scrollHeight+100; 
// 	}

$(function() {

	var orderid=$.query.get('orderid');
	$.post("InitPrintExpress.action",{"orderid":orderid},function(data){
		if(data.sprintexpressflag){
			$("body").html(data.pe.kindeditorCode);
			$("#sendname").text(data.pe.sendName);
			$("#sendcountry").text(data.pe.sendCountry);
			$("#sendprovince").text(data.pe.sendProvince);
			$("#senddistrict").text(data.pe.sendDistrict);
			$("#sendstreet").text(data.pe.sendStreet);
			$("#sendtelno").text(data.pe.sendTelno);
			$("#sendmobile").text(data.pe.sendMobile);
			$("#sendcontactor").text(data.pe.sendContactor);
			$("#quantity").text(data.pe.quantity);
			
			$("#recipientname").text(data.pe.recipientName);
			$("#recipientcountry").text(data.pe.recipientCountry);
			$("#recipientprovince").text(data.pe.recipientProvince);
			$("#recipientcity").text(data.pe.recipientCity);
			$("#recipientdistrict").text(data.pe.recipientDistrict);
			$("#recipientstreet").text(data.pe.recipientStreet);
			$("#recipienttelno").text(data.pe.recipientTelno);
			$("#recipientmobile").text(data.pe.recipientMobile);
			$("#recipientpostcode").text(data.pe.recipientPostcode);
			$("#recipientcontactor").text(data.pe.recipientContactor);
			
			$("#notes").text(data.pe.notes);
			$("#year").text(data.pe.year);
			$("#month").text(data.pe.month);
			$("#day").text(data.pe.day);
			$("#hour").text(data.pe.hour);
			$("#minutes").text(data.pe.minutes);
			$("#righttag").text(data.pe.righttag);
			
			
		}
	});
	
	
	
	function changeCss(){
		$("#sendname").css("border","0");   
	}
});
