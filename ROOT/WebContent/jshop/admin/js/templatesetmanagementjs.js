
/**
 * Global variables
 */
var session="true";
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
function findTemplatesetTBytsid(){
	var tsid=$.query.get('tsid');
	if(tsid!=""){
		$.post("findTemplatesetTBytsid.action",{"tsid":tsid},function(data){
			$('#modify').show();
			$('#submit').hide();
			$('#ssystemcontent').hide();
			var h="<input class='small' readonly id='ssystemcontent1' name='ssystemcontent1' value="+data.bean.systemcontent+" type='text'/>";
			$('#xtsy p').after(h);
			$('#modifysys').show();
			$('#tsid').attr("value",data.bean.tsid);
			$('#buildhtmlpath').val(data.bean.buildhtmlpath);
			$("#templateurl").val(data.bean.templateurl+","+data.bean.sign);
			$("#sign").attr("value",data.bean.sign);
			$("#syssign").attr("value",data.bean.sign+","+data.bean.templateurl);
		});
	}else{
		$('#modify').hide();
	}
}
/*===========================================Gorgeous split-line==============================================*/

/**
 * Required to initialize the page data
 */
$(function(){
	/**
	 * 修改系统内容按钮
	 */
	$('#modifysys').click(function(){
		$('#zsys').show();
		$('#ssystemcontent').show();
	});
	
	//加载系统内容
	$.post("findSystemcontent.action",function(data){
		if(data.sucflag){
			$('#ssystemcontent').append(data.syscontentstrs);
		}
	});
	$.post("getAllTemplate.action",function(data){
		if(data.sucflag){
			$('#templateurl').append(data.templatestrs);
		}
	});
	
	//当选择模板文件时填充sign
	$('#templateurl').change(function(){
		var tarray=new Array();
		tarray=$('#templateurl').val().split(',');
		$('#sign').attr("value",tarray[1]);
	});
	
	$('#ssystemcontent').change(function(){
		var ssystemcontent=$('#ssystemcontent').val();
		if(ssystemcontent=="0"){
			$('#sign').attr("value","");
			$('#syssign').attr("value","");
			$('#zsys').show();
			//$('#sign').attr("disabled",false);
		}else{
			$('#zsys').hide();
			if(ssystemcontent=="1"||ssystemcontent=="2"){
				//$('#sign').hide();
				return;
			}else{
				$('#sign').show();
				var array=new Array();
				array=ssystemcontent.split(",");
				$('#sign').attr("value",array[1]);
				$('#syssign').attr("value",array[1]);
				//$('#sign').attr("disabled",true);
			}
			
		}
	});
});
/*===========================================Gorgeous split-line==============================================*/
/**
 * flexigrid list 
 */
$(function() {
	$("#templatesetmanagement").flexigrid( {
		url : 'findAllTemplatesetT.action',
		dataType : 'json',
		cache : false,
		colModel : [{ 
			display:'所属主题',
			name:'themename',
			width:150,
			sortable:true,
			align:'center'
		},{ 
			display:'系统内容名称',
			name:'systemcontent',
			width:200,
			sortable:true,
			align:'center'
		},{ 
			display:'标示',
			name:'sign',
			width:150,
			sortable:true,
			align:'center'
		},{ 
			display:'状态',
			name:'status',
			width:80,
			sortable:true,
			align:'center'
		},{ 
			display:'模板文件路径',
			name:'templateurl',
			width:315,
			sortable:true,
			align:'center'
		},{ 
			display:'静态页面输出路径',
			name:'buildhtmlpath',
			width:315,
			sortable:true,
			align:'center'
		},{
			display : '创建时间',
			name : 'createtime',
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
		title : '模板文件和系统内容关系列表',
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
			window.location.href="addtemplateset.jsp?session="+session+"#settings";
			return;

		}else if(com=='编辑'){
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						window.location.href="addtemplateset.jsp?session="+session+"#settings&tsid="+str;
						return;
					}
				});
			} else {
				jAlert('请选择一条信息', '信息提示');
				return false;
			}
		}else if(com=="删除"){
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定删除此项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						$.post("delTemplatesetT.action",{"tsid":str},function(data){
							if(data.sucflag){
								$('#templatesetmanagement').flexReload();
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
/*===========================================Gorgeous split-line==============================================*/
/**
 * Add Function
 */
$(function(){
	$('#submit').click(function(){
		if($('#zsys').is(":hidden")){
			var ssystemcontent=$('#ssystemcontent').find("option:selected").text();
			if(ssystemcontent=='-1'||ssystemcontent=='0'||ssystemcontent=='1'||ssystemcontent=='2'){
				jAlert('请选择系统内容', '信息提示');
				return false;
			}else{
				var systemcontent=ssystemcontent;
				var sign=$("#sign").val();
			}
		}else{
			var zsystemcontent=$('#zsystemcontent').val();
			if(zsystemcontent==""){
				jAlert('请输入系统内容', '信息提示');
				return false;
			}else{
				var systemcontent=zsystemcontent;
				var sign=$("#sign").val();
				if(sign==""){
					jAlert('请输入标示', '信息提示');
					return false;
				}
			}
		}
		var templateurl=$('#templateurl').val();
		if(templateurl=="-1"){
			jAlert('请选择模板文件', '信息提示');
			return false;
		}else{
			templateurl=$('#templateurl').find("option:selected").text();
		}
		var buildhtmlpath=$('#buildhtmlpath').val();
		if(buildhtmlpath==""){
			jAlert('请填写输出目录', '信息提示');
			return false;
		}
		
		$.post("addTemplatesetT.action",{"systemcontent":systemcontent,"buildhtmlpath":buildhtmlpath,"templateurl":templateurl,"sign":sign},function(data){
			if(data.sucflag){
				window.location.href="templatesetmanagement.jsp?session="+session+"#settings";
			}else{
				jAlert('模板文件和系统内容设定失败', '信息提示');
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
	if($('#ssystemcontent').is(":hidden")){
		var systemcontent=$('#ssystemcontent1').val();
		
	}else{
		if($('#zsys').is(":hidden")){
			var ssystemcontent=$('#ssystemcontent').find("option:selected").text();
			if(ssystemcontent=='-1'||ssystemcontent=='0'||ssystemcontent=='1'||ssystemcontent=='2'){
				jAlert('请选择系统内容', '信息提示');
				return false;
			}else{
				var systemcontent=ssystemcontent;
				var sign=$("#sign").val();
			}
		}else{
			var zsystemcontent=$('#zsystemcontent').val();
			if(zsystemcontent==""){
				jAlert('请输入系统内容', '信息提示');
				return false;
			}else{
				var systemcontent=zsystemcontent;
				var sign=$("#sign").val();
				if(sign==""){
					jAlert('请输入标示', '信息提示');
					return false;
				}
			}
		}
	}
	var sign=$("#sign").val();
	if(sign==""){
		jAlert('请输入标示', '信息提示');
		return false;
	}
	var templateurl=$('#templateurl').val();
	if(templateurl=="-1"){
		jAlert('请选择模板文件', '信息提示');
		return false;
	}else{
		templateurl=$('#templateurl').find("option:selected").text();
	}
	var buildhtmlpath=$('#buildhtmlpath').val();
	if(buildhtmlpath==""){
		jAlert('请填写输出目录', '信息提示');
		return false;
	}
	var tsid=$('#tsid').val();
	$.post("updateTemplatesetT.action",{"systemcontent":systemcontent,"buildhtmlpath":buildhtmlpath,"templateurl":templateurl,"tsid":tsid,"sign":sign},function(data){
		if(data.sucflag){
			window.location.href="templatesetmanagement.jsp?session="+session+"#settings";
		}
	});
});

});

