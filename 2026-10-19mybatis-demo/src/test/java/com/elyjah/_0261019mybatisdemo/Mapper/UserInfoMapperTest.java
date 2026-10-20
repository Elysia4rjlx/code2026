package com.elyjah._0261019mybatisdemo.Mapper;

import com.elyjah._0261019mybatisdemo.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void queryAllUser() {
        List<UserInfo> list = userInfoMapper.queryAllUser();
        System.out.println(list);
    }

    @Test
    void queryUserById() {
        UserInfo userInfo = userInfoMapper.queryUserById(4);
        System.out.println("查询结果：" + userInfo);
    }

    @Test
    void queryUserByNameAndAge() {
        List<UserInfo> list = userInfoMapper.queryUserByNameAndAge("蔡徐坤",18);
    }


    @Test
    void queryUserByUserInfo() {
        UserInfo parm = new UserInfo();
        parm.setUsername("科比");
        parm.setAge(20);

        List<UserInfo> list = userInfoMapper.queryUserByUserInfo(parm);
        System.out.println("查询结果：" + list);
    }

    @Test
    void queryUserByCondition() {
        System.out.println("只按用户名：" + userInfoMapper.queryUserByCondition("lisi", null));
        System.out.println("只按年龄：" + userInfoMapper.queryUserByCondition(null, 18));
        System.out.println("都不传：" + userInfoMapper.queryUserByCondition(null, null));
        System.out.println("都传：" + userInfoMapper.queryUserByCondition("蔡徐坤", 18));
    }

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("原神");
        userInfo.setPassword("666666");
        userInfo.setGender(2);
        userInfo.setAge(6);
        userInfo.setPhone("14629365287");

        Integer count = userInfoMapper.insert(userInfo);
        System.out.println("添加数据条数：" + count);
    }

    @Test
    void insert1() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("张雪峰老师");
        userInfo.setPassword("6474");
        userInfo.setGender(1);
        userInfo.setAge(1);
        userInfo.setPhone("12333365287");

        Integer count = userInfoMapper.insert1(userInfo);
        System.out.println("添加数据条数：" + count + "，数据ID：" + userInfo.getId());
    }

    @Test
    void delete() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(20);

        Integer count = userInfoMapper.delete(userInfo);
        System.out.println("删除数据条数：" + count);
    }

    @Test
    void update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("原神");
        userInfo.setId(5);

        Integer count = userInfoMapper.update(userInfo);
        System.out.println("影响的数据条数：" + count);

    }

    @Test
    void queryAllUser1() {
        List<UserInfo> list = userInfoMapper.queryAllUser1();
        System.out.println(list);
    }
    @Test
    void queryAllUser2() {
        List<UserInfo> list = userInfoMapper.queryAllUser2();
        System.out.println(list);
    }
}