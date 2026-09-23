package com.elyjah._026_09_23springboot_demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello! SpringBoot!";
    }

    @RequestMapping("/getNum")
    public Integer getNum(){
        return 10;
    }

    @RequestMapping("/sayHi")
    public String sayHi(){
        return "hi!";
    }
}