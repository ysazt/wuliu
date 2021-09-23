<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2021/9/1
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="index.jsp">回首页</a>
${flag1==0?"可用列表":"废弃列表"}
    <table border="1">
        <tr>
            <td>id</td>
            <td>路线名</td>
            <td>起始城市</td>
            <td>终点城市</td>
            <td>价格</td>
            <td>状态</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${rlist}"  var="routine">
            <tr>
                <td>${routine.rid}</td>
                <td>${routine.rname}</td>
                <td>${routine.rbegincid.cname}</td>
                <td>${routine.rendcid.cname}</td>
                <td>${routine.rprice}</td>
                <td>${routine.rbeizhu==0?"可用":"废弃"}</td>
                <c:if test="${flag1 == 0}">
                    <td><a href="routineServlet?routine=delRoutine&rid=${routine.rid}&flag=1">废弃</a> </td>
                    <td><a href="routineServlet?routine=byidRoutine&rid=${routine.rid}">update</a> </td>
                </c:if>
                <c:if test="${flag1 == 1}">
                    <td><a href="routineServlet?routine=delRoutine&rid=${routine.rid}&flag=0">可用</a> </td>
                </c:if>

            </tr>
        </c:forEach>

    </table>
</body>
</html>
