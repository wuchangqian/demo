package com.chencye.security.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    
    @RequestMapping("loginSuccess")
    public String loginSuccess() {
        LOGGER.info("login success.");
        return "home";
    }
    
    @RequestMapping("loginFailure")
    public String loginFailure() {
        LOGGER.info("login failure.");
        return "login";
    }
}
