
/**
 * Global variables
 */
var session="true";
/*===========================================Gorgeous split-line==============================================*/

/**
 * flexigrid list 
 */
$(function() {
	$("#goodsmanagement").flexigrid( {
		url : 'findAllGoods.action',
		dataType : 'json',
		cache : false,
		colModel : [{
			display : '商品名称',
			name : 'goodsname',
			width : 500,
			sortable : true,
			align : 'center'
		}, {
			display : '商品编号',
			name : 'usersetnum',
			width : 150,
			sortable : true,
			align : 'center'
		},{
			display : '会员价',
			name : 'memberprice',
			width : 120,
			sortable : true,
			align : 'center'
		}],
		buttons : [ {
			name:'确定',
			bclass:'edit',
			onpress:action
		}, {
			separator : true
		} ],

		searchitems : [ {
			display : '请选择搜索条件',
			name : 'sc',
			isdefault : true
		}, {
			display : '商品名称',
			name : 'goodsname'
		} ],
		sortname : "createtime",
		sortorder : "desc",
		usepager : true,
		title : '商品列表',
		useRp : true,
		rp : 20,
		rpOptions : [ 5, 20, 40, 100 ],
		showTableToggleBtn : true,
		showToggleBtn : true,
		width : 'auto',
		height : 'auto',
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...',
		checkbox:true
	});
	function action(com, grid) {
		if(com=='确定'){
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						$.post("findGoodsById.action",{"goodsid":str},function(data){
							if(data.sucflag){	
							$('#goodsname').attr("value",data.bean.goodsname);
							$('#goodsid').attr("value",data.bean.goodsid);
							return;
							}
						});
						return;
					}
				});
			} else {
				jAlert('请选择一条信息', '信息提示');
				return false;
			}
		}
	}
});
