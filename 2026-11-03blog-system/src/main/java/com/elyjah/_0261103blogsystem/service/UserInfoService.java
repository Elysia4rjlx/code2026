package com.elyjah._0261103blogsystem.service;

import com.elyjah._0261103blogsystem.domain.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.elyjah._0261103blogsystem.pojo.param.UserInfoParam;
import com.elyjah._0261103blogsystem.pojo.response.UserLoginResponse;

/**
* @author Elysia1111
* @description 针对表【user_info(用户表)】的数据库操作Service
* @createDate 2026-11-03 16:24:15
*/
public interface UserInfoService extends IService<UserInfo> {

    /**
     * 用户登录
     *
     * @param user 登录请求参数（用户名、密码）
     * @return 登录成功返回用户ID和令牌；失败抛 BlogException
     */
    UserLoginResponse login(UserInfoParam user);

    /**
     * 根据用户名查询用户信息
     */
    UserInfo selectUserInfoByName(String userName);
}
