package com.elyjah._0261029springaopdemo.Controller;

import com.elyjah._0261029springaopdemo.Aspect.MyAspect;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/t1")
    @MyAspect
    public String t1(){
        System.out.println("nh");
        return "t1";
    }

    @RequestMapping("/t2")
    public int t2(){
        return 2/0;
    }

    @RequestMapping("/t3")
    public boolean t3(){
        int i = 10/0;
        return true;
    }
}