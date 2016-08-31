package com.github.chencye.demo.datasource.dao;

import com.github.chencye.demo.datasource.entity.User;

import java.util.List;

public interface UserDao {

    List<User> findUsers();

    User findById(Long id);

    int saveUser(User user);

    int deleteUser(Long id);

    int updateUser(User user);
}
