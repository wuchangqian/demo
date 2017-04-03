package com.chencye.demo.security.authentication;

import org.springframework.stereotype.Component;

import com.chencye.demo.conf.Conf;

@Component
public class PasswordEncoder implements org.springframework.security.crypto.password.PasswordEncoder {
    
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }
    
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (Conf.IS_ENCODE_FRONT.isTrue()) {
            
        }
        return encodedPassword != null && encodedPassword.equals(encode(rawPassword));
    }
    
    /**
     * 解密前端传来的数据
     */
    public String decode(CharSequence rawPassword) {
        return rawPassword.toString();
    }
    
}
