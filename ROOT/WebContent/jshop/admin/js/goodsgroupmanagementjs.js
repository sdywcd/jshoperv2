var session="true";


$(function() {
	$("#goodsgroupmanagement").flexigrid( {
		url : 'findAllGoodsGroupT.action',
		dataType : 'json',
		cache : false,
		colModel : [{
			display : '商品ID',
			name : 'goodsid',
			width : 150,
			sortable : true,
			align : 'center'
		},{
			display : '商品名称',
			name : 'goodsname',
			width : 150,
			sortable : true,
			align : 'center'
		}, {
			display : '价格',
			name : 'priceladder',
			width : 60,
			sortable : true,
			align : 'center'
		}, {
			display : '积分',
			name : 'sendpoint',
			width :60,
			sortable : true,
			align : 'center'
		}, {
			display : '保证金额度',
			name : 'cashlimit',
			width : 60,
			sortable : true,
			align : 'center'
		}, {
			display : '开始时间',
			name : 'begintime',
			width : 120,
			sortable : true,
			align : 'center'
		}, {
			display : '结束时间',
			name : 'endtime',
			width : 120,
			sortable : true,
			align : 'center'
		}, {
			display : '保证金制度',
			name : 'cashstate',
			width : 60,
			sortable : true,
			align : 'center'
		}, {
			display : '状态',
			name : 'state',
			width : 60,
			sortable : true,
			align : 'center'
		}, {
			display : '限购数量',
			name : 'limitbuy',
			width : 100,
			sortable : true,
			align : 'center'
		}, {
			display : '可卖数量',
			name : 'salequantity',
			width : 110,
			sortable : true,
			align : 'center'
		} , {
			display : '成功卖数',
			name : 'SOrderCount',
			width : 110,
			sortable : true,
			align : 'center'
		} , {
			display : '总数量',
			name : 'totalOrderCount',
			width : 110,
			sortable : true,
			align : 'center'
		} , {
			display : '创建者',
			name : 'creatorid',
			width : 110,
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
		},{
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
		if (com == '添加') {
			window.location.href = 'addgoodsgroupt.jsp?session='+session+"#goods";
			return;

		}else if(com=='编辑'){
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						window.location.href = "addgoodsgroupt.jsp?session=" + session + "#goods&groupid=" + str;
						return;
					}
				});				
			}else if($('.trSelected').length>1){
				jAlert('请不要选择多个','信息提示');
			}else {
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
						$.post("delGoodsGroup.action", {
							"groupid" : str
						}, function(data) {
							if (data.goodsgroup) {
								jAlert( '商品已经删除', '信息提示框');
								//window.location.href='goodsgroupmanagement.jsp?session'+session+"#goods";
								$('#goodsgroupmanagement').flexReload();
								
							}
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
	