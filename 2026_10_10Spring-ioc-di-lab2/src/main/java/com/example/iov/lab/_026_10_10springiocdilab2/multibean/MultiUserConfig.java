package com.example.iov.lab._026_10_10springiocdilab2.multibean;

import com.example.iov.lab._026_10_10springiocdilab2.beanmethod.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("com.example.iov.lab._026_10_10springiocdilab2.beanmethod")
public class MultiUserConfig {

    @Primary
    @Bean("u3")
    public User user3() {
        User user = new User();
        user.setName("zhangsan");
        user.setAge(18);
        return user;
    }

    @Bean
    public User user4() {
        User user = new User();
        user.setName("lisi");
        user.setAge(16);
        return user;
    }
}