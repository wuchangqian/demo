package com.chencye.sys.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chencye.security.support.MyUserDetails;
import com.chencye.sys.login.service.LoginService;

@Controller
public class LoginController {
    
    private final static Logger log = LoggerFactory.getLogger(LoginController.class);
    
    @Autowired
    private LoginService loginService;
    
    @RequestMapping("loginSuccess")
    public String loginSuccess() {
        log.info("login success.");
        MyUserDetails myUserDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        loginService.loginLog();
        log.info(myUserDetails.getUser().getUsername());
        return "home";
    }
    
    @RequestMapping("loginFailure")
    public String loginFailure() {
        log.info("login failure.");
        return "login";
    }
}
