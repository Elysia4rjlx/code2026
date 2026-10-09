package com.example.iov.lab._026_10_09springiocdilab1.bean;

import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    public void sayHi() {
        System.out.println("hello,UserController!");
    }
}