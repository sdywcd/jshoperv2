
$(function(){
	//确认按钮点击事件
$('#confirm_electronicorder').click(function(){
	var tableNumber= $('#hidtablenumber').val();
	$.post("ConfirmedOrderElectronic.action",{"tableNumber":tableNumber},function(){
		window.location.href="GetElectronicOrderInternation.action?tableNumber="+tableNumber;
	});
});

//菜已上齐
$('#vegetable_electronicorder').click(function(){
	var tableNumber= $('#hidtablenumber').val();
	$.post("VegetablesAllOrderElectronic.action",{"tableNumber":tableNumber},function(){
		window.location.href="GetElectronicOrderInternation.action?tableNumber="+tableNumber;
	});
});
//付款
$('#pay_electronicorder').click(function(){
	var tableNumber= $('#hidtablenumber').val();
	$.post("updateElectronicOrderPaystate.action",{"tableNumber":tableNumber},function(){
		window.location.href="GetElectronicOrderInternation.action?tableNumber="+tableNumber;
	});
});
});