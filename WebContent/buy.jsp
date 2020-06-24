<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>产品信息</title>
</head>
<body>
<a href="order.jsp">查看订单</a>
  <form action="${ctxPath }/CartServlet?opt=buy&pid=${buyProduct.pid }" method="post">
    <table>
      <tr>
        <td>名称</td>
        <td>类型</td>
	    <td>单价</td>
	    <td>促销价</td>
	    <td>产地</td>
	    <td>导演</td>
	    <td>主演</td>
	    <td>发行日期</td>
	    <td>产品说明</td>
	    <td>操作</td>
      </tr>
<!--       <tr> -->
<%-- 		<td class="pname">${buyProduct.pname }</td> --%>
<%--         <td class="ptype">${buyProduct.ptype }</td> --%>
<%-- 		<td class="pprice">${buyProduct.pprice }</td> --%>
<%--         <td class="discount">${buyProduct.discount }</td> --%>
<%--         <td class="origin">${buyProduct.origin }</td> --%>
<%--         <td class="director">${buyProduct.director }</td> --%>
<%--         <td class="act">${buyProduct.act }</td> --%>
<%--         <td class="date">${buyProduct.date }</td> --%>
<%--         <td class="explain">${buyProduct.explain }</td>  --%>
<!-- 		<td style="font-size:13px"> -->
<%--         <a href="${ctxPath }/CartServlet?opt=buy&pid=${blist.pid}">加入购物车</a> --%>
<!--         </td> -->
<!--       </tr> -->
      
      <tr>
		<td class="pname">海上钢琴师</td>
        <td class="ptype">电影</td>
		<td class="pprice">30</td>
        <td class="discount">20</td>
        <td class="origin">美国</td>
        <td class="director">朱塞佩</td>
        <td class="act">蒂姆</td>
        <td class="date">2019年</td>
        <td class="explain">讲述了一个钢琴天才传奇一生</td> 
		<td style="font-size:13px">
        <a href="${ctxPath }/CartServlet?opt=buy&pid=${blist.pid}">加入购物车</a>
        </td>
      </tr>
      <tr>
		<td class="pname">无心法师</td>
        <td class="ptype">电视剧</td>
		<td class="pprice">20</td>
        <td class="discount">15</td>
        <td class="origin">中国</td>
        <td class="director">徐惠康</td>
        <td class="act">韩东君</td>
        <td class="date">2019年</td>
        <td class="explain">一部奇幻剧</td> 
		<td style="font-size:13px">
        <a href="${ctxPath }/CartServlet?opt=buy&pid=${blist.pid}">加入购物车</a>
        </td>
      </tr>
      <tr>
		<td class="pname">名侦探柯南</td>
        <td class="ptype">动漫</td>
		<td class="pprice">20</td>
        <td class="discount">18</td>
        <td class="origin">日本</td>
        <td class="director">静野孔文</td>
        <td class="act">小山力也</td>
        <td class="date">2019年</td>
        <td class="explain">动漫悬疑</td> 
		<td style="font-size:13px">
        <a href="${ctxPath }/CartServlet?opt=buy&pid=${blist.pid}">加入购物车</a>
        </td>
      </tr>
      <tr>
		<td class="pname">我们的乐队</td>
        <td class="ptype">综艺</td>
		<td class="pprice">20</td>
        <td class="discount">15</td>
        <td class="origin">中国</td>
        <td class="director">未知</td>
        <td class="act">谢霆锋</td>
        <td class="date">2020年</td>
        <td class="explain">真人秀</td> 
		<td style="font-size:13px">
        <a href="${ctxPath }/CartServlet?opt=buy&pid=${blist.pid}">加入购物车</a>
        </td>
      </tr>
      
  </table>
</form>

</body>
</html>