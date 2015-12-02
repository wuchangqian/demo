package com.chencye.security.support;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.chencye.sys.login.model.User;

/**
 * <pre>
 * 该类实现 UserDetails 接口，该类在验证成功后会被保存在当前回话的principal对象中
 * 
 * 获得对象的方式：
 * MyUserDetails myUserDetails = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 * 
 * 或在JSP中：
 * <sec:authentication property="principal.username"/>
 * 
 * 如果需要包括用户的其他属性，可以在该类中增加相应属性即可
 * </pre>
 *
 */
public class MyUserDetails implements UserDetails {
    private static final long serialVersionUID = 3488051330239389328L;
    
    private User user;
    
    private Collection<GrantedAuthority> authorities;
    
    public MyUserDetails() {
        super();
    }
    
    public MyUserDetails(User user, Collection<GrantedAuthority> authorities) {
        super();
        this.user = user;
        this.authorities = authorities;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    
    @Override
    public String getPassword() {
        return user.getPassword();
    }
    
    @Override
    public String getUsername() {
        return user.getUsername();
    }
    
    @Override
    public boolean isAccountNonExpired() {
        // -1删除，0正常，1过期，2证书过期，3禁用
        return user.getStatus() != 1;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return user.getStatus() != 3;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return user.getStatus() != 2;
    }
    
    @Override
    public boolean isEnabled() {
        return user.getStatus() == 0;
    }
    
    public User getUser() {
        return user;
    }
    
}
