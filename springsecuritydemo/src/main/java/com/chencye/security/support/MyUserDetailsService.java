package com.chencye.security.support;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        final String password = "abcd1234";
        final boolean enabled = true; // 账号是否可用
        final boolean accountNonExpired = true; // 账号是否未过期
        final boolean credentialsNonExpired = true; // 证书是否未过期
        final boolean accountNonLocked = true; // 账号是否未被锁定
        
        final Set<GrantedAuthority> authorities = getAuthoritiesByUserId("1"); // 权限
        
        UserDetails userDetails = new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        
        return userDetails;
    }
    
    private Set<GrantedAuthority> getAuthoritiesByUserId(String userId) {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("SUPER"));
        return authorities;
    }
    
}
