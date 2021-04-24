<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String context = request.getContextPath();
%>
<!-- 头部开始 -->
<jsp:include page="common/top.jsp"></jsp:include>
<!-- 头部结束 -->

<!-- 左边菜单开始 -->
<jsp:include page="common/left.jsp"></jsp:include>
<!-- 左边菜单结束 -->

<div class="content">
	<div class="header">

		<h1 class="page-title">用户修改</h1>
		<ul class="breadcrumb">
			<li><a href="#">首页</a></li>
			<li><a href="#">用户管理</a></li>
			<li class="active">用户修改</li>
		</ul>

	</div>
	<div class="main-content">
		<div class="row">
			<div class="col-md-11">
				<form class="form-horizontal" action="edit" method="post">					
					<div class="form-group">
						<label class="col-sm-2 control-label">编号</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" name="uid"
								value="${user.uid }" readOnly>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="uname"
								placeholder="" value="${user.uname }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">性别</label>
						<div class="col-sm-4">
							<label class="radio-inline"> <input type="radio"
								name="usex" value="男" ${user.usex=='男'?'checked':''} /> 男
							</label> <label class="radio-inline"> <input type="radio"
								name="usex" value="女" ${user.usex=='女'?'checked':''} /> 女
							</label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">手机</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="uphone"
								value="${user.uphone }"  required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">QQ</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="uqq"
								value="${user.uqq }"  required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Email</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="uemail"
								value="${user.uemail }"  required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">出生年月</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="ubirth"
								value="${user.ubirth }"  required>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-12">
							<button class="btn btn-primary">
								<i class="fa fa-save"></i> 保存
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>

		<!-- 底部开始 -->
		<%@ include file="common/bottom.jsp"%>
		<!-- 底部结束 -->
	</div>
</div>