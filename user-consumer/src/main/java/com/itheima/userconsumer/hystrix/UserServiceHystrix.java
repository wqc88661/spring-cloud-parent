package com.itheima.userconsumer.hystrix;

import com.itheima.User;
import com.itheima.userconsumer.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceHystrix implements UserService {
    @Override
    public int register(String uname, String upassword, String usex) {
        return 0;
    }

    @Override
    public User login(String uname) {
        return null;
    }
}
