package com.elyjah._026_09_27springmvc3;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ctx")
public class ContextController {

    //存Session
    @RequestMapping("/setSess")
    public String setSess(HttpSession session){
        session.setAttribute("username","zhangsan");
        return "session存好了";
    }

    //用 @SessionAttribute 读 Session
    @RequestMapping("/getSess")
    public String get(@SessionAttribute(value = "username",required = false) String username){
        return "username = " + username;
    }

    //用 @CookieValue 读 Cookie
    @RequestMapping("/getCookie")
    public String getCookie(@CookieValue(value = "bite",required = false) String bite){
        return "bite = " + bite;
    }

    //用 @RequestHeader 读请求头
    @RequestMapping("/getHeader")
    public String getHeader(@RequestHeader("User-Agent")String userAgent){
        return "User-Agent " + userAgent;
    }
}