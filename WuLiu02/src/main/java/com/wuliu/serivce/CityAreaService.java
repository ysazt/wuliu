package com.wuliu.serivce;

import com.wuliu.dao.CityAreaDao;
import com.wuliu.entity.CityAreaEntity;

import java.util.List;

public class CityAreaService {

    CityAreaDao cityAreaDao = new CityAreaDao();

    public List<CityAreaEntity> allCityAreaByCidService(String id){
        return cityAreaDao.allByCidDao(Integer.parseInt(id));
    }
}
