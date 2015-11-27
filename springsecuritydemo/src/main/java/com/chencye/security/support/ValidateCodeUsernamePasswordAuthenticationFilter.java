package com.chencye.security.support;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * 实现带验证码的登录验证，在这里还可以实现登录验证的其他参数接收和处理
 * 
 * 通过指定 processUrl 属性，指定的Url会被Spring Security拦截，登录表单数据直接提交到这个Url
 * (如果不指定，默认Url为：/j_spring_security_check)
 * 
 */
public class ValidateCodeUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    
    private static Logger log = LoggerFactory.getLogger(ValidateCodeUsernamePasswordAuthenticationFilter.class);
    
    /** 是否需要验证码 **/
    private boolean checkValidateCode = false;
    
    /** 验证码对应的表单参数名称 **/
    private String validateCodeParameter = "verifyCode";
    
    /** 验证码保存在session中的名称 **/
    private String validateCodeSessionName = "verifyCode";
    
    /** 符合此规则的URL，才进行用户名密码验证 **/
    private String processUrl = "/login";
    /** 此方式的请求，才进行用户名密码验证 **/
    private String httpMethod = "POST";
    
    /** 用户名密码验证成功，跳转的页面 注意：地址必须是 / 或 http 开头的URL地址 **/
    private String successUrl = "/loginSuccess";
    
    /** 用户名密码验证失败，中转的页面 **/
    private String failureUrl = "/loginFailure";
    
    /**
     * 初始化方法，在bean定义时，定义init-method
     */
    public void init() {
        log.info("[begin] init ValidateCodeUsernamePasswordAuthenticationFilter. usernameParameter[" + this.getUsernameParameter()
                + "], passwordParameter[" + this.getPasswordParameter() + "], checkValidateCode[" + checkValidateCode + "], validateCodeParameter["
                + validateCodeParameter + "], validateCodeSessionName[" + validateCodeSessionName + "], processUrl[" + processUrl + "], httpMethod["
                + httpMethod + "], successUrl[" + successUrl + "], failureUrl[" + failureUrl + "]");
                
        // 验证成功，跳转的页面
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setDefaultTargetUrl(successUrl);
        this.setAuthenticationSuccessHandler(successHandler);
        
        // 验证失败，跳转的页面
        SimpleUrlAuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();
        failureHandler.setDefaultFailureUrl(failureUrl);
        this.setAuthenticationFailureHandler(failureHandler);
        
        // 符合此规则的请求，才进行用户名密码验证
        RequestMatcher requiresAuthenticationRequestMatcher = new RegexRequestMatcher(processUrl, httpMethod);
        super.setRequiresAuthenticationRequestMatcher(requiresAuthenticationRequestMatcher);
        
        log.info("[end] init ValidateCodeUsernamePasswordAuthenticationFilter.");
    }
    
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        // 是否需要校验验证码
        if (checkValidateCode) {
            checkValidateCode(request);
        }
        return super.attemptAuthentication(request, response);
    }
    
    protected void checkValidateCode(HttpServletRequest request) {
        String sessionValidateCode = obtainSessionValidateCode(request);
        String validateCodeParameter = obtainValidateCodeParameter(request);
        // 验证码输入不能为空，不区分大小写
        if (StringUtils.isBlank(validateCodeParameter) || !sessionValidateCode.equalsIgnoreCase(validateCodeParameter)) {
            throw new AuthenticationServiceException(messages.getMessage("validateCode.notEquals"));
        }
    }
    
    private String obtainValidateCodeParameter(HttpServletRequest request) {
        return request.getParameter(validateCodeParameter);
    }
    
    protected String obtainSessionValidateCode(HttpServletRequest request) {
        Object sessionCode = request.getSession().getAttribute(validateCodeSessionName);
        return null == sessionCode ? "" : sessionCode.toString();
    }
    
    public boolean isCheckValidateCode() {
        return checkValidateCode;
    }
    
    public void setCheckValidateCode(boolean checkValidateCode) {
        this.checkValidateCode = checkValidateCode;
    }
    
    public String getValidateCodeParameter() {
        return validateCodeParameter;
    }
    
    public void setValidateCodeParameter(String validateCodeParameter) {
        this.validateCodeParameter = validateCodeParameter;
    }
    
    public String getValidateCodeSessionName() {
        return validateCodeSessionName;
    }
    
    public void setValidateCodeSessionName(String validateCodeSessionName) {
        this.validateCodeSessionName = validateCodeSessionName;
    }
    
    public String getProcessUrl() {
        return processUrl;
    }
    
    public void setProcessUrl(String processUrl) {
        this.processUrl = processUrl;
    }
    
    public String getHttpMethod() {
        return httpMethod;
    }
    
    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }
    
    public String getSuccessUrl() {
        return successUrl;
    }
    
    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }
    
    public String getFailureUrl() {
        return failureUrl;
    }
    
    public void setFailureUrl(String failureUrl) {
        this.failureUrl = failureUrl;
    }
}
