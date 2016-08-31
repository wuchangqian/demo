package com.github.chencye.demo.config.bean;

public class ConfigParamBean {
    private String key;
    private String name;
    private String value;
    private String enable;
    private String remark;

    public ConfigParamBean() {
    }

    @Override
    public String toString() {
        return "ConfigParamBean{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", enable='" + enable + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
