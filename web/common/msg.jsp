<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String context = request.getContextPath();
	String result = "";
	String isShow = "hide";
	if (session.getAttribute("flag") != null) {
		isShow = "show";
		if((boolean)session.getAttribute("flag")) {
			result="操作成功！";
		}
		else result="操作失败";
		session.removeAttribute("flag");
	}
	
%>
<div class="modal fade bs-example-modal-sm" id="alertModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-body">
        <p class="alert alert-danger text-center" role="alert"><%= result %></p>
      </div>
    </div>
  </div>
</div>

<script src="<%=context%>/resources/bootstrap/js/bootstrap.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$('#alertModal').modal('<%=isShow%>');
	});
</script>