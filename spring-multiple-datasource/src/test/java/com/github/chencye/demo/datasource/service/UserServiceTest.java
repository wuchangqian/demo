package com.github.chencye.demo.datasource.service;

import com.github.chencye.demo.datasource.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring*.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findUsers() throws Exception {
        userService.findUsers().forEach(System.out::println);
    }

    @Test
    public void findUsers4DRUID() throws Exception {
        userService.findUsers4DRUID().forEach(System.out::println);
    }

    @Test
    public void findUsers4C3P0() throws Exception {
        userService.findUsers4C3P0().forEach(System.out::println);
    }

}