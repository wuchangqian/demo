package com.chencye.demo.conf;

/**
 * <pre>
 * 返回码
 * 小于4位为通用返回码
 * 0 操作成功
 * 1 操作失败
 * 110 恶意攻击
 * 120 未登录或会话过期
 * 250 用户名或密码错误
 * 403 权限不足
 * 500 服务器繁忙
 * 
 * 
 * 
 * 1xxx: 系统管理
 *      10xx: 用户登录及用户管理
 *      11xx: 角色管理
 *      12xx: 权限管理
 *      13xx: 资源管理
 *      14xx: 菜单管理
 * </pre>
 * 
 * @author chencye
 *
 */
public enum RetCode {
    
    /** 操作成功 **/
    SUCCESS(0, "success"),
    /** 操作失败 **/
    FAILURE(1, "failure"),
    /** 恶意攻击 **/
    ATTACK(110, "attack"),
    /** 会话过期 **/
    TO_LOGIN(120, "unlogin or session expire"),
    /** 用户名或密码错误 **/
    LOGIN_FAILED(250, "wrong username or passowrd"),
    /** 权限不足 **/
    ACCESS_DENIED(403, "access denied"),
    /** 服务器繁忙 **/
    SYSTEM_BUSY(500, "服务器繁忙"),
    
    /* end */
    ;
    
    private int code;
    private String message;
    
    private RetCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public int getCode() {
        return code;
    }
    
    public void setCode(int code) {
        this.code = code;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
}
