package com.example.iov.lab._026_10_10springiocdilab2.multibean;

import com.example.iov.lab._026_10_10springiocdilab2.beanmethod.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class Controller_Qualifier {

//@Qualifier 不能单独使用，必须配合 @Autowired。
//因为它只是「筛选条件」，必须依附于一次注入动作才有意义
    @Qualifier("user4")
    @Autowired
    private User user;

    public void show() {
        System.out.println("       @Qualifier 注入 → " + user);
    }
}