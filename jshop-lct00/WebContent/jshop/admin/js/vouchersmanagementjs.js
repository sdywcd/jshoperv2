//function IFrameResize(){
// 	 var obj = parent.document.getElementById("frm_main"); 
// 	 obj.height = this.document.body.scrollHeight+100; 
// 	}

$(function(){
	$('#vouchersname').val(randomChar(10));
});
//生成随即优惠券
function randomChar(l){
	   var x="0123456789qwertyuioplkjhgfdsazxcvbnm";
	   var tmp="";
	   for(var i=0;i<l;i++)   {
	   tmp+=x.charAt(Math.ceil(Math.random()*100000000)%x.length);
	   }
	   return tmp;
}

//点击刷新编码
$(function(){
	$('#refresh').click(function(){
		$('#vouchersname').val(randomChar(10));
	});
});
//当选择金额时显示金额输入框
$(function(){
	$('#contentstate').change(function(){
		var cv=$("#contentstate").val();
		if(cv=="1"){
			$('#voucherscontent').show();
			$('#voucherscontentlabel').show();
		}
		if(cv=="0"){
			$('#voucherscontent').hide();
			$('#voucherscontentlabel').hide();
		}
	});

});
//增加抵用券
$(function(){
	$('#addvouchers').click(function(){
		//抵扣内容类型
		var contentstate=$('#contentstate').val();
		//抵用券内容商品和金钱
		var voucherscontent="";
		//优惠券编码
		var vouchersname=$('#vouchersname').val();
		//使用金额上限
		var limitprice=$('#limitprice').val();
		//抵用券种类
		var voucheruseway=$('#voucheruseway').val();
		//开始时间
		var begintime=$('#begintime').val();
		//结束时间
		var endtime=$('#endtime').val();
		
		var cv=$("#contentstate").val();
		var sum=0;
		var str="";
		
		if(cv=="0"){
			$(":checkbox[name='firstcol'][checked=true]").each(function(){
				sum++;
				str=this.value;
			});
			if(sum==0){
				jAlert('请选择作为抵用券的商品','信息提示');
				
				return false;
			}else if(sum>1){
				jAlert('不要选择多个商品作为抵用券内容','信息提示');
				
				return false;
			}else{
				voucherscontent=str;
			}
		}
		if(cv=="1"){
			voucherscontent=$('#voucherscontent').val();
		}
		//执行增加抵用券操作
		$.post("addVoucherst.action",{"vouchersname":vouchersname,"begintime":begintime,"endtime":endtime,"voucherscontent":voucherscontent,"limitprice":limitprice,"voucherstate":cv,"voucheruseway":voucheruseway},function(data){
			 if(data.addvoucherflag){
				 jAlert('增加成功','信息提示');
				
				return true;
			 }else{
				 jAlert('增加失败','信息提示');
				 
					return false;
			 }
		});
		
	});
});

//flexigrid for vouchers
$(function() {
	$("#vouchersmanagement").flexigrid( {
		url : 'findAllVoucherst.action',
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '序号',
			name : 'vouchersid',
			width : 100,
			sortable : true,
			align : 'center'
		},{ 
			display:'抵用券编码',
			name:'vouchersname',
			width:200,
			sortable:true,
			align:'center'
		},{
			display:'开始时间',
			name:'begintime',
			width:100,
			sortable:true,
			align:'center'
		},{
			display:'结束时间',
			name:'endtime',
			width:100,
			sortable:true,
			align:'center'
		},{
			display:'抵用券内容',
			name:'voucherscontent',
			width:100,
			sortable:true,
			align:'center'
		},{
			display:'使用限额',
			name:'limitprice',
			width:100,
			sortable:true,
			align:'center'
		},{
			display:'抵用券种类',
			name:'voucherstate',
			width:100,
			sortable:true,
			align:'center'
		},{
			display:'抵用券方式',
			name:'voucheruseway',
			width:100,
			sortable:true,
			align:'center'
		},{
			display:'使用状态',
			name:'state',
			width:100,
			sortable:true,
			align:'center'
		},{
			display:'抵用券归属人',
			name:'givenuserid',
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
		}],
		buttons : [{
			name:'删除',
			bclass:'add',
			onpress:test
		},{
			separator : true
		} ],

		searchitems : [ {
			display : '抵用券种类',
			name : 'voucherstate',
			isdefault : true
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
		
	});

	
	function test(com, grid) {
		 if(com='删除'){
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
					$.post("DelVoucherst.action",{"vouchersid":str},function(data){
						$('#vouchersmanagement').flexReload();
					});
				}
				});
			}
		}
	}
});


//flexigrid
$(function() {
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
			width:100,
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
			separator : true
		} ],

		searchitems : [ {
			display : '商品品牌名称',
			name : 'brandname',
			isdefault : true
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
		
	});

	
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
						$('#goodsmanagement').flexReload();
					});
				}
				});
			}
		}
	}
});