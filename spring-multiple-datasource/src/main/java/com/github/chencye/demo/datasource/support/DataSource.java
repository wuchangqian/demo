package com.github.chencye.demo.datasource.support;

public enum DataSource {
    JNDI("jndiDataSource"), DRUID("druidDataSource"), C3P0("c3p0DataSource");

    private String name;

    private DataSource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
