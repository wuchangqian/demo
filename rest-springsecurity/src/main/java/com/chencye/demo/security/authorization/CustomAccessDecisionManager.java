package com.chencye.demo.security.authorization;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomAccessDecisionManager implements AccessDecisionManager {
    
    private final String ACCESS_ALL = "0";
    private final String FORBIT_ALL = "1";
    private final String SUPPER = "2";
    
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
            throws AccessDeniedException, InsufficientAuthenticationException {
        
        Collection<? extends GrantedAuthority> grantedAuthorities = authentication.getAuthorities();
        
        String authority = null;
        
        outermost: for (ConfigAttribute configAttribute : configAttributes) {
            String attribute = configAttribute.getAttribute();
            
            if (ACCESS_ALL.equals(attribute)) {
                authority = ACCESS_ALL;
                break;
            }
            if (FORBIT_ALL.equals(attribute)) {
                authority = FORBIT_ALL;
                break;
            }
            
            for (GrantedAuthority grantedAuthority : grantedAuthorities) {
                String currentAuthority = grantedAuthority.getAuthority();
                if (SUPPER.equals(currentAuthority)) {
                    authority = SUPPER;
                    break outermost;
                }
                
                if (currentAuthority.equals(attribute)) {
                    authority = currentAuthority;
                    break outermost;
                }
            }
        }
        
        if (authority == null) {
            throw new AccessDeniedException("403:AccessDenied");
        }
        
    }
    
    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }
    
    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
    
}
