/**
 * flexigrid list 
 */
$(function() {
	$("#websitemsgmenagement").flexigrid( {
		url : 'findAllWebsiteByMine.action',
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '标题',
			name : 'title',
			width : 215,
			sortable : true,
			align : 'center'
		}, {
			display : '接受用户名',
			name : 'msgtousername',
			width : 215,
			sortable : true,
			align : 'center'
		}, {
			display : '内容id',
			name : 'msgtextid',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '状态',
			name : 'state',
			width : 215,
			sortable : true,
			align : 'center'
		}, {
			display : '内容状态',
			name : 'msgstate',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '创建时间',
			name : 'createtime',
			width : 105,
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
		}, {
			display : '分类名称',
			name : 'name',
			isdefault : true
		}, {
			display : '分类等级',
			name : 'grade',
			isdefault : true
		} ],
		sortname : "createtime",
		sortorder : "desc",
		usepager : true,
		title : '站内信列表',
		useRp : true,
		rp : 20,
		rpOptions : [ 5, 20, 40, 100 ],
		showTableToggleBtn : true,
		width : 'auto',
		height : 'auto',
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...',
		checkbox:true
	});
	function action(com, grid) {
		if (com == '添加') {
			window.location.href = "addwensitemsg.jsp?session="+session+"#pagecontent";
			return;
		} else if (com == '编辑') {
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						window.location.href = "addarticlecategory.jsp?session="+session+"#pagecontent&articleCategoryTid=" + str;
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
						$.post("delArticleCategoryT.action", {
							"articleCategoryTid" : str
						}, function(data) {
							$('#articlecategorymanagement').flexReload();
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
