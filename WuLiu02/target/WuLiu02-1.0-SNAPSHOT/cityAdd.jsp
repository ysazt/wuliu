<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2021/8/31
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
     <form action="cityServlet?city=addCity" method="post">
      输入城市名<input type="text" name="cname"/>
         选择省份<select name="proid">
                 <c:forEach items="${proList}" var="pro">
                     <option value="${pro.pid}"> ${pro.pname}  </option>
                 </c:forEach>
          <input type="submit" value="城市添加">
     </select>

     </form>

</body>
</html>
