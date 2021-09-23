package com.wuliu.servlet;

import com.wuliu.entity.PageEntity;
import com.wuliu.entity.ProvinceEntity;
import com.wuliu.serivce.ProvinceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


         String method= request.getParameter("province");
         if(method.equals("addProvince")){
            addProvinceServlet(request,response);
         }else if(method.equals("delProvince")){
             delProvinceServlet(request,response);
         }else if(method.equals("byidProvince")){
             byidProvinceServlet(request,response);
         }else if(method.equals("updateProvince")){
             updateProvinceServlet(request,response);
         }else if(method.equals("allProvince")){
             allProvinceServlet(request,response);
         }else if(method.equals("allPageProvince")){
             allPageProvince(request,response);
         }
    }

    private void allPageProvince(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        if(currentPage == null){
            currentPage = "1";
        }
        PageEntity pageEntity = new PageEntity();
        pageEntity.setCurrentPage(Integer.parseInt(currentPage));
        pageEntity.setTotalNum(provinceService.totalProvinceService());

        List<ProvinceEntity> list = provinceService.allByPageProvinceService(pageEntity);
        request.setAttribute("listPro",list);
        /*request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPage",pageEntity.getTotalPage());*/
        request.setAttribute("pageEnity" , pageEntity);
        request.getRequestDispatcher("provinceAll.jsp").forward(request,response);
    }

    ProvinceService provinceService = new ProvinceService();

    private void allProvinceServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       List<ProvinceEntity> list = provinceService.allProvince();
       request.setAttribute("listPro" ,list);
       request.getRequestDispatcher("provinceAll.jsp").forward(request,response);
    }
    private void updateProvinceServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String id = request.getParameter("pid");
       String name= request.getParameter("pname");
       provinceService.updateProvinceService(id,name);
       allProvinceServlet(request,response);
    }

    private void byidProvinceServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  id = request.getParameter("pid");
        ProvinceEntity provinceEntity = provinceService.byidProvinceService(id);
        request.setAttribute("pro",provinceEntity);
        request.getRequestDispatcher("provinceUpate.jsp").forward(request,response);
    }

    private void delProvinceServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String  id = request.getParameter("pid");
          provinceService.delProvinceService(id);
          allProvinceServlet(request,response);
    }

    private void addProvinceServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("pname");
        provinceService.addProvinceService(name);
        allProvinceServlet(request,response);
    }
}
