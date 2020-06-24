<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
</head>
<body>
  <div>
    <a href="OrderServlet?opt=show" >我的订单</a>
    <a href="user/userinfo.jsp" >我的资料</a>
    <a href="UserServlet?opt=logout" >注销退出</a>
  </div>

<!-- <div class="usermenu"> -->
<%--   <jsp:include page="user/usermenu.jsp"></jsp:include> --%>
<!-- </div> -->

<!-- 购物车列表 -->
			<table class="table table-hover">
				<thead>
					<tr>
						<th>产品名称</th>
<!-- 						<th>订单产品ID</th> -->
<!-- 						<th>会员ID</th> -->
						<th>单价(元)</th>
						<th width="120px" class="text-center">数量</th>
<!-- 						<th>订单日期</th> -->
<!-- 						<th>发货日期</th> -->
<!-- 						<th>发货地址</th> -->
						<th>小计(元)</th>
						<th>操作</th>
					</tr>
				</thead>
				
				<tbody>
				<c:if test="${cart!=null && cart.itemAmount>0 && silist!=null}">
				<c:forEach items="${silist}" var="s">
					<tr>
						<td><a href="ProductServlet?opt=buyProduct&pid=${s.item.pid}">${s.item.pname }</a></td>
						<td>￥${s.item.unitPrice }</td>
						<td>
						<div class="input-group input-group-sm">
						<a href="CartServlet?opt=deAmount&pid=${s.item.pid}" class="input-group-addon"  style="text-decoration: none;">-</a>
						<input id="num" type="text" value="${s.amount }" class="form-control input-sm text-center" onblur="uSAmount(this.value,${s.item.pid})"/>
						<a href="CartServlet?opt=inAmount&pid=${s.item.pid}" class="input-group-addon" style="text-decoration: none;">+</a>
						</div>
						</td>
						<td>${s.item.unitPrice*s.amount }元</td>
						<td><a href="${ctxPath }/CartServlet?opt=del&pid=${s.item.pid}">删除</a></td>
					</tr>
				</c:forEach>
				</c:if>
				<c:if test="${cart==null || cart.itemAmount<1 || silist==null}">
					<tr>
						<td colspan="5" class="text-center"><br>购物车中什么都没有！赶紧<a href="product.jsp">去选购</a>吧！<br></td>
					</tr>
				</c:if>
				</tbody>
				</table>
				
				<c:if test="${cart!=null && cart.itemAmount>0 }">
				<div class="pull-right">
					<span class="show_total">总计:<i>￥${cart.total}</i></span>
					<a href="${ctxPath }/login.jsp" class="btn btn-danger  btn-sm">去结算</a>
					<a href="${ctxPath }/CartServlet?opt=clear" class="btn btn-warning btn-sm">清空购物车</a>
				</div>
				
			</c:if>
</body>
</html>