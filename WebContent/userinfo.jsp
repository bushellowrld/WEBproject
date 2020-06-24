<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的资料</title>
</head>
<body>
        <form action="userServlet?opt=updateUser" method="post">
			<input type="hidden" name="mid" value="${user.mid }" />
			<label>姓名</label>
			<input type="text" class="form-control" name="mname" placeholder="真实姓名" value="${user.mname }"/>
			<label>*电子邮箱</label>
			<input type="text" class="form-control" name="memail" placeholder="邮箱" value="${user.memail }"/>
			<label>*手机号码</label>
			<input type="text" class="form-control" name="mphone"  placeholder="手机号码" value="${user.mphone }"/>
			<label>*联系地址</label>
<%-- 			<textarea rows="3" cols="" class="form-control" name="maddress" placeholder="联系地址"> ${user.maddress}</textarea> --%>
			<input type="text" class="form-control" name="maddress"  placeholder="联系地址" value="${user.maddress }"/>
			<br>
			<button class="btn btn-default" type="submit"><a href="useredit.jsp">修改资料</a></button>
		</form>

</body>
</html>