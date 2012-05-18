
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
  <head>
  
    
    <title>${(jshopbasicinfo.jshopname)}我的收获地址</title>
    
	<meta http-equiv="pragma" content="OSTOCY">
	<meta http-equiv="cache-control" content="OSTOCY">
	<meta http-equiv="expires" content="0">    
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
	<#if (jshopbasicinfo.metaKeywords)! !=""><meta http-equiv="keywords" content="${jshopbasicinfo.metaKeywords}"/></#if>
	<#if (jshopbasicinfo.metaDes)! !=""><meta http-equiv="description" content="${jshopbasicinfo.metaDes}"/></#if>
	<link rel="stylesheet" type="text/css" title="Green" href="${basePath}ui/default/css/style_usercenter.css" />
	<link rel="stylesheet" type="text/css" title="Green" href="${basePath}ui/default/css/style_green.css" />
	<link rel="stylesheet" type="text/css" href="${basePath}ui/default/css/tabs-accordion-usercenter.css"/>
	<script type="text/javascript"  src="${basePath}ui/default/js/jquery1.4.2.js"></script>
	<script type="text/javascript" src="${basePath}ui/default/js/jquery.tools.min.js"></script>
  	<script type="text/javascript" src="${basePath}js/mydeliveraddressjs.js"></script>
  	<script type="text/javascript" src="${basePath}js/location.js"></script>
	<script type="text/javascript" src="${basePath}js/YLChinaArea.js"></script>
  	<!--[if IE 6]>
	<style>
	body {behavior: url("<%=basePath%>ui/default/css/csshover3.htc");}
	</style>
	<![endif]-->
<script type="text/javascript">    
       $(document).ready(function() {
         $("#ChinaArea").jChinaArea({
             aspnet:false,
             s1:"河南省",//默认选中的省名
             s2:"安阳市",//默认选中的市名
             s3:"文峰区"//默认选中的县区名
         });
       });
   </script>

  </head>
  
<body>

<s:hidden name="hidurl" id="hidurl" value=""></s:hidden>


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
		  <s:action name="GetIndexMenu" namespace="/jshop_system" id="bean" /> 
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
						<img src="ui/default/images_green/cart_009.gif" alt="我的收获地址" />
					</div>
					<div class="list_cart">
						<h2><strong>我的收货地址</strong> </h2><a id="addnewa">[增加新地址]</a><a id="closenewa">[关闭]</a>
					</div>
					<div class="cart_table">
						<table>
							<tbody>
								<tr class="trhead">
									<td width="10%" style="height:30px;">收货人</td>
									<td>地址</td>
									<td width="14%">邮编</td>
									<td width="8%">手机号码</td>
									<td width="10%">固定电话</td>
									<td width="9%">邮箱</td>
									<td width="9%">删除商品</td>
								</tr>
								<#if deliveraddress??&&deliveraddress?size>0>
								<#list deliveraddress as d >
								<tr class="align_Center">
									<td style="padding: 5px 0pt;">${d.username}</td>
									<td class="align_Left">
										<span>
											${d.province}${d.city}${d.district}${d.street}
										</span>
									</td>
									<td>
										${d.postcode}
									</td>
									<td>${d.mobile}</td>
									<td>${d.telno}</td>
									<td>
										${d.email}
									</td>
									<td><a href="UserDelDeliverAddress.action?addressid=${d.addressid}">删除</a></td>
								</tr>
								</#list>
								</#if>
							</tbody>
						</table>
	
					</div>
							<div id="addnewaddressarea" style="display:none;" class="middle" >
									<div id="addressform">
										<table cellspacing="0" border="0" width="100%" >
											<tbody>
												<tr>
													<td align="right" width="85" valign="middle">
														<font color="red">*</font>
														收货人姓名：
													</td>
													<td align="left" valign="middle">
														<input id="username" class="txt" type="text" value="" maxlength="20"/>
														<span id="deliver_username_info" style="display:none;" class="alertinfo">请填写收货人姓名</span>
													</td>
												</tr>
												<tr>
													<td align="right" width="85" valign="middle">
														<font color="red">*</font>
														国家：
													</td>
													<td align="left" valign="middle">
														<select id="country" name="country">
															<option value="1">中国</option>
														</select>
													</td>
												</tr>
												<tr>
													<td align="right" valign="middle">
														<font color="red">*</font>
														省     份：
													</td>
													<td align="left" valign="middle">
														<div id="ChinaArea">
														 <select id="province" name="province" style="width: 100px;"></select>
													     <select id="city" name="city" style="width: 100px;"></select>
													     <select id="district" name="district" style="width: 120px;"> </select>      
													     </div>
													</td>
												</tr>
												<tr>
													<td align="right" valign="middle">
														<font color="red">*</font>
														地     址：
													</td>
													<td align="left" valign="middle">
														<input type="text" id="street" name="street" style="width:320px;" maxlength="100"/>
													</td>
												</tr>
												<tr>
													<td align="right" valign="middle">
														<font color="red">*</font>
														手机号码：
													</td>
													<td align="left" valign="middle">
														<input type="text" id="mobile" name="mobile" style="width:100px;" maxlength="11"/>
													</td>
												</tr>
												<tr>
													<td align="right" valign="middle">
														
														固定电话：
													</td>
													<td align="left" valign="middle">
														<input type="text" id="telno" name="telno" style="width:100px;" maxlength="11"/>
													</td>
												</tr>
												<tr>
													<td align="right" valign="middle">
														
														电子邮件：
													</td>
													<td align="left" valign="middle">
														<input type="text" id="email" name="email" style="width:200px;" maxlength="50"/>
													</td>
												</tr>
												<tr>
													<td align="right" valign="middle">
														
														邮政编码：
													</td>
													<td align="left" valign="middle">
														<input type="text" id="postcode" name="postcode" style="width:100px;" maxlength="11"/>
													</td>
												</tr>
											</tbody>
										</table>
									</div>
									<div style="padding:10px 0px 20px 45px;">
										<a id="addaddress" >[添加到常用地址]</a>
									</div>
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
	
				<jsp:include page="../usercentermenu.jsp"></jsp:include>

			</div>

		</div>

		<br class="clear" />

	</div>

</div>


    <#include "/WEB-INF/theme/default/shop/footer.ftl">
  </body>
</html>
