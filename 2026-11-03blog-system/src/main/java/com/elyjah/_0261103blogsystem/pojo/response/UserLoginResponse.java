package com.elyjah._0261103blogsystem.pojo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录成功后的返回结果
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginResponse {

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 签发给客户端的 JWT 令牌
     */
    private String token;
}
