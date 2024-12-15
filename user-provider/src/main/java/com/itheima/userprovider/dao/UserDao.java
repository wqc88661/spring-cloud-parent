package com.itheima.userprovider.dao;


import com.itheima.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    //用户注册
    int register(@Param("uname") String uname, @Param("upassword")String upassword, @Param("usex")String usex);

    //用户登录
    User login(@Param("uname") String uname);

}
