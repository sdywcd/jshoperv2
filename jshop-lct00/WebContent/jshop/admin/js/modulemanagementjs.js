
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
 * flexigrid list 
 */
$(function() {
	$("#modulemanagement").flexigrid( {
		url : 'findAllModuleM.action',
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '模块名称',
			name : 'modulename',
			width : 315,
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
			name : '查看模块功能',
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
		title : '模块列表',
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
			window.location.href = "addmodule.jsp?session="+session+"#settings";
			return;

		} else if (com == '编辑') {
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						window.location.href = "addmodule.jsp?session="+session+"#settings&id=" + str;
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
						$.post("delModuleM.action", {
							"id" : str
						}, function(data) {
							$('#modulemanagement').flexReload();
						});
					}
				});
				return;
			} else {
				jAlert('请选择要删除的信息!', '信息提示');
				return false;
			}
	
		}else if(com=='查看模块功能'){
			if ($('.trSelected', grid).length == 1) {
				var str = $('.trSelected', grid)[0].id.substr(3);
				window.location.href = "functionmanagement.jsp?session="+session+"#settings&moduleid=" + str;
				return;
			} else {
				jAlert('请选择一条信息', '信息提示');
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
 * 增加模块
 */
$(function(){
	$('#submit').click(function(){
		var modulename=$('#modulename').val();
		if(modulename==""){
			jAlert('模块名称必须填写', '信息提示');
			return false;
		}
		$.post("addModuleM.action",{"modulename":modulename},function(data){
			if(data.sucflag){
				window.location.href="modulemanagement.jsp?session="+session+"#pagecontent";
			}else{
				jAlert('系统模块增加失败', '信息提示');
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
	$.post("findModuleMById.action",{"id":id},function(data){
		if(data.bean!=null){
			$('#modulename').attr("value",data.bean.modulename);
			$('#hidid').attr("value",data.bean.id);
			$('#submit').hide();
			$('#modify').show();
		}
	});
	
	$('#modify').click(function(){
		var modulename=$('#modulename').val();
		if(modulename==""){
			jAlert('模块名称必须填写', '信息提示');
			return false;
		}
		var id=$('#hidid').val();
		$.post("updateModuleM.action",{"modulename":modulename,"id":id},function(data){
			if(data.sucflag){
				window.location.href="modulemanagement.jsp?session="+session+"#pagecontent";
			}else{
				jAlert('系统模块更新失败', '信息提示');
				return false;
			}
		});
	});
});
/*===========================================Gorgeous split-line==============================================*/





