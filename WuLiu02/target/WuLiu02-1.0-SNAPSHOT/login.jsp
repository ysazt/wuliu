<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2021/8/30
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  登录页面
<form action="userServlet?method=login" method="post">
    用户名：<input type="text" name="uname" />
    密码<input type="text" name="upwd" />
    角色：<%--<input type="hidden" name="juese" value="1">--%>
    <select name="juese">
               <option value="0">管理员</option>
               <option value="1">消费者</option>
            </select>
      <input type="submit" value="登录">
</form>
</body>
</html>
