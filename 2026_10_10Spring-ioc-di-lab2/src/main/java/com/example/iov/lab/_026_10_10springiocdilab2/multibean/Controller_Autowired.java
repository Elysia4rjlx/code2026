package com.example.iov.lab._026_10_10springiocdilab2.multibean;

import com.example.iov.lab._026_10_10springiocdilab2.beanmethod.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Controller_Autowired {
    @Autowired
    private User user;

    public void show(){
        System.out.println("  " + user);
    }
}