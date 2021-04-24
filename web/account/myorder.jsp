<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String context = request.getContextPath();
	String upload = context + this.getServletContext().getInitParameter("upload");
%>

<!-- top部件 -->
<jsp:include page="../common/top.jsp"></jsp:include>
<!-- /top部件 -->
<div class="container">
	<div class="col-sm-1"></div>
	<div class="col-sm-10">
		<div class="cart">
			<form class="form-horizontal" method="post" action="">
				<div class="col-sm-12">
					<h3>
						<i class="fa fa-shopping-cart"></i> 我的订单
					</h3>
					<table class="table">
						<tr>
							<th>#</th>
							<th>订单号</th>
							<th>下单日期</th>
							<th>总金额</th>
							<th>订单状态</th>
							<th></th>
						</tr>
						<c:forEach items="${list }" var="order" varStatus="status">
							<tr>
								<td>${status.count}</td>
								<td>${order.ocode }</td>
								<td><fmt:formatDate type="both" pattern="yyyy-MM-dd HH:mm:ss"  
            value="${order.otime }" /></td>
								<td>¥ ${order.ototal == null ? 0: order.ototal }</td>
								<td>
									<c:choose>
										<c:when test="${order.ostatus == 2}">已发货</c:when>
										<c:when test="${order.ostatus == 3}">已收货</c:when>
										<c:otherwise>已下单</c:otherwise>
									</c:choose>
								</td>
								<td>
								<c:if test="${order.ostatus == 2}">
									<a class="acount-btn" href="<%=context %>/account/order/receipt?id=${order.oid}">确认收货</a>
								</c:if>
								</td>
							</tr>
						</c:forEach>
						<tr><th colspan="6"><span style="height: 40px">&nbsp;</span></th></tr>
					</table>
				</div>
			</form>
		</div>
	</div>
</div>
<!---->
<jsp:include page="../common/bottom.jsp"></jsp:include>
</body>
</html>