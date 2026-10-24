package com.elyjah._026_10_01bookdemo.controller;

import com.elyjah._026_10_01bookdemo.model.UserInfo;
import com.elyjah._026_10_01bookdemo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 参数校验
     * 验证密码
     */
    @PostMapping("/login")
    public boolean login(String userName,String password, HttpSession session){
        if (!StringUtils.hasText(userName) ||  !StringUtils.hasLength(password)){
            return false;
        }

        //从数据库中查询用户
        UserInfo userInfo = userService.queryUserByName(userName);
        if (userInfo ==null){
            return false;
        }

        //账号密码正确
        if (password.equals(userInfo.getPassword())){
            //存到Session中
            userInfo.setPassword("");
            session.setAttribute("session_user_key", userInfo);
            return true;
        }

        // 账号密码错误
        return false;
    }
}