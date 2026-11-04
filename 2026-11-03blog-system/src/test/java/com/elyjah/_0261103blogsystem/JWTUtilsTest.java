package com.elyjah._0261103blogsystem;

import com.elyjah._0261103blogsystem.common.util.JWTUtils;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * JWT 令牌工具类测试
 * <p>
 * 跑这个测试可以直观看到：
 * 1. 生成的令牌长什么样（aaa.bbb.ccc 三段）
 * 2. 载荷里存了什么（用户信息）
 * 3. 令牌被篡改后能不能被识别出来
 */
public class JWTUtilsTest {

    @Test
    public void genJwt() {
        // 自定义信息（载荷）
        Map<String, Object> claim = new HashMap<>();
        claim.put("id", 1);
        claim.put("name", "zhangsan");

        String jwt = JWTUtils.genJwt(claim);
        System.out.println("生成的令牌：" + jwt);
        System.out.println("令牌分段数：" + jwt.split("\\.").length);
    }

    @Test
    public void parseJWT() {
        Map<String, Object> claim = new HashMap<>();
        claim.put("id", 1);
        claim.put("name", "zhangsan");
        String jwt = JWTUtils.genJwt(claim);

        // 正常校验
        Claims claims = JWTUtils.parseJWT(jwt);
        System.out.println("校验结果：" + claims);
        System.out.println("取出的用户ID：" + JWTUtils.getUserIdFromToken(jwt));

        // 篡改令牌：随便改一个字符
        String tampered = jwt.substring(0, jwt.length() - 2) + "xy";
        System.out.println("篡改后校验结果：" + JWTUtils.parseJWT(tampered));

        // 空令牌
        System.out.println("空令牌校验结果：" + JWTUtils.parseJWT(""));
        System.out.println("null令牌校验结果：" + JWTUtils.parseJWT(null));
    }
}
