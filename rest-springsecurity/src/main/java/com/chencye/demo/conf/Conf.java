package com.chencye.demo.conf;

public enum Conf {
    /** 前端数据是否加密：仅针对可能需要加密的时候 **/
    IS_ENCODE_FRONT(true),
    /** 数据库数据是否加密：仅针对可能需要加密的时候 **/
    IS_ENCODE_DB(true),
    
    /* end */
    ;
    
    private Object value;
    
    private Conf(Object value) {
        this.value = value;
    }
    
    @SuppressWarnings("unchecked")
    public <T> T val() {
        return (T) value;
    }
    
    public <T> T val(Class<T> clazz) {
        return clazz.cast(value);
    }
    
    public boolean isTrue() {
        return (boolean) value;
    }
    
}
