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
		<h1 class="page-title">会员列表</h1>
		<ul class="breadcrumb">
			<li><a href="#">首页</a></li>
			<li><a href="#">会员管理</a></li>
			<li class="active">会员列表</li>
		</ul>
	</div>

	<div class="main-content">
		<div class="btn-toolbar list-toolbar">
			<div class="btn-group">
				<form action="search" method="post" class="form-inline">
					<div class="form-group">
						<input class="form-control" style="width: 300px" placeholder="输入用户名或者手机"
							type="text" name="keywords" />
						<button class="btn btn-default" type="submit">
							<i class="fa fa-search"></i> 查询
						</button>
					</div>
				</form>
			</div>
		</div>

		<table class="table">
			<thead>
				<tr>
					<th>#</th>
					<th>用户名</th>
					<th>性别</th>
					<th>手机</th>
					<th>Email</th>
					<th>注册日期</th>
					<th style="width: 3.5em;"></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="user" items="${list}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${user.uname }</td>
						<td>${user.usex }</td>
						<td>${user.uphone }</td>
						<td>${user.uemail }</td>
						<td>${user.uregtime }</td>
						<td><a href="edit?id=${user.uid }"><i
								class="fa fa-pencil"></i></a> <a href="delete?id=${user.uid }"
							role="button" data-toggle="modal"><i class="fa fa-trash-o"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<jsp:include page="common/alert.jsp"></jsp:include>
		<!-- 底部开始 -->
		<%@ include file="common/bottom.jsp"%>
		<!-- 底部结束 -->
	</div>
</div>

