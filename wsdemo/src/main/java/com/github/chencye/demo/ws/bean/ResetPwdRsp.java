package com.github.chencye.demo.ws.bean;

import com.github.chencye.demo.ws.common.MsgRspHeader;

public class ResetPwdRsp {
    private MsgRspHeader header;
    private ResetPwdRspBody body;
    
    public ResetPwdRsp() {
        super();
    }
    
    public ResetPwdRsp(MsgRspHeader header, ResetPwdRspBody body) {
        super();
        this.header = header;
        this.body = body;
    }
    
    @Override
    public String toString() {
        return "ResetPwdRsp [header=" + header + ", body=" + body + "]";
    }
    
    public MsgRspHeader getHeader() {
        return header;
    }
    
    public void setHeader(MsgRspHeader header) {
        this.header = header;
    }
    
    public ResetPwdRspBody getBody() {
        return body;
    }
    
    public void setBody(ResetPwdRspBody body) {
        this.body = body;
    }
    
}
