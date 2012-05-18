//function IFrameResize(){
// 	 var obj = parent.document.getElementById("frm_main"); 
// 	 obj.height = this.document.body.scrollHeight+100; 
// 	}
//拦截器json页面跳转
window.onload=checklogin;
var session ="true";
//function checklogin(){
//	var tag=$('#brandmanagement');
//	if(tag.is(":hidden")){
//		top.location.href="jshop/admin/adminlogin.jsp";
//		return;
//	}
//}


//点击编辑更新内容
$(function(){
	$("#editpage").click(function(){
		var rangearea=$("input[type=radio]:checked").val();
		var pagename=$("#pagename").val();
		var pagenameen=$("#pagenameen").val();
		var url=$("#url").val();
		var pageid=$("#pageid").val();
		var canedit=$("#canedit").val();
		$.post("UpdatePaget.action",{"pageid":pageid,"url":url,"pagenameen":pagenameen,"pagename":pagename,"rangearea":rangearea,"canedit":canedit},function(data){
			$('#pagesmanagement').flexReload();
		});
	});
});

//flexigrid
$(function() {
	$("#pagesmanagement").flexigrid( {
		url : 'findAllPaget.action',
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '序号',
			name : 'pageid',
			width : 100,
			sortable : true,
			align : 'center'
		},{ 
			display:'中文名称',
			name:'pagename',
			width:215,
			sortable:true,
			align:'center'
		},{ 
			display:'英文名称',
			name:'pagenameen',
			width:215,
			sortable:true,
			align:'center'
		},{ 
			display:'链接地址',
			name:'url',
			width:315,
			sortable:true,
			align:'center'
		},{ 
			display:'范围',
			name:'rangearea',
			width:215,
			sortable:true,
			align:'center'
		},{ 
			display:'是否可编辑',
			name:'canedit',
			width:215,
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
			name : '全选',
			bclass : 'add',
			onpress : test
		}, {
			name : '反选',
			bclass : 'add',
			onpress : test
		},{
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
			display : '英文名称',
			name : 'pagenameen',
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
		onSuccess:ck
	});
	function ck(){
		var tag=$('#pagesmanagement');
		if(tag.is(":hidden")){
			top.location.href="jshop/admin/adminlogin.jsp";
			return;
		}
	}
	function test(com, grid) {
		if(com=='编辑'){
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
					$('#submit').hide();
					$('#editpage').show();
					$.post("findPagetById.action",{"pageid":str},function(data){
						if("1"==data.beanlist.range){
							$('#rangearea').attr("checked","checked");
						}
						if("2"==data.beanlist.range){
							$('#rangearea').attr("checked","checked");
						}
						$('#pagename').attr("value",data.beanlist.pagename);
						$('#pagenameen').attr("value",data.beanlist.pagenameen);
						$('#url').attr("value",data.beanlist.url);
						$('#canedit').val(data.beanlist.canedit);
						$('#pageid').attr("value",data.beanlist.pageid);
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
					$.post("DelPaget.action",{"pageid":str},function(data){
						$('#pagesmanagement').flexReload();
					});
				}
				});
			}
		}else if(com=='全选'){
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
