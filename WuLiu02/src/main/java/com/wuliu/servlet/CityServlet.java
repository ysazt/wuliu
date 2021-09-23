package com.wuliu.servlet;

import com.wuliu.entity.CityEntity;
import com.wuliu.entity.ProvinceEntity;
import com.wuliu.serivce.CityService;
import com.wuliu.serivce.ProvinceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    ProvinceService provinceService = new ProvinceService();
    CityService cityService = new CityService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         String method = request.getParameter("city");
         if(method.equals("sheng")){
             shengCity(request,response);
         }else if(method.equals("addCity")){
             addCity(request,response);
         }
         else if(method.equals("allCity")){
             allCity(request,response);
         }
         else if(method.equals("delCity")){
             delCity(request,response);
         }else if(method.equals("byidCity")){
             byidCity(request,response);
         }else if(method.equals("updateCity")){
             updateCity(request,response);
         }

    }

    private void updateCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("cid");
        String name = request.getParameter("cname");
        cityService.updateCityService(id,name);

        allCity(request,response);
    }
    private void byidCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("cid");
        //request.setAttribute("cityEntity",cityService.byidCityService(id));
        CityEntity city =  cityService.byidCityService(id);
        request.setAttribute("cityEntity",city);
        request.getRequestDispatcher("cityUpdate.jsp").forward(request,response);
    }
    private void delCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("cid");
        cityService.delCityService(id);

        allCity(request,response);
    }
    private void allCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("cityList",cityService.allCityService2());
        request.getRequestDispatcher("cityAll.jsp").forward(request,response);
    }

    private void addCity(HttpServletRequest request, HttpServletResponse response) throws IOException {
          String cname = request.getParameter("cname");
          String proid = request.getParameter("proid");
          cityService.addCityService(cname,proid);
          response.sendRedirect("index.jsp");
    }

    private void shengCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProvinceEntity> list = provinceService.allProvince();
        request.setAttribute("proList",list);
        request.getRequestDispatcher("cityAdd.jsp").forward(request,response);


    }
}
