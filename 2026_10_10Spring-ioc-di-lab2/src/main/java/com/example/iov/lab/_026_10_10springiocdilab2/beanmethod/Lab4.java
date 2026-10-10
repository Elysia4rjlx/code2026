package com.example.iov.lab._026_10_10springiocdilab2.beanmethod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Lab4 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Lab4.class,args);
        System.out.println("=== 实验4：方法注解 @Bean ===");

        //按名称获取u1
        User user1 = (User) context.getBean("u1");
        System.out.println("按名称 \"u1\" 取   → " + user1);

        //按名称获取User2
        User user2 = (User) context.getBean("user2");
        System.out.println("按名称\"user2\" 取 → " + user2);

        //名称 + 类型 获取
        User user1Again = context.getBean("u1", User.class);
        System.out.println("名称 + 类型 取       → " + user1Again);


        System.out.println();
        System.out.println("--- 容器里一共有几个 User 类型的 bean？ ---");
        String[] names = context.getBeanNamesForType(User.class);
        // getBeanNamesForType
        // 是个很好用的调试技巧
        // 它能列出容器里所有符合某个类型的 bean 名字
        System.out.println("数量： " + names.length);
        for(String name : names){
            System.out.println("名字 ：" + name);
        }

        System.out.println("---------------------------------");

//        User byType = context.getBean(User.class);
        //NoUniqueBeanDefinitionException:
        // expected single matching bean but found 2: u1, user2


    }
}