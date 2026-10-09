package com.example.iov.lab._026_10_09springiocdilab1.bean;

import org.springframework.stereotype.Component;

@Component
public class UserComponent {

    public void sayHi() {
        System.out.println("hello,UserComponent!");
    }
}