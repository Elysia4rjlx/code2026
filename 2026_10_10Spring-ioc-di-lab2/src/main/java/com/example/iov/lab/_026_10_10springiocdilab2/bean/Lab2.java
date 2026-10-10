package com.example.iov.lab._026_10_10springiocdilab2.bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Lab2 {
    public static void main(String[] args) {
        // 启动 Spring，拿到「上下文」对象 —— 它就是那个装满 Bean 的容器
        ApplicationContext context =
                SpringApplication.run(Lab2.class,args);

        System.out.println("=== 实验2：类注解存储 ===");

        System.out.println("@Controller: ");
        context.getBean(UserController.class).sayHi();

        System.out.println("@Service: ");
        context.getBean(UserService.class).sayHi();

        System.out.println("@Repository: ");
        context.getBean(UserRepository.class).sayHi();

        System.out.println("@Component :");
        context.getBean(UserComponent.class).sayHi();

        System.out.println("@Configuration:");
        context.getBean(UserConfiguration.class).sayHi();

    }
}