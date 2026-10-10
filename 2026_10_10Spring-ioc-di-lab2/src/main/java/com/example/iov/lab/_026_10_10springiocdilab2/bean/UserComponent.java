package com.example.iov.lab._026_10_10springiocdilab2.bean;

import org.springframework.stereotype.Component;

@Component
public class UserComponent {

    public void sayHi() {
        System.out.println("hello,UserComponent!");
    }
}