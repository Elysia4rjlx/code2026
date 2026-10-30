package com.elyjah._0261029springaopdemo.Controller;


import com.elyjah._0261029springaopdemo.Aspect.Exercise4MyAspect;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Exercise4MyAspect
    @GetMapping("/u1")
    public String u1() {
        return "u1";
    }

    @GetMapping("/u2")
    public String u2() {
        return "u2";
    }
}