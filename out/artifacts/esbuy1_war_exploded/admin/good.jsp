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
		<h1 class="page-title">商品列表</h1>
		<ul class="breadcrumb">
			<li><a href="#">首页</a></li>
			<li><a href="#">商品管理</a></li>
			<li class="active">商品列表</li>
		</ul>
	</div>

	<div class="main-content">
		<div class="btn-toolbar list-toolbar">
			<div class="btn-group">
				<a class="btn btn-primary" href="add"><i class="fa fa-plus"></i>
					添加商品</a>
			</div>
			<div class="btn-group">
				<form action="search" method="post" class="form-inline">
					<div class="form-group">
						<select class="form-control" name="tid">
							<option value="0">所有类别</option>
							<c:forEach items="${goodtype_list }" var="i">
								<option value="${i.tid }">${i.tname }</option>
							</c:forEach>
						</select>
					</div>

					<div class="form-group">
						<input class="form-control" style="width: 400px" placeholder="输入商品名称"
							type="text" name="gdname">
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
					<th>商品名称</th>
					<th>商品分类</th>
					<th>价格</th>
					<th>库存</th>
					<th style="width: 3.5em;"></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="good" items="${good_list}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td><img class="img-thumbnail" id="gdimage"
							src="<%=context %>/upload/${good.gdimage}" /> ${good.gdname }</td>
						<td>${good.tname }</td>
						<td>${good.gdprice }</td>
						<td>${good.gdquantity }</td>
						<td><a href="edit?id=${good.gdid }"><i
								class="fa fa-pencil"></i></a> <a href="delete?id=${good.gdid }"
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

