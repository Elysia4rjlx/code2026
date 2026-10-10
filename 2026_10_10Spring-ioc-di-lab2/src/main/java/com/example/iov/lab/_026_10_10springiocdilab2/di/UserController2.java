package com.example.iov.lab._026_10_10springiocdilab2.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController2 {

    private  DiUserService userService;

    //todo  构造方法注入，类只有一个构造方法时，@Autowired 可以省略。
    public UserController2(){
        System.out.println("我是备用");
    }

    @Autowired
    public UserController2(DiUserService userService) {
        this.userService = userService;
    }

    public void sayHi() {
        System.out.println("2 构造方法注入 Controller2");
        userService.sayHi();
    }


}