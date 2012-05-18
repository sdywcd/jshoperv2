
var session ="true";
////获取商城基本信息
//$(function(){
//	$.post("CheckLogin.action",function(data){
//		if(data.slogin){
//			top.location.href="jshop/admin/adminlogin.jsp";
//		}
//	});
//});



/**
 * 获取图片关系
 * @param imgId
 * @return
 */

$(function(){
	var imgName=$.query.get('imgName');
	$("#imgrelshipmanagement").flexigrid( {
		url : 'findimgShip.action?imgName='+imgName,
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '序号',
			name : 'imgId',
			width : 100,
			sortable : true,
			align : 'center'
		},{ 
			display:'引用商品',
			name:'usedGoodsname',
			width:315,
			sortable:true,
			align:'center'
		}, {
			display:'引用的自定义页面',
			name:'usedPositionName',
			width:200,
			sortable:true,
			align:'center'
		}],
		buttons : [ {
			name : '返回',
			bclass : 'add',
			onpress : test
		}],

		searchitems : [{
			display:'请选择搜索条件',
			name:'sc',
			isdefault : true
		},{
			display:'商品名称',
			name:'goodsname'
		} ],
		sortname : "createtime",
		sortorder : "desc",
		usepager : true,
		title : '',
		useRp : true,
		rp : 20,
		rpOptions : [ 5, 20, 40, 100 ],
		showTableToggleBtn : true,
		width :'auto',
		height : 200,
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...'

	});
	function test(com, grid) {
		if(com=='返回'){
			history.go(-1);
		}
	}
});



