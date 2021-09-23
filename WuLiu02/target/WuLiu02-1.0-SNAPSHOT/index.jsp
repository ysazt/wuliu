<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World!</h2>


<c:if test="${users==null}">
    <a href="userServlet?method=sheng&flag=1">消费者注册</a>
    <a href="login.jsp">登录</a>
</c:if>

<c:if test="${users.uflag==1}">
    <a href="userServlet?method=zhuxiao">注销登录</a>
    消费者登录

    <a href="orderServlet?orders=orderSheng">下单操作</a>
    恭喜您下单成功...${message}
</c:if>

<c:if test="${users.uflag==0}">
    欢迎管理员的登录
    <a href="userServlet?method=sheng&flag=0">添加子管理员</a>
    <a href="provinceAdd.jsp">省份添加</a>
    <a href="provinceServlet?province=allProvince">省份列表</a>
    <a href="provinceServlet?province=allPageProvince">省份分页列表</a>
    <a href="cityServlet?city=sheng">城市添加</a>
    <a href="cityServlet?city=allCity">城市查看</a>
    <a href="routineServlet?routine=allCity">路线添加</a>
    <a href="routineServlet?routine=allRoutine&flag=0">查看可用路线</a>
    <a href="routineServlet?routine=allRoutine&flag=1">查看废弃路线</a>
</c:if>

</body>
</html>
