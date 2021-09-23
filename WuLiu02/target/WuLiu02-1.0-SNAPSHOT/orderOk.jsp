<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2021/9/3
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    根据您的邮寄信息，您本次需要支付的金额是${totalPrice} ,用户钱够 一定支付
     付钱成功， 修改状态 <a href="orderServlet?orders=totalPrice&code=${code}&price=${totalPrice}">已支付</a>

</body>
</html>
