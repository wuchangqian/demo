package com.chencye.demo.logback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogbackController {
    
    private final static Logger log = LoggerFactory.getLogger(LogbackController.class);
    
    @RequestMapping("logback")
    public String testLogback() {
        for (int i = 0; i < 1000; i++) {
            log.debug("[debug] testLogback.");
            log.info("[info] testLogback.");
            log.warn("[warn] testLogback.");
            log.error("[error] testLogback.");
        }
        System.out.println("--------test----------");
        log.info("[end] testLogback.");
        return "index";
    }
}
