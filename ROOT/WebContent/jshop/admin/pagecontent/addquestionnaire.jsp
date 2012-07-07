<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>

		<title>增加/编辑问卷管理</title>
	</head>

	<body>
		<!-- header 包含头部导航-->
		<%@include file="/jshop/admin/header.jsp"%>
		<!-- end header -->
		<!-- content -->
		<div id="content">
			<!-- end content / left -->
			<%@include file="/jshop/admin/left.jsp"%>
			<!-- end content / left -->
			<!-- content / right -->
			<div id="right">
				<!-- table -->
				<div class="box">
					<!-- box / title -->
					<div class="title">
						<h5>
							增加/编辑问卷
						</h5>

					</div>

					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="label">
									<label for="input-medium">
										标题:
									</label>
								</div>
								<div class="input">
									<input type="text" id="title" name="title" class="medium" />

								</div>
							</div>
					
							<div class="field">
								<div class="label">
									<label for="input-medium">
										问题:
									</label>
								</div>
								<div class="input">
									<input type="text" id="question" name="question" class="medium" />

								</div>
							</div>
						
						<div class='field'>
	                            <div class='label'>
	                                <label for='input-small'>选项号:</label>
	                            </div>
	                            <div class='input'>
	                                <input type='text' id='choosetag' name='choosetag'/>
	                            </div>
	                       </div>
	                       <div class='field'>
                                <div class='label'>
                                    <label for='select'>表单元素类型:</label>
                                </div>
                                <div class='select'>
                                    <div>
                                        <select id='inputtype' name='inputtype'>
                                            <option value='checkbox'>多选</option>
                                            <option value='radio'>单选</option>
                                        </select>
                                    </div>
                                </div>
                           </div>
	                       <div class='field'>
                                <div class='label'>
                                    <label for='input-medium'>答案:</label>
                                </div>
                                <div class='input'>
                                    <input type='text' id='answer' name='answer' class='medium'/>
                                </div>
                           </div>
                           </div>
					</div>

					<div class="form">
						<div class="fields">
							<div class="field field-first">
								<div class="input">
									<div class="button highlight">

										<input type="hidden" id="qid" name="qid" value="" />
										<input type="button" id="submit" name="submit" value="提交" />
										<input type="button" id="modify" name="modify" value="更新" style="display: none;" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- end table -->
			</div>
			<!-- end content / right -->
		</div>
		<!-- end content -->
		<!-- footer -->
		<%@include file="/jshop/admin/footer.jsp"%>
		<!-- end footert -->
		<script type="text/javascript" src="<%=basePath%>jshop/admin/js/questionnairemanagementjs.js"></script>
		

	</body>
</html>
