<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2021/8/30
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="provinceServlet?province=updateProvince" method="post">
    <input type="hidden" name="pid" value="${pro.pid}">
    省份<input  type="text" name="pname" value="${pro.pname}">
    <input type="submit" value="修改省份">
</form>
</body>
</html>
