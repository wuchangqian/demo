package com.chencye.demo.security.authorization;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccessController {
    
    @RequestMapping("accessDenied")
    public String accessDenied() {
        return "403:forbidden";
    }
    
}
