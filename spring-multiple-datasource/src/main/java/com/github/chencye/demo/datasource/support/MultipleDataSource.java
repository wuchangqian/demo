package com.github.chencye.demo.datasource.support;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultipleDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        String dataSourceName = DataSourceHolder.getDataSourceName();
        System.out.println("dataSourceName : " + dataSourceName);
        return dataSourceName;
    }
}
