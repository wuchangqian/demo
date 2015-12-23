###测试logback，当前只是测试是否能正常使用

测试方法：
启动tomcat后，访问如下链接
[http://localhost:8080/logbackdemo/logback](http://localhost:8080/logbackdemo/logback)

生成日志的代码如下
```java
for (int i = 0; i < 20000; i++) {
    log.debug("[debug] testLogback.");
    log.info("[info] testLogback." + i);
    log.warn("[warn] testLogback." + i);
    log.error("[error] testLogback." + i);
}
```

配置的是info，大概会生成6M的日志。
配置的最大日志文件为10M，所以**第二次访问链接时，会生成一个压缩文件**