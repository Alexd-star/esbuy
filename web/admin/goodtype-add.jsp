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

		<h1 class="page-title">类别添加</h1>
		<ul class="breadcrumb">
			<li><a href="#">首页</a></li>
			<li><a href="#">类别管理</a></li>
			<li class="active">类别添加</li>
		</ul>

	</div>
	<div class="main-content">
		<div class="row">
			<div class="col-md-5">
				<form class="form-horizontal" action="add" method="post">
					<div class="form-group">
						<label class="col-sm-3 control-label">类别名称</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="tname"
								placeholder="">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-10">
							<button class="btn btn-primary"><i class="fa fa-save"></i> 保存</button>
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