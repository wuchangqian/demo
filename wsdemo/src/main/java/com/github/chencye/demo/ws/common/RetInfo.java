package com.github.chencye.demo.ws.common;

public class RetInfo {
    private int retCode;
    private int retType;
    private String retMsg;
    
    public RetInfo() {
        super();
    }
    
    public RetInfo(int retCode, int retType, String retMsg) {
        super();
        this.retCode = retCode;
        this.retType = retType;
        this.retMsg = retMsg;
    }
    
    @Override
    public String toString() {
        return "RetInfo [retCode=" + retCode + ", retType=" + retType + ", retMsg=" + retMsg + "]";
    }
    
    public int getRetCode() {
        return retCode;
    }
    
    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }
    
    public int getRetType() {
        return retType;
    }
    
    public void setRetType(int retType) {
        this.retType = retType;
    }
    
    public String getRetMsg() {
        return retMsg;
    }
    
    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }
    
}
