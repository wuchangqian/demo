package com.chencye.demo.User.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chencye.demo.User.bean.User;
import com.chencye.demo.User.service.UserService;
import com.github.pagehelper.PageInfo;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("user")
    public PageInfo<User> list(@RequestParam(required = false, defaultValue = "0") int pageNum,
            @RequestParam(required = false, defaultValue = "0") int pageSize) {
        
        return userService.list(pageNum, pageSize);
    }
}
