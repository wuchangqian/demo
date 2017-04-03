package com.chencye.demo.security.authorization;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

@Component
public class FilterSecurityInterceptor extends org.springframework.security.web.access.intercept.FilterSecurityInterceptor {
    
    @Autowired
    private AccessDecisionManager accessDecisionManager;
    
    @Autowired
    private FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;
    
    @PostConstruct
    public void init() {
        super.setSecurityMetadataSource(filterInvocationSecurityMetadataSource);
        super.setAccessDecisionManager(accessDecisionManager);
    }
    
    @Override
    public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
        return filterInvocationSecurityMetadataSource;
    }
    
    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return filterInvocationSecurityMetadataSource;
    }
    
    @Override
    public AccessDecisionManager getAccessDecisionManager() {
        return accessDecisionManager;
    }
    
}
