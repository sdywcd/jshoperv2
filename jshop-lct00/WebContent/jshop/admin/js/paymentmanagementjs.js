
/**
 * Global variables
 */
var session="true";
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
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
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
/**
 * Required to initialize the page data
 */
$(function(){
	$('#gradevalue').change(function(){
		var gradevalue=$("#gradevalue").val();
		if(gradevalue=="0"){
			return false;
		}
		var gradename=$("#gradevalue").find("option:selected").text();
		$('#gradename').attr("value",gradename);
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
	$("#paymentmanagement").flexigrid( {
		url : 'findAllPayment.action',
		dataType : 'json',
		cache : false,
		colModel : [{ 
			display:'支付方式名称',
			name:'paymentname',
			width:215,
			sortable:true,
			align:'center'
		},{ 
			display:'支付方式代码',
			name:'paymentCode',
			width:150,
			sortable:true,
			align:'center'
		}, { 
			display:'手续费',
			name:'paymentFree',
			width:150,
			sortable:true,
			align:'center'
		},{ 
			display:'接口类型',
			name:'paymentInterface',
			width:115,
			sortable:true,
			align:'center'
		},{
			display : '描述',
			name : 'des',
			width : 100,
			sortable : true,
			align : 'center'
				
		},{ display:'是否支持货到付款',
			name:'isCod',
			width:150,
			sortable:true,
			align:'center'
		},{ display:'是否支持在线交易',
			name:'isOnline',
			width:150,
			sortable:true,
			align:'center'
		},{ display:'是否启用',
			name:'state',
			width:100,
			sortable:true,
			align:'center'
		}],
		buttons : [{
			name : '开启',
			bclass : 'add',
			onpress : action
		},{
			name : '禁止',
			bclass : 'edit',
			onpress : action
		},{
			separator : true
		} ],

		searchitems : [ {
			display:'请选择搜索条件',
			name:'sc',
			isdefault : true
		}],
		sortname : "createtime",
		sortorder : "desc",
		usepager : true,
		title : '支付方式列表',
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
		if(com=='开启'){
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定开启此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						$.post("OpenPayment.action",{"paymentid":str},function(data){
							$('#paymentmanagement').flexReload();
						});
					}
				});
			} else {
				jAlert('请选择一条信息', '信息提示');
				return false;
			}
		}else if(com=='禁止'){
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定禁止此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						$.post("ClosePayment.action",{"paymentid":str},function(data){
							$('#paymentmanagement').flexReload();
						});
					}
				});
			} else {
				jAlert('请选择一条信息', '信息提示');
				return false;
			}
		}
	}
});
