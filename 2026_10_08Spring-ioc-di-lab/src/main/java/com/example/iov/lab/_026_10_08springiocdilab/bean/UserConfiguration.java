package com.example.iov.lab._026_10_08springiocdilab.bean;

import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    public void sayHi() {

        System.out.println("hello, UserConfiguration~");
    }
}