package com.chencye.demo.system.datasource;

public class DataSourceHolder {
    private static ThreadLocal<DataSourceName> dataSource = new ThreadLocal<>();
    
    private DataSourceHolder() {
        
    }
    
    public static void set(DataSourceName dataSourceName) {
        dataSource.set(dataSourceName);
    }
    
    public static DataSourceName get() {
        return dataSource.get();
    }
}
