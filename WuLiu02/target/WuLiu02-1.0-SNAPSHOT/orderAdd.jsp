<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2021/9/3
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
        $(function(){
            $("#province").change(function(){
                var val = $(this).val();
                $.ajax({
                    type:"post",
                    url:"orderServlet?orders=orderCity",
                    data:{proid:val},
                    success:function(res){
                        $("#city").empty();
                        $("#city").append("<option>请选择城市</option>");
                        for (var i = 0; i <res.citylist.length ; i++) {
                            $("#city").append(" <option  value='"+res.citylist[i].cid+"'>"+res.citylist[i].cname+"</option>");

                        }
                    }
                });
            });

            $("#city").change(function(){
                var val = $(this).val();
                $.ajax({
                    type:"post",
                    url:"userServlet?method=cityarea",
                    data:{cid:val},
                    success:function(res){
                        $("#cityarea").empty();
                        $("#cityarea").append("<option>请选择城市区域</option>");
                        for (var i = 0; i <res.citylist.length ; i++) {
                            $("#cityarea").append(" <option  value='"+res.citylist[i].aname+"'>"+res.citylist[i].aname+"</option>");

                        }
                    }
                });
            });

          })
    </script>
</head>
<body>
  下单操作：
   <form action="orderServlet?orders=addOrder" method="post">
       货物名称:<select name="ordername">
                   <option value="文件">文件</option>
                   <option value="易碎品">易碎品</option>
                   <option value="普通物品">普通物品</option>
                </select>
               <br/>
       货物重量:<input type="text" name="orderWeight">   <br/>
       收货地址: 选择邮寄到的省份<select id="province" name="province">
                                   <option>请选择省份</option>
                                   <c:forEach items="${proList}" var="pro">
                                       <option value="${pro.pid}">${pro.pname}</option>
                                   </c:forEach>
                               </select>
                 选择邮寄到的城市<select  id="city" name="city"></select>
                 选择邮寄到的城市区域<select  name="cityarea" id="cityarea"></select>
       <br/>
       收货人:<input type="text" name="orderShouName" /> <br/>
       收货电话:<input type="text" name="orderShouPhone" /> <br/>
      <%-- 备注:<input type="text" name="beizhu" />--%>

      <input type="submit" value="下单">

   </form>
</body>
</html>
