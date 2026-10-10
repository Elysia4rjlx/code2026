package com.example.iov.lab._026_10_10springiocdilab2.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Lab7 {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Lab7.class,args);

        System.out.println("=== 实验7：DI 三种注入方式 ===");

        System.out.println();
        System.out.println("=== 1 属性注入 ===");
        UserController1 u1 = context.getBean(UserController1.class);
        u1.sayHi();
        u1.fun2();
        System.out.println();
        System.out.println("=== 2 构造方法注入 ===");
        UserController2 u2 = context.getBean(UserController2.class);
        u2.sayHi();

        System.out.println();
        System.out.println("=== 3 setter注入 ===");
        UserController3 u3 = context.getBean(UserController3.class);
        u3.sayHi();
    }

}