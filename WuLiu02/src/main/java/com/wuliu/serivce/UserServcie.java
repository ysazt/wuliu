package com.wuliu.serivce;

import com.wuliu.dao.CityAreaDao;
import com.wuliu.dao.CityDao;
import com.wuliu.dao.ProvinceDao;
import com.wuliu.dao.UserDao;
import com.wuliu.entity.CityAreaEntity;
import com.wuliu.entity.CityEntity;
import com.wuliu.entity.ProvinceEntity;
import com.wuliu.entity.UserEntity;
import com.wuliu.utils.MailUtils;
import com.wuliu.utils.Tools;

import java.util.UUID;

public class UserServcie {

    UserDao userDao = new UserDao();
    CityAreaDao cityAreaDao = new CityAreaDao();
    CityDao cityDao = new CityDao();
    ProvinceDao provinceDao = new ProvinceDao();


    public void userRegService(String name, String upwd, String usex, String uphone, String ubirthday, String province, String city, String area,String flag){
        UserEntity userEntity = new UserEntity();
        userEntity.setUname(name);
        userEntity.setUpwd(upwd);
        userEntity.setUsex(usex);
        userEntity.setUphone(uphone);
        userEntity.setUaddress(area);
        userEntity.setUbeizhu(1);
        userEntity.setUbirthday(ubirthday);
        CityEntity cityEntity = cityDao.byidCityDao(Integer.parseInt(city));
        ProvinceEntity provinceEntity = provinceDao.byidProvinceDao(Integer.parseInt(province));
        userEntity.setUcity(provinceEntity.getPname()+" "+cityEntity.getCname());
        userEntity.setUflag(Integer.parseInt(flag));
        userEntity.setUtime(new Tools().getTime());
        UUID uid = UUID.randomUUID();//唯一标识一条数据，
        String str = uid.toString().replace("-" ,"");
         userEntity.setUcode(str);
        userDao.addUserDao(userEntity);

      //  int id = userDao.lastUserId();//唯一, 只支持单线程，

        //发送激活链接   code 传谁？ 一种添加操作结束后返回当前添加的id ;
        //String content="<a href='http://localhost:8080/WuLiu02_war_exploded/mailServlet?code="+id+"'>点击激活</a>";
        String content="<a href='http://localhost:8080/WuLiu02_war_exploded/mailServlet?code="+str+"'>点击激活</a>";
        MailUtils.sendMail("ting.zhang@ambow.com",content,"激活邮件");

    }

    public static void main(String[] args) {
        UUID uid = UUID.randomUUID();
        System.out.println(uid.toString().replace("-" ,""));
    }

    //// 以前获取的id
    public void updateUserBeizhuService(String code) {
        userDao.updateUserDao(Integer.parseInt(code));
    }

    //现在获取到的是uuid
    public void updateUserBeizhuService1(String code){
        //1. 根据uuid ，找到对象
        //2. 有了对象，就要对象中id , 根据id 修改
        int cid = userDao.byCodeUser(code);
        userDao.updateUserDao(cid);

    }

    public UserEntity  loginUserService(String name ,String pwd, String juese){
        UserEntity userEntity = userDao.loginUserDao2(name,pwd,Integer.parseInt(juese));

        return userEntity;
    }

    public  boolean isCheckNameService(String name){
        return userDao.isCheckName(name);
    }
}
