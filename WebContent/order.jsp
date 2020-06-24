<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>order</title>
</head>
<body>

  <div>
    <a href="CartServlet?opt=show" >我的购物车</a>
    <a href="userinfo.jsp" >我的资料</a>
    <a href="UserServlet?opt=logout" >注销退出</a>
  </div>

<!-- <div class="usermenu"> -->
<%--   <jsp:include page="user/usermenu.jsp"></jsp:include> --%>
<!-- </div> -->


			<table class="table table-hover">
				<thead>
					<tr>
						<th>订单编号</th>
						<th>产品ID</th>
						<th>会员ID</th>
						<th>订单日期</th>
						<th>总价</th>
						<th width="120px" class="text-center">数量</th>
						<th>发货日期</th>
						<th>收货地址</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${olist}" var="o">
					<tr>
<!-- 					     oid -->
						<td>${o.oid}</td>
						
<!-- 						pid -->
                        <td>${o.pid}</td>
                        
<!--                         mid -->
                        <td>${o.mid }</td>
                        
                        <td>${o.orderDate }</td>
						<td>${o.price}元</td>
						<td>${o.number}元</td>
<!-- 						<td> -->
<!-- 						<div class="input-group input-group-sm"> -->
<%-- 						<a href="${ctxPath }/CartServlet?opt=deAmount&pname=${s.item.pname}" class="input-group-addon"  style="text-decoration: none;">-</a> --%>
<%-- 						<input id="num" type="text" value="${s.amount }" class="form-control input-sm text-center" onblur="uSAmount(this.value,${s.item.name})"/> --%>
<%-- 						<a href="${ctxPath }/CartServlet?opt=inAmount&pname=${s.item.pname}" class="input-group-addon" style="text-decoration: none;">+</a> --%>
<!-- 						</div> -->
<!-- 						</td> -->
<!-- 						+1 -->
						<td>${o.senddate }</td>
						
						<td>${o.maddress }</td>
						<td><a href="${ctxPath }/CartServlet?opt=del&pid=${s.item.pid}">删除</a></td>
					</tr>
					
				</c:forEach>
				</tbody>		
			</table>
		</div>


</body>
</html>