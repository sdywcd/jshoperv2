var session="true";
$(function(){
	$('#ecoupontmanagement').flexigrid({
		url:'findAllEcouponT.action',
		dataType:'json',
		cache:false,
		colModel:[{
			display:'商品名称',
			name:'goodsname',
			width:'150',
			sortable:true,
			align:'center'				
		},{
			display:'商品ID',
			name:'goodsid',
			width:'150',
			sortable:true,
			align:'center'				
		},{
			display:'模式',
			name:'ecouponstate',
			width:'150',
			sortable:true,
			align:'center'				
		},{
			display:'状态',
			name:'state',
			width:'150',
			sortable:true,
			align:'center'				
		},{
			display:'开始时间',
			name:'begintime',
			width:'150',
			sortable:true,
			align:'center'				
		},{
			display:'结束时间',
			name:'endtime',
			width:'150',
			sortable:true,
			align:'center'				
		},{
			display:'优惠价格',
			name:'favourableprices',
			width:'150',
			sortable:true,
			align:'center'				
		},{
			display:'抵扣价格',
			name:'pricededuction',
			width:'150',
			sortable:true,
			align:'center'				
		},{
			display:'使用说明',
			name:'note',
			width:'150',
			sortable:true,
			align:'center'				
		}],buttons:[{

			name : '添加',
			bclass : 'add',
			onpress : action
		}, {
			name:'编辑',
			bclass:'edit',
			onpress:action
		},{
			name : '删除',
			bclass : 'delete',
			onpress : action
		},{
			separator : true		 
		}],
		sortname : "begintime",
		sortorder : "desc",
		usepager : true,
		title : '商品列表',
		useRp : true,
		rp : 20,
		rpOptions : [ 5, 20, 40, 100 ],
		showTableToggleBtn : true,
		showToggleBtn : true,
		width : 'auto',
		height : 'auto',
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...',
		checkbox:true
	});
	function action(com,grid){
		if(com=='添加'){
			window.location.href='addecoupont.jsp?session='+session+"#goods";
			return;
		}else if(com=='编辑'){
			if($('.trSelected',grid).length==1){
				jConfirm('确定编辑此项吗？','信息提示',function(r){
					if(r){
					var str	=$('.trSelected',grid)[0].id.substr(3);
					window.location.href="editecoupont.jsp?session="+session+"#goods&eid="+str;
					return;
					}
				});
			}else if($('.trSelected').length>1){
				jAlert('请不要选择多个','信息提示');
			}else {
				jAlert('请选择一条信息','信息提示');
				return false;
			}
		}else if(com=='删除'){
			if($('.trSelected',grid).length>0){
				jConfirm('确定删除吗？','信息提示',function(r){
					if(r){
						var str="";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						$.post("delEcouponT.action",{"eid":str},function(data){
							if(data.flag){
								jAlert('删除成功','信息提示');
								$('#ecoupontmanagement').flexReload();
							}
						});
					}
				});
				return ;				
			}else{
				jAlert('请选择要删除的信息!', '信息提示');
				return false;
			}
		}
	}
});
