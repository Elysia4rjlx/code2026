package com.elyjah._026_10_01bookdemo;

import jakarta.annotation.PostConstruct;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @PostConstruct
    public void printMappedStatements() {
        sqlSessionFactory.getConfiguration()
                .getMappedStatementNames()
                .forEach(System.out::println);
    }

}


