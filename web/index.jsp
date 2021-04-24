<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String context = request.getContextPath();
	String upload = context + this.getServletContext().getInitParameter("upload");
%>		

<!-- top部件 -->
<jsp:include page="common/top.jsp"></jsp:include>
<!-- /top部件 -->

	<div class="container">
		<div class="banner-menu">
			<div class="shoes-grid">
				<div class="wmuSlider example1 slide-grid">
					<div class="wmuSliderWrapper">
						<article style="position: absolute; width: 100%; opacity: 0;">
							<div id="banner1">
								
							</div>
						</article>
						<article style="position: absolute; width: 100%; opacity: 0;">
							<div id="banner2">
								
							</div>
						</article>
						<article style="position: absolute; width: 100%; opacity: 0;">
							<div id="banner3">
								
							</div>
						</article>
					</div>
					<ul class="wmuSliderPagination">
						<li><a href="#" class="">0</a></li>
						<li><a href="#" class="">1</a></li>
						<li><a href="#" class="">2</a></li>
					</ul>
				</div>
				<script src="<%=context%>/resources/bootstrap/js/jquery.wmuSlider.js"></script>
				<script>
					$('.example1').wmuSlider();
				</script>
				<div class="products">
					<h5 class="latest-product">最新上架</h5>
				</div>
				<div class="product-left">
				
				<c:forEach items="${good_list }" var="good" varStatus="status">
					<div class=" chain-grid  
						<c:choose>
							<c:when test="${status.count % 3==0}"> 
							grid-top-chain
							</c:when>
						</c:choose>
					" style="backgroud-image: url(<%=upload%>/${good.gdimage})">
						<a href="detail?id=${good.gdid}"><img class="img-responsive chain" style="height:250px"
							src="<%=upload%>/${good.gdimage}" alt=" " /></a> <span
							class="star"> </span>
						<div class="grid-chain-bottom">
							<h6>${good.gdname }</h6>
							<div class="star-price">
								<div class="dolor-grid">
									<span class="actual">¥ ${good.gdprice}</span> 									
								</div>
								<a class="now-get get-cart" href="account/cart/add?id=${good.gdid }">加入购物车</a>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
					</c:forEach>
					
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
			<!-- left.jsp -->
			<jsp:include page="common/left.jsp"></jsp:include>
			<!-- /left.jsp -->
			<div class="clearfix"></div>
		</div>
	</div>
	<!---->
	<jsp:include page="common/bottom.jsp"></jsp:include>
	<!---->
	<jsp:include page="common/msg.jsp"></jsp:include>
</body>
</html>