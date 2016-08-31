package com.github.chencye.demo.datasource.support;

public final class DataSourceHolder {

    private static final ThreadLocal<String> holder = new ThreadLocal<>();

    public static void setDataSource(DataSource dataSource) {
        holder.set(dataSource.getName());
    }

    public static String getDataSourceName() {
        return holder.get();
    }

    public static void clearDataSource() {
        holder.remove();
    }
}
