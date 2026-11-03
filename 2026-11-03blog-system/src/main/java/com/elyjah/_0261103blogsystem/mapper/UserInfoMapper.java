package com.elyjah._0261103blogsystem.mapper;

import com.elyjah._0261103blogsystem.domain.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Elysia1111
* @description 针对表【user_info(用户表)】的数据库操作Mapper
* @createDate 2026-11-03 16:24:15
* @Entity com.elyjah._0261103blogsystem.domain.UserInfo
*/
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}




