package com.example.iov.lab._026_10_09springiocdilab1.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Lab3 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Lab3.class,args);

        System.out.println("=== 实验3：Bean 的获取方式与命名 ===");

        //按类型获取
        UserController c1 = context.getBean(UserController.class);
        System.out.println("按类型取 : " + c1);

        //按名称获取 —— 返回 Object，必须强转
        UserController c2 = (UserController)context.getBean("userController");
        System.out.println("按名称获取 :" + c2);
//        System.out.println("② 按名称取   : " + context.getBean("URManager"));


        //名称 + 类型 —— 最安全，写错名字立刻报错
        UserController c3 = context.getBean("userController",UserController.class);
        System.out.println("名称+类型 : " + c3);

        System.out.println();
        System.out.println("三个地址一样吗？→ 一样就是同一个对象（单例）");

        System.out.println("=================================");

        if (context.containsBean("URManager")) {
            System.out.println("类名 URManager      → bean名 URManager（前两字母大写，保持原样）");
        }
        if (context.containsBean("urManager")) {
            System.out.println("（注意：urManager 这个名字【也】存在，但真正生效的是 URManager）");
        }

        System.out.println();
        System.out.println("=================================");
        System.out.println("--- 容器类型关系 ---");
        System.out.println("ApplicationContext 是 BeanFactory 的子类型？"
                + (context instanceof BeanFactory));
    }

}