
/**
 * Global variables
 */
var session ="true";
/*===========================================Gorgeous split-line==============================================*/

/**
 * ui
 */
$(function(){
	$("h6").each(function(){
		$(this).removeClass("selected"); 
	});
	$("ul").each(function(){
		$(this).removeClass("opened"); 
		$(this).addClass("closed"); 
	});
	$("#h-menu-settings").addClass("selected");
	$("#menu-settings").removeClass("closed"); 
	$("#menu-settings").addClass("opened");

});
/*===========================================Gorgeous split-line==============================================*/
/**
 * Required to initialize the page data
 */
$(function(){
	/**
	 * 获取模块下拉列表
	 */
	$.post("findAllModuleForselect.action", function(data) {
		if (data.sucflag) {
			$('#moduleid').append(data.moduleselectstr);	
		}
	});

});



/**
 * flexigrid list 
 */

$(function() {
	var moduleid=$.query.get('moduleid');
	$("#functionmanagement").flexigrid( {
		url : 'findAllFunctionMBymoduleid.action?moduleid='+moduleid,
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '功能名称',
			name : 'functionname',
			width : 215,
			sortable : true,
			align : 'center'
		},{
			display : '可访问路径',
			name : 'visiturl',
			width : 415,
			sortable : true,
			align : 'center'
		}, {
			display : '可访问方法',
			name : 'visitmethodname',
			width : 215,
			sortable : true,
			align : 'center'
		}, {
			display : '创建时间',
			name : 'createtime',
			width : 214,
			sortable : true,
			align : 'center'

		}],
		buttons : [ {
			name : '添加功能',
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
		title : '功能列表',
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
		if (com == '添加功能') {
			window.location.href = "addfunction.jsp?session="+session+"#settings";
			return;

		} else if (com == '编辑') {
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						window.location.href = "addfunction.jsp?session="+session+"#settings&id=" + str;
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
						$.post("delFunctionM.action", {
							"id" : str
						}, function(data) {
							$('#functionmanagement').flexReload();
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
/*===========================================Gorgeous split-line==============================================*/
/**
 * Add Function
 */

/**
 * 增加模块功能
 */
$(function(){
	$('#submit').click(function(){
		var moduleid=$('#moduleid').val();
		if(moduleid=="0"){
			jAlert('功能所属系统模块必须选择', '信息提示');
			return false;
		}
		var functionname=$('#functionname').val();
		var visiturl=$('#visiturl').val();
		var visitmethodname=$('#visitmethodname').val();
		$.post("addFunctionM.action",{"moduleid":moduleid,"functionname":functionname,"visiturl":visiturl,"visitmethodname":visitmethodname},function(data){
			if(data.sucflag){
				window.location.href="functionmanagement.jsp?session="+session+"#pagecontent";
			}else{
				jAlert('系统模块功能增加失败', '信息提示');
				return false;
			}
		});
	});	
});
/*===========================================Gorgeous split-line==============================================*/
/**
 * Update Function
 */
$(function(){
	var id=$.query.get('id');
	if(id==""){
		return false;
	}
	$.post("findFunctionMById.action",{"id":id},function(data){
		if(data.bean!=null){
			$('#moduleid').attr("value",data.bean.moduleid);
			$('#functionname').attr("value",data.bean.functionname);
			$('#visiturl').attr("value",data.bean.visiturl);
			$('#visitmethodname').attr("value",data.bean.visitmethodname);
			$('#hidid').attr("value",data.bean.id);
			$('#submit').hide();
			$('#modify').show();
		}
	});
	
	$('#modify').click(function(){
		var moduleid=$('#moduleid').val();
		if(moduleid=="0"){
			jAlert('功能所属系统模块必须选择', '信息提示');
			return false;
		}
		var functionname=$('#functionname').val();
		var visiturl=$('#visiturl').val();
		var visitmethodname=$('#visitmethodname').val();
		var id=$('#hidid').val();
		$.post("updateFunctionM.action",{"moduleid":moduleid,"functionname":functionname,"visiturl":visiturl,"visitmethodname":visitmethodname,"id":id},function(data){
			if(data.sucflag){
				window.location.href="functionmanagement.jsp?session="+session+"#pagecontent";
			}else{
				jAlert('系统模块功能更新失败', '信息提示');
				return false;
			}
		});
	});
});
/*===========================================Gorgeous split-line==============================================*/





