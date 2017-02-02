package com.chencye.demo.system.datasource;

public enum DataSourceName {
    
    /** 数据源1 **/
    DataSource1(""),
    
    /** 数据源2 **/
    DataSrouce2(""),
    
    /** end **/
    ;
    
    private String name;
    
    private DataSourceName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
