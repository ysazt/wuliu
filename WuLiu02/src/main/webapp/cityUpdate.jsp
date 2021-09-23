<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2021/8/31
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="cityServlet?city=updateCity" method="post">
    <input type="hidden" name="cid" value="${cityEntity.cid}">
    输入城市名<input type="text" name="cname" value="${cityEntity.cname}"/>

    <input type="submit" value="城市修改">
</select>
</form>
</body>
</html>
