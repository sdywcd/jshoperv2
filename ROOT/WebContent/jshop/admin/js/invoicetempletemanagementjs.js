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

/**
 * flexigrid list
 */
$(function() {
	$("#invoicetempletemanagement").flexigrid( {
		url : 'findAllInvoicetempleteT.action',
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '发货单模板编号',
			name : 'invoicetempleteid',
			width : 215,
			sortable : true,
			align : 'center'
		}, {
			display : '状态',
			name : 'state',
			width : 114,
			sortable : true,
			align : 'center'

		} ],
		buttons : [ {
			name : '添加',
			bclass : 'add',
			onpress : action
		}, {
			name : '编辑',
			bclass : 'edit',
			onpress : action
		}, {
			name : '删除',
			bclass : 'delete',
			onpress : action
		}, {
			separator : true
		} ],

		searchitems : [ {
			display : '请选择搜索条件',
			name : 'sc',
			isdefault : true
		} ],
		sortname : "createtime",
		sortorder : "desc",
		usepager : true,
		title : '发货单模板列表',
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
		if (com == '添加') {
			window.location.href = "invoicetempleteset.jsp";
			return;

		} else if (com == '编辑') {
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						window.location.href = "invoicetempleteupdate.jsp?session=" + session + "#settings&invoicetempleteid=" + str;
						return;
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
						$.post("DelInvoiceTemplete.action", {
							"invoicetempleteid" : str
						}, function(data) {
							$('#invoicetempletemanagement').flexReload();
						});
					}
				});
				return;
			} else {
				jAlert('请选择要删除的信息!', '信息提示');
				return false;
			}
		}
	}

});
