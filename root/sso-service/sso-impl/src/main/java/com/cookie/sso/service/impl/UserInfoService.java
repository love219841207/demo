package com.cookie.sso.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cookie.sso.mapper.UserInfoMapper;
import com.cookie.sso.model.UserInfo;
import com.cookie.sso.service.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;



@Service
public class UserInfoService implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public String getById(Integer id) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        return userInfo.getUsername();
    }

    public void deleteById(Integer id) {
        userInfoMapper.deleteByPrimaryKey(id);
    }

    public boolean save(String name) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("dean");
        userInfoMapper.insert(userInfo);
        return true;
    }
}
/*
    public UserInfo getById(Integer id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        userInfoMapper.deleteByPrimaryKey(id);
    }

    public void save(UserInfo country) {
        if (country.getId() != null) {
            userInfoMapper.updateByPrimaryKey(country);
        } else {
            userInfoMapper.insert(country);
        }
    }*/
