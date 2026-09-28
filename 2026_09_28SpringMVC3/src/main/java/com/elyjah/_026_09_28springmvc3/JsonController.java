package com.elyjah._026_09_27springmvc3;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/json")
public class JsonController {

    //用 @RequestBody 接收 JSON
    @RequestMapping("/m1")
    public String m1(@RequestBody Person person){
        return person.toString();
    }

    //反例:不加 @RequestBody
    public String m2(Person person){
        return person.toString();
    }
}