/**
 * Global variables
 */
var session="true";
/*===========================================Gorgeous split-line==============================================*/


/**
 * flexigrid list 
 */
$(function() {
	$('#showsetarea').hide();
	$("#setgoodscommentmanagement").flexigrid( {
		url : 'findAllGoods.action',
		dataType : 'json',
		cache : false,
		colModel : [{
			display:'商品名称',
			name:'goodsname',
			width:500,
			sortable:true,
			align:'center'
		},{ 
			display:'商品编号',
			name:'usersetnum',
			width:150,
			sortable:true,
			align:'center'
		},{
			display:'分类',
			name:'sname',
			width:150,
			sortable:true,
			align:'center'
		},{
			display:'会员价',
			name:'memberprice',
			width:120,
			sortable:true,
			align:'center'
		},{
			display:'上架',
			name:'salestate',
			width:60,
			sortable:true,
			align:'center'
		},{
			display:'新品',
			name:'isNew',
			width:60,
			sortable:true,
			align:'center'
		},{
			display:'特价',
			name:'bargainprice',
			width:60,
			sortable:true,
			align:'center'
		},{
			display:'热销',
			name:'hotsale',
			width:60,
			sortable:true,
			align:'center'
		},{
			display:'推荐',
			name:'recommended',
			width:60,
			sortable:true,
			align:'center'
		},{
			display:'库存',
			name:'quantity',
			width:100,
			sortable:true,
			align:'center'
		},{
			display : '操作',
			name : 'operating',
			width : 110,
			sortable : true,
			align : 'center'
		}],
		buttons : [ {
			name : '设置评论和分值',
			bclass : 'add',
			onpress : action
		},{
			separator : true
		} ],
		searchitems : [{
			display:'请选择搜索条件',
			name:'sc',
			isdefault : true
		},{
			display:'商品名称',
			name:'goodsname'
		} ],
	
		sortname : "createtime",
		sortorder : "desc",
		usepager : true,
		title : '评论列表',
		useRp : true,
		rp : 20,
		rpOptions : [ 20, 60,200, 1000 ],
		showTableToggleBtn : true,
		width :'auto',
		height : 'auto',
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...',
		checkbox:true
	});
	function action(com, grid) {
		if (com == '设置评论和分值') {
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						$('#showsetarea').show();
						$('#hidgoodsid').attr("value",str);
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

//商品评论列表
$(function() {
	$("#goodscommentmanagement").flexigrid( {
		url : 'findAllGoodsComment.action',
		dataType : 'json',
		cache : false,
		colModel : [{
			display : '评论的商品',
			name : 'goodsname',
			width : 200,
			sortable : true,
			align : 'center'
		}, {
			display : '评论/回复内容',
			name : 'commentcontent',
			width : 300,
			sortable : true,
			align : 'center'
		}, {
			display : '评论人/回复人',
			name : 'replyorcommentusername',
			width : 150,
			sortable : true,
			align : 'center'
		}, {
			display : '发表时间',
			name : 'posttime',
			width : 150,
			sortable : true,
			align : 'center'
		}, {
			display : '状态',
			name : 'state',
			width : 100,
			sortable : true,
			align : 'center'
		}, {
			display : '评论类型',
			name : 'replyorcomment',
			width : 100,
			sortable : true,
			align : 'center'
		}, {
			display : '提醒',
			name : 'emailable',
			width : 100,
			sortable : true,
			align : 'center'
		}, {
			display : '备注状态',
			name : 'virtualadd',
			width : 100,
			sortable : true,
			align : 'center'
		} ],
		buttons : [ {
			name : '设置商品分值和评论数据',
			bclass : 'add',
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
			display : '评论内容',
			name : 'commentcontent'
		}, {
			display : '商品名称',
			name : 'goodsname'
		} ],
		sortname : "posttime",
		sortorder : "desc",
		usepager : true,
		title : '商品评论列表',
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
		if (com == '删除') {
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定删除此项吗！确定要删除此项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						$.post("DelGoodsComment.action", {
							"commentid" : str
						}, function(data) {
							$('#goodscommentmanagement').flexReload();
						});
					}
				});
				return;
			} else {
				jAlert('请选择要删除的信息!', '信息提示');
				return false;
			}
		} else if (com == '设置商品分值和评论数据') {
			window.location.href = "addgoodscommentandmark.jsp?session="+session+"#goods";
			return;
		}
	}
});
/*===========================================Gorgeous split-line==============================================*/
/**
 * Add Function
 */

$(function(){
	/**
	 * 设置商品星级分值
	 */
	$('#updatestarsum').click(function(){
		var goodsid=$('#hidgoodsid').val();
		var star=$('#star').val();
		$.post("updatestarsumBygoodsid.action",{"goodsid":goodsid,"star":star},function(data){
			if(data.sucflag){
				jAlert('设置商品星级分值成功','信息提示');
				
				return;
			}
		});
	});
	
	
	/**
	 * 设置商品打分人数
	 */
	$('#updatestarusersum').click(function(){
		var goodsid=$('#hidgoodsid').val();
		var staruser=$('#staruser').val();
		$.post("updatestarusersumBygoodsid.action",{"goodsid":goodsid,"staruser":staruser},function(data){
			if(data.sucflag){
				jAlert('设置商品打分人数成功','信息提示');
				
				return;
			}
		});
	});
	
	/**
	 * 设置商品总评论人数
	 */
	$('#updatecommentsum').click(function(){
		var goodsid=$('#hidgoodsid').val();
		var totalcomment=$('#totalcomment').val();
		$.post("updatecommentsumBygoodsid.action",{"goodsid":goodsid,"totalcomment":totalcomment},function(data){
			if(data.sucflag){
				jAlert('设置商品总评论人数成功','信息提示');
				
				return;
			}
		});
	});
	
	
	/**
	 *增加商品虚拟评论
	 */
	$('#addgoodscomment').click(function(){
		var goodsid=$('#hidgoodsid').val();
		var replyorcommentusername=$('#replyorcommentusername').val();
		var commentcontent=$('#commentcontent').val();
		$.post("addvirtualGoodsComment.action",{"goodsid":goodsid,"replyorcommentusername":replyorcommentusername,"commentcontent":commentcontent},function(data){
			if(data.sucflag){
				jAlert('增加商品虚拟评论成功','信息提示');
				
				window.location.href="goodscommentmanagement.jsp?session="+session+"#goods";
			}
		});
	});
	
	
})
/*===========================================Gorgeous split-line==============================================*/

