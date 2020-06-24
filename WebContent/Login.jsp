<%@ page contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>登录界面</title>

  </head>
  
  <body>
  
  <!-- 登陆表单 -->
  <div class="divForm">
  <form action="userServlet?opt=login" method="post">
    <p>
    <h2>欢迎登录</h2>
    <p>
    <b>账 号：</b><input type="text" name="maccount"/>
    </p>
    <p>
    <b>密  码：</b><input type="password" name="mpassword"/>
    </p>
    <input type="submit" value="登录"/>
    <input type="reset" value="清除"/>
      <div>    没有账户？<a href="register.jsp">立即注册</a></div>
   </form>
  </div>
    <div><a href="login_admin.jsp">管理员登录</a></div>

	
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
	
	<!-- js 检验注册和登陆 -->
	<script type="text/javascript" src="${ctxPath }/js/userckeck.js"></script>
  </body>
</html>
