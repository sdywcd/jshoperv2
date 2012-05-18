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

// 点击编辑更新内容
$(function() {
	$("#editlogistics").click(function() {
		var logisticsid = $("#logisticsid").val();
		var logisticsname = $('#logisticsname').val();
		var city = $('#city').val();
		var contractor = $('#contractor').val();
		var telno = $('#telno').val();
		var faxno = $('#faxno').val();
		var email = $('#email').val();
		var address = $('#address').val();
		var receiver = $('#receiver').val();
		var bankaccount = $('#bankaccount').val();
		var bankaddress = $('#bankaddress').val();
		var insure = $('#insure').val();
		var isCod = $('#isCod').val();
		var state = $('#state').val();
		var visible = $('#visible').val();
		var des = $('#des').val();
		var website = $('#website').val();
		$.post("UpdateLogisticsBusiness.action", {
			"logisticsid" : logisticsid,
			"logisticsname" : logisticsname,
			"city" : city,
			"contractor" : contractor,
			"telno" : telno,
			"faxno" : faxno,
			"email" : email,
			"address" : address,
			"receiver" : receiver,
			"bankaccount" : bankaccount,
			"bankaddress" : bankaddress,
			"insure" : insure,
			"isCod" : isCod,
			"state" : state,
			"visible" : visible,
			"des" : des,
			"website" : website
		}, function(data) {
			$('#logisticsmanagement').flexReload();
		});
	});
});

/**
 * flexigrid list
 */
$(function() {
	$("#logisticsmanagement").flexigrid( {
		url : 'findAllLogisticsBusiness.action',
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '物流商名称',
			name : 'logisticsname',
			width : 315,
			sortable : true,
			align : 'center'
		}, {
			display : '所属城市',
			name : 'city',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '联系人',
			name : 'contractor',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '座机',
			name : 'telno',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '传真',
			name : 'faxno',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '邮箱',
			name : 'email',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '地址',
			name : 'address',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '收款人',
			name : 'receiver',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '银行账号',
			name : 'bankaccount',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '所属银行',
			name : 'bankaddress',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '是否支持保价',
			name : 'insure',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '是否支持货到付款',
			name : 'iscod',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '是否默认显示',
			name : 'visible',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '描述',
			name : 'des',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '使用状态',
			name : 'state',
			width : 100,
			sortable : true,
			align : 'center'

		}, {
			display : '创建时间',
			name : 'createtime',
			width : 214,
			sortable : true,
			align : 'center'

		}, {
			display : '创建者编号',
			name : 'creatorid',
			width : 200,
			sortable : true,
			align : 'center'

		}, {
			display : '网址',
			name : 'website',
			width : 300,
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
			name : '设置配送区域及运费',
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
			display : '物流商名称',
			name : 'logisticsname'
		} ],
		sortname : "createtime",
		sortorder : "desc",
		usepager : true,
		title : '物流商列表',
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
						$('#editlogistics').show();
						$.post("findLogisticsBusinessById.action", {
							"logisticsid" : str
						}, function(data) {
							$('#logisticsid').attr("value", data.beanlist.logisticsid);
							$('#logisticsname').attr("value", data.beanlist.logisticsname);
							$('#city').attr("value", data.beanlist.city);
							$('#contractor').attr("value", data.beanlist.contractor);
							$('#telno').attr("value", data.beanlist.telno);
							$('#faxno').attr("value", data.beanlist.faxno);
							$('#email').attr("value", data.beanlist.email);
							$('#address').attr("value", data.beanlist.address);
							$('#receiver').attr("value", data.beanlist.receiver);
							$('#bankaccount').attr("value", data.beanlist.bankaccount);
							$('#bankaddress').attr("value", data.beanlist.bankaddress);
							$('#insure').val(data.beanlist.insure);
							$('#isCod').val(data.beanlist.isCod);
							$('#des').attr("value", data.beanlist.des);
							$('#website').attr("value", data.beanlist.website);
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
						$.post("DelLogisticsBusiness.action", {
							"logisticsid" : str
						}, function(data) {
							$('#logisticsmanagement').flexReload();

						});
					}
				});
				return;
			} else {
				jAlert('请选择要删除的信息!', '信息提示');
				return false;
			}
		} else if (com == '设置配送区域及运费') {
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						window.location.href = "logisticsareamanagement.jsp?session=" + session + "#settings&logisticsid=" + str + "";
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
