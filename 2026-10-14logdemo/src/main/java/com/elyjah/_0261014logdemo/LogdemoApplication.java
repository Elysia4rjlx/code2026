package com.elyjah._0261014logdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class LogdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogdemoApplication.class, args);

        log.info("===自定义日志启动完成===");


    }


}
