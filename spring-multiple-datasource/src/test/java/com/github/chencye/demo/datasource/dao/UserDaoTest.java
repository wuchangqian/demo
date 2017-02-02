package com.github.chencye.demo.datasource.dao;

import com.github.chencye.demo.datasource.entity.User;
import com.github.chencye.demo.datasource.support.DataSource;
import com.github.chencye.demo.datasource.support.DataSourceHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring*.xml"})
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void findUsers() throws Exception {
        DataSourceHolder.setDataSource(DataSource.DRUID);
        for (User user : userDao.findUsers()) {
            System.out.println(user);
        }
        System.out.println("--------------------------");
        DataSourceHolder.clearDataSource();
        DataSourceHolder.setDataSource(DataSource.C3P0);
        for (User user : userDao.findUsers()) {
            System.out.println(user);
        }
    }

    public void findById() throws Exception {

    }

    public void saveUser() throws Exception {

    }

    public void deleteUser() throws Exception {

    }

    public void updateUser() throws Exception {

    }

}