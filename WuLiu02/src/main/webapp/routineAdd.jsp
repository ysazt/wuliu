<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2021/9/1
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
 <form action="routineServlet?routine=addRoutine" method="post">
      路线名称：<input type="text" name="rname" /> <br/>
      起始城市：<select name="begincid">
                 <c:forEach items="${cityList}" var="city">
                     <option value="${city.cid}"> ${city.cname} </option>
                 </c:forEach>
                </select>
      终点城市：<select name="endcid">
                 <c:forEach items="${cityList}" var="city">
                     <option value="${city.cid}"> ${city.cname} </option>
                 </c:forEach>
             </select>
        价格：<input type="text" name="rprice" />
       <input type="submit" value="路线添加">
  </form>
</body>
</html>
