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
	$("#templatethememanagement").flexigrid( {
		url : 'findAllTemplatetheme.action',
		dataType : 'json',
		cache : false,
		colModel : [{ 
			display:'主题名称',
			name:'themename',
			width:215,
			sortable:true,
			align:'center'
		},{ 
			display:'说明',
			name:'note',
			width:115,
			sortable:true,
			align:'center'
		},{
			display : '标示',
			name : 'sign',
			width : 314,
			sortable : true,
			align : 'center'
				
		},{
			display : '状态',
			name : 'status',
			width : 114,
			sortable : true,
			align : 'center'
				
		},{
			display : '创建时间',
			name : 'createtime',
			width : 110,
			sortable : true,
			align : 'center'
		},{
			display : '创建人',
			name : 'creatorid',
			width : 110,
			sortable : true,
			align : 'center'
		},{
			display : '操作',
			name : 'operating',
			width : 110,
			sortable : true,
			align : 'center'
		}],
		buttons : [ {
			name : '添加',
			bclass : 'add',
			onpress : action
		},{
			name : '编辑',
			bclass : 'edit',
			onpress : action
		},{
			name : '删除',
			bclass : 'delete',
			onpress : action
		},{
			separator : true
		}],
		searchitems : [{
			display:'请选择搜索条件',
			name:'sc',
			isdefault : true
		}],
		sortname : "createtime",
		sortorder : "desc",
		usepager : true,
		title : '模板主题列表',
		useRp : true,
		rp : 20,
		rpOptions : [ 5, 20, 40, 100 ],
		showTableToggleBtn : true,
		width :'auto',
		height : 'auto',
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...',
		checkbox:true

	});

	function action(com, grid) {
		if (com == '添加') {
			window.location.href="addtemplatetheme.jsp?session="+session+"#settings";
			return;

		}else if(com=='编辑'){
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						window.location.href="addtemplatetheme.jsp?session="+session+"#settings&ttid="+str;
						return;
					}
				});
			} else {
				jAlert('请选择一条信息', '信息提示');
				return false;
			}
		}else if(com=='删除'){
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定删除此项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						$.post("delTemplatetheme.action",{"ttid":str},function(data){
							$('#templatethememanagement').flexReload();
							jAlert(data.msg,'信息提示');
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
$(function(){
	$('#submit').click(function(){
		var themename=$('#themename').val();
		if(themename==""){
			jAlert('主题名称必须填写', '信息提示');
			return false;
		}
		var note=$("#note").val();
		if(note==""){
			jAlert('说明必须填写', '信息提示');
			return false;
		}
		var sign=$('#sign').val();
		if(sign==""){
			jAlert('标示必须填写', '信息提示');
			return false;
		}
	
		if($("#status").attr('checked')){
			var status="1";
		}else{
			var status="0";
		}
		$.post("addTemplatetheme.action",{"themename":themename,"note":note,"sign":sign,"status":status},function(data){
			if(data.sucflag){
				window.location.href="templatethememanagement.jsp?session="+session+"#settings";
			}else{
				jAlert('模板主题增加失败', '信息提示');
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
	var ttid=$.query.get('ttid');
	if(ttid!=""){
		$.post("findTemplatethemeByttid.action",{"ttid":ttid},function(data){
			$('#modify').show();
			$('#submit').hide();
			$('#themename').attr("value",data.bean.themename);
			$('#note').attr("value",data.bean.note);
			$('#ttid').attr("value",data.bean.ttid);
			$('#sign').attr("value",data.bean.sign);
			if(data.bean.status=="1"){
				$("#status").attr("checked",true);
			}else{
				$("#status").attr("checked",false);
			}
			
		});
	}else{
		$('#modify').hide();
		return;
	}
	
	
	$('#modify').click(function(){
		var themename=$('#themename').val();
		if(themename==""){
			jAlert('主题名称必须填写', '信息提示');
			return false;
		}
		var note=$("#note").val();
		if(note==""){
			jAlert('说明必须填写', '信息提示');
			return false;
		}
		var sign=$('#sign').val();
		if(sign==""){
			jAlert('标示必须填写', '信息提示');
			return false;
		}
		if($("#status").attr("checked")){
			var status="1";
		}else{
			var status="0";
		}
		var ttid=$("#ttid").val();
		$.post("updateTemplatetheme.action",{"themename":themename,"note":note,"sign":sign,"ttid":ttid,"status":status},function(data){
			if(data.sucflag){
				window.location.href="templatethememanagement.jsp?session="+session+"#settings";
			}else{
				jAlert('模板主题更新失败', '信息提示');
				return false;
			}
		});
	});
	
});

/*===========================================Gorgeous split-line==============================================*/




