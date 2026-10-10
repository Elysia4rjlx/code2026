package com.example.iov.lab._026_10_10springiocdilab2.multibean;

import com.example.iov.lab._026_10_10springiocdilab2.beanmethod.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Lab8 {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Lab8.class,args);

        System.out.println("=== 实验8：@Autowired 遇到同类型多 Bean ===");
        System.out.println("容器里User的类型的bean有： "
                            + Arrays.toString(context.getBeanNamesForType(User.class)));

        System.out.println();
        System.out.println("==== ① 裸 @Autowired 问题现场 ====");

        try{
            context.getBean(Controller_Autowired.class).show();

        }catch (Exception e){
            Throwable root = e;
            while (root.getCause() != null && root.getCause() != root) {
                root = root.getCause();
            }
            System.out.println("   ❌ " + e.getClass().getSimpleName());
            System.out.println("   " + root.getMessage());
        }

        System.out.println();
        System.out.println("--- ② @Qualifier(\"user4\") ---");
        try {
            context.getBean(Controller_Qualifier.class).show();
        } catch (Exception e) {
            System.out.println("   ❌ " + e.getMessage());
        }

        System.out.println();
        System.out.println("--- ③ @Resource(name = \"user4\") ---");
        try {
            context.getBean(Controller_Resource.class).show();
        } catch (Exception e) {
            System.out.println("   ❌ " + e.getMessage());
        }
    }
}