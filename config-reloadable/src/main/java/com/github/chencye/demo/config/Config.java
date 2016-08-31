package com.github.chencye.demo.config;

import com.github.chencye.demo.config.bean.ConfigBean;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Config {

    private static final Map<String, String> map = new ConcurrentHashMap<>();

    private static final Map<String, Integer> boolMap = new ConcurrentHashMap<>();
    private static final Map<String, Integer> intMap = new ConcurrentHashMap<>();
    private static final Map<String, Integer> doubleMap = new ConcurrentHashMap<>();
    private static final Map<String, Integer> patternMap = new ConcurrentHashMap<>();
    private static final Map<String, Integer> charsetMap = new ConcurrentHashMap<>();

    public static void init(Collection<ConfigBean> configs) {
        if (configs == null) {
            return;
        }
        for (ConfigBean configBean : configs) {
            if (configBean == null) {
                continue;
            }
            map.put(configBean.getKey(), configBean.getValue());
        }
    }

    public static final String get(String key) {
        return map.get(key);
    }

    public static final String get(String key, String defaultValue) {
        String value = get(key);
        return value == null ? defaultValue : value;
    }

    public static final int getInt(String key) {
        String value = get(key);
        return NumberUtils.toInt(value);
    }

    public static final int getInt(String key, int defaultValue) {
        String value = get(key);
        return NumberUtils.toInt(value, defaultValue);
    }

}
