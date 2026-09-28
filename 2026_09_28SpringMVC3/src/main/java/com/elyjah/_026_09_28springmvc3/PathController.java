package com.elyjah._026_09_27springmvc3;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/path")
public class PathController {

    //形参名和占位符名一致 → 可省略 value
    @RequestMapping("m1/{id}/{name}")
    public String m1(@PathVariable Integer id,@PathVariable String name){
        return "id = " + id + ", name=" + name;
    }

    // 形参名和占位符名不一致 → 必须指定 value
    @RequestMapping("/m2/{id}/{name}")
    public String m2(@PathVariable Integer id,@PathVariable("name") String userName ){
        return "id = " + id + ", name = " + userName;
    }

    @RequestMapping("/m3/{id}/{name}/{age}")
    public String m3(@PathVariable Integer id,@PathVariable String name){
        // age 占位符存在,但我们不取,看会不会报错
        return "id=" + id + ", name=" + name;
        //TODO 404报错（路径 /m3/{id}/{name}/{age} 必须三段
    }
}