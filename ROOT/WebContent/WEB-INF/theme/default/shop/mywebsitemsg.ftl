
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
  <head>  
    
    <title>${jshopbasicinfo.jshopname}我的信件</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<#if (jshopbasicinfo.metaKeywords)! !=""><meta http-equiv="keywords" content="${jshopbasicinfo.metaKeywords}"></#if>
	<#if (jshopbasicinfo.metaDes)! !=""><meta http-equiv="description" content="${jshopbasicinfo.metaDes}"></#if>
	<link rel="stylesheet" type="text/css" title="Green" href="${basePath}ui/default/css/style_usercenter.css" />
	<link rel="stylesheet" type="text/css" title="Green" href="${basePath}ui/default/css/style_green.css" />
	<link rel="stylesheet" type="text/css" href="${basePath}ui/default/css/tabs-accordion-usercenter.css"/>
	<script type="text/javascript"  src="${basePath}ui/default/js/jquery1.4.2.js"></script>
	<script type="text/javascript" src="${basePath}ui/default/js/jquery.tools.min.js"></script>
	<script type="text/javascript" src="${basePath}jshop/admin/js/kindeditor-min.js"></script>
  	<script type="text/javascript" src="${basePath}js/mywebsitemsgjs.js"></script>
  	<!--[if IE 6]>
	<style>
	body {behavior: url("<%=basePath%>ui/default/css/csshover3.htc");}
	</style>
	<![endif]-->

<script type="text/javascript">
$(function() {
	KE.show({
				id : 'text',
				resizeMode : 1,
				allowPreviewEmoticons : false,
				allowUpload : false,
				items : [
				'fontname', 'fontsize', '|', 'textcolor', 'bgcolor', 'bold', 'italic', 'underline',
				'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
				'insertunorderedlist', '|', 'emoticons', 'link']
			});
});
</script>

  </head>
  
<body>
<div id="top_header">
	<div id="top_header_menu">
	<#include "/WEB-INF/theme/default/shop/top_header.ftl">
    </div>
</div>
<div id="header">

	<div id="header_inner" class="fixed">

		<div id="logo">
			<h2>www.soipay.com</h2>
		</div>
		
		<!-- 读取导航菜单 -->
		  
		  <div id="menu">
			<ul>
				<#list siteNavigationList as navigation>
					<#if navigation.position="2">
					<li>
						<a href="${basePath}<@navigation.htmlPath?interpret />"
						<#if navigation.isTargetBlank="1"> target="_blank"</#if> class="active">${navigation.name}
						</a>
					</li>
				        </#if>
				</#list>
			</ul>
		 </div>
		
		
  </div>
</div>

<div id="main">

	<div id="main_inner" class="fixed">
	  <div id="top_main_inner" class="fixed">
   		<#include "/WEB-INF/theme/default/shop/headersearch.ftl">
      </div>
      
                   
	  <div id="primaryContent_2columns">
			<div id="columnA_2columns">

				<br class="clear"/>
				<div id="cart_info">
					<div class="cart_img">
						<img id="newmsg" src="ui/default/images_green/cart_010.gif" alt="我的购物车" />
					</div>
					
					<div id="msgarea" style="display:none;">
						<div class="list_cart">
						<h2><strong>新信件</strong></h2>
					</div>
					<div id="msgarea1" class="cart_table1" style="display:none;">
						<label>主题</label>
						<p><input id="title" name="title" value="" size="50" maxlength="45"/></p>
						<label>发送给</label>
						<p><input id="msgToUsername" name="msgToUsername" value="" size="30" maxlength="25"/></p>
						<label>内容</label>
						
						<p>
							<textarea id="text" name="text" cols="100" rows="8" style="width:860px;height:400px;visibility:hidden;"></textarea>
						</p>
						<p><input id="submit" name="submit" value="提交" type="button"></input><span id="msginfo" name="msginfo"></span></p>
					</div>
					</div>
				
					<div class="list_cart">
						<h2><strong>我的信件</strong></h2>
					</div>
					<#if (msgtext??)&&(msgtext?size>0)>
						<table class="cart_table1" >
							<tr>
								<td colspan="6">
									<p>${msgtext.mymsgtext}</p>
								</td>
							</tr>
						</table>
					</#if>
					<div class="cart_table">
						<table>
							<tbody>
								<tr class="trhead">
									<td style="height:30px;">主题</td>
									<td width="14%">来自于</td>
									<td width="14%">类型</td>
									<td width="6%">状态</td>
									<td width="15%">时间</td>
									<td width="5%" ></td>
								</tr>
								<#if (websitemsg??)&&(websitemsg?size>0)>
								<#list websitemsg as msg>
								<tr class="align_Center">
									<td style="padding: 5px 0pt;" class="align_Left">
										<span>
												<a href="findMsgtextById.action?msgtextid=${msg.msgtextid}">${msg.title}</a>
										</span>
									</td>
									<td>
										<span>${msg.msgfromusrname}</span>
									</td>
									<td><span><#if (msg.msgstate==1)>普通信件
									<#elseif (msg.msgstate==2)>系统信件
											
										</span></td></#if>
									<td>									
										<span><#if (msg.state==1) >已读
										<#elseif (msg.state==0) >未读
										
										</span>
										</td>
										</#if>
									<td>${msg.createtime}</td>
									<td>
									
									<a href="DelWebsiteMsgT.action?msgid=${msg.msgid}">删除</a></td>
								</tr>
								
								
								</#list>
								</#if>
							</tbody>
						</table>
	
					</div>
					
					<div class="round">
						<div class="lround"></div>
						<div class="rround"></div>
					</div>
					
				</div>
				
				<br class="clear" />
		
			

				
				
			</div>
	
		</div>
		
		<div id="secondaryContent_2columns">
		
			<div id="columnC_2columns">
	
				<#include  "/WEB-INF/theme/default/shop/usercentermenu.ftl" >

			</div>

		</div>

		<br class="clear" />

	</div>

</div>


    <#include "/WEB-INF/theme/default/shop/footer.ftl">
  </body>
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