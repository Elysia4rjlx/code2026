package com.elyjah._026_10_01bookdemo.mapper;


import com.elyjah._026_10_01bookdemo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserInfoMapper {

//    Integer insertUserByCondition(UserInfo userInfo);
//
//    List<UserInfo> queryByCondition(UserInfo userInfo);
//
//    Integer updateUserByCondition(UserInfo userInfo);
//
//    Integer deleteByIds(@Param("ids") List<Integer> ids);

    @Select("select id, user_name, `password`, delete_flag, create_time, update_time " +
            "from user_info where delete_flag = 0 and user_name = #{name}")
    UserInfo queryUserByName(String userName);
}