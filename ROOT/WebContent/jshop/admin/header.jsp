<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String pathb = request.getContextPath();
	String basePathb = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + pathb + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<!-- scripts (jquery) -->
		<script type="text/javascript" src="<%=basePathb%>jshop/admin/js/jquery-1.6.2.min.js"></script>
		<!--[if IE]><script language="javascript" type="text/javascript" src="<%=basePathb%>jshop/admin/resources/scripts/excanvas.min.js"></script><![endif]-->
		<script src="<%=basePathb%>jshop/admin/resources/scripts/jquery-ui-1.8.custom.min.js" type="text/javascript"></script>
		<script src="<%=basePathb%>jshop/admin/resources/scripts/jquery.flot.min.js" type="text/javascript"></script>
		<script src="<%=basePathb%>jshop/admin/resources/scripts/tiny_mce/tiny_mce.js" type="text/javascript"></script>
		<script src="<%=basePathb%>jshop/admin/resources/scripts/tiny_mce/jquery.tinymce.js" type="text/javascript"></script>
		<!-- scripts (custom) -->
		<script type="text/javascript" src="<%=basePathb%>jshop/admin/resources/scripts/smooth.js"></script>
		<script type="text/javascript" src="<%=basePathb%>jshop/admin/resources/scripts/smooth.menu.js" ></script>
		<script type="text/javascript" src="<%=basePathb%>jshop/admin/resources/scripts/smooth.table.js" ></script>
		<script type="text/javascript" src="<%=basePathb%>jshop/admin/resources/scripts/smooth.dialog.js" ></script>

		<script type="text/javascript" src="<%=basePathb%>jshop/admin/js/easyvalidator/js/easy_validator.pack.js"></script>
		<script type="text/javascript" src="<%=basePathb%>jshop/admin/js/easyvalidator/js/jquery.bgiframe.min.js"></script>
		<script type="text/javascript" src="<%=basePathb%>jshop/admin/js/jquery.alerts/jquery.alerts.js"></script>
		<script type="text/javascript" src="<%=basePathb%>jshop/admin/js/kindeditor-min.js"></script>
		<script type="text/javascript" src="<%=basePathb%>jshop/admin/js/flexigrid/flexigrid.js"></script>
		<script type="text/javascript" src="<%=basePathb%>jshop/admin/js/jqueryplugin/jquery.query.js"></script>
		<script type="text/javascript" src="<%=basePathb%>jshop/admin/js/uploader/fileuploader.js"></script>
		<script type="text/javascript" src="<%=basePathb%>jshop/admin/js/farbtastic/farbtastic.js"></script>
		<script type="text/javascript" src="<%=basePathb%>jshop/admin/js/jqueryprogressbar/jquery.progressbar.min.js"></script>
		<script type="text/javascript" src="<%=basePathb%>jshop/admin/adminindexjs.js"></script>
		<script type="text/javascript" src="<%=basePathb%>jshop/admin/indexjs.js"></script>
		<!-- stylesheets -->
		<link rel="stylesheet" type="text/css" href="<%=basePathb%>jshop/admin/resources/css/reset.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePathb%>jshop/admin/resources/css/style.css" media="screen" />
		<link id="color" rel="stylesheet" type="text/css" href="<%=basePathb%>jshop/admin/resources/css/colors/blue.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePathb%>jshop/admin/js/flexigrid/css/flexigrid/flexigrid_gray.css" />
		<link rel="stylesheet" href="<%=basePathb%>jshop/admin/js/jquery.alerts/jquery.alerts.css" type="text/css" media="screen" />
		<link href="<%=basePathb%>jshop/admin/js/uploader/fileuploader.css" rel="stylesheet" type="text/css" />
		<link href="<%=basePathb%>jshop/admin/js/easyvalidator/css/validate.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="<%=basePathb%>jshop/admin/js/farbtastic/farbtastic.css" />
		
	</head>
	<div id="header">
		<!-- logo -->
		<div id="logo">
			<h1>
				欧斯塔克网络商城管理系统
			</h1>
		</div>
		<!-- end logo -->
		<!-- user -->
		<ul id="user">
			<li class="first">
				<a href="<%=basePathb%>jshop/admin/member/editmember.jsp?session=6584359BA964336B9BDE75737952F5AA">账号（管理员）</a>
			</li>
			<li>
				<a href="<%=basePathb%>jshop/admin/order/orderstobeshipped.jsp?session=6584359BA964336B9BDE75737952F5AA">信息中心 (0)</a>
			</li>
			<li>
				<a href="adminLogout">登出</a>
			</li>
			<li class="highlight last">
				<a target="_blank" href="<%=basePathb%>index.html">网站首页</a>
			</li>
		</ul>
		<!-- end user -->
		<div id="header-inner">
			<div id="home">
				<a id="adminindex"  href="<%=basePathb%>jshop/admin/adminindex.jsp?session=6584359BA964336B9BDE75737952F5AA" title="Home"></a>
			</div>
			<!-- quick -->
			<ul id="quick">
				<li>
					<a href="<%=basePathb %>jshop/admin/setting/buildhtmlmsg.jsp?session=6584359BA964336B9BDE75737952F5AA" ><span class="normal">生成网站</span>
					</a>
					<!-- <ul>
                                                            <li><a href="index.html">Full, Column</a></li>
                                                            <li><a href="index-no-column.html">Full, No Column</a></li>
                                                            <li><a href="index-fixed.html">Fixed, Column</a></li>
                                                            <li class="last"><a href="index-fixed-no-column.html">Fixed, No Column</a></li>
                                                  </ul>-->
				</li>

				<li>
					<a href="<%=basePathb%>jshop/admin/lab/html5test.jsp?session=6584359BA964336B9BDE75737952F5AA" title="lab"><span class="icon"><img src="<%=basePathb%>jshop/admin/resources/images/icons/application_double.png" alt="lab" />
					</span><span>实验室</span>
					</a>
					<!--  <ul>
                                                            <li><a href="#">Manage Products</a></li>
                                                            <li><a href="#">Add Product</a></li>
                                                            <li>
                                                                      <a href="#" class="childs">Sales</a>
                                                                      <ul>
                                                                                <li><a href="">Today</a></li>
                                                                                <li class="last"><a href="">Yesterday</a></li>
                                                                      </ul>
                                                            </li>
                                                            <li class="last">
                                                                      <a href="#" class="childs">Offers</a>
                                                                      <ul>
                                                                                <li><a href="">Coupon Codes</a></li>
                                                                                <li class="last"><a href="">Rebates</a></li>
                                                                      </ul> 
                                                            </li>
                                                  </ul>-->
				</li>
				<li>
					<a href="" onclick="createSqlite()"><span class="normal">同步SQLite数据库</span>
					</a>
					
				</li>
				<!-- <li>
                                                  <a href="" title="Events"><span class="icon"><img src="<%=basePathb%>jshop/admin/resources/images/icons/calendar.png" alt="Events" /></span><span>Events</span></a>
                                                  <ul>
                                                            <li><a href="#">Manage Events</a></li>
                                                            <li class="last"><a href="#">New Event</a></li>
                                                  </ul>
                                        </li>
                                        <li>
                                                  <a href="" title="Pages"><span class="icon"><img src="<%=basePathb%>jshop/admin/resources/images/icons/page_white_copy.png" alt="Pages" /></span><span>Pages</span></a>
                                                  <ul>
                                                            <li><a href="#">Manage Pages</a></li>
                                                            <li><a href="#">New Page</a></li>
                                                            <li class="last">
                                                                      <a href="#" class="childs">Help</a>
                                                                      <ul>
                                                                                <li><a href="#">How to Add a New Page</a></li>
                                                                                <li class="last"><a href="#">How to Add a New Page</a></li>
                                                                      </ul>
                                                            </li>
                                                  </ul>
                                        </li>
                                        <li>
                                                  <a href="" title="Links"><span class="icon"><img src="<%=basePathb%>jshop/admin/resources/images/icons/world_link.png" alt="Links" /></span><span>Links</span></a>
                                                  <ul>
                                                            <li><a href="#">Manage Links</a></li>
                                                            <li class="last"><a href="#">Add Link</a></li>
                                                  </ul>
                                        </li>
                                        <li>
                                                  <a href="" title="Settings"><span class="icon"><img src="<%=basePathb%>jshop/admin/resources/images/icons/cog.png" alt="Settings" /></span><span>Settings</span></a>
                                                  <ul>
                                                            <li><a href="#">Manage Settings</a></li>
                                                            <li class="last"><a href="#">New Setting</a></li>
                                                  </ul>
                                        </li>-->
			</ul>
			<!-- end quick -->
			<div class="corner tl"></div>
			<div class="corner tr"></div>
		</div>
	</div>
</html>
