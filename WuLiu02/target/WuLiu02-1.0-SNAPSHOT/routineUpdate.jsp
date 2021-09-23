<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2021/9/1
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="routineServlet?routine=updateRoutine" method="post">
    <input type="hidden" name="rid" value="${routineEntity.rid}">
    路线名称：<input type="text" name="rname" value="${routineEntity.rname}"  readonly/> <br/>
    起始城市：<span>${routineEntity.rbegincid.cname}</span>
    终点城市：<span>${routineEntity.rendcid.cname}</span>
    价格：<input type="text" name="rprice" value="${routineEntity.rprice}" />
    <input type="submit" value="路线修改">
</form>
</body>
</html>
