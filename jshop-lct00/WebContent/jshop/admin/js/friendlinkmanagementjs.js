
/**
 * Global variables
 */
var session="true";
var fg=false;
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
//验证链接传递的参数
function validatethenpostinfotoaddLink(){
	var linkName=$('#linkName').val();
	var linkUrl=$('#linkUrl').val();
	var sort=$('#sort').val();
	var linkLogo=$('#linkLogo').val();
	if(""==linkName){
		jAlert('链接名称必须填写','信息提示');
		return false;
	}
	if(""==linkUrl){
		jAlert('链接地址必须填写','信息提示');
		return false;
	}
	fg =true;
}
/*===========================================Gorgeous split-line==============================================*/
/**
 * Required to initialize the page data
 */
$(function(){
	$("#delpc").click(function(){
		var str="";
		var sum=0;
		$(":checkbox[name='pcpath'][checked=true]").each(function(){
			sum++;
			str=this.id;
		});
		if(sum==0){
			jAlert('只有在选择图片后才能删除', '信息提示');
			return false;
		}
		if(sum>1){
			jAlert('不能选择多个图片', '信息提示');
			return false;
		}
		$('#triggers img').each(function(){
			if(this.id==str){
				this.style.display="none";
				$(":checkbox[name='pcpath'][checked=true]").each(function(){
					if(this.id==str){
						this.style.display="none";
						this.name="dispcpath";
					}
					
				});
			}
			
			
		});  

	});
});
/*===========================================Gorgeous split-line==============================================*/


/**
 * flexigrid list 
 */
$(function() {

	$("#friendlinkmanagement").flexigrid( {
		url : 'findAllFriendLink.action',
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '序号',
			name : 'friendlinkid',
			width : 100,
			sortable : true,
			align : 'center'
		}, {
			display : '链接名称',
			name : 'linkName',
			width : 100,
			sortable : true,
			align : 'center'
		}, {
			display : '链接图片',
			name : 'linkLogo',
			width : 400,
			sortable : true,
			align : 'center'
		}, {
			display : '链接地址',
			name : 'linkUrl',
			width : 100,
			sortable : true,
			align : 'center'
		}, {
			display : '排序号',
			name : 'sort',
			width : 100,
			sortable : true,
			align : 'center'
		} ],

		buttons : [ {
			name : '添加',
			bclass : 'add',
			onpress : test
		}, {
			name : '编辑',
			bclass : 'add',
			onpress : test
		}, {
			name : '删除',
			bclass : 'add',
			onpress : test
		},{
			separator : true
		} ],
		searchitems : [ {
			display : '请选择搜索条件',
			name : 'sc',
			isdefault : true
		}, {
			display : '商品名称',
			name : 'goodsname'
		} ],

		sortname : "sort",
		sortorder : "desc",
		usepager : true,
		title : '友情链接列表',
		useRp : true,
		rp : 20,
		rpOptions : [ 5, 20, 40, 100 ],
		showTableToggleBtn : true,
		width : 'auto',
		height : 'auto',
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...'
	});
	function test(com, grid) {
		if (com == '添加') {
			window.location.href = '../setting/addFriendLink.jsp?session='+session+"#settings";
			return;

		} else if (com == '编辑') {
			var sum = 0;
			var str = "";
			$(":checkbox[name='firstcol'][checked=true]").each(function() {
				sum++;
				str = this.value;
			});
			if (sum == 0) {
				jAlert('请先选择要编辑的内容', '信息提示');
				return false;
			} else if (sum > 1) {
				jAlert('请不要选择多个项', '信息提示');
				return false;
			} else {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						window.location.href = "addFriendLink.jsp?session="+session+"#settings&friendlinkid=" + str + "";

					}
				});
			}
		} else if (com == '删除') {
			var sum = 0;
			var str = "";
			$(":checkbox[name='firstcol'][checked=true]").each(function() {
				sum++;
				str += this.value + ",";
			});
			if (sum == 0) {
				jAlert('请先选择要删除的内容', '信息提示');

				return false;
			} else {
				jConfirm('确定删除此项吗?', '信息提示', function(r) {
					if (r) {
						$.post("delFriendLink.action", {
							"friendlinkid" : str
						}, function(data) {
							$('#friendlinkmanagement').flexReload();
						});
					}
				});
			}
		}

	}

});
/*===========================================Gorgeous split-line==============================================*/

/**
 * Add Function
 */
$(function(){
	$('#submit').show();
	$('#submit').click(function(){
		validatethenpostinfotoaddLink();
		if(fg){
			var linkName=$('#linkName').val();
			var linkUrl=$('#linkUrl').val();
			var sort=$('#sort').val();
			var linkLogo="";
			$(":checkbox[name='pcpath'][checked=true]").each(function(){
				linkLogo+=this.value+",";
			});
			$.post("addFriendLink.action",{"linkLogo":linkLogo,"linkName":linkName,"linkUrl":linkUrl,"sort":sort},function(data){
				window.location.href="friendlinkmanagement.jsp?session="+session+"#settings";
			});
		}
	});
});
/**
 * Update Function
 */
$(function(){
	var friendlinkid=$.query.get('friendlinkid');
	if(friendlinkid!=""){
		$.post("findFriendByID.action",{"friendlinkid":friendlinkid},function(data){
			$('#friendlinkid').attr("value",friendlinkid);
			$('#linkName').attr("value",data.linklist.linkName);
			$('#linkUrl').attr("value",data.linklist.linkUrl);
			$('#sort').attr("value",data.linklist.sort);
			//图片显示
			var pcpath="";
			var pcurl=data.linklist.linkLogo;
			var htm="";
			var checkpc="";
			var temp=pcurl.split(',');
			var allpcpath="";
			$.each(temp,function(n,value){
				if(""==value){
					return;
				}
				pcpath=value;
				htm="<img id='"+value+"' src='"+pcpath+"'></img>";
				checkpc="<input id='"+value+"' name='pcpath' type='checkbox' value='"+value+"' checked/>";
				allpcpath=htm+checkpc;
				$('#triggers').append(allpcpath);
			});
			$('#update').show();
			$('#submit').hide();
			return;
		});
	}
	
	$('#update').click(function(){
		validatethenpostinfotoaddLink();
		if(fg){
			var friendlinkid=$('#friendlinkid').val();
			var linkName=$('#linkName').val();
			var linkUrl=$('#linkUrl').val();
			var sort=$('#sort').val();
			var linkLogo="";
			$(":checkbox[name='pcpath'][checked=true]").each(function(){
				linkLogo+=this.value+",";
			});
			$.post("updateFriendLink.action",{"friendlinkid":friendlinkid,"linkLogo":linkLogo,"linkName":linkName,"linkUrl":linkUrl,"sort":sort},function(data){
				window.location.href="friendlinkmanagement.jsp?session="+session+"#settings";
			});
		}
	});
	
	
});

