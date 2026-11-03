package com.elyjah._0261103blogsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elyjah._0261103blogsystem.domain.UserInfo;
import com.elyjah._0261103blogsystem.service.UserInfoService;
import com.elyjah._0261103blogsystem.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author Elysia1111
* @description 针对表【user_info(用户表)】的数据库操作Service实现
* @createDate 2026-11-03 16:24:15
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

}




