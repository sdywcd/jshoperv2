
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
	$.post("findAllFunction.action", function(data) {
		if (data.beanlist!=null) {
			var html="";
			$.each(data.beanlist,function(n,value){
				html+="<p><input type='checkbox' id='functions' name='functions' value='"+value.id+"'/>"+value.functionname+"</p>";
			});
			$('#functionsdiv').append(html);
		}
	});

});
/*===========================================Gorgeous split-line==============================================*/



/**
 * flexigrid list 
 */

$(function() {
	$("#rolemanagement").flexigrid( {
		url : 'findAllRoleM.action',
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '角色名称',
			name : 'rolename',
			width : 215,
			sortable : true,
			align : 'center'
		},{
			display : '说明',
			name : 'note',
			width : 415,
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
			name : '添加角色',
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
		title : '角色列表',
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
		if (com == '添加角色') {
			window.location.href = "addrole.jsp?session="+session+"#settings";
			return;

		} else if (com == '编辑') {
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						window.location.href = "addrole.jsp?session="+session+"#settings&id=" + str;
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
						$.post("delRoleM.action", {
							"id" : str
						}, function(data) {
							$('#rolemanagement').flexReload();
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
 * 增加角色
 */
$(function(){
	$('#submit').click(function(){
		var functionid="";
		$("input:checkbox").each(function(i){
		    if($(this).attr("checked")) {
		      functionid+=this.value+",";
		   }
		});
		var rolename=$('#rolename').val();
		var note=$('#note').val();
		$.post("addRoleM.action",{"functionid":functionid,"rolename":rolename,"note":note},function(data){
			if(data.sucflag){
				window.location.href="rolemanagement.jsp?session="+session+"#pagecontent";
			}else{
				jAlert('角色权限增加失败', '信息提示');
				return false;
			}
		});
	});	
});
/*===========================================Gorgeous split-line==============================================*/
/**
 * Update Function
 */
function bindfunction(v1){
	$("input:checkbox").each(function(i){
	   if(v1==this.value){
		   $(this).attr("checked",true);
	   }
	});
	
}

$(function(){
	var id=$.query.get('id');
	if(id==""){
		return false;
	}
	$.post("findRoleMById.action",{"id":id},function(data){
		if(data.bean!=null){
			$('#rolename').attr("value",data.bean.rolename);
			$('#note').attr("value",data.bean.note);
			$('#hidid').attr("value",data.bean.id);
			//绑定角色权限
			$.each(data.rfmbean,function(n,value){
				bindfunction(value.functionid);
			});
			$('#submit').hide();
			$('#modify').show();
		}
	});
	
	$('#modify').click(function(){
		var functionid="";
		$("input:checkbox").each(function(i){
		    if($(this).attr("checked")) {
		      functionid+=this.value+",";
		   }
		});
		var rolename=$('#rolename').val();
		var note=$('#note').val();
		var id=$('#hidid').val();
		$.post("updateRoleM.action",{"functionid":functionid,"rolename":rolename,"note":note,"id":id},function(data){
			if(data.sucflag){
				window.location.href="rolemanagement.jsp?session="+session+"#pagecontent";
			}else{
				jAlert('角色权限更新失败', '信息提示');
				return false;
			}
		});
	});
});
/*===========================================Gorgeous split-line==============================================*/





