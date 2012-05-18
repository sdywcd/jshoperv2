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
	$("#h-menu-member").addClass("selected");
	$("#menu-member").removeClass("closed");
	$("#menu-member").addClass("opened");
});
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
/**
 * Required to initialize the page data
 */
$(function() {
	$('#gradevalue').change(function() {
		var gradevalue = $("#gradevalue").val();
		if (gradevalue == "0") {
			return false;
		}
		var gradename = $("#gradevalue").find("option:selected").text();
		$('#gradename').attr("value", gradename);

	});

});
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */

/**
 * flexigrid list
 */
$(function() {

	$("#grademanagement").flexigrid( {
		url : 'findAllGrade.action',
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '等级名称',
			name : 'gradename',
			width : 315,
			sortable : true,
			align : 'center'
		}, {
			display : '购物金额要求',
			name : 'needcost',
			width : 315,
			sortable : true,
			align : 'center'
		}, {
			display : '折扣',
			name : 'discount',
			width : 115,
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
		} ],
		buttons : [ {
			name : '编辑',
			bclass : 'edit',
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
		title : '会员等级列表',
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
			if ($('.trSelected', grid).length ==1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						$('#submit').hide();
						$('#editgrade').show();
						$.post("findGradeById.action", {
							"gradeid" : str
						}, function(data) {
							$('#gradevalue').val(data.beanlist.gradevalue);
							$('#needcost').attr("value", data.beanlist.needcost);
							$('#discount').attr("value", data.beanlist.discount);
							$('#gradeid').attr("value", data.beanlist.gradeid);
							return;
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
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
/**
 * Update Function
 */
// 点击编辑更新内容
$(function() {
	$("#editgrade").click(function() {
		var gradevalue = $("#gradevalue").val();
		var gradename = $("#gradevalue").find("option:selected").text();
		var needcost = $("#needcost").val();
		var discount = $("#discount").val();
		var gradeid = $("#gradeid").val();
		$.post("UpdateGradeById.action", {
			"gradeid" : gradeid,
			"gradevalue" : gradevalue,
			"gradename" : gradename,
			"needcost" : needcost,
			"discount" : discount
		}, function(data) {
			$('#grademanagement').flexReload();
		});
	});
});
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
