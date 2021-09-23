package com.wuliu.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wuliu.entity.CityEntity;
import com.wuliu.entity.ProvinceEntity;
import com.wuliu.entity.RoutineEntity;
import com.wuliu.entity.UserEntity;
import com.wuliu.serivce.CityService;
import com.wuliu.serivce.OrderService;
import com.wuliu.serivce.ProvinceService;
import com.wuliu.serivce.RoutineService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class OrderServlet extends HttpServlet {

    ProvinceService provinceService = new ProvinceService();
    CityService cityService = new CityService();
    RoutineService routineService = new RoutineService();
    OrderService orderService = new OrderService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("orders");
        if(method.equals("orderSheng")){
            orderSheng(request,response);
        }else if(method.equals("orderCity")){
            orderCity(request,response);
        }else if(method.equals("addOrder")){
            addOrder(request,response);
        }else if(method.equals("totalPrice")){
            totalPrice(request,response);
        }
    }

    private void totalPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String price = request.getParameter("price");
        //修改操作
        orderService.updateOrderService(price,"1",code);
        request.setAttribute("message","下单成功");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private void addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserEntity userEntity = (UserEntity)session.getAttribute("users");

        String ordername = request.getParameter("ordername");
        String orderWeight = request.getParameter("orderWeight");
        String provinceid = request.getParameter("province");// id
        String cityid = request.getParameter("city"); //id
        String cityareaName = request.getParameter("cityarea"); //名字
        String orderShouName = request.getParameter("orderShouName");
        String orderShouPhone = request.getParameter("orderShouPhone");
        /*String beizhu = request.getParameter("beizhu");
        if (beizhu == null){
            beizhu="无" ;
        }*/
        String beizhu = UUID.randomUUID().toString().replace("-","");
        double totalPrice = orderService.addOrderService(ordername,orderWeight,userEntity,provinceid,cityid,cityareaName,orderShouName,orderShouPhone,beizhu);
        request.setAttribute("totalPrice",totalPrice);
        request.setAttribute("code",beizhu);
        request.getRequestDispatcher("orderOk.jsp").forward(request,response);

    }

    // 以前， 只要选择了省份，就把省份下面的所有城市返回
    // 是否可以邮寄， 需要根据发货地和终点在我的系统路线表中是否存在， 存在才可以发货
    private void orderCity(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String proid = request.getParameter("proid");//用户选择终点省的id

        //先得到发货地，--》 session中  得到用户登录的信息， 获取用户的所在城市的id
        HttpSession session = request.getSession();
        UserEntity userEntity = (UserEntity)session.getAttribute("users");
        String ucity = userEntity.getUcity(); // 省份 城市
        String fahuoSheng = ucity.split(" ")[0];
        String fahuoCity = ucity.split(" ")[1];  // 城市是名字
        // 根据省份名，返回省份的id    接着带着 省份的id  和city的名字获取city 的id
        ProvinceEntity provinceEntity = provinceService.bynameProvinceService(fahuoSheng);
        int cid = cityService.byCnameAndProidCityService(fahuoCity,provinceEntity.getPid());


        //获取发货地存在的所有路线     根据用户的所在城市的id(上一步)， 得到该城市作为起始点的所有路线
        List<RoutineEntity> list = routineService.allbyCbeginidRoutineService(cid) ;

        //终点的省对应的终点城市 ，
        // 正常的是选择了省份，直接输出所有的城市，
        // 现在是需要根据选择省份，看看是否有满足的城市
        // 根据省份返回所有城市     遍历这个循环，和路线中的id匹配，有一致就存起来，最终返回有一致的所有城市
        List<CityEntity>  listAllCity = cityService.allByProidCityService(proid);  // 根据用户选择的省份，得到该省份下的所有城市
        List<CityEntity> listLastCity = new ArrayList<>();
        //  带着路线中的终点城市id 和  选择的省份下的所有城市的id 比较是否一致， 若一致，表示该城市可以作为终点城市选择， 添加到listLastCity中
        for (RoutineEntity routinue: list ) {
             for (CityEntity items: listAllCity ) {
                System.out.println(items.getCid()+".....添加到集合。。。。"+routinue.getRendcid().getCid()+"...."+((items.getCid())== (routinue.getRendcid().getCid())));
                if((items.getCid())== (routinue.getRendcid().getCid())){
                    listLastCity.add(items);
                    System.out.println(items.getCid()+".....添加到集合。。。。"+routinue.getRendcid().getCid());
                    break ;
                }
            }
        }

        // 回传数据以json 响应给页面
        Map<String ,List<CityEntity>> map = new HashMap<>();
        map.put("citylist",listLastCity);
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper(); // 将map转换为json,并传递给客户端
        mapper.writeValue(response.getWriter(),map);



    }


    private void orderSheng(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserEntity userEntity = (UserEntity)session.getAttribute("users");
        if(userEntity == null){
            response.sendRedirect("login.jsp");
        }else{
            request.setAttribute("proList", provinceService.allProvince());
            request.getRequestDispatcher("orderAdd.jsp").forward(request,response);
        }
    }
}
