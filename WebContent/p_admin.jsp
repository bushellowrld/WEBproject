<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>产品管理</title>
</head>
<body>

				     <table class="table table-hover">
		                <thead>
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
		                </thead>

		                
		                <tbody style="font-size:13px">
                        		                ？
		                <c:if test="${blist!=null}">
			                <c:forEach items="${blist.dataList}" var="b">
								 <tr>
			                        <td>${b.title}</td>
			                        <td>${b.type}</td>
			                        <td>${b.ppric}</td>
			                        <td>${b.discount}</td>
			                        <td>${b.origin}</td>
			                        <td>${b.directot}</td>
			                        <td>${b.act}</td>
			                        <td>${b.date}</td>
			                        <td>${b.explain}</td>
			                        <td>
			                        <td style="font-size:13px">
			                        	<div role="presentation" class="dropdown">
			                                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">操作<span class="caret"></span></button>
			                                <ul class="dropdown-menu">
<!-- 			                                        在productServlet或者cartServlet中添加加入订单函数，并修改下 -->
			                                    <li><a href="ProductServlet?opt=show&bid=${b.pid}">添加产品</a></li>
 			                                    <li><a href="javascript:if(confirm('确认要删除该产品吗?'))location='${ctxPath }/ProductServlet?opt=del&bid=${b.pid}'">删除</a></li>
			                                </ul>
			                            </div>
			                        </td>
			                    </tr>
							</c:forEach>
						</c:if>
		                </tbody>
		            </table>

</body>
</html>