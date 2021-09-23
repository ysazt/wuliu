package com.wuliu.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wuliu.entity.CityAreaEntity;
import com.wuliu.entity.CityEntity;
import com.wuliu.entity.ProvinceEntity;
import com.wuliu.entity.UserEntity;
import com.wuliu.serivce.CityAreaService;
import com.wuliu.serivce.CityService;
import com.wuliu.serivce.ProvinceService;
import com.wuliu.serivce.UserServcie;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
         doGet(request,response);
    }

    ProvinceService provinceService = new ProvinceService();
    CityService cityService = new CityService();
    CityAreaService cityAreaService = new CityAreaService();
    UserServcie userServcie = new UserServcie();


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

       String method = request.getParameter("method");
       if(method.equals("sheng")){
           shengUser(request,response );
       }else if(method.equals("city")){
           cityUser(request,response );
       }else if(method.equals("cityarea")){
           cityareaUser(request,response );
       }else if(method.equals("add")){
           addUser(request,response );
       }else if(method.equals("login")){
           loginUser(request,response );
       }else if(method.equals("checkName")){
           checkNameUser(request,response );
       }else if(method.equals("zhuxiao")){
           zhuxiaoUser(request,response);
       }
    }

    private void zhuxiaoUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("index.jsp");
    }

    private void checkNameUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String  name =request.getParameter("uname");
        boolean res = userServcie.isCheckNameService(name);

        Map<String ,Object> map = new HashMap<>();
        map.put("result",res);

        response.setContentType("application/json;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper(); // 将map转换为json,并传递给客户端
        mapper.writeValue(response.getWriter(),map);
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 1. 是否激活
        String name = request.getParameter("uname");
        String pwd = request.getParameter("upwd");
        String juese = request.getParameter("juese");
        UserEntity userEntity = userServcie.loginUserService(name,pwd,juese);
        HttpSession session = request.getSession();
        if(userEntity!= null){
              if(userEntity.getUbeizhu()==0){
                  session.setAttribute("users",userEntity);
                  response.sendRedirect("index.jsp");

              }
        }else{
            response.sendRedirect("login.jsp");
        }
            /*if (userEntity.getUbeizhu()==0){
                System.out.println("以激活，可以登录");

            }else{
                System.out.println("未激活.......");
            }*/




    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        String usex = request.getParameter("usex");
        String uphone = request.getParameter("uphone");
        String ubirthday = request.getParameter("ubirthday");
        String province = request.getParameter("province");
        String city = request.getParameter("city");
        String area = request.getParameter("area");
        String flag = request.getParameter("flag");
        String yanzhengma = request.getParameter("yanzhengma").toLowerCase();//用户输入的
        // 系统生成的
        HttpSession session = request.getSession();
        String xitongStr = (String)session.getAttribute("CHECKCODE_SERVER");
        if(xitongStr.toLowerCase().equals(yanzhengma)){
            userServcie.userRegService(name,upwd,usex,uphone,ubirthday,province,city,area,flag);
            response.sendRedirect("index.jsp");
        }else{
            response.sendRedirect("userServlet?method=sheng");
        }


    }

    private void cityareaUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id= request.getParameter("cid");
        List<CityAreaEntity> list = cityAreaService.allCityAreaByCidService(id);
        Map<String ,Object> map = new HashMap<>();
        map.put("citylist",list);

        response.setContentType("application/json;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper(); // 将map转换为json,并传递给客户端
        mapper.writeValue(response.getWriter(),map);
    }

    private void cityUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("proid");
        List<CityEntity> list = cityService.allByProidCityService(id);
        Map<String ,List<CityEntity>> map = new HashMap<>();
        map.put("citylist",list);

        response.setContentType("application/json;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper(); // 将map转换为json,并传递给客户端
        mapper.writeValue(response.getWriter(),map);

    }

    private void shengUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProvinceEntity> list = provinceService.allProvince();
        String flag = request.getParameter("flag");
        request.setAttribute("shengList", list);
        request.setAttribute("juese",flag);
        request.getRequestDispatcher("userReg.jsp").forward(request,response);
    }
}
