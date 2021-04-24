<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<form class="form-horizontal" method="post" action="<%=context %>/account/order/add">
				<div class="col-sm-12">
					<h3>
						<i class="fa fa-shopping-cart"></i> 购物车
					</h3>
					<table class="table">
						<tr>
							<th>商品</th>
							<th>价格</th>
							<th>数量</th>
							<th>小计</th>
							<th></th>
						</tr>
						<c:forEach items="${list }" var="scar">
							<tr>
								<td><img style="width: 50px; height: 50px"
									class="img-thumbnail" id="gdimage"
									src="<%=context %>/upload/${scar.gdimage}" /> ${scar.gdname }
									<input type="hidden" name="gdid" value="${scar.gdid}" />
								</td>
								<td>¥ <span class="price">${scar.gdprice }</span></td>
								<td>
									<div class="form-group">
										<input type="text" class="form-control" style="width: 50px"
											name="scnum" value="${scar.scnum }" />
									</div>
								</td>
								<td>¥ <span class="subtotal">${scar.scnum * scar.gdprice }</span></td>
								<td><a href="delete?id=${scar.scid }"><i
										class="fa fa-trash-o fa-lg" aria-hidden="true"></i></a></td>
							</tr>
						</c:forEach>
						<tr><th colspan="5"></th></tr>
					</table>
					<div>
						<div class="col-sm-10"><h4>总价</h4></div>
						<div class="col-sm-2"><h4>¥ <span class="total"></span></h4>
						<input type="hidden" name="ototal" value="" /></div>
					</div>
					<div>
						<label class="col-sm-10 control-label"></label>
						<div class="col-sm-2 account-but">
							<input type="submit" value="结算" />
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<!---->
<jsp:include page="../common/bottom.jsp"></jsp:include>
<!---->
<jsp:include page="../common/msg.jsp"></jsp:include>
</body>

<script type="text/javascript">
	$(function() {
		computeTotal();

		$('form').bootstrapValidator({
			feedbackIcons : {
				valid : ' ',
				invalid : ' ',
				validating : 'glyphicon glyphicon-refresh'
			},
			container : 'tooltip',
			fields : {
				'scnum' : {
					validators : {
						notEmpty : {
							message : '不能为空'
						},
						digits : {
							message : '只能输入数字'
						}
					}
				}
			}
		}).on('success.field.bv', function(e, data) { //验证通过后，重新计算小计值
			computeTotal();
		});
	});

	function computeTotal() {
		var total = 0.00;
		//遍历所有name为scnum的input标签，index为每个input标签的索引
		$("input[name='scnum']").each(function(index) {
			//获取第index个class为price的标签的值
			var price = $(".price").eq(index).text();
			//获取当前input标签的value值
			var num = $(this).val();
			//给第index个class为subtotal的标签文本赋值
			$(".subtotal").eq(index).text((price * num).toFixed(2));
			//计算总价
			total = total + parseFloat($(".subtotal").eq(index).text());
		});
		$(".total").text(total.toFixed(2));
		//赋值给隐藏控件
		$("input[name='ototal']").val(total.toFixed(2));
	}
</script>
</html>