package com.wuliu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {

    public String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  sdf.format(new Date());
    }
}
