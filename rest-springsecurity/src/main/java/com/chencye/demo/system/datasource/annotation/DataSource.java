package com.chencye.demo.system.datasource.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.chencye.demo.system.datasource.DataSourceName;

@Documented
@Retention (RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DataSource {
    
    DataSourceName value();
}
