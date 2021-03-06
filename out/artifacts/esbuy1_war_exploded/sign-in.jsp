<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String context = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<title>登录</title>
<link href="<%=context%>/resources/bootstrap/css/bootstrap.css"
	rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet"
	href="<%=context%>/resources/bootstrap/css/bootstrapValidator.min.css" />

<link rel="stylesheet"
	href="<%=context%>/resources/bootstrap/css/font-awesome.css">
<!--theme-style-->
<link href="<%=context%>/resources/styles/style.css" rel="stylesheet"
	type="text/css" media="all" />
<!--//theme-style-->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<!--fonts-->
<link href='<%=context%>/resources/bootstrap/css/font-gooleapis.css'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet" type="text/css"
	href="<%=context%>/resources/styles/style.css" />
<!--//fonts-->
<script src="<%=context%>/resources/bootstrap/js/jquery.min.js"></script>
<script src="<%=context%>/resources/js/jquery.easydropdown.js"></script>
<!--script-->
<script src="<%=context%>/resources/bootstrap/js/bootstrap.js"
	type="text/javascript"></script>
<script
	src="<%=context%>/resources/bootstrap/js/bootstrapValidator.min.js"
	type="text/javascript"></script>
</head>
<body>
	<div class="header">
		<div class="top-header">
			<div class="container">
				<div class="top-header-left">
					<img style="height: 20px"
						src="<%=context%>/resources/images/logowhite.png" />
				</div>
				<div class="top-header-right">
					<a href="sign-up" class="label"><i class="fa fa-key"> </i> 注册</a>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- /head部件 -->

	<div class="register">
		<form class="form-horizontal" method="post" action="sign-in">
			<div class="  register-top-grid">
				<div class="form-group">
					<div class="col-sm-2"></div>
					<div class="col-sm-10">
						<h3>
							<i class="fa fa-address-card-o fa-lg fa-fw"></i> 会员登录
						</h3>
					</div>
				</div>
				<div class="mation">
					<div class="row">
						<label class="col-sm-2"></label>
						<div class="col-sm-5">
							<div id="alert-info" class="alert alert-danger hide" role="alert"><i class="fa fa-info-circle"></i> ${error }</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label"><span>用户名*</span></label>
						<div class="col-sm-5">
							<input type="text" name="uname" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label"><span>密码*</span></label>
						<div class="col-sm-5">
							<input type="password" name="upwd" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label"></label>
						<div class="col-sm-10 register-but">
							<input type="submit" value="登录" />
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>


	<script>
		$(function() {
 			if ('${error}' != '') {
				$('#alert-info').addClass("show");
			} 
			
			$('form').bootstrapValidator({
				message : 'This value is not valid',
				feedbackIcons : {
					valid : 'glyphicon glyphicon-ok',
					invalid : 'glyphicon glyphicon-remove',
					validating : 'glyphicon glyphicon-refresh'
				},
				fields : {
					uname : {
						validators : {
							notEmpty : {
								message : '用户名不能为空'
							}
						}
					},
					upwd : {
						validators : {
							notEmpty : {
								message : '密码不能为空'
							}
						}
					}
				}
			});
		});
	</script>
</body>
</html>

