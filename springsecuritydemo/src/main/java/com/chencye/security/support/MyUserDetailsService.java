package com.chencye.security.support;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.chencye.sys.login.model.User;

/**
 * 实现 UserDetailsService 接口，主要是在 loadUserByUsername方法中获取用户账号
 * 
 * 这里需要从数据库中读取验证表单提交过来的用户
 *
 */
public class MyUserDetailsService implements UserDetailsService {
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        /*
         * final String password = "abcd1234";
         * 
         * final boolean enabled = true; // 账号是否可用 final boolean
         * accountNonExpired = true; // 账号是否未过期 final boolean
         * credentialsNonExpired = true; // 证书是否未过期 final boolean
         * accountNonLocked = true; // 账号是否未被锁定
         */
        
        // dao.findByUsername(username);
        User user = new User();
        user.setId("1");
        user.setUsername(username);
        user.setPassword("abcd1234");
        user.setStatus(0);
        
        final Set<GrantedAuthority> authorities = getAuthoritiesByUserId(user.getId()); // 权限
        
        /**
         * <pre>
         * 这是springsecurity提供的实现，下面使用自己定义的，只要实现接口UserDetails即可
         * org.springframework.security.core.userdetails.User
         * UserDetails userDetails = new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
         * </pre>
         */
        UserDetails userDetails = new MyUserDetails(user, authorities);
        
        return userDetails;
    }
    
    private Set<GrantedAuthority> getAuthoritiesByUserId(String userId) {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("SUPER"));
        return authorities;
    }
    
}
