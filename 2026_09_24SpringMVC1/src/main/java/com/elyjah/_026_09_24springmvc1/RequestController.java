package com.elyjah._026_09_24springmvc1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request")
public class RequestController {

    @RequestMapping("/r1")
    public String r1(String name) {
        return "接收到的名字为： " + name;
    }

    @RequestMapping("/r2")
    public String r2(String name,String password) {
        return "接收到的name为：" + name + " ,接收到的password为：" + password;
    }
}