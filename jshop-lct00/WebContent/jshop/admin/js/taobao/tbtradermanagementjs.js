
var session;
$(function(){
	$.post("CheckLogin.action",function(data){
		if(data.slogin){
			top.location.href="../adminlogin.jsp";
		}else{
			session=data.usession;
		}
	});
	$("h6").each(function(){
		$(this).removeClass("selected"); 
	});
	$("ul").each(function(){
		$(this).removeClass("opened"); 
		$(this).addClass("closed"); 
	});
	$("#h-menu-saletools").addClass("selected");
	$("#menu-saletools").removeClass("closed"); 
	$("#menu-saletools").addClass("opened");
});



//flexigrid
$(function() {
	var params=$.query.get("params");
	$("#tbonsaleitemsmanagement").flexigrid( {
		url : 'findAlltraderatessearchById.action?params='+params,
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '序号',
			name : 'nick',
			width : 100,
			sortable : true,
			align : 'center'
		},{ 
			display:'评价者昵称',
			name:'nick',
			width:115,
			sortable:true,
			align:'center'
		},{ 
			display:'标题',
			name:'item_title',
			width:315,
			sortable:true,
			align:'center'
		},{ 
			display:'评价结果',
			name:'result',
			width:100,
			sortable:true,
			align:'center'
		},{ 
			display:'评价时间',
			name:'created',
			width:100,
			sortable:true,
			align:'center'
		},{ 
			display:'内容',
			name:'content',
			width:100,
			sortable:true,
			align:'center'
		},{ 
			display:'解释',
			name:'reply',
			width:100,
			sortable:true,
			align:'center'
		},{ display:'操作',
			name:'operating',
			width:200,
			sortable:true,
			align:'center'
		}],
		buttons : [ {
			name : '全选',
			bclass : 'add',
			onpress : test
		}, {
			name : '反选',
			bclass : 'add',
			onpress : test
		},{
			separator : true
		} ],

		searchitems : [ {
			display:'请选择搜索条件',
			name:'sc',
			isdefault : true
		} ],
		sortname : "num_iid",
		sortorder : "desc",
		usepager : true,
		title : '',
		useRp : true,
		rp : 20,
		rpOptions : [ 5, 20, 40, 100 ],
		showTableToggleBtn : true,
		width :'auto',
		height : 600,
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...'
	});


	function test(com, grid) {
		if (com == '添加') {
			window.location.href="jshop/admin/pagecontent/addarticle.jsp";

		}else if(com=='编辑'){
			var sum=0;
			var str="";
			$(":checkbox[name='firstcol'][checked=true]").each(function(){
				sum++;
				str=this.value;
			});
			if(sum==0){
				jAlert('请先选择要编辑的内容', '信息提示');
				return false;
			}else if(sum>1){
				jAlert('请不要选择多个项', '信息提示');
				return false;
			}else{
				jConfirm('确定编辑此项吗?','信息提示',function(r){
					if(r){
					window.location.href="jshop/admin/pagecontent/addarticle.jsp?articleid="+str;
				}
				});
			}
		}else if(com=='删除'){
			var sum=0;
			var str="";
			$(":checkbox[name='firstcol'][checked=true]").each(function(){
				sum++;
				str+=this.value+",";
			});
			if(sum==0){
				jAlert('请先选择要删除的内容', '信息提示');
				return false;
			}else{
				jConfirm('确定删除此项吗?','信息提示',function(r){
					if(r){
					$.post("delArticleT.action",{"articleid":str},function(data){
						$('#articlemanagement').flexReload();
					});
				}
				});
			}
		} else if(com=='全选'){
			$(":checkbox[name='firstcol']").each(function(){
				this.checked=true;
			}
			);
			
		}else if(com=='反选'){
			$(":checkbox[name='firstcol']").each(function(){
				
				this.checked=false;
				
			}
			);
		}
		

	}

	

});
