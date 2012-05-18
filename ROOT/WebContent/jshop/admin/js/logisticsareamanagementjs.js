/**
 * Global variables
 */
var session = "true";
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
/**
 * ui
 */
$(function() {

	$("h6").each(function() {
		$(this).removeClass("selected");
	});
	$("ul").each(function() {
		$(this).removeClass("opened");
		$(this).addClass("closed");
	});
	$("#h-menu-settings").addClass("selected");
	$("#menu-settings").removeClass("closed");
	$("#menu-settings").addClass("opened");
});
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */

// 获取物流商id
$(function() {
	var logisticsid = $.query.get('logisticsid');
	$('#logisticsid').attr("value", logisticsid);
});

/**
 * flexigrid list
 */
$(function() {
	$("#logisticsareamanagement").flexigrid( {
		url : 'findAllLogisticsbusinessareaT.action',
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '物流商范围',
			name : 'areaname',
			width : 215,
			sortable : true,
			align : 'center'
		}, {
			display : '费用计算模式',
			name : 'costway',
			width : 215,
			sortable : true,
			align : 'center'
		}, {
			display : '最小购物金额',
			name : 'needcostmin',
			width : 215,
			sortable : true,
			align : 'center'
		}, {
			display : '最大购物金额',
			name : 'needcostmax',
			width : 215,
			sortable : true,
			align : 'center'
		}, {
			display : '标准费用',
			name : 'normalcost',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '超标重量值（kg）',
			name : 'overvalue',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '超标费用',
			name : 'overcost',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '配送范围',
			name : 'sendarea',
			width : 115,
			sortable : true,
			align : 'center'
		} ],
		buttons : [ {
			name : '编辑',
			bclass : 'edit',
			onpress : action
		}, {
			name : '删除',
			bclass : 'delete',
			onpress : action
		}, {
			name : '启用区域价格',
			bclass : 'edit',
			onpress : action
		}, {
			name : '禁用区域价格',
			bclass : 'edit',
			onpress : action
		}, {
			separator : true
		} ],

		searchitems : [ {
			display : '请选择搜索条件',
			name : 'sc',
			isdefault : true
		}, {
			display : '配送范围',
			name : 'sendarea'
		} ],
		sortname : "createtime",
		sortorder : "desc",
		usepager : true,
		title : '物流商区域价格列表',
		useRp : true,
		rp : 20,
		rpOptions : [ 5, 20, 40, 100 ],
		showTableToggleBtn : true,
		width : 'auto',
		height : 'auto',
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...',
		checkbox : true
	});

	function action(com, grid) {
		if (com == '编辑') {
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						$('#submit').hide();
						$('#editlogisticsarea').show();
						$.post("findLogisticsbusinessareaTById.action", {
							"logbusareaid" : str
						}, function(data) {
							$('#logbusareaid').attr("value", data.beanlist.logbusareaid);
							$('#areaname').val(data.beanlist.areaname);
							$('#costway').val(data.beanlist.costway);
							$('#normalcost').attr("value", data.beanlist.normalcost);
							$('#overvalue').attr("value", data.beanlist.overvalue);
							$('#overcost').attr("value", data.beanlist.overcost);
							$('#freecount').attr("value", data.beanlist.freecount);
							$('#sendarea').attr("value", data.beanlist.sendarea);
							return;
						});
					}
				});
			} else {
				jAlert('请选择一条信息', '信息提示');
				return false;
			}
		} else if (com == '删除') {
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定删除此项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						$.post("DelLogisticsbusinessarea.action", {
							"logbusareaid" : str
						}, function(data) {
							$('#logisticsareamanagement').flexReload();

						});
					}
				});
				return;
			} else {
				jAlert('请选择要删除的信息!', '信息提示');
				return false;
			}
		} else if (com == '启用区域价格') {
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定启用此项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						$.post("UpdateLogisticsbusinessareaBystate.action", {
							"logbusareaid" : str,
							"state" : "1"
						}, function(data) {
							$('#logisticsareamanagement').flexReload();

						});
					}
				});
				return;
			} else {
				jAlert('请选择要启用的信息!', '信息提示');
				return false;
			}
		} else if (com == '禁用区域价格') {
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定禁用此项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						$.post("UpdateLogisticsbusinessareaBystate.action", {
							"logbusareaid" : str,
							"state" : "0"
						}, function(data) {
							$('#logisticsareamanagement').flexReload();

						});
					}
				});
				return;
			} else {
				jAlert('请选择要禁用的信息!', '信息提示');
				return false;
			}

		}
	}

});
