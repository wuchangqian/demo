package com.chencye.demo.security.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.csrf.CsrfFilter;

import com.chencye.demo.security.authentication.LoginUrlAuthenticationEntryPoint;
import com.chencye.demo.security.csrf.CsrfTokenResponseHeaderBindingFilter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private FilterSecurityInterceptor filterSecurityInterceptor;
    @Autowired
    private AccessDecisionManager accessDecisionManager;
    
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
    
    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;
    
    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;
    
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.addFilterBefore(filterSecurityInterceptor, FilterSecurityInterceptor.class);
        http.authorizeRequests().accessDecisionManager(accessDecisionManager);
        http.authorizeRequests().anyRequest().authenticated();
        
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
        
        http.httpBasic().authenticationEntryPoint(authenticationEntryPoint);
        
        http.formLogin().loginProcessingUrl("/login");
        http.formLogin().usernameParameter("username").passwordParameter("password");
        http.formLogin().successHandler(authenticationSuccessHandler);
        http.formLogin().failureHandler(authenticationFailureHandler);
        
        http.logout().logoutUrl("/logout");
        http.logout().invalidateHttpSession(true).deleteCookies("JSESSION");
        http.logout().logoutSuccessHandler(logoutSuccessHandler);
        
        http.addFilterAfter(new CsrfTokenResponseHeaderBindingFilter(), CsrfFilter.class);
        http.csrf().disable();
        
        // http.cors();
        
        // http.sessionManagement().sessionAuthenticationStrategy(sessionAuthenticationStrategy)
    }
    
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        // 未登录访问受限资源，转到无权限访问
        return new LoginUrlAuthenticationEntryPoint("/accessDenied");
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
    
}
