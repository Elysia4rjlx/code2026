package com.example.iov.lab._026_10_09springiocdilab1.bean;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public void sayHi() {
        System.out.println("hello,UserRepository!");
    }
}