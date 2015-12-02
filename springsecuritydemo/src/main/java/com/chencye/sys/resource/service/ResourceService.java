package com.chencye.sys.resource.service;

import java.util.List;

import com.chencye.sys.resource.model.Resource;

public interface ResourceService {
    
    List<Resource> loadResourceByRoleId(String roleId);
    
}
