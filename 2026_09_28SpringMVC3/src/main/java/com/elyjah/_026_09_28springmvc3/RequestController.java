package com.elyjah._026_09_27springmvc3;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class RequestController {


    @RequestMapping("/sayHi")
    public String sayHi(){
        return "hello Spring MVC";
    }

}