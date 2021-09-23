package com.wuliu.servlet;

import com.wuliu.entity.RoutineEntity;
import com.wuliu.serivce.CityService;
import com.wuliu.serivce.RoutineService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RoutineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String method=request.getParameter("routine");
       if(method.equals("allCity")){
           allCityRoutine(request,response);
       }
       else if(method.equals("addRoutine")){
           addRoutine(request,response);
       }else if(method.equals("delRoutine")){
           delRoutine(request,response);
       }if(method.equals("byidRoutine")){
            byidRoutine(request,response);
        }if(method.equals("updateRoutine")){
            updateRoutine(request,response);
        }if(method.equals("allRoutine")){
            allRoutine(request,response);
        }
    }

    CityService cityService = new CityService();
    RoutineService routineService = new RoutineService();
    private void allCityRoutine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("cityList",cityService.allCityService());
        request.getRequestDispatcher("routineAdd.jsp").forward(request,response);
    }
    private void delRoutine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("rid");
        String flag = request.getParameter("flag");

        routineService.delRoutineService(id,flag);
        if(flag .equals("0")){
            flag ="1";
        }else{
            flag="0";
        }
        request.getRequestDispatcher("routineServlet?routine=allRoutine&flag="+flag).forward(request,response);
    }

    private void allRoutine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flag = request.getParameter("flag");
        if(flag == null){
            flag = "0";
        }
        request.setAttribute("rlist", routineService.allRoutineService(flag));
        request.setAttribute("flag1",flag);
        request.getRequestDispatcher("routineAll.jsp").forward(request,response);
    }
    private void updateRoutine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("rid");
        String rprice = request.getParameter("rprice");
        routineService.updateRoutineService(rprice,id);
        allRoutine(request,response);
    }
    private void byidRoutine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("rid");
        RoutineEntity routineEntity = routineService.byidRoutineService(id);
        request.setAttribute("routineEntity" , routineEntity);
        request.getRequestDispatcher("routineUpdate.jsp").forward(request,response);
    }

    private void addRoutine(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String rname =  request.getParameter("rname");
        String begincid =  request.getParameter("begincid");
        String endcid =  request.getParameter("endcid");
        String rprice =  request.getParameter("rprice");
       boolean rs =  routineService.addRoutineService(rname,begincid,endcid,rprice);
        // 需要判断
        if(rs){
            response.sendRedirect("index.jsp");
        }else{
            //回添加页
            allCityRoutine(request,response);
        }
    }
}
