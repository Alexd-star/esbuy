<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String context = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<title>e诚尚品</title>
<link href="<%=context%>/resources/bootstrap/css/bootstrap.css"
	rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet"
	href="<%=context%>/resources/bootstrap/css/font-awesome.css">
<!--theme-style-->
<link href="<%=context%>/resources/styles/style.css" rel="stylesheet"
	type="text/css" media="all" />
<!--//theme-style-->
<link rel="stylesheet"
	href="<%=context%>/resources/bootstrap/css/bootstrapValidator.min.css" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<!--fonts-->
<link href='<%=context%>/resources/bootstrap/css/font-gooleapis.css'
	rel='stylesheet' type='text/css'>

<script src="<%=context%>/resources/bootstrap/js/jquery.min.js"></script>
<script src="<%=context%>/resources/bootstrap/js/bootstrap.js"></script>
<script src="<%=context%>/resources/bootstrap/js/jquery.easydropdown.js"></script>
<script
	src="<%=context%>/resources/bootstrap/js/bootstrapValidator.min.js"
	type="text/javascript"></script>
<!--script-->
</head>
<body>
	<!--top-header-->
	<div class="header">
		<div class="top-header">
			<div class="container">
				<div class="top-header-right">
					<div class="down-top">
						<select class="dropdown">
							<option value="1" class="label" value="">注册</option>
						</select>
					</div>
					<div
						class="down-top 
						<c:if test='${user!=null }'>hide</c:if>
					">
						<select class="dropdown">
							<option value="2" class="label" value="">登录</option>
						</select>
					</div>

					<div class="down-top">
						<select class="dropdown">
							<option value="3" class="label">${user.uname }</option>
							<option>我的订单</option>
							<option>注销</option>
						</select>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="bottom-header">
			<div class="container">
				<div class="col-md-3">
					<div class="logo">
						<a href="<%=context%>/index"><img style="width: 180px"
							src="<%=context%>/resources/images/logo.png" alt=" " /></a>
					</div>
				</div>
				<div class="col-md-6">
				<form action="<%=context%>/list" method="post">
					<div class="input-group" style="margin-top: 30px;">
						<input type="text" name="keywords" class="form-control" placeholder="请输入商品名称...">
						<span class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div></form>
					<!-- /input-group -->
				</div>
				<div class="col-md-3">
					<ul class="men-grid">
						<li class="cart"><a href="<%=context%>/account/cart/list"><span>
							</span>我的购物车</a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--/top-header-->
	<script>
	$(document).ready(function(){
	      $("span.selected").click(function() {	  
		      var selected = $(this).text();
		      if (selected == '注册') location.href = '<%=context%>/sign-up';
		      if (selected == '登录') location.href = '<%=context%>/sign-in';
		      
		  }); 
	      $("ul li").click(function() {
	    	  	  var selected = $(this).text();
	    	  	  if (selected == '我的订单') location.href = '<%=context%>/account/myorder';
	    	  	  if (selected == '注销') location.href = '<%=context%>/sign-out';
	    	  	  
			});
		});
	</script>