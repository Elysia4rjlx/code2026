package com.example.iov.lab._026_10_10springiocdilab2.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController3 {
    private DiUserService userService;

    //todo Setter 注入

    @Autowired
    //Spring 靠 @Autowired 注解才知道「这个 setter 是注入点」。
    // 注解一去掉，setUserService 就只是个普通方法，
    // Spring 根本不会调它，字段保持 null。
    public void setUserService(DiUserService userService){
        this.userService = userService;
    }

    public void sayHi() {
        System.out.println("3 Setter 注入 Controller3");
        userService.sayHi();
    }
}