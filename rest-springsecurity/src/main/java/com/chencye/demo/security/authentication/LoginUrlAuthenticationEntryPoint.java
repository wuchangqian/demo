package com.chencye.demo.security.authentication;


/**
 * <pre>
 *  由于前后端分离，未登录访问受限资源时，不能进行重写向，这里设置使用forward
 * </pre>
 * 
 * @author chencye
 *
 */
public class LoginUrlAuthenticationEntryPoint extends org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint {
    
    public LoginUrlAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
        super.setUseForward(true);
    }
    
}
