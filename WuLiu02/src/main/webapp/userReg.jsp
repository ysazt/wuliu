<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2021/8/27
  Time: 10:32
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
                    url:"userServlet?method=city",
                    data:{proid:val},
                    success:function(res){
                        $("#city").empty();
                        $("#city").append("<option>请选择城市</option>")
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
                        $("#cityarea").append("<option>请选择城市区域</option>")
                        for (var i = 0; i <res.citylist.length ; i++) {
                            $("#cityarea").append(" <option  value='"+res.citylist[i].aname+"'>"+res.citylist[i].aname+"</option>");

                        }
                    }
                });
            });


        })

        function ischeckName(val){
            alert("val.."+val);
             $.ajax({
                type:"post",
                url:"userServlet?method=checkName",
                data:{uname:val},
                success:function(res){
                   if(res.result){
                       $("#uname").append("<span>可以使用</span>");

                   }else{
                       $("#uname").append("<span>不可以使用</span>");
                   }
                }
            });
        }
    </script>
</head>
<body>
<form action="userServlet?method=add" method="post">
    <c:if test="${juese==0}">
        管理员注册
    </c:if>
    <c:if test="${juese==1}">
        消费者注册
    </c:if>
    用户名<input type="text" name="uname" onblur="ischeckName(this.value)" /> <div id="uname">  </div><br/>
    密码<input type="text" name="upwd"/> <br/>
    性别<input type="radio" name="usex" value="男"/>男
        <input type="radio" name="usex" value="女"/>女<br/>
    联系电话<input type="text" name="uphone"/> <br/>
    出生日期<input type="text" name="ubirthday"/> <br/>
           <input type="hidden" name="flag" value="${juese}">
    选择省份：<select id="province" name="province">
                   <option>请选择省份</option>
                   <c:forEach items="${shengList}" var="sheng">
                       <option value="${sheng.pid}">${sheng.pname}</option>
                   </c:forEach>
             </select>
    请选择城市<select id="city"  name="city">
             <option>请选择城市</option>
              </select>
    请选择城市区域<select id="cityarea" name="area">

                 <option>请选择城市区域</option>
                 </select>
<br/>

    请输入验证码：<input type="text" name="yanzhengma"/>
         <img src="checkCodeServlet">

       <input type="submit" value="注册">

</form>
</body>
</html>
