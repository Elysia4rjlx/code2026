package com.elyjah._026_09_24springmvc1;


import org.springframework.web.bind.annotation.*;

@RequestMapping("/hello")
@RestController
public class HelloController {

    @RequestMapping(value = "/v1",method = {RequestMethod.GET})
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping("/v2")
    public String miao() {
        return "喵~";
    }

    @GetMapping("/get")
    public String GET() {
        return "只接受get请求";
    }

    @PostMapping("/post")
    public String POST(){
        return "只接受post请求";
    }

    @PutMapping("/put")
    public String PUT() {
        return "只接受put请求";
    }

    @DeleteMapping("/delete")
    public String DELETE(){
        return "只接受Delete请求";
    }
}