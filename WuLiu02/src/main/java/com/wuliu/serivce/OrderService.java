package com.wuliu.serivce;

import com.wuliu.dao.*;
import com.wuliu.entity.OrderEntity;
import com.wuliu.entity.ProvinceEntity;
import com.wuliu.entity.UserEntity;
import com.wuliu.utils.Tools;

public class OrderService {
    OrderDao orderDao = new OrderDao();
    CityDao cityDao = new CityDao();
    RoutineDao routineDao = new RoutineDao();
    UserDao userDao  = new UserDao();
    PeifanDao peifanDao = new PeifanDao();

    public double addOrderService(String ordername, String orderWeight, UserEntity userEntity, String provinceid, String cityid, String cityareaName, String orderShouName, String orderShouPhone, String beizhu) {
        double weight = Double.parseDouble(orderWeight);
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setDname(ordername);
        orderEntity.setDweight(weight);

        orderEntity.setDbname(userEntity.getUname());
        orderEntity.setDbaddr(userEntity.getUcity()+" "+userEntity.getUaddress());
        orderEntity.setDbphone(userEntity.getUphone());

        orderEntity.setDrname(orderShouName);
        String str = cityDao.bycidAndpidCityDao(Integer.parseInt(cityid),Integer.parseInt(provinceid));
        orderEntity.setDraddr(str +" " +cityareaName);
        orderEntity.setDrphone(orderShouPhone);

        orderEntity.setDtime(new Tools().getTime() );
        orderEntity.setDprice(0);
        orderEntity.setDflag(0);
        orderEntity.setDbeizhu(beizhu);
        orderDao.addOrder(orderEntity);

        //计算总价= 运输价格+ 配送价格
        // 运输价格 = 起始城市+终点城市
        // 配送价格 = 终点城市
        String ucity = userEntity.getUcity();
        System.out.println(ucity);
        String fahuoSheng = ucity.split(" ")[0];
        String fahuoCity = ucity.split(" ")[1];  // 城市是名字
        int cbeginid = cityDao.byNameUser(fahuoCity);// 根据当前登录者所在的城市名查询返回对应的城市id
        int cendid = Integer.parseInt(cityid) ;
        System.out.println(cbeginid+".........."+cendid);
        double yunshuPrice = routineDao.byCbeginidAndCendidRoutineDao(cbeginid,cendid);
        System.out.println(weight+"...yunshu...."+yunshuPrice);
        yunshuPrice = yunshuPrice+ yunshuPrice*(weight-2 );
        //根据终点城市id 去配送范围表查询
        double peiPrice = peifanDao.byfcidPeifanDao(cendid);

        return yunshuPrice+peiPrice;
    }

    public static void main(String[] args) {
       /* int cbeginid = new UserDao().byNameUser("济南");// 根据当前登录者所在的城市名查询返回对应的城市id
        System.out.println(cbeginid);*/
    }

    public void updateOrderService(String price , String flag ,String code){
        orderDao.updateOrder(Double.parseDouble(price),Integer.parseInt(flag),code);
    }
}
