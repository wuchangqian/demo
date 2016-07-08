package com.github.chencye.demo.ws.bean;

import com.github.chencye.demo.ws.common.MsgReqHeader;

public class ResetPwdReq {
    private MsgReqHeader header;
    private ResetPwdReqBody body;
    
    public ResetPwdReq() {
        super();
    }
    
    public ResetPwdReq(MsgReqHeader header, ResetPwdReqBody body) {
        super();
        this.header = header;
        this.body = body;
    }
    
    @Override
    public String toString() {
        return "ResetPwdReq [header=" + header + ", body=" + body + "]";
    }
    
    public MsgReqHeader getHeader() {
        return header;
    }
    
    public void setHeader(MsgReqHeader header) {
        this.header = header;
    }
    
    public ResetPwdReqBody getBody() {
        return body;
    }
    
    public void setBody(ResetPwdReqBody body) {
        this.body = body;
    }
    
}
