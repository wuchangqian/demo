package com.chencye.demo.security.authorization;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.stereotype.Component;

@Component
public class CustomFilterSecurityInterceptor extends FilterSecurityInterceptor {
    
    @Autowired
    private CustomAccessDecisionManager customAccessDecisionManager;
    
    @Autowired
    private CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;
    
    @PostConstruct
    public void init() {
        super.setSecurityMetadataSource(customFilterInvocationSecurityMetadataSource);
        super.setAccessDecisionManager(customAccessDecisionManager);
    }
    
    @Override
    public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
        return customFilterInvocationSecurityMetadataSource;
    }
    
    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return customFilterInvocationSecurityMetadataSource;
    }
    
    @Override
    public AccessDecisionManager getAccessDecisionManager() {
        return customAccessDecisionManager;
    }
    
}
