<%@ page language ="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>订单管理</title>
</head>
<body>
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
<%-- 				<c:if test="${cart!=null && cart.itemAmount>0 && silist!=null}"> --%>
<%-- 				<c:forEach items="${silist}" var="s"> --%>
					<tr>
<!-- 					     oid -->
						<td><a href="P_adminServlet?opt=buyProduct&oid=${s.item.oid}"></a></td>
<!-- 						pid -->
                        <td><a href="BookServlet?opt=buyProduct&pid=${s.item.id}">${s.item.pname }</a></td>
<!--                         mid -->
                        <td><a href="BookServlet?opt=buyProduct&mid=${s.item.id}">${s.item.maccount }</a></td>
                        <td>${o.orderDate }</td>
						<td>￥${s.item.unitPrice }</td>
						
						<td>${o.quantity }</td>
<!-- 						+1 -->
						<td>${o.senddate }</td>
						
						<td>${o.maddress }</td>
						<td style="font-size:13px">
			                        	<div role="presentation" class="dropdown">
<!-- 			                                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">操作<span class="caret"></span></button> -->
<!-- 			                                <ul class="dropdown-menu"> -->
<!-- 			                                        在productServlet或者cartServlet中添加加入订单函数，并修改下 -->
			                                    <li><a href="${ctxPath }/ProductServlet?opt=show&bid=${b.pid}">编辑</a></li>
 			                                    <li><a href="javascript:if(confirm('确认要删除该订单吗?'))location='${ctxPath }/ProductServlet?opt=del&pid=${b.pid}'">删除</a></li> 
<!-- 			                                </ul> -->
			                            </div>
			                        </td>
					</tr>
					
				</tbody>
			</table>
			
</body>
</html>