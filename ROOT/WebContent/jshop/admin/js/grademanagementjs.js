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
						var str =$('.trSelected', grid)[0].id.substr(3);
						window.location.href="addgrade.jsp?session="+session+"#member&gradeid="+str;
                        return;
					}
				});
				return;
			} else {
				jAlert('请选择一条信息', '信息提示');
                return false;
			}

		}else if(com=="添加"){
            window.location.href="addgrade.jsp?session="+session+"#member";
            return;
        }else if(com=="删除"){
            
        }
	}
});
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
/**
 * Add Function
 */
$(function(){
    $("#submit").click(function(){
        var gradename = $("#gradename").val();
        var needcost = $("#needcost").val();
        var discount = $("#discount").val();
        
        $.post("addGradet.action",{
            "gradename":gradename,
            "needcost":needcost,
            "discount":discount
        },function(data){
            if(data.sucflag){
                window.location.href="grademanagement.jsp?session="+session+"#member";
            }
        });
    });
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
    var gradeid=$.query.get("gradeid");
    if(gradeid==""){
        return false;
    }
    $.post("findGradeById.action",{"gradeid":gradeid},function(data){
        if(data.sucflag){
            $("#gradename").val(data.bean.gradename);
            $("#needcost").val(data.bean.needcost);
            $("#discount").val(data.bean.discount);
            $("#gradeid").val(data.bean.gradeid);
            $("#editgrade").show();
            $("#submit").hide();
        }
    });
    
	$("#editgrade").click(function() {
		var gradename = $("#gradename").val();
        var needcost = $("#needcost").val();
        var discount = $("#discount").val();
		var gradeid = $("#gradeid").val();
		$.post("UpdateGradeById.action", {
			"gradeid" : gradeid,
			"gradename" : gradename,
			"needcost" : needcost,
			"discount" : discount
		}, function(data) {
			 if(data.sucflag){
                window.location.href="grademanagement.jsp?session="+session+"#member";
            }
		});
	});
});
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
