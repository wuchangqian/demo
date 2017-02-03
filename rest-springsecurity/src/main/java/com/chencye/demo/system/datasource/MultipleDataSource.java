package com.chencye.demo.system.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultipleDataSource extends AbstractRoutingDataSource {
    
    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceName dataSourceName = DataSourceHolder.get();
        return dataSourceName == null ? null : dataSourceName.getName();
    }
}
