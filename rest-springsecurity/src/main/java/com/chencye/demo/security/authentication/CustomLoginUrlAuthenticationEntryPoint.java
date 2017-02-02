package com.chencye.demo.security.authentication;

import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

/**
 * <pre>
 *  由于前后端分离，未登录访问受限资源时，不能进行重写向，这里设置使用forward
 * </pre>
 * 
 * @author chencye
 *
 */
public class CustomLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {
    
    public CustomLoginUrlAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
        super.setUseForward(true);
    }
    
}
