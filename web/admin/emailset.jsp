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

		<h1 class="page-title">邮箱设置</h1>
		<ul class="breadcrumb">
			<li><a href="#">首页</a></li>
			<li><a href="#">系统管理</a></li>
			<li class="active">邮件设置</li>
		</ul>

	</div>
	<div class="main-content">
		<div class="row">
			<div class="col-md-5">
				<form class="form-horizontal" action="set" method="post">
					<div class="form-group">
						<label class="col-sm-4 control-label">发送邮件服务器</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="emserver"
								value="${emailset.emserver }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">发件邮件地址</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="emaddress"
								value="${emailset.emaddress }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">授权码</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="empasscode"
								value="${emailset.empasscode }" required>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-10">
							<button class="btn btn-primary"><i class="fa fa-save"></i> 保存</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<jsp:include page="common/alert.jsp"></jsp:include>
		<!-- 底部开始 -->
		<%@ include file="common/bottom.jsp"%>
		<!-- 底部结束 -->
	</div>
</div>