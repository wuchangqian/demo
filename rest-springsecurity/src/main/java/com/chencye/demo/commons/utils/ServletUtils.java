package com.chencye.demo.commons.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chencye.demo.commons.bean.ReturnBean;
import com.chencye.demo.conf.RetCode;

public final class ServletUtils {
    private static final Logger log = LoggerFactory.getLogger(ServletUtils.class);
    
    public static void write(HttpServletResponse response, ReturnBean<?> returnBean) {
        try {
            response.getWriter().write(JSONUtils.toJSON(returnBean));
        } catch (IOException e) {
            log.error("write error.", e);
        }
    }
    
    public static void write(HttpServletResponse response, RetCode retCode) {
        try {
            response.getWriter().write(JSONUtils.toJSON(new ReturnBean<>(retCode)));
        } catch (IOException e) {
            log.error("write error.", e);
        }
    }
    
}
