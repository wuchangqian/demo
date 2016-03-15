package com.chencye.demo.hotpublish.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogbackController {
    
    private final static Logger log = LoggerFactory.getLogger(LogbackController.class);
    
    @Value("${env.name}")
    private String envName;
    
    @RequestMapping("logback")
    public ModelAndView testLogback() {
        
        for (int i = 0; i < 1; i++) {
            log.debug("[debug] testLogback. current environment is {}", envName);
            log.info("[info] testLogback. current environment is {}", envName);
            log.warn("[warn] testLogback. current environment is {}", envName);
            log.error("[error] testLogback. current environment is {}", envName);
        }
        
        ModelAndView mv = new ModelAndView();
        mv.addObject("envName", envName);
        mv.setViewName("index");
        return mv;
    }
}
