package com.chencye.sys.role.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chencye.sys.role.model.Role;
import com.chencye.sys.role.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    
    @Override
    public List<Role> getAvailableRoles() {
        List<Role> roles = new ArrayList<Role>();
        Role role1 = new Role();
        role1.setId("1");
        role1.setName("super");
        
        Role role2 = new Role();
        role2.setId("2");
        role2.setName("user");
        
        roles.add(role1);
        roles.add(role2);
        
        return roles;
    }
    
}
