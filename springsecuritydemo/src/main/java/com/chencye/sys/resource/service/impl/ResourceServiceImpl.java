package com.chencye.sys.resource.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chencye.sys.resource.model.Resource;
import com.chencye.sys.resource.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {
    
    @Override
    public List<Resource> loadResourceByRoleId(String roleId) {
        
        List<Resource> resources = new ArrayList<Resource>();
        
        Resource resource1 = new Resource();
        resource1.setId("1");
        resource1.setName("保存");
        resource1.setUrl("/save");
        
        Resource resource2 = new Resource();
        resource2.setId("2");
        resource2.setName("删除");
        resource2.setUrl("/del");
        
        resources.add(resource1);
        resources.add(resource2);
        
        return resources;
    }
    
}
