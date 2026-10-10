package com.example.iov.lab._026_10_10springiocdilab2.beanmethod;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConfig {
    @Bean("u1")
    public User user1(){
        User user = new User();
        user.setName("zhangsan");
        user.setAge(18);
        return user;
    }
    @Bean
    public User user2(){
        User user = new User();
        user.setName("lisi");
        user.setAge(19);
        return user;
    }
}