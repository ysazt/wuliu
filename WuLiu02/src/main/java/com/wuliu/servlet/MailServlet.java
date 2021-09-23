package com.wuliu.servlet;

import com.wuliu.serivce.UserServcie;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    UserServcie userServcie = new UserServcie();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String code = request.getParameter("code");
         if(code!=null){
             //点击了， 修改用户的备注状态为0 ，可以使用
            //调用service ,  1. 根据id 修改操作
             userServcie.updateUserBeizhuService1(code);// 以前获取的id , 现在获取到的是uuid
             response.sendRedirect("login.jsp");
         }else{
             request.setAttribute("msg","请去邮箱激活");
             response.sendRedirect("jihuo.jsp");
         }
    }
}
