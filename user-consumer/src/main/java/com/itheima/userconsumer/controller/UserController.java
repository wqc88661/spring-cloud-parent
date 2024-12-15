package com.itheima.userconsumer.controller;

import com.itheima.userconsumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    UserService userService;

    //完成用户注册页面的跳转

    @GetMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    //用户注册的接口
    @GetMapping("/register")
    public String register(String uname, String upassword, String usex) {
        if (userService.register(uname, upassword, usex) > 0) {
            System.out.println("用户注册成功");
            return "login";
        }
        System.out.println("用户注册失败");
        return "register";
    }

    //完成用户登录页面的跳转
    @GetMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    //用户登录的接口
    @GetMapping("/login")
    public String login(String uname, String upassword, HttpServletRequest request) {
        if (userService.login(uname) != null) {
            if (userService.login(uname).getUpassword().equals(upassword)) {
                HttpSession session = request.getSession(true);
                session.setAttribute("user", userService.login(uname));
                System.out.println("登录成功");
                return "redirect:http://localhost:8896/goods/getAllGoods?uaccount=" + userService.login(uname).getUaccount();
            }
        }
        System.out.println("用户登录失败");
        return "login";

    }

}
