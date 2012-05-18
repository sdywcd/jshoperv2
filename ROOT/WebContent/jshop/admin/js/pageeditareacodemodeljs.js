//function IFrameResize(){
// 	 var obj = parent.document.getElementById("frm_main"); 
// 	 obj.height = this.document.body.scrollHeight+100; 
// 	}

$(function(){
	
	//2号区域
	function area2(){
		var a2="<ul>" +
				"<li><a href='goods/goodsdetial.jsp?goodsid=#' target='_blank'><img width='170px' height='50px' alt='#' src='#'></img></a></li>" +
				"</ul>";
		return a2;
	}
	//3号区域
	function area3(){
		var a3="<ul>" +
				"<li><dt><a href='goods/goodsdetial.jsp?goodsid=#' target='_blank'><img width='50px' height='60px' alt='#' src='#'></img></a></dt>" +
				"<dd>" +
				"<div class='spprice'>特惠价<strong>请输入价格</strong></div>" +
				"<div class='spprice'>原价<del>请输入价格</del></div>" +
				"<div class='detialbutton'><a href='goods/goodsdetail.jsp?goodsid=#'>查看详情</a></div></dd></li></ul>";
		return a3;
	}
	
	//4号区域
	function area4(){
		var a4="<li><a href='goods/goodsdetail.jsp?goodsid=#' target='_blank'><img src='#' alt='#'></img></a></li>";
			return a4;
	}
	
	//5号区域
	function  area5(){
         var a5="<ul class='tabs'>"+
		             "<li><a href='#'>请输入标题</a></li>"+
		             "<li><a href='#'>请输入标题</a></li>"+
		             "<li><a href='#'>请输入标题</a></li>"+
		             "<li><a href='#'>请输入标题</a></li>"+
		         "</ul>"+
		         "<div class='panes'>"+
		             "<div>" +
		             "<a href='goods/goodsdetail.jsp?goodsid=#' target='_blank'><img width='170px' height='244px' src='#'></img></a>" +
		             "<a href='goods/goodsdetail.jsp?goodsid=#' target='_blank'><img width='170px' height='244px' src='#'></img></a>" +
		             "<a href='goods/goodsdetail.jsp?goodsid=#' target='_blank'><img width='170px' height='244px' src='#'></img></a>" +
		             "<a href='goods/goodsdetail.jsp?goodsid=#' target='_blank'><img width='170px' height='244px' src='#'></img></a>" +
		             "</div>"+
		             "<div>" +
		             "<a href='goods/goodsdetail.jsp?goodsid=#' target='_blank'><img width='170px' height='244px' src='#'></img></a>" +
		             "<a href='goods/goodsdetail.jsp?goodsid=#' target='_blank'><img width='170px' height='244px' src='#'></img></a>" +
		             "<a href='goods/goodsdetail.jsp?goodsid=#' target='_blank'><img width='170px' height='244px' src='#'></img></a>" +
		             "<a href='goods/goodsdetail.jsp?goodsid=#' target='_blank'><img width='170px' height='244px' src='#'></img></a>" +
		             "</div>"+
		             "<div>" +
		             "<a href='goods/goodsdetail.jsp?goodsid=#' target='_blank'><img width='170px' height='244px' src='#'></img></a>" +
		             "<a href='goods/goodsdetail.jsp?goodsid=#' target='_blank'><img width='170px' height='244px' src='#'></img></a>" +
		             "<a href='goods/goodsdetail.jsp?goodsid=#' target='_blank'><img width='170px' height='244px' src='#'></img></a>" +
		             "<a href='goods/goodsdetail.jsp?goodsid=#' target='_blank'><img width='170px' height='244px' src='#'></img></a>" +
		             "</div>"+
		             "<div>" +
		             "<a href='goods/goodsdetail.jsp?goodsid=#' target='_blank'><img width='170px' height='244px' src='#'></img></a>" +
		             "<a href='goods/goodsdetail.jsp?goodsid=#' target='_blank'><img width='170px' height='244px' src='#'></img></a>" +
		             "<a href='goods/goodsdetail.jsp?goodsid=#' target='_blank'><img width='170px' height='244px' src='#'></img></a>" +
		             "<a href='goods/goodsdetail.jsp?goodsid=#' target='_blank'><img width='170px' height='244px' src='#'></img></a>" +
		             "</div>"+
		         "</div>";
		     return a5;
	}
	
	//6号区域
	function area6(){
		var a6="<div class='p_div'>" +
				"<ul class='t_ul'>" +
				"<li class='fore'>" +
				"<div class='p_img'>" +
				"<a href='goods/goodsdetail.jsp?goodsid=#'><img src='#'></img></a>" +
				"</div>" +
				"<div class='p_name'>" +
				"<a href='goods/goodsdetail.jsp?goodsid=#'>#</a>" +
				"</div>" +
				"<div class='p_price'>" +
				"<span class='reduce'>请输入市场价格</span>" +
				"<span class='price'>请输入优惠价格</span>" +
				"</div>" +
				"</li>" +
				"</ul>" +
				"</div>";
		return a6;
	}
	
	//7号区域
	function area7(){
		var a7="<div class='p_div'>" +
				"<ul class='t_ul'>" +
				"<li class='fore'>" +
				"<div class='p_img'>" +
				"<a href='goods/goodsdetail.jsp?goodsid=#'><img src='#'></img></a>" +
				"</div>" +
				"<div class='p_name'>" +
				"<a href='goods/goodsdetail.jsp?goodsid=#'>#请输入商品名称</a>" +
				"</div>" +
				"<div class='p_price'>" +
				"<span class='reduce'>请输入市场价格</span>" +
				"<span class='price'>请输入优惠价格</span>" +
				"</div>" +
				"</li>" +
				"</ul>" +
				"</div>";
		return a7;
	}
	
	//8号区域
	function area8(){
		var a8="<ul class='links'>" +
				"<li class='first'><a href='notice/noticedetail.jsp?noticeid=noticeid'>请输入公告标题</a></li>" +
				"</ul>";
		return a8;
	}
	
	//9号区域
	function area9(){
		var a9="<div id='hpgoods'>"+
			   "<ul>"+
			   "<li>"+
			   "<dt>"+
               "<a href='goods/goodsdetial.jsp?goodsid=#' target='_blank'><img width='150px' height='60px' alt='#' src='jshop/Uploads/88_31_cuHtmr.jpg' /></a>"+
               "</dt>"+
               "<dd>"+
               "<div class='spprice'>特惠价<strong>#</strong></div>"+
               "<div class='spprice'>原价<del>#</del></div>"+
               "<div class='detialbutton'><a href='goods/goodsdetail.jsp?goodsid=#'>查看详情</a></div>"+
               "</dd>"+
               "</li>"+
               "</ul>"+
               "</div>";
		return a9;
	}
	
	//10号区域
	function area10(){
		var a10="<h2 class='current'>商品名称</h2>"+
				"<div class='pane' style='display:block'>"+
				"<img width='82px' height='82px' src='#' alt='#' style='float:left;margin:0 16px 15px 0'></img>"+
				"<h3>输入会员价</h3>"+
				"<p>" +
				"<strong>输入市场价</strong>" +
				"</p>" +
				"<p style='clear:both'>介绍性文字</p>"+
				"</div>"+
				
				"<h2>商品名称</h2>"+
				"<div class='pane'>"+
				"<img width='82px' height='82px' src='#' alt='#' style='float:left;margin:0 16px 15px 0'></img>"+
			    "<h3>输入会员价</h3>"+
			    "<p>" +
			    "<strong>输入市场价</strong>" +
			    "</p>"+
			    "<p style='clear:both'>介绍性文字</p>"+
				"</div>";
		return a10;
	}
	
	$('#getcode').click(function(){
		var editflag=$("#editflag").val();
		if(editflag=="2"){
			var a2=area2();
			KE.html("editareavalue", a2);
			return;
		}
		if(editflag=="3"){
			var a3=area3();
			KE.html("editareavalue", a3);
			return;
		}
		if(editflag=="4"){
			var a4=area4();
			KE.html("editareavalue", a4);
			return;
		}
		if(editflag=="5"){
			var a5=area5();
			KE.html("editareavalue", a5);
			return;
		}
		if(editflag=="6"){
			var a6=area6();
			KE.html("editareavalue", a6);
			return;
		}
		if(editflag=="7"){
			var a7=area7();
			KE.html("editareavalue", a7);
			return;
		}
		if(editflag=="8"){
			var a8=area8();
			KE.html("editareavalue", a8);
			return;
		}
		if(editflag=="9"){
			var a9=area9();
			KE.html("editareavalue", a9);
			return;
		}
		if(editflag=="10"){
			var a10=area10();
			KE.html("editareavalue", a10);
			return;
		}
		
	});

	
	
});



//点击编辑更新内容
$(function(){
	$("#modify").click(function(){
		var brandid=$("#brandid").val();
		var brandname=$("#brandname").val();
		$.post("UpdateBrandt.action",{"brandid":brandid,"brandname":brandname},function(data){
			$('#brandmanagement').flexReload();
		});
	});
});


//flexigrid
$(function() {
	$("#pageeditareamanagement").flexigrid( {
		url : 'findAllPageareaT.action',
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '序号',
			name : 'pageid',
			width : 100,
			sortable : true,
			align : 'center'
		},{ 
			display:'页面名称',
			name:'pagename',
			width:215,
			sortable:true,
			align:'center'
		},{ 
			display:'商品分类名称',
			name:'typename',
			width:315,
			sortable:true,
			align:'center'
		},{ 
			display:'路径',
			name:'url',
			width:315,
			sortable:true,
			align:'center'
		}],
		buttons : [ {
			name : '添加页面',
			bclass : 'add',
			onpress : test
		}, {
			name : '编辑页面',
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
			display : '页面名称',
			name : 'pagename',
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
			$("#submit").show();
			$("#modify").hide();
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
					$.post("findBrandById.action",{"brandid":str},function(data){
						$("#submit").hide();
						$("#modify").show();
						$("#brandname").attr("value",data.beanlist.brandname);
						$("#brandid").attr("value",data.beanlist.brandid);
						return;
					});
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
		height : 100,
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

