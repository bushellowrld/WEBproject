<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员管理</title>
</head>
<body>
<div class="col-md-2">
<%-- 			            <a href="${ctxPath }/UserServlet?opt=userlist" class="list-group-item active">用户管理</a> --%>
			            <a href="useredit.jsp">编辑用户</a>
				</div>
		                
		                
		                <tbody style="font-size:13px">

		                <c:if test="${blist!=null}">
			                <c:forEach items="${blist.dataList}" var="b">
			                   <c:if test="${u.mid!=user.mid}">
								 <tr>

			                        <td>${u.mid}</td>
			                        <td>${u.maccount}</td>
			                        <td>${u.mname}</td>
			                        <td>${u.msex}</td>
			                        <td>${u.maddress}</td>
			                        <td>${u.mphone}</td>
			                        <td>${u.memail}</td>
			                        <td style="font-size:13px">
			                        	<div role="presentation" class="dropdown">
			                                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">操作<span class="caret"></span></button>
			                                <ul class="dropdown-menu">
 			                                    <li><a href="${ctxPath }/ProductServlet?opt=show&bid=${b.pid}">添加产品</a></li> 
  			                                    <li><a href="javascript:if(confirm('确认要删除该用户吗?'))location='${ctxPath }/ProductServlet?opt=del&bid=${b.pid}'">删除</a></li> 
			                                </ul>
			                            </div>
			                        </td>
			                    </tr>
			                    </c:if>
							</c:forEach>
						</c:if>
		                </tbody>
		            </table>

</body>
</html>