<%@ page contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>管理员登陆</title>

</head>
<body>
<hr>
  <div class="divForm">
   <form action="adminServlet?opt=login" method="post" name="form1" >
   <p>
    <h2>欢迎登录</h2>
    <p>
    <b>账 号：</b><input type="text" name="saccount"/>
    </p>
    <p>
    <b>密  码：</b><input type="password" name="spassword"/>
    </p>
    <input type="submit" value="登录"/>
    <input type="reset" value="清除"/>
    </form>
    </div>
    <div><a href="Login.jsp">返回</a></div>
    
    <style type="text/css">
		.divForm{
			position: absolute;
			width: 300px;
			height: 230px;
		
			border: 1px solid blue;
			text-align: center;
			top: 70%;
			left: 50%;
			margin-top: -200px;
			margin-left: -150px;
	}
	</style>
</body>
</html>