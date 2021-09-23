package com.wuliu.serivce;

import com.wuliu.dao.RoutineDao;
import com.wuliu.entity.CityEntity;
import com.wuliu.entity.RoutineEntity;

import java.util.List;

public class RoutineService {
    RoutineDao routineDao = new RoutineDao();

    public boolean addRoutineService(String rname ,String beginid, String endid, String price){
        RoutineEntity routineEntity = new RoutineEntity();
        routineEntity.setRname(rname);
        int bid = Integer.parseInt(beginid) ;
        int cid = Integer.parseInt(endid) ;
        routineEntity.setRbegincid(new CityEntity(bid));// 手动给这个类增加传入id 构造
       // routineEntity.setRbegincid(new CityEntity(Integer.parseInt(beginid),"",null));
        routineEntity.setRendcid(new CityEntity(cid));
        routineEntity.setRprice(Double.parseDouble(price));
        routineEntity.setRbeizhu(0);
        // 先判断起始+终点是否已经存在，若存在不能添加
        boolean res = routineDao.isCheckBeginAndEnd(bid,cid);
        if(res){
            return false ;
        }else{
            routineDao.addRoutineDao(routineEntity);
            return true ; // 添加成功
        }

    }

    public void delRoutineService(String id,String flag){
        routineDao.delRoutineDao(Integer.parseInt(id),Integer.parseInt(flag));
    }

    public void updateRoutineService(String price ,String id){
        routineDao.updateRoutineDao(Double.parseDouble(price),Integer.parseInt(id));
    }

    public RoutineEntity  byidRoutineService(String id){
        return routineDao.byidRoutineDao(Integer.parseInt(id));
    }

    public List<RoutineEntity>  allRoutineService(String flag){
        return routineDao.allRoutineDao(Integer.parseInt(flag));
    }

    public List<RoutineEntity>  allbyCbeginidRoutineService(int cbeginid){
        return routineDao.allbyCbeginidRoutineDao(cbeginid);
    }

}
