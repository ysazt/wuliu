<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2021/8/30
  Time: 14:48
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
<table border="1">
    <tr>
        <td>id</td>
        <td>省份名</td>
        <td colspan="2">操作</td>
    </tr>
    <c:forEach items="${listPro}" var="province">
        <tr>
            <td>${province.pid}</td>
            <td>${province.pname}</td>
            <td ><a href="provinceServlet?province=delProvince&pid=${province.pid}">删除</a></td>
            <td ><a href="provinceServlet?province=byidProvince&pid=${province.pid}">修改</a></td>
        </tr>
    </c:forEach>

    <tr>
         <td><a href="provinceServlet?province=allPageProvince&currentPage=1">首页</a> </td>
         <td><a href="provinceServlet?province=allPageProvince&currentPage=${pageEnity.currentPage-1}" onclick="return ${pageEnity.currentPage==1?false:true} ">上一页</a> </td>
         <td>
             <%--前三个数--%>
             <c:if test="${pageEnity.currentPage<=3}">
                 <c:forEach  var="pages" begin="1" end="5">
                     <a href="provinceServlet?province=allPageProvince&currentPage=${pages}"> ${pages}</a>
                 </c:forEach>
             </c:if>
             <%--第四个数开始  当前页从第四页开始， 且当前页不是最后一页--%>
             <c:if test="${pageEnity.currentPage>3&&pageEnity.currentPage!=pageEnity.totalPage}">
                 <%--当前页+2 >最后一页--%>
                 <c:if test="${(pageEnity.currentPage+2)>pageEnity.totalPage}">
                     <c:forEach  var="pages" begin="${pageEnity.currentPage-3}" end="${pageEnity.totalPage}">
                         <a href="provinceServlet?province=allPageProvince&currentPage=${pages}"> ${pages}</a>
                     </c:forEach>
                 </c:if>
                 <c:if test="${(pageEnity.currentPage+2)==pageEnity.totalPage}">
                     <c:forEach  var="pages" begin="${pageEnity.totalPage-4}" end="${pageEnity.totalPage}">
                         <a href="provinceServlet?province=allPageProvince&currentPage=${pages}"> ${pages}</a>
                     </c:forEach>
                 </c:if>
                 <c:if test="${(pageEnity.currentPage+2)<pageEnity.totalPage}">
                     <c:forEach  var="pages" begin="${pageEnity.currentPage-2}" end="${pageEnity.currentPage+2}">
                         <a href="provinceServlet?province=allPageProvince&currentPage=${pages}"> ${pages}</a>
                     </c:forEach>
                 </c:if>
             </c:if>
                 <%--处理最后一页  ， 当前页是最后一页--%>
             <c:if test="${pageEnity.currentPage==pageEnity.totalPage}">
                 <c:forEach  var="pages" begin="${pageEnity.totalPage-4}" end="${pageEnity.totalPage}">
                     <a href="provinceServlet?province=allPageProvince&currentPage=${pages}"> ${pages}</a>
                 </c:forEach>
             </c:if>
         </td>
        <td>
            <%--<c:forEach  var="pages" begin="1" end="${pageEnity.totalPage}"></c:forEach>--%>
            <%--小于5 ， 1234  123  12   1  0--%>
              <c:if test="${pageEnity.totalPage <5}">
                  <a href="provinceServlet?province=allPageProvince&currentPage=${pageEnity.currentPage}"> 1</a>
                  <a href="provinceServlet?province=allPageProvince&currentPage=${pageEnity.currentPage+1}"> 2</a>
                  <a href="provinceServlet?province=allPageProvince&currentPage=${pageEnity.totalPage-1}"> ${pageEnity.totalPage-1}</a>
                  <a href="provinceServlet?province=allPageProvince&currentPage=${pageEnity.totalPage}"> ${pageEnity.totalPage}</a>
              </c:if>

                <%--总页数大于等于5页--%>
              <c:if test="${pageEnity.totalPage >= 5}">
                  <%--当前页+4 > 总页数--%>
                  <c:if test="${(pageEnity.currentPage+4)> pageEnity.totalPage}">
                      <%-- 当前页是第三页，  当前页+4 = 总页数+1  结果  当前页前一页  当前页    当前页后一页 ， 末尾的--%>
                      <c:if test="${(pageEnity.currentPage+4)== (pageEnity.totalPage+1)}">
                          <a href="provinceServlet?province=allPageProvince&currentPage=${pageEnity.currentPage-1}"> ${pageEnity.currentPage-1}</a>
                          <a href="provinceServlet?province=allPageProvince&currentPage=${pageEnity.currentPage}"> ${pageEnity.currentPage}</a>
                          <a href="provinceServlet?province=allPageProvince&currentPage=${pageEnity.currentPage+1}"> ${pageEnity.currentPage+1}</a>
                          <a href="provinceServlet?province=allPageProvince&currentPage=${pageEnity.totalPage-1}"> ${pageEnity.totalPage-1}</a>
                          <a href="provinceServlet?province=allPageProvince&currentPage=${pageEnity.totalPage}"> ${pageEnity.totalPage}</a>
                      </c:if>
                      <%--第4页， 第5页 ，第六页--%>
                      <c:if test="${(pageEnity.currentPage+4)!= (pageEnity.totalPage+1)}">
                          <a href="provinceServlet?province=allPageProvince&currentPage=${pageEnity.totalPage-3}"> ${pageEnity.totalPage-3}</a>
                          <a href="provinceServlet?province=allPageProvince&currentPage=${pageEnity.totalPage-2}"> ${pageEnity.totalPage-2}</a>
                          <a href="provinceServlet?province=allPageProvince&currentPage=${pageEnity.totalPage-1}"> ${pageEnity.totalPage-1}</a>
                          <a href="provinceServlet?province=allPageProvince&currentPage=${pageEnity.totalPage}"> ${pageEnity.totalPage}</a>
                      </c:if>

                  </c:if>
                  <%-- 第二页 --%>
                  <c:if test="${(pageEnity.currentPage+4)== pageEnity.totalPage}">
                      <a href="provinceServlet?province=allPageProvince&currentPage=${pageEnity.currentPage-1}"> ${pageEnity.currentPage-1}</a>
                      <a href="provinceServlet?province=allPageProvince&currentPage=${pageEnity.currentPage}"> ${pageEnity.currentPage}</a>
                      <a href="provinceServlet?province=allPageProvince&currentPage=${pageEnity.currentPage+1}"> ${pageEnity.currentPage+1}</a>
                      <c:if test="${(pageEnity.currentPage+1)!=(pageEnity.totalPage-1) }">
                          ....
                      </c:if>
                      <a href="provinceServlet?province=allPageProvince&currentPage=${pageEnity.totalPage-1}"> ${pageEnity.totalPage-1}</a>
                      <a href="provinceServlet?province=allPageProvince&currentPage=${pageEnity.totalPage}"> ${pageEnity.totalPage}</a>
                  </c:if>
                   <%--第2页之前--%>
                  <c:if test="${(pageEnity.currentPage+4)< pageEnity.totalPage}">
                      <a href="provinceServlet?province=allPageProvince&currentPage=${pageEnity.currentPage}"> ${pageEnity.currentPage}</a>
                      <a href="provinceServlet?province=allPageProvince&currentPage=${pageEnity.currentPage+1}"> ${pageEnity.currentPage+1}</a>
                      <c:if test="${(pageEnity.currentPage+1)!=(pageEnity.totalPage-1) }">
                          ....
                      </c:if>
                      <a href="provinceServlet?province=allPageProvince&currentPage=${pageEnity.totalPage-1}"> ${pageEnity.totalPage-1}</a>
                      <a href="provinceServlet?province=allPageProvince&currentPage=${pageEnity.totalPage}"> ${pageEnity.totalPage}</a>
                  </c:if>
                </c:if>
        </td>
         <td><a href="provinceServlet?province=allPageProvince&currentPage=${pageEnity.currentPage+1}" onclick="return ${pageEnity.currentPage==pageEnity.totalPage?false:true} ">下一页</a> </td>
         <td><a href="provinceServlet?province=allPageProvince&currentPage=${pageEnity.totalPage}">尾页</a> </td>
          <td>
              <form action="provinceServlet?province=allPageProvince" method="post">
                  <input type="text" name="currentPage"/>
                  <input type="submit" value="跳转">
              </form>
          </td>
    </tr>
</table>
</body>
</html>
