package com.github.chencye.demo.datasource.service;

import com.github.chencye.demo.datasource.dao.UserDao;
import com.github.chencye.demo.datasource.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findUsers()
    {
        return userDao.findUsers();
    }

    public List<User> findUsers4DRUID()
    {
        return userDao.findUsers();
    }

    public List<User> findUsers4C3P0()
    {
        return userDao.findUsers();
    }

}
