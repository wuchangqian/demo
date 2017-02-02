package com.chencye.demo.system.datasource.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.chencye.demo.system.datasource.DataSourceHolder;
import com.chencye.demo.system.datasource.DataSourceName;
import com.chencye.demo.system.datasource.annotation.DataSource;

/**
 * <pre>
 * <b>通过注解自动切换数据源</b>
 * 以最近原则取得注解内容：方法 > 类 > 接口
 * 若无注解，则使用spring-datasource.xml中配置的默认数据源
 * </pre>
 * 
 * @author chencye
 *
 */
@Component
@Aspect
public class AutoDataSourceAspect {
    private static final Logger log = LoggerFactory.getLogger(AutoDataSourceAspect.class);
    
    @Pointcut("@annotation(com.chencye.demo.system.datasource.annotation.DataSource)")
    public void dataSourceMethod() {
        
    }
    
    @Around("dataSourceMethod()")
    public Object around(ProceedingJoinPoint pjd) {
        Object result = null;
        try {
            DataSourceName dataSourceName = getDataSourceName(pjd);
            DataSourceName originDataSourceName = DataSourceHolder.get();
            DataSourceHolder.set(dataSourceName);
            result = pjd.proceed();
            DataSourceHolder.set(originDataSourceName);
        } catch (Throwable e) {
            log.error("set dataSource error.", e);
        }
        return result;
    }
    
    private DataSourceName getDataSourceName(ProceedingJoinPoint pjd) throws NoSuchMethodException, SecurityException {
        DataSourceName dataSourceName = null;
        Class<?> target = pjd.getTarget().getClass();
        for (Class<?> clazz : target.getInterfaces()) {
            if (clazz.isAnnotationPresent(DataSource.class)) {
                dataSourceName = clazz.getAnnotation(DataSource.class).value();
                log.debug("getDataSourceName on interface. class={}, dataSourceName={}", clazz.getName(), dataSourceName.getName());
                break;
            }
        }
        
        if (target.isAnnotationPresent(DataSource.class)) {
            dataSourceName = target.getAnnotation(DataSource.class).value();
            log.debug("getDataSourceName on class. class={}, dataSourceName={}", target.getName(), dataSourceName.getName());
        }
        
        /**
         * <code>
         Method method = ((MethodSignature) pjd.getSignature()).getMethod();
         Method targetMethod = target.getMethod(method.getName(), method.getParameterTypes());
         if (targetMethod.isAnnotationPresent(DataSource.class)) {
             dataSourceName = target.getAnnotation(DataSource.class).value();
             log.debug("getDataSourceName on method. class={}, method={} dataSourceName={}", target.getName(), method.getName(),
                     dataSourceName.getName());
         }
         </code>
         **/
        return dataSourceName;
    }
    
}
