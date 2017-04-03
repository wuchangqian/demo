package com.chencye.demo.commons.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {
    private static final Logger logger = LoggerFactory.getLogger(JSONUtils.class);
    
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    static {
        /**
         * 默认非空才输出，时间格式
         */
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }
    
    /**
     * 将 Java 对象转为 JSON 字符串
     * 
     * @param <T>
     */
    public static <T> String toJSON(T obj) {
        String jsonStr;
        try {
            jsonStr = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("toJSON error. obj={}, error={}", obj, e);
            throw new RuntimeException(e);
        }
        return jsonStr;
    }
    
    /**
     * 将 JSON 字符串转为 Java 对象
     * 
     * @param <T>
     */
    public static <T> T fromJSON(String json, Class<T> type) {
        T obj;
        try {
            obj = (T) objectMapper.readValue(json, type);
        } catch (IOException e) {
            logger.error("fromJSON error. json={}, type={}, error={}", json, type, e);
            throw new RuntimeException(e);
        }
        return obj;
    }
    
}
