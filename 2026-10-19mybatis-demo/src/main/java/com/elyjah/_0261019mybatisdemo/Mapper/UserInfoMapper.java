package com.elyjah._0261019mybatisdemo.Mapper;

import com.elyjah._0261019mybatisdemo.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Select("select username, `password`, age, gender, phone from user_info")
    List<UserInfo> queryAllUser();

    @Select("select * from user_info where id = #{username}")
    UserInfo queryUserById(Integer id);

    @Select("select * from user_info where username = #{username} and age = #{age}")
    List<UserInfo> queryUserByNameAndAge(@Param("username") String username,@Param("age") Integer age);
//@Select("select * from user_info where username = #{username} and age = #{age}")
//    List<UserInfo> queryUserByNameAndAge(String username1,Integer age1);
    //BindingException

    @Select("select * from user_info where username = #{username} and age = #{age}")
    List<UserInfo> queryUserByUserInfo(UserInfo userInfo);

    @Select("<script>" +
            "select * from user_info " +
            "where 1=1 " +
            "<if test='username != null and username != \"\"'>" +
            "  and username = #{username} " +
            "</if>" +
            "<if test='age != null'>" +
            "  and age = #{age} " +
            "</if>" +
            "order by id desc" +
            "</script>")
    List<UserInfo> queryUserByCondition(@Param("username") String username, @Param("age") Integer age);

    @Insert("insert into user_info(username, `password`, age, gender,phone) " +
            "values (#{username},#{password},#{age},#{gender},#{phone})")
    Integer insert(UserInfo userInfo);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into user_info(username, `password`, age, gender, phone) " +
            "values (#{username}, #{password}, #{age}, #{gender}, #{phone})")
    Integer insert1(UserInfo userInfo);

    @Delete(("delete from user_info where id = #{id}"))
    Integer delete(UserInfo userInfo);

    @Update("update user_info set id = #{id} where username = #{username}")
    Integer update(UserInfo userInfo);


    @Select("select id, username, `password`, age, gender, phone, delete_flag as deleteFlag, create_time as createTime, update_time as updateTime from user_info")
    List<UserInfo> queryAllUser1();


    @Results({
            @Result(column = "delete_flag",property = "deleteFlag"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "update_time",property = "updateTime")
    })
    @Select("select id, username, `password`, age, gender, phone, delete_flag, create_time, update_time from user_info")
    List<UserInfo> queryAllUser2();
}