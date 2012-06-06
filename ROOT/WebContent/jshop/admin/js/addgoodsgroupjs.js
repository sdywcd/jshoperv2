$(function(){
	$('#add').click(function(){
		var goodsid=$('#goodsid').val();
		var goodsname=$('#goodsname').val();
		var creatorid=$('#creatorid').val();
		var sendpoint=$('#sendpoint').val();
		var priceladder=$('#priceladder').val();
		var detail=$('#detail').val();
		$.post("addGoodsGroupT.action",{"goodsid":goodsid,"goodsname":goodsname,"detail":detail,"priceladder":priceladder,"sendpoint":sendpoint,"creatorid":creatorid});
	});
});