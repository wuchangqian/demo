package com.chencye.sys.login.service.impl;

import org.springframework.stereotype.Service;

import com.chencye.sys.login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
    
    @Override
    public void loginLog() {
        System.out.println("loginLog");
    }
    
}
