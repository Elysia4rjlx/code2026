package com.elyjah._026_10_01bookdemo.service;


import com.elyjah._026_10_01bookdemo.mapper.UserInfoMapper;
import com.elyjah._026_10_01bookdemo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo queryUserByName(String userName){
        return userInfoMapper.queryUserByName(userName);
    }
}