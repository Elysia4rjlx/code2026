package com.elyjah._026_09_27springmvc3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// TODO ← 注意:这里是 @Controller,不是 @RestController
public class IndexController {

    //返回视图
    @RequestMapping("/index")
    public String index(){
        return "/index.html";
        //Spring 看到 @Controller,会去找 /index.html
    }

    @RequestMapping("/returnData")
    @ResponseBody
    public String returnData(){
        return "/index.html";
        //返回数据
    }
}