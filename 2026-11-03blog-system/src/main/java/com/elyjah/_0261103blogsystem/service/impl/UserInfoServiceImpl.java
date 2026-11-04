package com.elyjah._0261103blogsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elyjah._0261103blogsystem.common.Constants;
import com.elyjah._0261103blogsystem.common.exception.BlogException;
import com.elyjah._0261103blogsystem.common.util.JWTUtils;
import com.elyjah._0261103blogsystem.domain.UserInfo;
import com.elyjah._0261103blogsystem.pojo.param.UserInfoParam;
import com.elyjah._0261103blogsystem.pojo.response.UserLoginResponse;
import com.elyjah._0261103blogsystem.service.UserInfoService;
import com.elyjah._0261103blogsystem.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
* @author Elysia1111
* @description 针对表【user_info(用户表)】的数据库操作Service实现
* @createDate 2026-11-03 16:24:15
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserLoginResponse login(UserInfoParam user) {
        // 1. 根据用户名查库
        UserInfo userInfo = selectUserInfoByName(user.getUserName());
        // 2. 校验账号密码
        if (userInfo == null || userInfo.getId() == null) {
            throw new BlogException("用户不存在");
        }
        if (!user.getPassword().equals(userInfo.getPassword())) {
            throw new BlogException("用户密码不正确");
        }

        // 3. 账号密码正确，签发令牌（把用户信息放进载荷）
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", userInfo.getId());
        claims.put("name", userInfo.getUserName());
        String jwt = JWTUtils.genJwt(claims);

        // 4. 把用户ID和令牌一起返回给前端
        return new UserLoginResponse(userInfo.getId(), jwt);
    }

    @Override
    public UserInfo selectUserInfoByName(String userName) {
        return userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getUserName, userName)
                .eq(UserInfo::getDeleteFlag, Constants.IS_NOT_DELETE));
    }
}




