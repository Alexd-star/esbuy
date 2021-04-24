<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	 String context = request.getContextPath();
%>
    <div class="sidebar-nav">
    <ul>
    <li><a href="#" data-target=".goodtype-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i> 类别管理<i class="fa fa-collapse"></i></a></li>
    <li><ul class="goodtype-menu nav nav-list collapse in">
            <li><a href="<%=context %>/admin/goodtype/list"><span class="fa fa-caret-right"></span> 类别列表</a></li>
            <li ><a href="<%=context %>/admin/goodtype/add"><span class="fa fa-caret-right"></span> 类别添加</a></li>
    </ul></li>	
	<li><a href="#" data-target=".good-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i> 商品管理<i class="fa fa-collapse"></i></a></li>
    <li><ul class="good-menu nav nav-list collapse in">
            <li><a href="<%=context %>/admin/good/list"><span class="fa fa-caret-right"></span> 商品列表</a></li>
            <li ><a href="<%=context %>/admin/good/add"><span class="fa fa-caret-right"></span> 商品添加</a></li>
    </ul></li>
    
    <li><a href="#" data-target=".user-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i> 会员管理<i class="fa fa-collapse"></i></a></li>
    <li><ul class="user-menu nav nav-list collapse in">
            <li><a href="<%=context %>/admin/user/list"><span class="fa fa-caret-right"></span> 会员列表</a></li>
    </ul></li>
    <li><a href="#" data-target=".order-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i> 订单管理<i class="fa fa-collapse"></i></a></li>
    <li><ul class="order-menu nav nav-list collapse in">
            <li><a href="<%=context %>/admin/order/list"><span class="fa fa-caret-right"></span> 订单列表</a></li>
    </ul></li>
    <li><a href="#" data-target=".system-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i> 系统管理<i class="fa fa-collapse"></i></a></li>
    <li><ul class="system-menu nav nav-list collapse in">
            <li><a href="<%=context %>/admin/email/set"><span class="fa fa-caret-right"></span> 邮件设置</a></li>
    </ul></li>
</ul>
    </div>