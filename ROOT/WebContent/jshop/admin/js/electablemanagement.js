
/**
 * Global variables
 */
var session="true";
var rid="";
var globalrjson="";//post json data to backstage server
/*===========================================Gorgeous split-line==============================================*/

/**
 * Function
 */
/*
 * To obtain random rid
 */
function getIdforradom(){
	var myDate=new Date();
	rid="1"+myDate.getSeconds().toString()+myDate.getMilliseconds().toString();
}
/*
 * Delete Page elements According to rid 
 */
function delParamPChild(rid){
	$('#add'+rid).remove();
}
/*===========================================Gorgeous split-line==============================================*/
$(function(){
	$.post("getAllTableT.action",function(data){
		if(data.sucflag){
			;
		}
	});
});
/*===========================================Gorgeous split-line==============================================*/
/**
 * flexigrid list 
 */
$(function() {
	$("#electablemanagement").flexigrid( {
		url : 'findAllTableT.action',
		dataType : 'json',
		cache : false,
		colModel : [{
			display : '餐桌号码',
			name : 'tableNumber',
			width : 150,
			sortable : true,
			align : 'center'
		}, {
			display : '包房名',
			name : 'roomName',
			width : 350,
			sortable : true,
			align : 'center'
		}, {
			display : '楼层',
			name : 'floor',
			width : 300,
			sortable : true,
			align : 'center'
		}, {
			display : '使用状态',
			name : 'tablestate',
			width : 120,
			sortable : true,
			align : 'center'
		}, {
			display : '创建时间',
			name : 'createtime',
			width : 60,
			sortable : true,
			align : 'center'
		}, {
			display : '创建人',
			name : 'creatorid',
			width : 60,
			sortable : true,
			align : 'center'
		}, {
			display : '备注',
			name : 'note',
			width : 60,
			sortable : true,
			align : 'center'
		}, {
			display : '可容纳人数',
			name : 'nop',
			width : 60,
			sortable : true,
			align : 'center'
		}, {
			display : '实际人数',
			name : 'rnop',
			width : 60,
			sortable : true,
			align : 'center'
		}, {
			display : 'Android设备数量',
			name : 'androidDevicesCount',
			width : 60,
			sortable : true,
			align : 'center'
		} ],
		buttons : [ {
			name : '添加',
			bclass : 'add',
			onpress : action
		}, {
			name:'编辑',
			bclass:'edit',
			onpress:action
		},{
			name : '删除',
			bclass : 'delete',
			onpress : action
		}, {
			name : '标记空闲',
			bclass : 'add',
			onpress : action
		}, {
			name : '标记占用',
			bclass : 'add',
			onpress : action
		}, {
			separator : true
		} ],

		searchitems : [ {
			display : '请选择搜索条件',
			name : 'sc',
			isdefault : true
		}, {
			display : '餐桌号',
			name : 'tableNumber'
		} ],
		sortname : "createtime",
		sortorder : "desc",
		usepager : true,
		title : '餐桌列表',
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
		if (com == '添加') {
			window.location.href = 'addrelectable.jsp?session='+session+"#table";
			return;

		}else if(com=='编辑'){
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						window.location.href = "editelectable.jsp?session=" + session + "#table&tableid=" + str;
						return;
					}
				});
			} else {
				jAlert('请选择一条信息', '信息提示');
				return false;
			}
		}else if (com == '删除') {
			if ($('.trSelected', grid).length > 0) {
				jConfirm('删除商品会同时删除商品对应的规格货品！确定要删除此项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						$.post("delTableT.action", {
							"tableid" : str
						}, function(data) {
							if (data.sucflag) {
								$('#electablemanagement').flexReload();
								jAlert(data.goodsid + '号商品已经删除', '信息提示框');
							}
						});
					}
				});
				return;
			} else {
				jAlert('请选择要删除的信息!', '信息提示');
				return false;
			}
		} else if (com == '标记空闲') {
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定要标记此些项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						var tablestate = "0";
						$.post("updateGoodsbargainprice.action", {
							"tableid" : str,
							"tablestate" : bargainprice
						}, function(data) {
							if (data.sucflag) {
								$('#electablemanagement').flexReload();
								jAlert('操作成功', '信息提示框');
							}
						});
					}
				});
				return;
			} else {
				jAlert('请选择要标记空闲的餐桌!', '信息提示');
				return false;
			}
		} else if (com == '标记占用') {
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定要标记此些项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						var tablestate = "1";
						$.post("updateGoodshotsale.action", {
							"tableid" : str,
							"tablestate" : hotsale
						}, function(data) {
							if (data.sucflag) {
								$('#electablemanagement').flexReload();
								jAlert('操作成功', '信息提示框');
							}
						});
					}
				});
				return;
			} else {
				jAlert('请选择要标记占用的餐桌!', '信息提示');
				return false;
			}
		} 

	}
});
