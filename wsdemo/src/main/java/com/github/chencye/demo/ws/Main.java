package com.github.chencye.demo.ws;

import javax.xml.ws.Endpoint;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    
    private static final String DEFAULT_ADDRESS = "http://localhost:8088/ws";
    
    public static void main(String[] args) {
        String address = DEFAULT_ADDRESS;
        if (ArrayUtils.isNotEmpty(args)) {
            address = args[0];
        }
        
        log.info("Endpoint publish, address={}", address);
        ResetPwdService service = new ResetPwdServiceImpl();
        Endpoint.publish(address, service);
        log.info("Endpoint running...");
        
    }
}
