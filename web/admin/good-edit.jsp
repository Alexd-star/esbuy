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

		<h1 class="page-title">商品修改</h1>
		<ul class="breadcrumb">
			<li><a href="#">首页</a></li>
			<li><a href="#">商品管理</a></li>
			<li class="active">商品修改</li>
		</ul>

	</div>
	<div class="main-content">
		<div class="row">
			<div class="col-md-11">
				<form class="form-horizontal" action="edit" method="post" enctype="multipart/form-data">
				<div class="form-group">
						<label class="col-sm-2 control-label">编号</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" name="gdid" value="${good.gdid }"
								readOnly>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">商品名称</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="gdname"
								placeholder="" value="${good.gdname }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">所属类别</label>
						<div class="col-sm-3">
							<select class="form-control" name="tid">
								<c:forEach items="${list }" var="i">
									<option value="${i.tid }" 
										<c:if test="${good.tid==i.tid }">
											selected="selected"
										</c:if>
									>${i.tname }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">货号</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" name="gdcode" value="${good.gdcode }"
								placeholder="4901990000" required>
						</div>
						<label class="col-sm-2 control-label">销售价格</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" name="gdprice" value="${good.gdprice }"
								value="0.01" pattern="^\d+.\d{2}$" required>
						</div>
					</div>
					<div class="form-group">
					<label class="col-sm-2 control-label">库存</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" name="gdquantity" value="${good.gdquantity }"
								value="0" pattern="^[0-9]*$" required>
						</div>
						<label class="col-sm-2 control-label">发货城市</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" name="gdcity" value="${good.gdcity }"
								placeholder="北京">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">商品图片</label>
						<div class="col-sm-5">
							<input type="file" class="form-control" name="gdimage" />
						</div>
												
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">商品描述</label>
						<div class="col-sm-10">
							<textarea class="form-control" rows="7" name="gdinfo">${good.gdinfo }</textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-12">
							<button class="btn btn-primary">
								<i class="fa fa-save"></i> 保存
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>

		<!-- 底部开始 -->
		<%@ include file="common/bottom.jsp"%>
		<!-- 底部结束 -->
	</div>
</div>