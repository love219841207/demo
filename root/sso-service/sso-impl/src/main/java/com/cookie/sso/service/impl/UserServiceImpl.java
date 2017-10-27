package com.cookie.sso.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cookie.sso.service.inter.TestService;

@Service
public class UserServiceImpl implements TestService {
    public String sayHello(String str) {
        return "Hello "+ str;
    }
}
