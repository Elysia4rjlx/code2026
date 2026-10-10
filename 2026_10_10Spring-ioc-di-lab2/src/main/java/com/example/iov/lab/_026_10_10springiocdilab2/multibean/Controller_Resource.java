package com.example.iov.lab._026_10_10springiocdilab2.multibean;

import com.example.iov.lab._026_10_10springiocdilab2.beanmethod.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller
public class Controller_Resource {

    @Resource(name = "user4")
    private User user;

    public void show() {
        System.out.println("       @Resource 注入 → " + user);
    }

}