package com.chencye.demo.security.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.csrf.CsrfFilter;

import com.chencye.demo.security.authentication.CustomLoginUrlAuthenticationEntryPoint;
import com.chencye.demo.security.authentication.LoginFailureHandler;
import com.chencye.demo.security.authentication.LoginSuccessHandler;
import com.chencye.demo.security.authentication.LogoutSuccessHandler;
import com.chencye.demo.security.authentication.UserLoaderService;
import com.chencye.demo.security.authorization.CustomAccessDeniedHandler;
import com.chencye.demo.security.authorization.CustomFilterSecurityInterceptor;
import com.chencye.demo.security.csrf.CsrfTokenResponseHeaderBindingFilter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private UserLoaderService userLoaderService;
    
    @Autowired
    private CustomFilterSecurityInterceptor customFilterSecurityInterceptor;
    
    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;
    
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    @Autowired
    private LoginFailureHandler loginFailureHandler;
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/css/**", "/js/**");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.addFilterBefore(customFilterSecurityInterceptor, FilterSecurityInterceptor.class);
        http.authorizeRequests().anyRequest().authenticated();
        
        http.exceptionHandling().accessDeniedHandler(customAccessDeniedHandler);
        
        http.httpBasic().authenticationEntryPoint(CustomLoginUrlAuthenticationEntryPoint());
        
        http.formLogin().loginProcessingUrl("/login");
        http.formLogin().usernameParameter("username").passwordParameter("password");
        http.formLogin().successHandler(loginSuccessHandler);
        http.formLogin().failureHandler(loginFailureHandler);
        
        http.logout().logoutUrl("/logout");
        http.logout().invalidateHttpSession(true).deleteCookies("JSESSION");
        http.logout().logoutSuccessHandler(logoutSuccessHandler);
        
        http.addFilterAfter(new CsrfTokenResponseHeaderBindingFilter(), CsrfFilter.class);
        http.csrf().disable();
        
        // http.cors();
        
        // http.sessionManagement().sessionAuthenticationStrategy(sessionAuthenticationStrategy)
    }
    
    @Bean
    public CustomLoginUrlAuthenticationEntryPoint CustomLoginUrlAuthenticationEntryPoint() {
        // 未登录访问受限资源，转到无权限访问
        return new CustomLoginUrlAuthenticationEntryPoint("/accessDenied");
    }
    
    @Override
    protected UserDetailsService userDetailsService() {
        return userLoaderService;
    }
}
