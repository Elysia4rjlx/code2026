package com.example.iov.lab._026_10_10springiocdilab2.bean;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void sayHi() {
        System.out.println("hello,UserService!");
    }
}