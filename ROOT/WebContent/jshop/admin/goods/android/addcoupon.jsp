<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("detail") != null ? request.getParameter("detail") : "";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>增加新商品</title>
    <meta charset="utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=basePath %>jshop/admin/css/overlay-basic.css" type="text/css" rel="stylesheet"/>
	<link href="<%=basePath %>jshop/admin/css/overlay-apple.css" type="text/css" rel="stylesheet"/>
	<link href="<%=basePath %>jshop/admin/js/Uploadify/uploadify.css" type="text/css" rel="stylesheet"/>
	<link href="<%=basePath %>jshop/admin/css/tab.css" type="text/css" rel="stylesheet"/>
	<link href="<%=basePath%>jshop/admin/themes/default/easyui.css" type="text/css" rel="stylesheet" />
	<link href="<%=basePath%>jshop/admin/css/form.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>jshop/admin/js/flexigrid/css/flexigrid/flexigrid_blue.css"/>
    <script type="text/javascript" src="<%=basePath %>jshop/admin/js/jquery1.4.2.js"></script>
    <script type="text/javascript" src="<%=basePath %>jshop/admin/js/jquery.tools.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>jshop/admin/js/flexigrid/flexigrid.js"></script>
   	<script type="text/javascript" src="<%=basePath %>jshop/admin/js/Uploadify/swfobject.js"></script>
   	<script type="text/javascript" src="<%=basePath %>jshop/admin/js/Uploadify/jquery.uploadify.v2.1.4.min.js"></script>
   	<script type="text/javascript" charset="utf-8"  src="<%=basePath %>jshop/admin/js/kindeditor.js"></script>
   	<script type="text/javascript" src="<%=basePath %>jshop/admin/js/addnewgoodsjs.js"></script>
 	<script type="text/javascript">
 		$(document).ready(function() {
  			$('#fileupload').uploadify({
    			'uploader'  : 'jshop/admin/js/Uploadify/uploadify.swf',
    			'script'    : '<%=basePath%>uploadFiles.action;jsessionid=<%=session.getId()%>',
    			'cancelImg' : 'jshop/admin/js/Uploadify/cancel.png',
    			'fileDataName'   : 'fileupload',  
    			'folder'    : '<%=basePath%>Uploads',
    			 'queueID': 'fileQueue',  
    			'multi'     : true,
				'auto'           : true,
				'displayData'    : 'speed',  
				'buttonText'     : 'Browse', //按钮上的文字 
				'sizeLimit'      : 1073741824,  
				'simUploadLimit' : 5,
				onComplete: function (event, queueID, fileObj, response, data) { 
					var pcpath="/Uploads/"+response;
					var htm="<img id='"+response+"' src='"+pcpath+"' rel='#"+fileObj.name+"'/>";
					var checkpc="<input id='pcpath' name='pcpath' type='checkbox' value='"+response+"'/> "
					$("#triggers").append(htm).append(checkpc);
						
				}, 
				onError: function(event, queueID, fileObj) { 
             		alert("文件:" + fileObj.name + "上传失败"); 
       			}, 
       			onCancel: function(event, queueID, fileObj){ 
       				alert("取消了" + fileObj.name); 
       			} 
            }); 
		});
 
 	</script>
 	<script type="text/javascript">
	 // if the function argument is given to overlay,
		// it is assumed to be the onBeforeLoad event listener
	$(function() {
		
		$("a[rel]").overlay({
	
			mask: 'white',
			effect: 'apple',
			speed:'nomal',
			onBeforeLoad: function() {
			},
			//隐藏错误提示
			onBeforeClose:function(){
				if(confirm("确定要关闭上传窗口吗？")){
					return true;
				}
				return false;
			}
		});
		});

 	</script>
 	<script type="text/javascript">
 		KE.show({
			id : 'detail',
		    imageUploadJson : '<%=basePath%>jshop/admin/js/jsp/upload_json.jsp',
			fileManagerJson : '<%=basePath%>jshop/admin/js/jsp/file_manager_json.jsp',
			allowFileManager : true,
			afterCreate : function(id) {
				KE.event.ctrl(document, 13, function() {
					KE.util.setData(id);
				});
			}
		});
 		
 	</script>
 	<style type="text/css">
 	.closeshow{
 		display:none;
 	}
		td{font-size:9pt;line-height:120%;color:#353535} 
		body{font-size:9pt;line-height:120%} 
		
		/* tab pane styling */
			/* alternate colors: skin2 */
	ul.skin2 a {
		background-color:#89a;		
		color:#fff !important;
	}
	
	/* mouseover state */
	ul.skin2 a:hover {
		background-color: #99BBE8;
	}
	
	/* active tab */
	ul.skin2 a.current {
		background-color: #99BBE8;
		border-bottom:2px solid #4F5C6A;	
	}
	
	/* tab pane with background gradient */
	div.skin2 div {
		/*min-height:200px;*/
		color:#fff;	
		background: #99BBE8 url(http://static.flowplayer.org/img/global/gradient/h300.png) repeat-x scroll 0 -50px;
		
		/* IE6 does not support PNG24 images natively */
		_background: #99BBE8;
	}

	#fileQueue {
 		 border: 1px solid #E5E5E5;
    height: 213px;
    margin-bottom: 10px;
    width: 370px;
	}
	
		/* use a semi-transparent image for the overlay */
	#overlay {
		background-image:url(<%=basePath%>jshop/admin/images/white.png);
		color:#efefef;
		height:450px;
	}
	
	/* container for external content. uses vertical scrollbar, if needed */
	div.contentWrap {
		height:441px;
		overflow-y:auto;
	}
	#triggers img {
		cursor:pointer;
		margin:0 5px;
		background-color:#fff;
		border:1px solid #ccc;
		padding:2px;
		width:200px;
		height:150px;
		-moz-border-radius:4px;
		-webkit-border-radius:4px;
		
	}
	
	
	
	/* styling for elements inside overlay */
	.details {
		position:absolute;
		top:15px;
		right:15px;
		font-size:11px;
		color:#fff;
		width:150px;
	}
	
	.details h3 {
		color:#aba;
		font-size:15px;
		margin:0 0 -10px 0;
	}
	
    </style>
  </head>
  
  <body>
      <table width="98%" border="0" cellpadding="1" cellspacing="1" align="center">
 		<tr> 
   			<td class="panel-header">增加新商品</td>
  		</tr>
   	  </table>
   	  <table  width="98%" border="0" cellpadding="1" cellspacing="1" align="center">
   	  <div id="goodsdiv" style="margin-left:12px; width:98%">

		<!-- tab "panes" --> 
		<div class="css-panes skin2">
			<!-- 基础属性区 --> 
			<div class="goods">
				<p>
         			<label>选择商品所属分类*</label>
         		   	<select id="navid" name="navid">
         		   		<option value="0">--请选择--</option>
         		   	</select>
         		   	<select id="ltypeid" name="ltypeid">
         		   		<option value="0">--请选择--</option>
         		   	</select>
         		   	<select id="stypeid" name="stypeid">
         		   		<option value="0">--请选择--</option>
         		   	</select>
      			</p>
      			<p>
      				<label>商品品牌*</label>
         			<select id="brand" name="brand">
         		   		<option value="0">--请选择--</option>
         		   	</select>
         		</p>
         		<p>
      				<label>商品产地*</label>
         			<select id="productplace" name="productplace">
         		   		<option value="0">--请选择--</option>
         		   	</select>
         		</p>
         		<p>
      				<label>商品编码*</label> 
         			<input id="usersetnum" name="usersetnum"  type="text" size="40" maxlength="40"></input>
      			</p>
      			<p>
      				<label>商品名称*</label> 
         			<input id="goodsname" name="goodsname"  type="text" size="80" maxlength="80"></input>
      			</p>
      			<p>
      				<label>商品(市场)价格*￥</label>
         			<input type="text" id="price" name="price"  size="20" maxlength="20"></input>
      			</p>
      			<p>
      				<label>商品(会员)价格*￥</label>
         			<input type="text" id="memberprice" name="memberprice"  size="20" maxlength="20"></input>
      			</p>
      			<p>
      				<label>商品积分*</label>
      				<input type="text" id="points" name="point" value="0" size="10" maxlength="10"></input>
      			</p>
      			<!-- 商品的进含量 -->
      			<p>
      				<label>商品进含量*</label>
      				<input type="text" id="jweight" name="jweight"  size="10" maxlength="10"></input>
      			</p>
      			<p>
      				<label>商品毛量*</label>
         			<input type="text" id="weight" name="weight"  size="10" maxlength="10"></input>
         			<select id="weightselect">
         				<option value="0">--请选择--</option>
         			</select>
      			</p>
      			<p>
      				<label>保质期(月)*</label>
         			<input type="text" id="shelflife" name="shelflife"  size="10" maxlength="10"></input>
      			</p>
      			<p>
      				<label>初始库存*</label>
      				<input type="text" id="quantity" name="quantity" value="" size="10" maxlength="10"/>
      			</p>
      			<p>
      				<label>是否推荐*</label>
      				<input type="radio" id="recommended" name="recommended" value="1"/><span>推荐</span>
      				<input type="radio" id="recommended" name="recommended" value="0" checked/><span>不推荐</span>
      			</p>
      			<p>
      				<label>是否热销*</label>
      				<input type="radio" id="hotsale" name="hotsale" value="1"><span>热销</span>
      				<input type="radio" id="hotsale" name="hotsale" value="0" checked><span>不热销</span>
      			</p>
      			<p>
      				<label>是否特价*</label>
      				<input type="radio" id="bargainprice" name="bargainprice" value="1"><span>特价</span>
      				<input type="radio" id="bargainprice" name="bargainprice" value="0" checked><span>不特价</span>
      			</p>
      			<p>
      				<label>商品主图片*</label>
      				<a href="" rel="#overlay">
      					<img style="border:0;" alt="上传图片" src="<%=basePath %>jshop/admin/images/upload.jpg">
      				</a>
      			</p>
      			<p><button id="delpc" name="delpc">删除图片</button></p>
      			
				<!-- trigger elements -->
				<div id="triggers">	</div>
      			<p>
      				<span id="errormsg"></span>
      				<s:property value="#request.errormsg"/> 
      			</p>
      		
      			
			</div> 
			
			<div class="goods">
			<%=htmlData%>
				<p>
			
				<textarea id="detail" name="detail" cols="100" rows="8" style="width:100%;height:600px;visibility:hidden;"><%=htmlspecialchars(htmlData)%></textarea>
			
				</p>
				<p>
      				<span id="errormsg2"></span>
      				<s:property value="#request.errormsg"/> 
      			</p>
				
			</div> 
			
			<div class="goods">
				<p>
					<label>搜索关键字</label>
					<select id="keywordname" name="keywordname">
         		   		<option value="0">--请选择--</option>
         		   	</select>
				</p>
				<p>
					<label>生产许可证编号</label>
					<input type="text" id="productlicence" name="productlicence" size="30" maxlength="30"/>
				</p>
				<p>
					<label>卫生许可证编号</label>
					<input type="text" id="healthlicence" name="healthlicence" size="30" maxlength="30"/>
				</p>
				<p>
					<label>产品标准号</label>
					<input type="text" id="productstandard" name="productstandard" size="30" maxlength="30"/>
				</p>
				<p>
      				<span id="errormsg3"></span>
      				<s:property value="#request.errormsg"/> 
      			</p>
				<p>
					<button id="submit" name="submit">完成并增加商品</button>
				</p>
			</div> 

			
		
		</div> 
	
 	 </div> 
 	 
 	 </table>
 	 	 <!-- overlayed element -->

		<div class="apple_overlay" id="overlay">

			<!-- the external content is loaded inside this tag -->
			<div class="contentWrap">
				<input id="fileupload" name="fileupload" type="file"/>
				<div id="fileQueue"></div>
					
      			<a href="javascript:$('#fileupload').uploadifyUpload();">开始上传</a> | <a href="javascript:$('#fileupload').uploadifyClearQueue();">清除队列</a>  
      			
			</div>
		
		</div>
		 <script> 
		 
		// perform JavaScript after the document is scriptable.
		//$(function() {
			//$("ul.skin2").tabs("div.skin2 >div");
		//});

		</script> 

   	  
	
  
	  
	  <table width="98%" border="0" align="center" cellpadding="0" cellspacing="1">
  		<tr> 
    		<td class="panel-header">操作注意事项及说明</td>
  		</tr>
  		<tr> 
    		<td bgcolor="#FFFFFF"> 
			<table width="80%" border="0" align="center" cellpadding="5" cellspacing="0">
        		<tr> 
          		<td height="20"><font color="#FF6600">·请注意分类名称不要含有非法字符。<br>
              ·增加一级分类后，些分类将会被列出前台一级分类中。<br>
              ·进行删除操作的同时，会删除此大类下包含的所有小分类和商品。</font></td>
        		</tr>
      		</table>
      		</td>
  		</tr>
	  </table>
  </body>
  <script>

</script>
</html>
<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>