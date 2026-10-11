package com.elyjah._0261010captchademo.controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.elyjah._0261010captchademo.model.CaptchaProperties;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@Slf4j
@RestController
@RequestMapping("/captcha")
public class CaptchaController {

    private final static long VALID_MILLIS_TIME = 2 * 60 * 1000; // 2分钟

    @Autowired
    private CaptchaProperties captchaProperties;

    @RequestMapping("/getCaptcha")
    public void getCaptcha(HttpServletResponse response, HttpSession session) {

        //1、创建验证码对象，宽高通过配置文件获取
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(
                captchaProperties.getWidth(),
                captchaProperties.getHeight()
        );

        //2、取出验证码
        String code = lineCaptcha.getCode();
        System.out.println(code);

        //3、把答案和生成时间写进Session
        session.setAttribute(captchaProperties.getSession().getCode(), code);
        session.setAttribute(captchaProperties.getSession().getDate(), System.currentTimeMillis());

        //4、把图片写进响应
        response.setContentType("image/png");
        //告诉浏览器"我发给你的字节是什么格式"。


        try {
            lineCaptcha.write(response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/check")
    public boolean verify(String captcha, HttpSession session) {

        //1、用户没传 captcha，或者传了空字符串
        //captcha 是前端传来的参数，它可能是 null
        if (!StringUtils.hasText(captcha)) {
            return false;
        }

        //2、从 Session 里取出之前存的验证码和生成时间
        String savedCode = (String) session.getAttribute
                (captchaProperties.getSession().getCode());
        Long savedTime = (Long) session.getAttribute
                (captchaProperties.getSession().getDate());


        //3、 取不到说明用户根本没调生成接口，直接来校验了
        if (savedCode == null || savedTime == null) {
            return false;
        }


        //4、判断是否超时
        if (System.currentTimeMillis() - savedTime > VALID_MILLIS_TIME) {
            return false;
        }

        //5、对比答案
        if (!captcha.equalsIgnoreCase(savedCode)) {
            return false;
        }

        //6、校验通过，立刻从 Session 里删掉，防止同一个码反复用
        session.removeAttribute(
                captchaProperties.getSession().getCode());
        session.removeAttribute(
                captchaProperties.getSession().getDate());

        return true;
    }
}