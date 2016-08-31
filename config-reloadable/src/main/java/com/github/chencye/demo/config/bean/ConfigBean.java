package com.github.chencye.demo.config.bean;

import java.util.Set;

public class ConfigBean {
    private String module;
    private String usage;
    private String key;
    private String value;
    private char enable;
    private String remark;

    private Set<ConfigParamBean> params;

    public ConfigBean() {
    }

    @Override
    public String toString() {
        return "ConfigBean{" +
                "module='" + module + '\'' +
                ", usage='" + usage + '\'' +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", enable=" + enable +
                ", remark='" + remark + '\'' +
                ", params=" + params +
                '}';
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public char getEnable() {
        return enable;
    }

    public void setEnable(char enable) {
        this.enable = enable;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<ConfigParamBean> getParams() {
        return params;
    }

    public void setParams(Set<ConfigParamBean> params) {
        this.params = params;
    }
}
