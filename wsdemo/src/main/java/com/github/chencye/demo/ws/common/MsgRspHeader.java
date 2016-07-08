package com.github.chencye.demo.ws.common;

public class MsgRspHeader {
    private String processCode;
    private String sequence;
    private String rspTime;
    private RetInfo retInfo;
    
    public MsgRspHeader() {
        super();
    }
    
    public MsgRspHeader(String processCode, String sequence, String rspTime, RetInfo retInfo) {
        super();
        this.processCode = processCode;
        this.sequence = sequence;
        this.rspTime = rspTime;
        this.retInfo = retInfo;
    }
    
    @Override
    public String toString() {
        return "MsgRspHeader [processCode=" + processCode + ", sequence=" + sequence + ", rspTime=" + rspTime + ", retInfo=" + retInfo + "]";
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
    
    public String getRspTime() {
        return rspTime;
    }
    
    public void setRspTime(String rspTime) {
        this.rspTime = rspTime;
    }
    
    public RetInfo getRetInfo() {
        return retInfo;
    }
    
    public void setRetInfo(RetInfo retInfo) {
        this.retInfo = retInfo;
    }
    
}
