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

	<div class=" single_top">
		<div class="single_grid">
			<div class="grid images_3_of_2">
				<ul id="etalage">
					<li><a href="optionallink.html"> <img
							class="etalage_thumb_image" src="<%=upload%>/${good.gdimage}"
							style="width: 300px" class="img-responsive" /> <img
							class="etalage_source_image" src="images/si4.jpg"
							class="img-responsive" title="" />
					</a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="desc1 span_3_of_2">
				<ul class="back">
					<li><i class="back_arrow"> </i>Back to <a href="index">首页</a></li>
				</ul>
				<h1>${good.gdname}</h1>
				<ul class="price_single">
					<li class="head"><h2>¥ ${good.gdprice}</h2></li>
					<li class="clearfix"></li>
				</ul>
				<p>
					<span>库存：${good.gdquantity}</span><span>发货地：${good.gdcity}</span>
				</p>

				<a href="account/cart/add?id=${good.gdid }" class="now-get">加入购物车</a>

			</div>
			<div class="clearfix"></div>
		</div>

		<div class="toogle">
			<h3 class="m_3">商品简介</h3>
			<p class="m_text">${good.gdinfo}</p>
		</div>
	</div>

	<!---->
	<!-- left.jsp -->
	<jsp:include page="common/left.jsp"></jsp:include>
	<!-- /left.jsp -->
	<div class="clearfix"></div>
</div>
<!---->
<jsp:include page="common/bottom.jsp"></jsp:include>
<!---->
<jsp:include page="common/msg.jsp"></jsp:include>

</body>
</html>