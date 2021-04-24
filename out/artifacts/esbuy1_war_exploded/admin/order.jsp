<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<h1 class="page-title">订单列表</h1>
		<ul class="breadcrumb">
			<li><a href="#">首页</a></li>
			<li><a href="#">订单管理</a></li>
			<li class="active">订单列表</li>
		</ul>
	</div>

	<div class="main-content">
		<div class="btn-toolbar list-toolbar"></div>
		<table class="table">
			<thead>
				<tr>
					<th>#</th>
					<th>订单号</th>
					<th>用户名</th>
					<th>订单金额</th>
					<th>下单时间</th>
					<th>订单状态</th>
					<th style="width: 2em;"></th>
					<th style="width: 2em;"></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="i" items="${list}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${i.ocode }</td>
						<td>${i.uname }</td>
						<td>${i.ototal }</td>
						<td><fmt:formatDate type="both" pattern="yyyy-MM-dd HH:mm:ss"
								value="${i.otime }" /></td>
						<td><c:choose>
								<c:when test="${i.ostatus == 2}">已发货</c:when>
								<c:when test="${i.ostatus == 3}">已收货</c:when>
								<c:otherwise>已下单</c:otherwise>
							</c:choose>
							</td>
							<td>
							<c:if test="${i.ostatus == 1 or i.ostatus == 2}">
							<a href="<%=context %>/admin/email/send?id=${i.uid }" role="button"  title="发货邮件提醒"
							data-toggle="modal"><i class="fa fa-envelope" aria-hidden="true"></i></a>
							</c:if>
							</td>
							<td><c:if test="${i.ostatus == 1}">
							<a href="deliver?id=${i.oid }" role="button" title="订单发货"
							data-toggle="modal"><i class="fa fa-truck" aria-hidden="true"></i></a>
							</c:if>
							</td>
						<td>
						<a href="delete?id=${i.oid }" role="button"  title="删除订单"
							data-toggle="modal"><i class="fa fa-trash"></i></a></td>
							
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

