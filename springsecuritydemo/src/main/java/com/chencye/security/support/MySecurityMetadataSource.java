package com.chencye.security.support;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.chencye.sys.resource.model.Resource;
import com.chencye.sys.resource.service.ResourceService;
import com.chencye.sys.role.model.Role;
import com.chencye.sys.role.service.RoleService;

/**
 * <pre>
 * [核心处理逻辑]
 * 
 * 资源源数据定义，即定义某一资源可以被哪些角色访问
 * 建立资源与权限的对应关系
 * 
 * 也可以直接使用Spring提供的类 DefaultFilterInvocationSecurityMetadataSource
 * </pre>
 * 
 */
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    
    private static Map<RequestMatcher, Collection<ConfigAttribute>> resourceMap = new HashMap<RequestMatcher, Collection<ConfigAttribute>>();
    
    @Autowired
    private RoleService roleService;
    
    @Autowired
    private ResourceService resourceService;
    
    /**
     * <pre>
     * 初始化资源配置
     * 
     * spring 调用该方法的方式有2种
     * 方式1，方法上加注解：
     * &#64;PostConstruct
     * 
     * 方式2，配置文件中 init-method 属性指定：
     * <beans:bean id="mySecurityMetadataSource" init-method="init" class="com.chencye.security.support.MySecurityMetadataSource"/>
     * </pre>
     */
    public void init() {
        
        resourceMap.clear();
        
        // 取得当前系统所有可用角色
        List<Role> roles = this.roleService.getAvailableRoles();
        for (Role role : roles) {
            this.loadResource(role);
        }
    }
    
    private void loadResource(Role role) {
        // 这里的role参数为自己定义的，要和UserDetailsService中的SimpleGrantedAuthority参数对应
        // role 参数也可以直接使用角色名
        ConfigAttribute ca = new SecurityConfig(role.getName());
        // 取角色有哪些资源的权限
        List<Resource> resources = resourceService.loadResourceByRoleId(role.getId());
        for (Resource resource : resources) {
            String url = resource.getUrl();
            if (StringUtils.isBlank(url)) {
                continue;
            }
            
            RequestMatcher requestMatcher = new AntPathRequestMatcher(url);
            
            // 如果是URL资源，则建立角色与资源关系
            if (resourceMap.containsKey(requestMatcher)) {
                resourceMap.get(requestMatcher).add(ca);
            } else {
                Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
                atts.add(ca);
                resourceMap.put(requestMatcher, atts);
            }
        }
    }
    
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        final HttpServletRequest request = ((FilterInvocation) object).getRequest();
        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : resourceMap.entrySet()) {
            if (entry.getKey().matches(request)) {
                return entry.getValue();
            }
        }
        return null;
    }
    
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();
        
        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : resourceMap.entrySet()) {
            allAttributes.addAll(entry.getValue());
        }
        
        return allAttributes;
    }
    
    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
    
    public void reloadResource() {
        this.init();
    }
    
}
