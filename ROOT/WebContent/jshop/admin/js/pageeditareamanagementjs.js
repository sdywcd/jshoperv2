/**
 * Global variables
 */
var session="true";
/*===========================================Gorgeous split-line==============================================*/
/**
 * Required to initialize the page data
 */
$(function(){
	$("h6").each(function(){
		$(this).removeClass("selected"); 
	});
	$("ul").each(function(){
		$(this).removeClass("opened"); 
		$(this).addClass("closed"); 
	});
	$("#h-menu-pages").addClass("selected");
	$("#menu-pages").removeClass("closed"); 
	$("#menu-pages").addClass("opened");
});
// 当页面select改变时注入pageid到hidden中
$(function(){
	//获取导航数据
	$.post("findSiteNavigationList.action",function(data){
		if(data.sucflag){
			$('#sitenavigationlist').append(data.sitenavigationstr);
			return;
		}
	});
	//获取商品分类
	$.post("findGoodsCategoryList.action",function(data){
		if(data.sucflag){
			$('#goodscategorylist').append(data.goodscategorystr);
			return;
		}
	});
	//当页面类型改变
	$('#pagetype').change(function(){
		var pagetype=$('#pagetype').val();
		if("0"==pagetype){
			$('#sitenavigationlist').attr("disabled",true);
			$('#goodscategorylist').attr("disabled",true);
			$('#editflag').attr("disabled",true);
			$('#editareatitle').attr("disabled",true);
		}else if("sitenavigation"==pagetype){
			$('#sitenavigationlist').attr("disabled",false);
			$('#goodscategorylist').attr("disabled",true);
			$('#editflag').attr("disabled",false);
			$('#editareatitle').attr("disabled",false);
		}else{
			$('#sitenavigationlist').attr("disabled",true);
			$('#goodscategorylist').attr("disabled",false);
			$('#editflag').attr("disabled",false);
			$('#editareatitle').attr("disabled",false);
		}
		var pagename=$('#pagetype').find("option:selected").text();
		$('#pagename').attr("value",pagename);
		
	});
	
	$('#pageid').change(function(){
		var pageid=$('#pageid').val();
		if("0"==pageid){
			$('#navtypeid').hide();
			$('#ltypeid').hide();
			$('#stypeid').hide();
		}else{
			$('#typeid').attr("value","0");
			$('#typename').attr("value","");
			$('#navtypeid').attr("value","0");
			$('#ltypeid').attr("value","0");
			$('#stypeid').attr("value","0");
			$('#navtypeid').show();
			$('#ltypeid').show();
			$('#stypeid').show();
		}
		var pagename=$('#pageid').find("option:selected").text();
		$('#pagename').attr("value",pagename);
		
	});


	
});
/*===========================================Gorgeous split-line==============================================*/

/**
 * flexigrid list 
 */
$(function() {
	$("#pageeditareamanagement").flexigrid( {
		url : 'findAllPageareaT.action',
		dataType : 'json',
		cache : false,
		colModel : [{ 
			display:'页面名称',
			name:'name',
			width:215,
			sortable:true,
			align:'center'
		},{ 
			display:'标题',
			name:'editareatitle',
			width:315,
			sortable:true,
			align:'center'
		},{ 
			display:'编辑位置',
			name:'editflag',
			width:100,
			sortable:true,
			align:'center'
		},{ 
			display:'创建人',
			name:'creatorid',
			width:215,
			sortable:true,
			align:'center'
		},{ 
			display:'显示状态',
			name:'state',
			width:115,
			sortable:true,
			align:'center'
		},{
			display : '操作',
			name : 'operating',
			width : 110,
			sortable : true,
			align : 'center'
		}],
		buttons : [{
			name:'添加编辑页面',
			bclass:'add',
			onpress:action
		},{
			name : '编辑页面',
			bclass : 'edit',
			onpress : action
		},{
			name:'禁用',
			bclass:'edit',
			onpress:action
		},{
			name:'启用',
			bclass:'edit',
			onpress:action
		},{
			name:'删除',
			bclass:'delete',
			onpress:action
		},{
			separator : true
		} ],

		searchitems : [ {
			display : '请选择',
			name : 'sc',
			isdefault : true
		} ],
		sortname : "createtime",
		sortorder : "desc",
		usepager : true,
		title : '自定义页面列表',
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
		if(com=='编辑页面'){
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						window.location.href="addpageeditarea.jsp?session="+session+"#pages&pageeditareaid="+str;
						return;
					}
				});
			} else {
				jAlert('请选择一条信息', '信息提示');
				return false;
			}
		}else if(com=='禁用'){
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定禁用此项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						$.post("UpdatePageEditareaTBystate.action",{"pageeditareaid":str,"state":"2"},function(data){
							$('#pageeditareamanagement').flexReload();
						});
					}
				});
				return;
			} else {
				jAlert('请选择要禁用的信息!', '信息提示');
				return false;
			}
		}else if(com=='启用'){
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定启用此项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						$.post("UpdatePageEditareaTBystate.action",{"pageeditareaid":str,"state":"1"},function(data){
							$('#pageeditareamanagement').flexReload();
						});
					}
				});
				return;
			} else {
				jAlert('请选择要启用的信息!', '信息提示');
				return false;
			}
		}else if(com=='添加编辑页面'){
			window.location.href='addpageeditarea.jsp?session='+session;
			return;
		}else if(com=='删除'){
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定删除此项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						$.post("delPageEditareaTBypageeditareaid.action",{"pageeditareaid":str},function(data){
							$('#pageeditareamanagement').flexReload();
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
		if($('#sitenavigationlist').attr("disabled")==false){
			var pagename=$('#pagename').val();
			var sitenavigationlist=$('#sitenavigationlist').val();
			var array=new Array();
			array=sitenavigationlist.split(",");
			var snid=array[0];
			var htmlpath=array[1];
			var sign=array[2];
			var name="["+pagename+"]"+$('#sitenavigationlist').find("option:selected").text();
			var editareatitle=$('#editareatitle').val();
			var editareavalue=$('#editareavalue').val();
			var editflag=$('#editflag').val();
			var state="1";
			var goodscategoryid=null;
			$.post("addPageEditareaT.action",{"goodscategoryid":goodscategoryid,"name":name,"sign":sign,"htmlpath":htmlpath,"editareatitle":editareatitle,"editareavalue":editareavalue,"editflag":editflag,"state":state,"snid":snid},function(data){
				if(data.sucflag){
					jAlert('添加自定义数据成功', '信息提示');
					window.location.href="pageeditareamanagement.jsp?session="+session+"#pages";
					return;
				}
			});
		}
		
		if($('#goodscategorylist').attr("disabled")==false){
			//var pagename=$('#pagename').val();
			var goodscategorylist=$('#goodscategorylist').val();
			var array=new Array();
			array=goodscategorylist.split(",");
			var goodscategoryid=array[0];
			var sign=array[1];
			var htmlpath="html/default/shop/"+sign+".html";
			var name="["+pagename+"]"+$('#goodscategorylist').find("option:selected").text();
			var editareatitle=$('#editareatitle').val();
			var editareavalue=$('#editareavalue').val();
			var editflag=$('#editflag').val();
			var state="1";
			var snid=null;
			$.post("addPageEditareaT.action",{"goodscategoryid":goodscategoryid,"name":name,"sign":sign,"htmlpath":htmlpath,"editareatitle":editareatitle,"editareavalue":editareavalue,"editflag":editflag,"state":state,"snid":snid},function(data){
				if(data.sucflag){
					jAlert('添加自定义数据成功', '信息提示');
					window.location.href="pageeditareamanagement.jsp?session="+session+"#pages";
					return;
				}
			});
		}
		
	});

});
/*===========================================Gorgeous split-line==============================================*/

/**
 * Update Function
 */
$(function(){
	var pageeditareaid=$.query.get('pageeditareaid');
	if(pageeditareaid==""){
		return false;
	}
	$.post("findPageEditareaById.action",{"pageeditareaid":pageeditareaid},function(data){
		if(data.sucflag){
			$('#hidpageeditareaid').attr("value",data.bean.pageeditareaid);
			if(data.bean.snid!="null"){
				$('#pagetype').val("sitenavigation");
				$('#sitenavigationlist').attr("value",data.bean.snid+','+data.bean.htmlpath);
				$('#goodscategorylist').attr("disabled",true);
				$('#editflag').val(data.bean.editflag);
				$('#editareatitle').val(data.bean.editareatitle);
				KE.html("editareavalue",data.bean.editareavalue);
			}
			if(data.bean.goodscategory!="null"){
				$('#pagetype').val("goodscategory");
				$('#goodscategorylist').attr("value",data.bean.goodsCategoryTid+','+data.bean.sign);
				$('#sitenavigationlist').attr("disabled",true);
				$('#editflag').val(data.bean.editflag);
				$('#editareatitle').val(data.bean.editareatitle);
				KE.html("editareavalue",data.bean.editareavalue);
			}
			$('#submit').hide();
			$('#editpagearea').show();
			
		}
	});
	
	$("#editpagearea").click(function(){
		var pageeditareaid=$('#hidpageeditareaid').val();
		if(!$('#sitenavigationlist').attr("disabled")){
			var pagename=$('#pagename').val();
			var sitenavigationlist=$('#sitenavigationlist').val();
			var array=new Array();
			array=sitenavigationlist.split(",");
			var snid=array[0];
			var htmlpath=array[1];
			var sign=array[2];
			var name="["+pagename+"]"+$('#sitenavigationlist').find("option:selected").text();
			var editareatitle=$('#editareatitle').val();
			var editareavalue=$('#editareavalue').val();
			var editflag=$('#editflag').val();
			var state="1";
			var goodscategoryid=null;
			$.post("UpdatePageEditareaT.action",{"pageeditareaid":pageeditareaid,"goodscategoryid":goodscategoryid,"name":name,"sign":sign,"htmlpath":htmlpath,"editareatitle":editareatitle,"editareavalue":editareavalue,"editflag":editflag,"state":state,"snid":snid},function(data){
				if(data.sucflag){
					jAlert('添加自定义数据成功', '信息提示');
					window.location.href="pageeditareamanagement.jsp?session="+session+"#pages";
					return;
				}
			});
		}
		
		if($('#goodscategorylist').attr("disabled")==false){
			var pagename=$('#pagename').val();
			var goodscategorylist=$('#goodscategorylist').val();
			var array=new Array();
			array=goodscategorylist.split(",");
			var goodscategoryid=array[0];
			var sign=array[1];
			var htmlpath="html/default/shop/"+sign+".html";
			var name="["+pagename+"]"+$('#goodscategorylist').find("option:selected").text();
			var editareatitle=$('#editareatitle').val();
			var editareavalue=$('#editareavalue').val();
			var editflag=$('#editflag').val();
			var state="1";
			var snid=null;
			$.post("UpdatePageEditareaT.action",{"pageeditareaid":pageeditareaid,"goodscategoryid":goodscategoryid,"name":name,"sign":sign,"htmlpath":htmlpath,"editareatitle":editareatitle,"editareavalue":editareavalue,"editflag":editflag,"state":state,"snid":snid},function(data){
				if(data.sucflag){
					jAlert('添加自定义数据成功', '信息提示');
					window.location.href="pageeditareamanagement.jsp?session="+session+"#pages";
					return;
				}
			});
		}
		
		
		
	});
});
