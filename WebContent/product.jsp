<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>产品</title>
</head>
<body>
<a href="order.jsp">查看订单</a>
<a href="buy.jsp">详细列表</a>
<%-- <form action="${ctxPath }/CartServlet?opt=buy&pid=${buyProduct.pid }" method="post"> --%>
         <form action="CartServlet?opt=buy&pid=${buyProduct.pid }" method="post">
				     <table class="table table-hover">
		                <thead>
		                    <tr>
		                           <td>ID</td>
	                               <td>名称</td>
<!-- 			                       <td>类型</td> -->
			                       <td>单价</td>
<!-- 			                       <td>促销价</td> -->
<!-- 			                       <td>产地</td> -->
<!-- 			                       <td>导演</td> -->
<!-- 			                       <td>主演</td> -->
<!-- 			                       <td>发行日期</td> -->
<!-- 			                       <td>产品说明</td> -->
			                       <td>操作</td>
		                    </tr>
		                </thead>
		                
		                <tbody style="font-size:13px">
<%-- 		                <c:if test="${blist!=null}"> --%>
<%-- 			                <c:forEach items="${blist.dataList}" var="b"> --%>
<!-- 								 <tr> -->
<%-- 								   <td class="pid"><a href="${ctxPath }/ProductServlet?opt=buyProduct&pid=${products.pid }"></a></td> --%>
<%-- 								   <td class="pname"><a href="${ctxPath }/ProductServlet?opt=buyProduct&pid=${products.pid }">${products.pname }</a></td> --%>
<%-- 								   <td class="ptype">${buyProduct.ptype }</td> --%>
<%-- 								   <td class="pprice"><a href="${ctxPath }/ProductServlet?opt=buyProduct&pid=${products.pid }">${products.pprice }</a></td> --%>
<%-- 								   <td class="discount">${buyProduct.discount }</td> --%>
<%-- 								   <td class="origin">${buyProduct.origin }</td> --%>
<%-- 								   <td class="director">${buyProduct.director }</td> --%>
<%-- 								   <td class="act">${buyProduct.act }</td> --%>
<%-- 								   <td class="date">${buyProduct.date }</td> --%>
<%-- 								   <td class="explain">${buyProduct.explain }</td> --%>
<!-- 			                        <td style="font-size:13px"> -->
<%--                                        <a href="${ctxPath }/CartServlet?opt=buy&pid=${blist.pid}">加入购物车</a> --%>
<!-- 			                        </td> -->
<!-- 			                    </tr> -->

                                   <tr>
                                     <td>0000</td>
                                     <td>海上钢琴师</td>
                                     <td>30</td>
                                     <td style="font-size:13px">
                                       <a href="${ctxPath }/CartServlet?opt=buy&pid=${blist.pid}">加入购物车</a>
			                         </td>
                                   </tr>
                                   <tr>
                                     <td>0001</td>
                                     <td>无心法师</td>
                                     <td>20</td>
                                     <td style="font-size:13px">
                                       <a href="${ctxPath }/CartServlet?opt=buy&pid=${blist.pid}">加入购物车</a>
			                         </td>
                                   </tr>
                                   <tr>
                                     <td>0002</td>
                                     <td>名侦探柯南</td>
                                     <td>20</td>
                                     <td style="font-size:13px">
                                       <a href="${ctxPath }/CartServlet?opt=buy&pid=${blist.pid}">加入购物车</a>
			                         </td>
                                   </tr>
                                   <tr>
                                     <td>0003</td>
                                     <td>我们的乐队</td>
                                     <td>20</td>
                                     <td style="font-size:13px">
                                       <a href="${ctxPath }/CartServlet?opt=buy&pid=${blist.pid}">加入购物车</a>
			                         </td>
                                   </tr>
			                    
			                    
		                </tbody>
		            </table>
		        </form>


</body>
</html>