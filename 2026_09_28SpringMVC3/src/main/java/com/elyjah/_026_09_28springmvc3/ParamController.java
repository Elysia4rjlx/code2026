package com.elyjah._026_09_27springmvc3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/param")
public class ParamController {
    //形参名和请求参数名一致 → 不用 @RequestParam
    @RequestMapping("/m1")
    public String m1(String name) {
        return "name = " + name;
    }

    // 形参名和请求参数名不一致 → 必须用 @RequestParam
    @RequestMapping("/m2")
    public String m2(@RequestParam("time") String createtime) {
        return "createtime = " + createtime;
    }


    // required = false → 参数变成可选
    @RequestMapping("/m3")
    public String m3(@RequestParam(value = "time", required = false) String createtime) {
        return "createtime = " + createtime;
    }

    //包装类型
    @RequestMapping("/m4")
    public String m4(Integer age) { // 用 Integer,不要用 int
        return "age = " + age;
    }
}