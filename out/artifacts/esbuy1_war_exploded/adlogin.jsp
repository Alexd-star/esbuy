<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String context = request.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>商城后台</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet" type="text/css" href="<%=context%>/resources/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="<%=context%>/resources/bootstrap/css/font-awesome.css">
<script src="<%=context%>/resources/bootstrap/js/jquery-3.4.1.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="<%=context%>/resources/bootstrap/css/theme.css">
<link rel="stylesheet" type="text/css" href="<%=context%>/resources/bootstrap/css/premium.css">

</head>
<body class=" theme-blue theme-3">

	<style type="text/css">
#line-chart {
	height: 300px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.navbar-default .navbar-brand, .navbar-default .navbar-brand:hover {
	color: #fff;
}
</style>

	<script type="text/javascript">
		$(function() {
			var uls = $('.sidebar-nav > ul > *').clone();
			uls.addClass('visible-xs');
			$('#main-menu').append(uls.clone());
		});
	</script>


	<div class="navbar navbar-default" role="navigation">
		<div class="navbar-header">
			<span class="navbar-brand"><span
					class="glyphicon glyphicon-shopping-cart"></span> ESBUY 商城后台</span>
		</div>

		<div class="navbar-collapse collapse" style="height: 1px;"></div>
	</div>
	</div>



	<div class="dialog">
		<div class="panel panel-default">
			<p class="panel-heading no-collapse">管理员登录</p>
			<div class="panel-body">
				<form id="form1" action="<%=context%>/adlogin" method="post">
					<div class="form-group">
						<label>用户名</label> <input name="aname" type="text" placeholder="请输入用户名" class="form-control span12">
					</div>
					<div class="form-group">
						<label>密码</label> <input type="password" name="apwd" placeholder="请输入密码"
							class="form-controlspan12 form-control">
					</div>
					<button type="submit" class="btn btn-primary pull-right">登录</button>
					<label class="remember-me"><font color="red">${error }</font></label>
					<div class="clearfix"></div>
				</form>
			</div>
		</div>
		
	</div>

	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		$(function() {
			$('.demo-cancel-click').click(function() {
				return false;
			});
		});
	</script>


</body>
</html>
