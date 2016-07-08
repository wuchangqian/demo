package com.github.chencye.demo.ws;

import java.util.Date;

import javax.jws.WebService;

import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.chencye.demo.ws.bean.ResetPwdReq;
import com.github.chencye.demo.ws.bean.ResetPwdRsp;
import com.github.chencye.demo.ws.bean.ResetPwdRspBody;
import com.github.chencye.demo.ws.common.MsgReqHeader;
import com.github.chencye.demo.ws.common.MsgRspHeader;
import com.github.chencye.demo.ws.common.RetInfo;

@WebService(endpointInterface = "com.github.chencye.demo.ws.ResetPwdService")
public class ResetPwdServiceImpl implements ResetPwdService {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    
    @Override
    public ResetPwdRsp resetPwd(ResetPwdReq resetpwdreq) {
        log.info("resetPwd request. resetpwdreq={}", resetpwdreq);
        
        MsgReqHeader reqHeader = resetpwdreq.getHeader();
        
        RetInfo retInfo = new RetInfo(0, 0, "success");
        
        MsgRspHeader rspHeader = new MsgRspHeader();
        rspHeader.setProcessCode(reqHeader.getProcessCode());
        rspHeader.setSequence(reqHeader.getSequence());
        rspHeader.setRspTime(FastDateFormat.getInstance("yyyyMMddHHmmssSSS").format(new Date()));
        rspHeader.setRetInfo(retInfo);
        
        ResetPwdRspBody rspBody = new ResetPwdRspBody();
        
        ResetPwdRsp resetpwdrsp = new ResetPwdRsp();
        resetpwdrsp.setHeader(rspHeader);
        resetpwdrsp.setBody(rspBody);
        
        log.info("resetPwd response. resetpwdrsp={}", resetpwdrsp);
        
        return resetpwdrsp;
    }
    
}
