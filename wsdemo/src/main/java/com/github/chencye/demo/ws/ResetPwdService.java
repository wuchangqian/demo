package com.github.chencye.demo.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.github.chencye.demo.ws.bean.ResetPwdReq;
import com.github.chencye.demo.ws.bean.ResetPwdRsp;

@WebService(name = "resetpwdServer", serviceName = "resetpwdService", portName = "resetpwdServicePort", targetNamespace = "http://demo.chencye.github.com")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface ResetPwdService {
    
    @WebMethod(action = "resetpwd", operationName = "resetpwdreq")
    @WebResult(name = "resetpwdrsp", partName = "resetpwdrsp")
    public ResetPwdRsp resetPwd(@WebParam(name = "resetpwdreq") ResetPwdReq resetpwdreq);
}
