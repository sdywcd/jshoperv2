<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
          String path = request.getContextPath();
          String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
          <head>   
                    <title>欧斯塔克网络商城后台管理登录</title>

                    <meta http-equiv="pragma" content="no-cache"></meta>
                    <meta http-equiv="cache-control" content="no-cache"></meta>
                    <meta http-equiv="expires" content="0"></meta>


                    <link rel="stylesheet" type="text/css" href="<%=basePath%>jshop/admin/resources/css/reset.css" />
                    <link rel="stylesheet" type="text/css" href="<%=basePath%>jshop/admin/resources/css/style.css" media="screen" />
                    <link id="color" rel="stylesheet" type="text/css" href="<%=basePath%>jshop/admin/resources/css/colors/blue.css" />
                    <!-- scripts (jquery) -->
                    <script type="text/javascript" src="<%=basePath%>jshop/admin/resources/scripts/jquery-1.4.2.min.js"></script>
                    <script type="text/javascript" src="<%=basePath%>jshop/admin/resources/scripts/jquery-ui-1.8.custom.min.js"></script>
                    <script type="text/javascript" src="<%=basePath%>jshop/admin/resources/scripts/smooth.js"></script>
                    <script type="text/javascript" src="<%=basePath%>jshop/admin/js/jqueryplugin/jquery.query.js"></script>
                    <script type="text/javascript">
                              $(function(){
                                        $('#taobaoregister').click(function(){
                                                  $.post("registerTbuser.action",function(data){
                                                            window.location.href=data.redirecturl;
                                                  });
                                        });
                                        $('#taobaologin').click(function(){
                                                  $.post("loginTbuser.action",function(data){
                                                            window.location.href=data.redirecturl;
                                                  });
                                        });
                                        
                                        //读取登录返回状态并显示提示
                                        var  msg=$.query.get("msg");
                                        if("1"==msg){
                                                  $("#message-error").show();
                                        }else{
                                                  $("#message-error").hide();
                                        }
                              });
                              $(document).ready(function () {
                                        style_path = "resources/css/colors";

                                        $("input.focus").focus(function () {
                                                  if (this.value == this.defaultValue) {
                                                            this.value = "";
                                                  }
                                                  else {
                                                            this.select();
                                                  }
                                        });

                                        $("input.focus").blur(function () {
                                                  if ($.trim(this.value) == "") {
                                                            this.value = (this.defaultValue ? this.defaultValue : "");
                                                  }
                                        });

                                        $("input:submit, input:reset").button();
                              });
                    </script>
          </head>
          <body>
                    <div id="login">
                              <!-- login -->
                              <div class="title">
                                        <h5>欢迎使用欧斯塔克网络商城管理系统</h5>
                                        <div class="corner tl"></div>
                                        <div class="corner tr"></div>
                              </div>
                              <div class="messages">
                                        <div style=" display:  none;" id="message-error" class="message message-error">
                                                <div class="image">
                                                            <img src="resources/images/icons/error.png" alt="Error" height="32" />
                                                  </div>
                                                  <div class="text">
                                                            <h6>错误提示</h6>
                                                            <span>您输入的用户名或者密码错误.</span>
                                                  </div>-
                                                  <div class="dismiss">
                                                            <a href="#message-error"></a>
                                                  </div>
                                        </div>
                              </div>
                              <div class="inner">
                                        <s:form action="adminlogin" method="post" theme="simple">
                                                  <div class="form">
                                                            <!-- fields -->
                                                            <div class="fields">
                                                                      <div class="field">
                                                                                <div class="label">
                                                                                          <label for="username">Username:</label>
                                                                                </div>
                                                                                <div class="input">
                                                                                          <input type="text" id="username" name="username" size="40" value="admin" class="focus" />
                                                                                </div>
                                                                      </div>
                                                                      <div class="field">
                                                                                <div class="label">
                                                                                          <label for="password">Password:</label>
                                                                                </div>
                                                                                <div class="input">
                                                                                          <input type="password" id="password" name="password" size="40" value="password" class="focus" />
                                                                                </div>
                                                                      </div>
                                                                      <div class="field">
                                                                                <div class="checkbox">
                                                                                          
                                                                                </div>
                                                                      </div>
                                                                      <div class="buttons">
                                                                               <input  style=" width: 165px" id="taobaologin" name="taobaologin" class="iLogin ui-button ui-widget ui-state-default ui-corner-all" type="button" value="使用淘宝账号登录"/>
                                                                                <input class="iLogin" type="submit" value="登录"/>
                                                                                
                                                                                <input id="taobaoregister" name="taobaoregister" class="iLogin ui-button ui-widget ui-state-default ui-corner-all" type="button" value="注册"/>
                                                                      </div>
                                                            </div>
                                                            <!-- end fields -->
                                                            <!-- links -->
                                                            <div class="links">
                                                                      <!--<a href="index.html">Forgot your password?</a>-->
                                                            </div>
                                                            <!-- end links -->
                                                  </div>
                                        </s:form>
                              </div>
                              <!-- end login -->
                              <div id="colors-switcher" class="color">
                                        <a href="" class="blue" title="Blue"></a>
                                        <a href="" class="green" title="Green"></a>
                                        <a href="" class="brown" title="Brown"></a>
                                        <a href="" class="purple" title="Purple"></a>
                                        <a href="" class="red" title="Red"></a>
                                        <a href="" class="greyblue" title="GreyBlue"></a>
                              </div>
                    </div>
          </body>
</html>
