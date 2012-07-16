<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
          String path = request.getContextPath();
          String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
          <head>
                    <title>欧斯塔克网络商城管理系统</title>
                    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />

          </head>
          <body>
                    <!-- header 包含头部导航-->
                    <%@include  file="header.jsp" %>
                    <!-- end header -->
                    <!-- content -->
                    <div id="content">
                              <!-- end content / left -->
                              <%@include  file="left.jsp" %>
                              <!-- end content / left -->
                              <!-- content / right -->
                              <div id="right">
                                        <!-- table -->
                                        <div class="box">
                                                  <!-- box / title -->
                                                  <div class="title">
                                                            <h5>商品列表</h5>                                                            
                                                  </div>
                                                  <!-- end box / title -->
                                                  <div class="table" >                                                            
                                                  		          <div id="flexgoodsmanagement" style="width: 98%; margin-left: 15px;">
																	<table id="goodsmanagement" style="display: none;"></table>
															      </div>  
                                                  </div>
                                        </div>
                                    
                                        <!-- messages -->
                                        <div id="box-tabs" class="box">
                                                  <!-- box / title -->
                                                  <div class="title">
                                                            <h5>文章列表</h5>
                                                            
                                                  </div>
                                                  <!-- box / title -->
                                                  <div id="table">
                                                             <div id="flexarticlemanagement" style="width:98%;margin-left:15px;">
        														<table id="articlemanagement" style="display:none;" ></table>
															 </div>
                                                  </div>
                                                  
                                        </div>
                                       
                              </div>
                              <!-- end content / right -->
                    </div>
                    <!-- end content -->
                    <!-- footer -->
                    <%@include  file="footer.jsp" %>
                    <!-- end footert -->
          </body>
</html>