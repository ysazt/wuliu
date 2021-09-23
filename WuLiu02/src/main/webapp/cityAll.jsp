<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2021/8/31
  Time: 11:39
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
      <table border="1" width="300px">
          <tr >
              <td>省份名</td>
              <td>城市名</td>
              <td  colspan="2">操作</td>
          </tr>
          <c:forEach items="${cityList}" var="city">
          <tr>
              <td rowspan="${city.num}">${city.cproname}</td>
              <td>${city.list[0].cname}</td>
              <td><a href="cityServlet?city=delCity&cid=${city.list[0].cid}">del</a> </td>
              <td><a href="cityServlet?city=byidCity&cid=${city.list[0].cid}">update</a> </td>
          </tr>
              <c:forEach items="${city.list}" var="cityDetail" begin="1">
                  <tr>
                      <td>${cityDetail.cname}</td>
                      <td><a href="cityServlet?city=delCity&cid=${cityDetail.cid}">del</a> </td>
                      <td><a href="cityServlet?city=byidCity&cid=${cityDetail.cid}">update</a> </td>
                  </tr>
              </c:forEach>
          </c:forEach>
      </table>
</body>
</html>
