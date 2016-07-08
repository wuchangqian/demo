package com.github.chencye.demo.ws.common;

public class MsgReqHeader {
    private String name;
    private String key;
    private String processCode;
    private String sequence;
    private String reqTime;
    
    public MsgReqHeader() {
        super();
    }
    
    @Override
    public String toString() {
        return "MsgReqHeader [name=" + name + ", key=" + key + ", processCode=" + processCode + ", sequence=" + sequence + ", reqTime=" + reqTime
                + "]";
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getKey() {
        return key;
    }
    
    public void setKey(String key) {
        this.key = key;
    }
    
    public String getProcessCode() {
        return processCode;
    }
    
    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }
    
    public String getSequence() {
        return sequence;
    }
    
    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
    
    public String getReqTime() {
        return reqTime;
    }
    
    public void setReqTime(String reqTime) {
        this.reqTime = reqTime;
    }
    
}
