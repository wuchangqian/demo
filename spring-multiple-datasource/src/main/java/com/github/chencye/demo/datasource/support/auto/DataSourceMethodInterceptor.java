package com.github.chencye.demo.datasource.support.auto;


import com.github.chencye.demo.datasource.support.DataSource;
import com.github.chencye.demo.datasource.support.DataSourceHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DataSourceMethodInterceptor implements InitializingBean {
    private static final Logger log = LoggerFactory.getLogger(DataSourceMethodInterceptor.class);

    @Pointcut("execution(public * com.github.chencye.demo.datasource..service.*Service.*(..))")
    public void anyServiceMethod() {
    }

    @Before(value = "anyServiceMethod()")
    public void before(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();

        log.debug("methodName={}.{}", className, methodName);

        if (className.contains("JNDI") || methodName.contains("JNDI")) {
            DataSourceHolder.setDataSource(DataSource.JNDI);
        } else if (className.contains("C3P0") || methodName.contains("C3P0")) {
            DataSourceHolder.setDataSource(DataSource.C3P0);
        } else {
            DataSourceHolder.setDataSource(DataSource.JNDI);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("create a method interceptor.");
    }
}
