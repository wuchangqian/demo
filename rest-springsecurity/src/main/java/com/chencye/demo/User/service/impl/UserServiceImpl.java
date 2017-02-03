package com.chencye.demo.User.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chencye.demo.User.bean.User;
import com.chencye.demo.User.dao.UserMapper2;
import com.chencye.demo.User.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper2 userMapper;
    
    @Override
    public PageInfo<User> list(int pageNum, int pageSize) {
        //获取第1页，10条内容，默认查询总数count
        pageSize = pageSize == 0 ? 2 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userMapper.list();;
        //用PageInfo对结果进行包装
        PageInfo<User> page = new PageInfo<>(list);
        //测试PageInfo全部属性
        //PageInfo包含了非常全面的分页属性
        
        System.out.println(page.getPageNum());
        System.out.println(page.getPageSize());
        System.out.println(page.getStartRow());
        System.out.println(page.getEndRow());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.isHasPreviousPage());
        System.out.println(page.isHasNextPage());
        System.out.println(page.isIsFirstPage());
        System.out.println(page.isIsLastPage());
        return page;
    }
    
}
