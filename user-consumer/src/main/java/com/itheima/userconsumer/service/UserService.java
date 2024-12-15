package com.itheima.userconsumer.service;

import com.itheima.User;
import com.itheima.userconsumer.hystrix.UserServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "user-provider", fallback = UserServiceHystrix.class)
public interface UserService {

    //用户注册
    @GetMapping("/register")
    public int register(@RequestParam("uname") String uname,
                        @RequestParam("upassword") String upassword, @RequestParam("usex") String usex);

    //用户登录
    @GetMapping("/login")
    public User login(@RequestParam("uname") String uname);
}
