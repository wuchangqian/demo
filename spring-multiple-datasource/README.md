# spring 多数据源配置 

## 在代码中手动切换  

**主要是实现`org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource`**  

1. 代码实现  
`com.github.chencye.demo.datasource.support.MultipleDataSource` 实现`AbstractRoutingDataSource`  
`com.github.chencye.demo.datasource.support.DataSourceHolder` 使用`ThreadLocal`存储当前使用的数据源  
`com.github.chencye.demo.datasource.support.DataSource` 数据源枚举  

2. 在spring-datasource.xml中配置多个数据源，如druidDataSource、c3p0DataSource  

3. 配置multipleDataSource  

4. 测试代码

## 使用AOP自动切换  
