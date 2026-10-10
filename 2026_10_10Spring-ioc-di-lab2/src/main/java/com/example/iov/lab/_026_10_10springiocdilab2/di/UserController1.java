package com.example.iov.lab._026_10_10springiocdilab2.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController1 {

    //todo 属性注入
    @Autowired(required = false)
    private DiUserService userService;

    public void sayHi() {
        System.out.println("1 属性注入 Controller1");
        userService.sayHi();
    }

    public void fun1() {
        System.out.println("这里没用到 userService，一切正常");
    }
    public void fun2() {
        userService.sayHi();
    }

}