package com.example.iov.lab._026_10_10springiocdilab2.scan;

import com.example.iov.lab.outofscan.OuterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Lab6 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Lab6.class,args);
        System.out.println("本次扫描范围：com.example.iov.lab._026_10_10springiocdilab2.scan 及其子包");
        System.out.println();

        //成功案例
        System.out.println("--- ① InnerService 在扫描范围内 ---");


        try {
            InnerService innerService = context.getBean(InnerService.class);
            innerService.sayHi();
            System.out.println("取到了");
        } catch (Exception e){
            System.out.println("错误 " + e.getMessage());
        }

        System.out.println();
        System.out.println("-----------------------------");


        try {
            OuterService outerService = context.getBean(OuterService.class);
            outerService.sayHi();
            System.out.println("取到了");
        } catch (Exception e){
            System.out.println("   ❌ 取不到！");
            System.out.println();
            System.out.println("   异常类型：" + e.getClass().getSimpleName());
            System.out.println("   异常信息：" + e.getMessage());
        }


    }
}