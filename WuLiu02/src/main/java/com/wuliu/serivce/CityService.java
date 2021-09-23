package com.wuliu.serivce;

import com.wuliu.dao.CityDao;
import com.wuliu.entity.CityCenterEnity;
import com.wuliu.entity.CityEntity;
import com.wuliu.entity.ProvinceEntity;
import com.wuliu.entity.RoutineEntity;

import java.util.*;

public class CityService {
    CityDao cityDao = new CityDao();

    public List<CityEntity> allByProidCityService(String id){
        return cityDao.allCityByProidDao(Integer.parseInt(id));
    }

    public void addCityService(String cname, String proid) {
        CityEntity city = new CityEntity();
        city.setCname(cname);
        ProvinceEntity pro = new ProvinceEntity(Integer.parseInt(proid),"");
        city.setCproid(pro);
        cityDao.addCityDao(city);
    }

    public void delCityService(String id){
        cityDao.delCityDao(Integer.parseInt(id));
    }

    public void updateCityService(String id ,String name ){
        cityDao.updateCityDao(Integer.parseInt(id) ,name);
    }

    public CityEntity byidCityService(String id){
        return cityDao.byidCityDao(Integer.parseInt(id));
    }

    public List<CityEntity> allCityService(){
        return cityDao.allCityDao();
    }

    public List<CityCenterEnity> allCityService2(){
        List<CityEntity> list = cityDao.allCityDao3();
        // 将获取到的所有城市分类， 先统计总数，然后将相同存到CityCenterEntity
        /*Set<String> setName = new HashSet<>();
        //得到了所有省份名字
        for (int i = 0; i <list.size() ; i++) {
             String name = list.get(i).getCproid().getPname();
             setName.add(name);
        }
        List<Integer> setNum = new ArrayList<>();
        // 获取省份出现了几次
        for (String item :setName  ) {
            int num = 0 ;
            for (int i = 0; i <list.size() ; i++) {
                if(item.equals(list.get(i).getCproid().getPname())){
                    num ++;
                }
            }
            setNum.add(num);
        }*/
        Map<String,Integer> map = new HashMap<>();
        List<CityCenterEnity> listCenter = new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {

            String name = list.get(i).getCproid().getPname();

           // int num = map.keySet().size();
            if (!map.containsKey(name)){
                map.put(name,1);
                System.out.println("name..第一次."+name);
            }else{
                int totalNum = map.get(name);
                totalNum++;
                map.put(name,totalNum);
                System.out.println("name..."+name+"....."+totalNum);
            }
        }
        for (String item :map.keySet()) {
            CityCenterEnity cityCenterEnity = new CityCenterEnity();
            cityCenterEnity.setCproname(item);
            cityCenterEnity.setNum(map.get(item));
            List<CityEntity> listCity = new ArrayList<>();
            for (CityEntity cityItem : list) {
                 if(item.equals(cityItem.getCproid().getPname())){
                    listCity.add(cityItem);
                 }
            }
            cityCenterEnity.setList(listCity);
            listCenter.add(cityCenterEnity);
        }

      /*  for (CityCenterEnity center: listCenter  ) {
            System.out.println("省份："+center.getCproname()+",共计"+center.getNum()+",具体入下：");
            List<CityEntity> centerListCity =center.getList();
            for (CityEntity city:  centerListCity) {
                System.out.print(city.getCname());
            }

            System.out.println();
            System.out.println("---------------------------------");
        }*/
        return listCenter ;
    }

    public int byCnameAndProidCityService(String name ,int cproid){
        return cityDao.bynameAndPidCityDao(cproid,name);
    }

    public static void main(String[] args) {
     }
}
