<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Conten-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
  <p>
    <form action="userServlet?opt=register" method="post">
      <table> 
        <caption>添加信息</caption>
        <!-- idmember没有添加 -->
<!--            <tr> -->
<!--              <td>用户ID</td> -->
<!--              <td><input type="text" name="mid">5-19个长度</td> -->
<!--            </tr> -->
           <tr>
             <td>用户名</td>
             <td><input type="text" name="maccount">5-19个长度</td>
           </tr>
           <tr>
             <td>密码</td>
             <td><input type="text" name="mpassword">6-20</td>
           </tr>
           <tr>
             <td>姓名</td>
             <td><input type="text" name="mname"></td>
           </tr>
           <!-- 可以用radio -->
           <tr>
             <td>性别</td>
             <td><input type="text" name="msex">男/女</td>
           </tr>
           <tr>
             <td>所在城市</td>
             <td><input type="text" name="mcity">*</td>
           </tr>
           <tr>
             <td>地址</td>
             <td><input type="text" name="maddress">/省/市/路</td>
           </tr>
           <tr>
             <td>邮编</td>
             <td><input type="text" name="mpostcode">*</td>
           </tr>
           <tr>
             <td>电话</td>
             <td><input type="text" name="mphone">*</td>
           </tr>
           <tr>
             <td>Email</td>
             <td><input type="text" name="memail">*</td>
           </tr>
           <tr>
             <td align="center"><input type=submit value="立即注册 "></a></td>
            <!--  <td align="center"><input type=reset value="reset"></td> -->
           </tr>
       </table>
    </form>
 
 	<!-- script -->
	<script type="text/javascript" src="/js/userckeck.js"></script>
<script type="text/javascript">
$(function(){
	//处理提示消息
	if('${MSG_USER_REGISTER_RESULT}'==''){
		$('#msg').addClass('collapse');
		<% session.removeAttribute("MSG_USER_REGISTER_RESULT"); %>	
	}else
		$('#msg').removeClass('collapse');
});

</script>


</body>
</html>