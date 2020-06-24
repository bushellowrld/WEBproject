<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户修改</title>
</head>
<body>
		<div class="container">
			<div class="row">
				<!-- 内容 -->
				<div class="col-md-10">
					<div class="page-header">
			            <h1>用户管理</h1>
			        </div>
					<ul class="nav nav-tabs">
				        <li class="active">
				            <a href="m_admin.html">编辑用户</a>
				        </li>
				    </ul>
				    
				    <div>
				    	<form action="UserServlet?opt=edit" method="post">
				    		<div class="form-group">
		                        <label for="addname">UID</label>
		                        <input type="hidden" name="mid" value="${editUser.mid }">
		                         <input type="hidden" name="maddress" value="${editUser.maddress }">
		                      	<span style="margin-left: 30px;">${editUser.id }</span>
		                    </div>
		                    <div class="form-group">
		                        <label for="maccount">用户名</label>
		                        <input type="text" name="maccount" value="${editUser.maccount }" class="form-control" placeholder="用户名">
		                    </div>
		                    <div class="form-group">
		                        <label for="mname">真实姓名</label>
		                        <input type="text" name="mname" value="${editUser.mname }" class="form-control" placeholder="请输入用户姓名">
		                    </div>
		                    <div class="form-group">
		                        <label for="msex">性别</label>
		                        <input type="text" name="msex" value="${editUser.msex }" class="form-control" placeholder="请输入用户性别">
		                    </div>
		                    <div class="form-group">
		                        <label for="maddress">家庭住址</label>
		                        <input type="text" name="maddress" value="${editUser.maddress }" class="form-control" placeholder="请输入用户住址">
		                        
		                    </div>
		                    <div class="form-group">
		                        <label for="memail">用户邮箱</label>
		                        <input type="text" name="memail" value="${editUser.memail}" class="form-control" placeholder="请输入用户邮箱">
		                    </div>
		                    <div class="form-group">
		                        <label for="mphone">用户手机</label>
		                        <input type="text" name="mphone" value="${editUser.mphone}" class="form-control" placeholder="请输入用户手机">
		                    </div>
		                    <button type="submit" class="btn btn-primary">确认修改</button>
		                    <a href="${ctxPath }/m_admin.jsp" class="btn btn-default">取消</a>
		                </form>
				    </div>
				    
				    
				</div>
				<!-- 内容 -->
			</div>
		</div>
		<!-- 主区域 -->

</body>
</html>