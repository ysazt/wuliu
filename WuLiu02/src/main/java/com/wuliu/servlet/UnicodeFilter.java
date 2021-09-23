package com.wuliu.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UnicodeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("执行过滤器....");
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse) resp ;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
       /* HttpSession session = request.getSession();
        if(session.getAttribute("users")==null){
            chain.doFilter(request, response);//放行
            response.sendRedirect("login.jsp");
            System.out.println("没有登录");

        }else{
            //request,response tomcat 给的，
            chain.doFilter(request, response);//放行
            System.out.println("放行");
        }*/
        chain.doFilter(request, response);//放行
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
