package com.itheima.userprovider.controller;

import com.itheima.User;
import com.itheima.userprovider.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    //用户注册
    @GetMapping("/register")
    public int register(@RequestParam("uname") String uname, @RequestParam("upassword") String upassword, @RequestParam("usex") String usex) {
        return userDao.register(uname, upassword, usex);

    }

    //用户登录
    @GetMapping("/login")
    public User login(@RequestParam("uname") String uname){
        return userDao.login(uname);
    }
}
