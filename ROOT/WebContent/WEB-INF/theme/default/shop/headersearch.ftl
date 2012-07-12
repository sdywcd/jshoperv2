<html>
<head>
<title>首页${(jshopbasicinfo.jshopname)}</title>
<meta name="Author" content="OSTOCY">
<meta name="Copyright" content="OSTOCY">
<meta http-equiv="expires" content="0">
<#if (jshopbasicinfo.metaKeywords)! != "">
<meta name="keywords" content="${jshopbasicinfo.metaKeywords}"/>
</#if>
	<#if (jshopbasicinfo.metaDes)! != "">
<meta name="description" content="${jshopbasicinfo.metaDes}"/>
</#if>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${basepath}ui/default/css/global.css" />
<link rel="stylesheet" type="text/css" href="${basepath}ui/default/css/index.css" />
<link rel="stylesheet" type="text/css" href="${basepath}ui/default/css/category.css" />
<link rel="stylesheet" type="text/css" href="${basepath}ui/default/js/easyslider1.7/css/screen.css"/>
<script type="text/javascript"  src="${basepath}ui/default/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${basepath}ui/default/js/easyslider1.7/js/easySlider1.7.js"></script>
</head>
<body>
        <div class="topnav">
			


	<div class="topnav">
	<!-- Christmas Change begin -->
	<div class="inner" style="position:relative; z-index:999;">
	 <!-- Christmas Change End-->
		
			
		<ul class="main_nav">
			<#list sitenavigationlist?sort_by("sort") as snl>
			<#if snl.position="2">
			<li>
				<a href="${basepath}<@snl.htmlPath?interpret />"
				<#if snl.isTargetBlank="1"> target="_blank"</#if> >${snl.name}
				</a>
				
			</li>
			<li>
				<img src="${basepath}ui/default/images/top_separator_02.gif">
			</li>
			</#if>
			</#list>
			
		</ul>
		<div class="search">
			
	
				<div style="display:none;">
					<input type="hidden" id="SortCid2" name="Cid" value="">
					<input type="hidden" id="thKeywords" name="Keywords">
					<input type="hidden" name="searchlist" value="1">
				</div>
					<input type="text" id="topKeywords" class="searchinput_top" value="" onfocus="if (value ==''){value =''};this.style.color='#000'" onkeyup="showSuggest();" onkeydown="keyDown(event)">
<button id="searchgoods" name="searchgoods" class="searchbtn" target="_blank"value="搜索"/>
					
			
		</div>
	


	</div>
</div>
					
       </div>		
	   <script type="text/javascript" src="${basepath}ui/default/js/jshop.js"></script>
	   </body>
	   </html>
