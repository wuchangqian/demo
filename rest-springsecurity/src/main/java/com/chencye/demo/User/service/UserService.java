package com.chencye.demo.User.service;

import com.chencye.demo.User.bean.User;
import com.github.pagehelper.PageInfo;

public interface UserService {

    PageInfo<User> list(int pageNum, int pageSize);
    
}
