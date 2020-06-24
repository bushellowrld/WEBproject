<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心 </title>
</head>
<body>

		
<div id="container">
	<!-- 个人中心菜单 -->
	<div class="usermenu pull-left">
		<jsp:include page="usermenu.jsp" />
	</div>
	
	<!-- info -->
	<div class="useropt pull-right">
		<h4>我的资料</h4><hr/>
		<div class="updateuser">

		<form action="${ctxPath }/userServlet?opt=updateUser" method="post">
			<input type="hidden" name="mid" value="${user.mid }" />
			<label>姓名</label>
			<input type="text" class="form-control" name="mname" value="${user.mname }"/>
			<label>*电子邮箱</label>
			<input type="text" class="form-control" name="memail" value="${user.memail }"/>
			<label>*手机号码</label>
			<input type="text" class="form-control" name="mphone" value="${user.mphone }"/>
			<label>*联系地址</label>
			<textarea rows="3" cols="" class="form-control" name="maddress"> ${user.maddress}</textarea>
			<br>
			<button class="btn btn-default" type="submit">修改资料</button>
		</form>
		</div>
	</div>
</div>



<!-- script -->
<script type="text/javascript">
	$(function(){
		//处理提示消息
		if('${MSG_USER_UPDATE_RESULT}'==''){
			$('#msg').addClass('collapse');
			<% session.removeAttribute("MSG_USER_UPDATE_RESULT"); %>	
		}else
			$('#msg').removeClass('collapse');
	});
	
</script>
</body>
</html>