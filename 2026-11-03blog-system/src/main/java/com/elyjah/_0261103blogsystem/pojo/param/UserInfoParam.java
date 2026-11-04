package com.elyjah._0261103blogsystem.pojo.param;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * 登录请求参数
 * <p>
 * Controller 上加 @Validated 之后，这里的约束注解才会生效，
 * 校验不通过会抛出异常，被 ExceptionAdvice 统一转成友好的错误提示。
 */
@Data
public class UserInfoParam {

    @NotBlank(message = "用户名不能为空")
    @Length(max = 20, message = "用户名长度不能超过20")
    private String userName;

    @NotBlank(message = "密码不能为空")
    @Length(max = 20, message = "密码长度不能超过20")
    private String password;
}
