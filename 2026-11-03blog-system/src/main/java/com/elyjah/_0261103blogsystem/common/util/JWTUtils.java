package com.elyjah._0261103blogsystem.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT 令牌工具类
 * <p>
 * 负责三件事：生成令牌、校验令牌、从令牌里取用户信息。
 * 服务器签发令牌时把用户信息放进载荷(claim)，客户端后续请求带上令牌，
 * 服务器用同一把密钥校验签名，通过即说明这个令牌是自己签发的、没被篡改。
 */
@Slf4j
public class JWTUtils {

    /**
     * 密钥（Base64 编码后的字符串）。
     * <p>
     * 用 Base64 解码成字节后，长度必须够长，否则 hmacShaKeyFor 会直接抛异常。
     * 生产环境这个值应该放到配置文件/配置中心，不要写死在代码里。
     */
    public static String secret = "dVnsmy+SIX6pNptQdeclDSJ26EMSPEIhvZYKBTTug4k=";

    /**
     * 过期时间，单位毫秒。这里是 24 小时。
     */
    public static long expiration = 24 * 60 * 60 * 1000;

    /**
     * 由密钥字符串生成真正用于签名的 SecretKey。
     */
    private static SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));

    /**
     * 生成令牌
     *
     * @param claim 自定义内容（载荷），比如 {"id":1,"name":"zhangsan"}
     * @return 签好的 JWT 字符串，形如 aaaaa.bbbbb.ccccc
     */
    public static String genJwt(Map<String, Object> claim) {
        String jwt = Jwts.builder()
                .setClaims(claim)                                              // 自定义内容（载荷）
                .setIssuedAt(new Date())                                      // 设置签发时间
                .setExpiration(new Date(System.currentTimeMillis() + expiration)) // 设置过期时间
                .signWith(SignatureAlgorithm.HS256, secretKey)                // 用 HS256 算法签名
                .compact();                                                   // 拼成最终字符串
        return jwt;
    }

    /**
     * 校验令牌
     *
     * @param jwt 客户端传来的令牌
     * @return 校验通过返回载荷(Claims)，校验失败（过期/被篡改/签名不对）返回 null
     */
    public static Claims parseJWT(String jwt) {
        if (!StringUtils.hasLength(jwt)) {
            return null;
        }
        Claims claims = null;
        try {
            // 创建解析器并设置签名密钥
            JwtParserBuilder jwtParserBuilder = Jwts.parserBuilder().setSigningKey(secretKey);
            // 解析令牌：签名不对、令牌过期都会在这里抛异常
            claims = jwtParserBuilder.build().parseClaimsJws(jwt).getBody();
        } catch (Exception e) {
            // 令牌无效，交给调用方决定怎么处理（一般就是判定为未登录）
            log.error("解析令牌错误,jwt:{}", jwt);
        }
        return claims;
    }

    /**
     * 从令牌中获取用户ID
     */
    public static Integer getUserIdFromToken(String jwtToken) {
        Claims claims = JWTUtils.parseJWT(jwtToken);
        if (claims != null) {
            Map<String, Object> userInfo = new HashMap<>(claims);
            Object id = userInfo.get("id");
            return id == null ? null : Integer.valueOf(id.toString());
        }
        return null;
    }
}
