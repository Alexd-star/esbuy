<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String context = request.getContextPath();
	String upload = context + this.getServletContext().getInitParameter("upload");
%>
<!-- top部件 -->
<jsp:include page="common/top.jsp"></jsp:include>
<!-- /top部件 -->
<!-- start content -->
<div class="container">

	<div class="women-product">
		<div class=" w_content">
			<div class="women">
				<a href="#"><h4>查询结果</h4></a>
				<div class="clearfix"></div>
			</div>
		</div>
		<!-- grids_of_4 -->
		<div class="grid-product">
			<c:forEach items="${good_list }" var="good">
				<div class="  product-grid">
					<div class="content_box">
						<a href="detail?id=${good.gdid}">
							<div class="left-grid-view grid-view-left">
								<img src="<%=upload%>/${good.gdimage}"
									class="img-responsive watch-right" alt="" />
								<div class="mask">
									<div class="info">Quick View</div>
								</div>
							</div>
						</a>
					</div>
					<h4>
						<a href="#">${good.tname}</a>
					</h4>
					<p>${good.gdname}</p>
					¥ ${good.gdprice}
				</div>
			</c:forEach>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- left.jsp -->
	<jsp:include page="common/left.jsp"></jsp:include>
	<!-- /left.jsp -->
	<div class="clearfix"></div>
</div>
<!---->
<jsp:include page="common/bottom.jsp"></jsp:include>

</body>
</html>