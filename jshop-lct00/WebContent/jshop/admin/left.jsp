<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
          String patha = request.getContextPath();
          String basePatha = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + patha + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />

	</head>
	<div id="left">
		<div id="menu">
			<h6 id="h-menu-goods" class="selected">
				<a href="#goods"><span>商品管理</span>
				</a>
			</h6>
			<ul id="menu-goods" class="opened">
				<li>
					<a id="link1" href="<%=basePatha%>jshop/admin/goods/goodstypetnmanagement.jsp?session=6584359BA964336B9BDE75737952F5AA#goods">商品类型参数设置</a>
				</li>
				<li>
					<a id="link2" href="<%=basePatha%>jshop/admin/goods/brandmanagement.jsp?session=6584359BA964336B9BDE75737952F5AA#goods">商品品牌设置</a>
				</li>
				<li>
					<a id="link3" href="<%=basePatha%>jshop/admin/goods/goodstypetnbrandmanagement.jsp?session=6584359BA964336B9BDE75737952F5AA#goods">商品品牌类型设置</a>
				</li>
				<li>
					<a id="link5" href="<%=basePatha%>jshop/admin/goods/productspecificationmanagement.jsp?session=6584359BA964336B9BDE75737952F5AA#goods">商品规格设置</a>
				</li>
				<li>
					<a id="link17" href="<%=basePatha%>jshop/admin/goods/goodsattributemanagement.jsp?session=6584359BA964336B9BDE75737952F5AA#goods">商品属性设置</a>
				</li>
				<li>
					<a id="link4" href="<%=basePatha%>jshop/admin/goods/goodscategorymanagement.jsp?session=6584359BA964336B9BDE75737952F5AA#goods">商品分类设置</a>
				</li>
				<li>
					<a id="link6" href="<%=basePatha%>jshop/admin/goods/goodsunitmanagement.jsp?session=6584359BA964336B9BDE75737952F5AA#goods">商品单位设置</a>
				</li>
				<li>
					<a id="link7" href="<%=basePatha%>jshop/admin/goods/keywordmanagement.jsp?session=6584359BA964336B9BDE75737952F5AA#goods">商品关键字设置</a>
				</li>
				<li>
					<a id="link8" href="<%=basePatha%>jshop/admin/goods/addgoods.jsp?session=6584359BA964336B9BDE75737952F5AA#goods">添加新商品</a>
				</li>
			
				<li>
					<a id="link19" href="<%=basePatha%>jshop/admin/goods/goodsmanagement.jsp?session=6584359BA964336B9BDE75737952F5AA#goods">所有商品</a>
				</li>

				<li>
					<a id="link12" href="<%=basePatha%>jshop/admin/goods/goodscommentmanagement.jsp?session=6584359BA964336B9BDE75737952F5AA#goods">商品评论</a>
				</li>
		
			</ul>
		
			<h6 id="h-menu-settings">
				<a href="#settings"><span>系统设置</span>
				</a>
			</h6>
			<ul id="menu-settings" class="closed">
				<li>
					<a id="link1" href="<%=basePatha%>jshop/admin/setting/addjshopbasicinfo.jsp?session=6584359BA964336B9BDE75737952F5AA#settings">基本设置</a>
				</li>
				<li>
					<a id="link2" href="<%=basePatha%>jshop/admin/setting/jshopbasicsafeset.jsp?session=6584359BA964336B9BDE75737952F5AA#settings">安全设置</a>
				</li>
				<li>
					<a id="link3" href="<%=basePatha%>jshop/admin/setting/systememailmanagement.jsp?session=6584359BA964336B9BDE75737952F5AA#settings">邮箱设置</a>
				</li>
				<!--  <li>
					<a id="link4" href="">邮件参数设置</a>
				</li>-->
				<li>
					<a id="link5" href="<%=basePatha%>jshop/admin/setting/jshopglobalparamset.jsp?session=6584359BA964336B9BDE75737952F5AA#settings">全局参数设置</a>
				</li>
				<li>
					<a id="link6" href="<%=basePatha%>jshop/admin/setting/paymentmanagement.jsp?session=6584359BA964336B9BDE75737952F5AA#settings">支付方式设置</a>
				</li>
				<li>
					<a id="link7" href="<%=basePatha%>jshop/admin/setting/logisticsmanagement.jsp?session=6584359BA964336B9BDE75737952F5AA#settings">物流及配送设置</a>
				</li>
				<li>
					<a id="link8" href="<%=basePatha%>jshop/admin/setting/expresstempletemanagement.jsp?session=6584359BA964336B9BDE75737952F5AA#settings">快递单模板设置</a>
				</li>
				<li>
					<a id="link9" href="<%=basePatha%>jshop/admin/setting/invoicetempletemanagement.jsp?session=6584359BA964336B9BDE75737952F5AA#settings">发货单模板设置</a>
				</li>

				
			
				<li>
					<a id="link12" href="<%=basePatha%>jshop/admin/template/templatethememanagement.jsp?session=6584359BA964336B9BDE75737952F5AA#settings">模板主题设置</a>
				</li>
				<li>
					<a id="link10" href="<%=basePatha%>jshop/admin/template/templatemanagement.jsp?session=6584359BA964336B9BDE75737952F5AA#settings">模板文件设置</a>
				</li>
				<li class="last">
					<a id="link11" href="<%=basePatha%>jshop/admin/template/templatesetmanagement.jsp?session=6584359BA964336B9BDE75737952F5AA#settings">模板文件和系统内容设置</a>
				</li>
	
	
				<li>
					<a id="link13" href="<%=basePatha%>jshop/admin/setting/modulemanagement.jsp?session=6584359BA964336B9BDE75737952F5AA#settings">系统模块设置</a>
	
				</li>
				<li>
					<a id="link14" href="<%=basePatha%>jshop/admin/setting/functionmanagement.jsp?session=6584359BA964336B9BDE75737952F5AA#settings">模块功能设置</a>
				</li>
				<li class="last">
					<a id="link16" href="<%=basePatha%>jshop/admin/setting/rolemanagement.jsp?session=6584359BA964336B9BDE75737952F5AA#settings">角色权限设置</a>
				</li>
				
				
			</ul>
		</div>
		<div id="date-picker"></div>
	</div>
</html>