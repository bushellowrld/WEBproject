<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员</title>
</head>
<body>
	
<%-- 		<form action= "${ctxPath }/adminServlet?opt=login }" method="post"> --%>
		<input type = "button" value = "管理订单" onclick = "window.location.href = 'order_admin.jsp'">
		<input type = "button" value = "管理产品" onclick = "window.location.href = 'p_admin.jsp'">
		<input type = "button" value = "管理会员" onclick = "window.location.href = 'm_admin.jsp'">
		</form>

</body>
</html>