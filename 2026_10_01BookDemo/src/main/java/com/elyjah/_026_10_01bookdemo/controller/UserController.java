package com.elyjah._026_10_01bookdemo.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 参数校验
     * 验证密码
     */
    @RequestMapping("/login")
    public boolean login(String userName,String password){
        if (!StringUtils.hasText(userName) || !StringUtils.hasText(password)){
            return false;
        }

        if ("kebi".equals(userName) && "2424".equals(password)){
            return true;
        }

        return false;
    }
}