package com.chencye.demo.commons.bean;

import com.chencye.demo.conf.RetCode;

public class ReturnBean<T> {
    
    private int returnCode;
    private String returnMessage;
    private T value;
    
    public ReturnBean() {
    }
    
    public ReturnBean(int returnCode, String returnMessage) {
        super();
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
    }
    
    public ReturnBean(int returnCode, String returnMessage, T value) {
        super();
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
        this.value = value;
    }
    
    public ReturnBean(RetCode retCode) {
        super();
        this.returnCode = retCode.getCode();
        this.returnMessage = retCode.getMessage();
    }
    
    public ReturnBean(T value) {
        super();
        this.value = value;
    }
    
    public int getReturnCode() {
        return returnCode;
    }
    
    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }
    
    public String getReturnMessage() {
        return returnMessage;
    }
    
    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }
    
    public T getValue() {
        return value;
    }
    
    public void setValue(T value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "ReturnBean [returnCode=" + returnCode + ", returnMessage=" + returnMessage + ", value=" + value + "]";
    }
    
}
