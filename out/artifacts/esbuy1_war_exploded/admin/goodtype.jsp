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

		<h1 class="page-title">类别列表</h1>
		<ul class="breadcrumb">
			<li><a href="#">首页</a></li>
			<li><a href="#">类别管理</a></li>
			<li class="active">类别列表</li>
		</ul>

	</div>
	<div class="main-content">

		<div class="btn-toolbar list-toolbar">
			<a class="btn btn-primary" href="add"><i class="fa fa-plus"></i>
				添加类别</a>
			<div class="btn-group"></div>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>#</th>
					<th>类别名称</th>
					<th style="width: 3.5em;"></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="goodtype" items="${list}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${goodtype.tname }</td>
						<td><a href="edit?id=${goodtype.tid }"><i class="fa fa-pencil"></i></a> 
						<a href="delete?id=${goodtype.tid }" role="button" data-toggle="modal"><i
								class="fa fa-trash-o"></i></a></td>
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

