package com.wuliu.serivce;

import com.wuliu.dao.ProvinceDao;
import com.wuliu.entity.PageEntity;
import com.wuliu.entity.ProvinceEntity;

import java.util.List;

public class ProvinceService {
     ProvinceDao provinceDao = new ProvinceDao();

    public List<ProvinceEntity> allProvince(){
        return  provinceDao.allProvinceDao();
    }


    public void addProvinceService(String name){
        provinceDao.addProviceDao(name);
    }

    public void delProvinceService(String id){
        provinceDao.delProvinceDao(Integer.parseInt(id));
    }

    public void updateProvinceService(String id, String name){
        ProvinceEntity provinceEntity = new ProvinceEntity();
        provinceEntity.setPid(Integer.parseInt(id));
        provinceEntity.setPname(name);
        provinceDao.updateProvinceDao(provinceEntity);
    }

    public ProvinceEntity byidProvinceService(String id){

        return provinceDao.byidProvinceDao(Integer.parseInt(id));
    }

    public List<ProvinceEntity> allByPageProvinceService(PageEntity pageEntity){
        return provinceDao.allProvinceByPageDao(pageEntity.getStartIndex(),pageEntity.getPageNum());
    }

    public int totalProvinceService(){
        return provinceDao.totalProvinceDao();
    }

    public ProvinceEntity bynameProvinceService(String name){

        return provinceDao.bynameProvinceDao(name);
    }
}
