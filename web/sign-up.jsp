<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String context = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<title>注册</title>
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
					<a href="sign-in" class="label"><i class="fa fa-key">
					</i> 登录</a>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- /head部件 -->

	<div class="register">
		<form class="form-horizontal" method="post" action="sign-up">
			<div class="  register-top-grid">
				<div class="form-group">
					<div class="col-sm-2"></div>
					<div class="col-sm-10">
						<h3>
							<i class="fa fa-address-card-o fa-lg fa-fw"></i> 会员注册
						</h3>
					</div>
				</div>
				<div class="mation">
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
						<label class="col-sm-2 control-label"><span>确认密码*</span></label>
						<div class="col-sm-5">
							<input type="password" name="urepwd" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label"><span>性别*</span></label>
						<div class="col-sm-5">
							<label class="checkbox-inline" style="border: 0"> <input
								type="radio" name="usex" checked="checked" value="男" /> 男 <i
								style="margin-left: 5px"></i> 
								<input type="radio" name="usex" value="女"/>
								女
							</label>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label"><span>出生日期*</span></label>
						<div class="col-sm-5">
							<input name="ubirth" type="date"
								style="width: 60%; height: 36px;" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label"><span>手机*</span></label>
						<div class="col-sm-5">
							<input type="text" name="uphone" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label"><span>Email*</span></label>
						<div class="col-sm-5">
							<input type="email" name="uemail" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label"><span>QQ*</span></label>
						<div class="col-sm-5">
							<input type="text" name="uqq" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label"></label>
						<div class="col-sm-10 register-but">
							<!-- <button type="submit" name="submit">注册</button> -->
							<input type="submit" value="注册" />
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>


	<script>
		$(function() {
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
							},
							threshold: 2, //有2字符以上才发送ajax请求
							remote: {
								url: '<%=context%>/user/check',
								delay: 1000,   //ajax刷新的时间是1秒/次
								data: function() {
									return {
										uname: $("input[name=uname]").val()
									};
								},
								message: '用户名已存在',
								type: 'post'
							}
						}
					},
					upwd : {
						validators : {
							notEmpty : {
								message : '密码不能为空'
							}
						}
					},
					urepwd : {
						validators : {
							notEmpty : {
								message : '确认密码不能为空'
							},
							identical : {
								field : 'upwd',
								message : '密码和确认密码不一致'
							}
						}
					},
					uphone : {
						validators : {
							notEmpty : {
								message : '手机不能为空'
							}
						}
					},
					uemail : {
						validators : {
							notEmpty : {
								message : '邮箱不能为空'
							},
							emailAddress : {
								message : '不是有效的邮箱格式'
							}
						}
					},
					uqq : {
						validators : {
							notEmpty : {
								message : 'QQ不能为空'
							}
						}
					},
				}
			});
		});
	</script>
</body>
</html>

