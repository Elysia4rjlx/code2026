package com.elyjah._0261103blogsystem.controller;

import com.elyjah._0261103blogsystem.pojo.param.UserInfoParam;
import com.elyjah._0261103blogsystem.pojo.response.UserLoginResponse;
import com.elyjah._0261103blogsystem.service.UserInfoService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {

    @Resource(name = "userInfoServiceImpl")
    private UserInfoService userInfoService;

    /**
     * 用户登录
     * <p>
     * 请求：{"userName":"zhangsan","password":"123456"}
     * <p>
     * 返回：{"code":200,"errMsg":"","data":{"userId":1,"token":"eyJhbGciOi..."}}
     */
    @PostMapping("/login")
    public UserLoginResponse login(@Valid @RequestBody UserInfoParam user) {
        log.info("用户登录, userName: {}", user.getUserName());
        return userInfoService.login(user);
    }
}
