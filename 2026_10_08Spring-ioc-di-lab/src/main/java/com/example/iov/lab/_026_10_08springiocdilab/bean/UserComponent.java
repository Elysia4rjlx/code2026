package com.example.iov.lab._026_10_08springiocdilab.bean;

import org.springframework.stereotype.Component;

@Component
public class UserComponent {

    public void sayHi() {
        System.out.println("hello,UserComponent!");
    }
}