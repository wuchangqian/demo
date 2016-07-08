package com.chencye.demo.logback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogbackController implements EnvironmentAware {
    
    private final static Logger log = LoggerFactory.getLogger(LogbackController.class);
    
    private Environment environment;
    
    @RequestMapping("logback")
    public ModelAndView testLogback() {
        
        for (int i = 0; i < 1; i++) {
            log.debug("[debug] testLogback.");
            log.info("[info] testLogback." + i);
            log.warn("[warn] testLogback." + i);
            log.error("[error] testLogback." + i);
        }
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
