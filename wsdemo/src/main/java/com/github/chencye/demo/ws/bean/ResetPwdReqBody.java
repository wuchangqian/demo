package com.github.chencye.demo.ws.bean;

public class ResetPwdReqBody {
    private String username;
    private String newpwd;
    
    public ResetPwdReqBody() {
        super();
    }
    
    public ResetPwdReqBody(String username, String newpwd) {
        super();
        this.username = username;
        this.newpwd = newpwd;
    }
    
    @Override
    public String toString() {
        return "ResetPwdReqBody [username=" + username + ", newpwd=" + newpwd + "]";
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getNewpwd() {
        return newpwd;
    }
    
    public void setNewpwd(String newpwd) {
        this.newpwd = newpwd;
    }
    
}
