
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
 * Function
 */
/**
 * 在页面数据完全加载完毕后填充
 * @return
 */
function findTemplateByTid(){
	var tid=$.query.get('tid');
	if(tid!=""){
		$.post("findTemplateByTid.action",{"tid":tid},function(data){
			$('#modify').show();
			$('#submit').hide();
			$('#name').attr("value",data.bean.name);
			$('#url').attr("value",data.bean.url);
			$('#note').attr("value",data.bean.note);
			$('#tid').attr("value",data.bean.tid);
			$('#type').val(data.bean.type);
			$("#tvalue").val(data.bean.tvalue);
			$('#sign').attr("value",data.bean.sign);
			$('#themename').attr("value",data.bean.themename);
			$('#status').attr("value",data.bean.status);
			var tarray=new Array();
			tarray=data.bean.sign.split('_');
			$('#templatetheme').val(data.bean.themeid+","+tarray[0]);
		});
	}else{
		$('#modify').hide();
		return;
	}
}
/*===========================================Gorgeous split-line==============================================*/

/**
 * Required to initialize the page data
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
$(function(){
	//加载模板主题
	$.post("getAllTemplatetheme.action",function(data){
		if(data.sucflag){
			$('#templatetheme').append(data.templatethemestrs);
		}
	});
	
	$('#templatetheme').focusout(function(){
		var templatetheme=$('#templatetheme').find("option:selected").text();
		var url="WEB-INF/theme/"+templatetheme+"/shop/";
		$('#url').attr("value",url);
	});
	
	$('#name').focus(function(){
		var templatetheme=$('#templatetheme').val();
		if(templatetheme=='-1'){
			jAlert('请先选择主题','信息提示');
			return false;
		}
	});
	
	$('#url').focus(function(){
		var name=$('#name').val();
		if(name==""){
			jAlert('请填写模板名称','信息提示');
			return false;
		}
	});
	
	$('#name').focusout(function(){
		var templatetheme=$('#templatetheme').find("option:selected").text();
		var name=$('#name').val();
		var url="WEB-INF/theme/"+templatetheme+"/shop/"+name+".ftl";
		$('#url').attr("value",url);
		//生成标示
		var tarray=new Array();
		tarray=$('#templatetheme').val().split(',');
		$('#sign').attr("value",tarray[1]+"_"+name);
	});
	
	$('#url').focusout(function(){
		var templatetheme=$('#templatetheme').find("option:selected").text();
		var name=$('#name').val();
		var url="WEB-INF/theme/"+templatetheme+"/shop/"+name+".ftl";
		$('#url').attr("value",url);
		//生成标示
		var tarray=new Array();
		tarray=$('#templatetheme').val().split(',');
		$('#sign').attr("value",tarray[1]+"_"+name);
	});
	
	
	
});

/*===========================================Gorgeous split-line==============================================*/
/**
 * flexigrid list 
 */
$(function() {
	$("#templatemanagement").flexigrid( {
		url : 'findAllTemplate.action',
		dataType : 'json',
		cache : false,
		colModel : [{ 
			display:'标示',
			name:'sign',
			width:220,
			sortable:true,
			align:'center'
		},{ 
			display:'主题',
			name:'themename',
			width:115,
			sortable:true,
			align:'center'
		},{ 
			display:'模板名称',
			name:'name',
			width:215,
			sortable:true,
			align:'center'
		},{ 
			display:'类型',
			name:'type',
			width:115,
			sortable:true,
			align:'center'
		},{
			display : '模板说明',
			name : 'note',
			width : 150,
			sortable : true,
			align : 'center'	
		},{
			display : '状态',
			name : 'status',
			width : 80,
			sortable : true,
			align : 'center'
				
		},{ display:'模板文件路径',
			name:'url',
			width:300,
			sortable:true,
			align:'center'
		},{
			display : '操作',
			name : 'operating',
			width : 80,
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
			name : '预览',
			bclass : 'edit',
			onpress : action
		},{
			name : '更新模板文件',
			bclass : 'edit',
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
		title : '模板文件列表',
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
			window.location.href="addtemplate.jsp?session="+session+"#settings";
			return;

		}else if(com=='编辑'){
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						window.location.href="addtemplate.jsp?session="+session+"#settings&tid="+str;
						return;
					}
				});
			} else {
				jAlert('请选择一条信息', '信息提示');
				return false;
			}
		}else if(com=="更新模板文件"){
			$.post("recreateTemplate.action",function(data){
				if(data.sucflag){
					jAlert('更新模板文件成功','信息提示');
					
					return true;
				}
			});
		}else if(com=='预览'){
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定预览此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						window.location.href="showtemplate.jsp?tid="+str;
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
/*===========================================Gorgeous split-line==============================================*/

/**
 * Add Function
 */
$(function(){
	$('#submit').click(function(){
		var templatetheme=$('#templatetheme').val();
		if(templatetheme=='-1'){
			jAlert('请先选择主题','信息提示');
			return false;
		}else{
			var tarray=new Array();
			tarray=$('#templatetheme').val().split(',');
			var themeid=tarray[0];
			var themename=$('#templatetheme').find("option:selected").text();
			var templatetheme=$('#templatetheme').find("option:selected").text();
			var name=$('#name').val();
			var url="WEB-INF/theme/"+templatetheme+"/shop/"+name+".ftl";
			$('#url').attr("value",url);
			//生成标示
			$('#sign').attr("value",tarray[1]+"_"+name);
		}
		var name=$('#name').val();
		if(name==""){
			jAlert('模板名称必须填写', '信息提示');
			return false;
		}
		var url=$('#url').val();
		if(url==""){
			jAlert('模板路径', '信息提示');
			return false;
		}
		var note=$("#note").val();
		if(note==""){
			jAlert('描述', '信息提示');
			return false;
		}
		var tvalue=$('#tvalue').val();
		if(tvalue==""){
			jAlert('模板内容', '信息提示');
			return false;
		}
		var type=$('#type').val();
		if(type=="0"){
			jAlert('请选择模板类型', '信息提示');
			return false;
		}
		var sign=$('#sign').val();
		if(sign==""){
			jAlert('标示出现获取异常请重新选择模板主题和输入模板名称','信息提示');
			return false;
		}
	
		$.post("addTemplate.action",{"sign":sign,"themeid":themeid,"themename":themename,"name":name,"url":url,"note":note,"tvalue":tvalue,"type":type},function(data){
			if(data.sucflag){
				window.location.href="templatemanagement.jsp?session="+session+"#settings";
			}else{
				jAlert('模板增加失败', '信息提示');
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
	$('#modify').click(function(){
		var tid=$('#tid').val();
		var tvalue=$('#tvalue').val();
		var templatetheme=$('#templatetheme').val();
		if(templatetheme=='-1'){
			jAlert('请先选择主题','信息提示');
			return false;
		}else{
			var tarray=new Array();
			tarray=$('#templatetheme').val().split(',');
			var themeid=tarray[0];
			var themename=$('#templatetheme').find("option:selected").text();
			var templatetheme=$('#templatetheme').find("option:selected").text();
			var name=$('#name').val();
			var url="WEB-INF/theme/"+templatetheme+"/shop/"+name+".ftl";
			$('#url').attr("value",url);
			//生成标示
			$('#sign').attr("value",tarray[1]+"_"+name);
		}
		var name=$('#name').val();
		if(name==""){
			jAlert('模板名称必须填写', '信息提示');
			return false;
		}
		var url=$('#url').val();
		if(url==""){
			jAlert('模板路径', '信息提示');
			return false;
		}
		var note=$("#note").val();
		if(note==""){
			jAlert('描述', '信息提示');
			return false;
		}
		var tvalue=$('#tvalue').val();
		if(tvalue==""){
			jAlert('模板内容', '信息提示');
			return false;
		}
		var type=$('#type').val();
		if(type=="0"){
			jAlert('请选择模板类型', '信息提示');
			return false;
		}
		var sign=$('#sign').val();
		if(sign==""){
			jAlert('标示出现获取异常请重新选择模板主题和输入模板名称','信息提示');
			return false;
		}
		var status=$('#status').val();
		$.post("UpdateTemplate.action",{"sign":sign,"themeid":themeid,"themename":themename,"name":name,"url":url,"note":note,"tid":tid,"tvalue":tvalue,"type":type,"status":status},function(data){
			if(data.sucflag){
				window.location.href="templatemanagement.jsp?session="+session+"#settings";
			}
		});
	});
});
