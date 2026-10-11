package com.elyjah._0261010captchademo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "captcha")
//把 yml 里所有以 captcha. 开头的配置，按字段名塞进这个对象。
@Data
public class CaptchaProperties {
    private int width;
    private int height;
    private Session session;
}

//todo
// yml: captcha.width = "200"
//  ↓ prefix 匹配 "captcha" → 剩下 "width"
//  ↓ 在 CaptchaProperties 里找 width 字段 → 找到
//  ↓ 类型是 int，转换 "200" → 200
//  ↓ 调 setWidth(200)
//
//todo
// yml: captcha.session.code = "captchaCode"
//  ↓ prefix 匹配 → 剩下 "session.code"
//  ↓ 先找 session 字段 → 找到，类型是 Session
//  ↓ 递归：进入 Session 对象，找 code 字段 → 找到
//  ↓ 调 session.setCode("captchaCode")