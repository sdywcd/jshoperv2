//function IFrameResize(){
// 	 var obj = parent.document.getElementById("frm_main"); 
// 	 obj.height = this.document.body.scrollHeight+100; 
// 	}
function showlinkgoodsarea(){
	$('#editlinkgood').show();

}

//检测是否选择了需要组合的商品，并更新商品组合
$(function(){
	$("#linkgoodsbutton").click(function(){ 
	
		var sum=0;
		var str="";
		$(":checkbox[name='firstcol'][checked=true]").each(function(){
			sum++;
			str=this.value;
		});
		if(sum==0){
			jAlert('请先选择要增加商品组合的内容','信息提示');
			
			return false;
		}
		var rightgoodslist="";
		var right=document.forms[0].rightgoodslist; 
		for(i=2; i <right.length; i++){
			  rightgoodslist+=right[i].value+","; 
		}
		var array=rightgoodslist.split(',');
		for(i=0;i<array.length;i++){
			if(array[i]==str){
				jAlert('不能将自身设定为组合商品','信息提示');
				
				return false;
			}
		}
		//var result=array.indexOf(str);
	
		$.post("UpdateGoodsrelatedgoods.action",{"goodsid":str,"rightgoodslist":rightgoodslist},function(data){
			
		});
	}); 

});

//获取商品导航菜单
$(function(){
	$.post("findAlllcategoryBynavjson.action",function(data){
		$("#navid").append(data.navidlist); ;
		return;
	});
});
//获取商品二级菜单
$(function(){
	$("#navid").change(function(){
		var navid=$("#navid").val();
		if("0"==navid){
			return;
		}
		$.post("findSecondcategoryjson.action",{"navid":navid},function(data){
			$("#ltypeid option").remove();
			$("#ltypeid").append(data.ltypeidlist); 
			return;
		});
	});
});
//获取商品三级菜单
$(function(){
	$("#ltypeid").change(function(){
		var ltypeid=$("#ltypeid").val();
		if("0"==ltypeid){
			return;
		}
		$.post("findThriedcategoryjson.action",{"ltypeid":ltypeid},function(data){
			$("#stypeid option").remove();
			$("#stypeid").append(data.stypeidlist);
			return;
		});
	});
	
});
//flexigrid
$(function() {
	$.post("CheckLogin.action",function(data){
		if(data.slogin){
			top.location.href="jshop/admin/adminlogin.jsp";
		}
	});
	$("#goodsmanagement").flexigrid( {
		url : 'findAllGoods.action',
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '序号',
			name : 'goodsid',
			width : 100,
			sortable : true,
			align : 'center'
		},{ 
			display:'商品编码',
			name:'usersetnum',
			width:100,
			sortable:true,
			align:'center'
		},{
			display:'商品小类',
			name:'sname',
			width:100,
			sortable:true,
			align:'center'
		},{
			display:'商品名称',
			name:'goodsname',
			width:400,
			sortable:true,
			align:'center'
		},{
			display:'商品品牌',
			name:'brand',
			width:100,
			sortable:true,
			align:'center'
		},{
			display:'市价',
			name:'price',
			width:100,
			sortable:true,
			align:'center'
		},{
			display:'会员价',
			name:'memberprice',
			width:100,
			sortable:true,
			align:'center'
		},{
			display:'积分',
			name:'points',
			width:100,
			sortable:true,
			align:'center'
		},{
			display:'库存数量',
			name:'quantity',
			width:100,
			sortable:true,
			align:'center'
		},{
			display:'重量',
			name:'weight',
			width:100,
			sortable:true,
			align:'center'
		},{
			display:'产地',
			name:'productplace',
			width:100,
			sortable:true,
			align:'center'
		},{
			display:'保质期',
			name:'shelflife',
			width:100,
			sortable:true,
			align:'center'
		},{
			display:'浏览次数',
			name:'readcount',
			width:100,
			sortable:true,
			align:'center'		
		},{
			display:'推荐',
			name:'recommended',
			width:100,
			sortable:true,
			align:'center'
		},{
			display:'热卖',
			name:'hotsale',
			width:100,
			sortable:true,
			align:'center'
		},{
			display:'特价',
			name:'bargainprice',
			width:100,
			sortable:true,
			align:'center'
		},{
			display:'回复次数',
			name:'replycount',
			width:100,
			sortable:true,
			align:'center'
		},{
			display:'排序',
			name:'sort',
			width:100,
			sortable:true,
			align:'center'
		},{
			display:'上架状态',
			name:'salestate',
			width:100,
			sortable:true,
			align:'center'
		},{
			display : '创建时间',
			name : 'createtime',
			width : 214,
			sortable : true,
			align : 'center'
		},{ display:'创建者编号',
			name:'creatorid',
			width:200,
			sortable:true,
			align:'center'
		},{ display:'商品组合编号',
			name:'relatedgoodsid',
			width:200,
			sortable:true,
			align:'center'
		}],
		buttons : [ {
			name : '添加',
			bclass : 'add',
			onpress : test
		}, {
			name : '编辑',
			bclass : 'add',
			onpress : test
		},{
			name:'删除',
			bclass:'add',
			onpress:test
		},{
			name:'设置商品组合',
			bclass:'add',
			onpress:setlinkgoods
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
		title : '',
		useRp : true,
		rp : 20,
		rpOptions : [ 5, 20, 40, 100 ],
		showTableToggleBtn : true,
		width :'auto',
		height : 200,
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...',
		onSuccess: msg
	});
	function msg(){
		$.post("CheckLogin.action",function(data){
			if(data.slogin){
				top.location.href="jshop/admin/adminlogin.jsp";
			}
		});
	}
	
	function test(com, grid) {
		if (com == '添加') {
			window.location.href='jshop/admin/goods/addnewgoods.jsp';
			return;

		}else if(com=='编辑'){
			var sum=0;
			var str="";
			$(":checkbox[name='firstcol'][checked=true]").each(function(){
				sum++;
				str=this.value;
			});
			if(sum==0){
				jAlert('请先选择要编辑的内容','信息提示');
				return false;
			}else if(sum>1){
				jAlert('请不要选择多个项','信息提示');
				return false;
			}else{
				jConfirm('确定编辑此项吗?','信息提示',function(r){
					if(r){
					window.location.href="jshop/admin/goods/editgoods.jsp?goodsid="+str+"";
					
				}
				});
			}
		}else if(com='删除'){
			var sum=0;
			var str="";
			$(":checkbox[name='firstcol'][checked=true]").each(function(){
				sum++;
				str+=this.value+",";
			});
			if(sum==0){
				jAlert('请先选择要删除的内容','信息提示');
				
				return false;
			}else{
				jConfirm('确定删除此项吗?','信息提示',function(r){
					if(r){
					$.post("DelBrandt.action",{"brandid":str},function(data){
						$('#brandmanagement').flexReload();
					});
				}
				});
			}
		}
	}
	
	function setlinkgoods(com,gird){
		var sum=0;
		var str="";
		$(":checkbox[name='firstcol'][checked=true]").each(function(){
			sum++;
			str=this.value;
		});
		if(sum==0){
			jAlert('请先选择要增加商品组合的内容','信息提示');
			
			return false;
		}else if(sum>1){
			jAlert('请不要选择多个项','信息提示');
			
			return false;
		}else{
			showlinkgoodsarea();
		}
	}

});
