### Eclipse中的Maven项目一键部署到Tomcat服务器 - 支持多环境部署
[http://blog.csdn.net/chwshuang/article/details/48499231](http://blog.csdn.net/chwshuang/article/details/48499231)

### 执行命令
#### 打包研发环境
`clean package -Pdevelopment`
#### 部署研发环境
`clean package cargo:redeploy -Pdevelopment`
#### 打包测试环境
`clean package -Ptest`
#### 部署测试环境
`clean package cargo:redeploy -Ptest`

### Maven pom.xml文件【Run As】自定义指令运行配置
 **说明：**
Name: 显示名称
Base directory:  项目绝对地址目录
Goals: maven执行指令 指令中的-D表示参数，如果是研发环境就是dev，测试就是test
Skip Tests  表示选中跳过测试
**1. 研发环境打包指令**
Name: hotpublish-dev-package
Base directory: D:/git/chencye/demo/hotpublish
Goals: clean package -Pdevelopment
Skip Tests
**2. 研发环境部署指令**
Name: hotpublish-dev-deploy
Base directory: D:/git/chencye/demo/hotpublish
Goals: cargo:redeploy -Pdevelopment
Skip Tests
**3. 测试环境打包指令**
Name: hotpublish-test-package
Base directory: D:/git/chencye/demo/hotpublish
Goals: clean package -Ptest
Skip Tests
**4. 测试环境部署指令**
Name: hotpublish-test-deploy
Base directory: D:/git/chencye/demo/hotpublish
Goals: cargo:redeploy -Ptest
Skip Tests

### Tomcat自动部署支持
需要在Tomcat配置目录conf下的tomcat-users.xml配置tomcat用户的角色和权限，下面的配置为我们tomcat-username这个用户配置了管理权限，可以向tomcat部署应用
```xml
<?xml version="1.0" encoding="UTF-8"?>
<tomcat-users>
    <role rolename="manager-script"/>
    <role rolename="manager-jmx"/>
    <role rolename="manager-status"/>
    <role rolename="manager"/>
    <role rolename="manager-gui"/>
    <user username="tomcat" password="tomcat" roles="manager,manager-gui,manager-script,manager-jmx,manager-status"/>  
</tomcat-users>
```
**配置说明：**
manager-gui 
允许访问html接口(即URL路径为/manager/html/*)
manager-script
允许访问纯文本接口(即URL路径为/manager/text/*)
manager-jmx
允许访问JMX代理接口(即URL路径为/manager/jmxproxy/*)
manager-status
允许访问Tomcat只读状态页面(即URL路径为/manager/status/*)
从Tomcat Manager内部配置文件中可以得知，manager-gui、manager-script、manager-jmx均具备manager-status的权限，也就是说，manager-gui、manager-script、manager-jmx三种角色权限无需再额外添加manager-status权限，即可直接访问路径"/manager/status/*"。

**通过maven的部署插件和tomcat的热部署功能，可以方便快捷的将代码部署到研发和测试环境，并且减轻研发人员部署验证的工作，提高工作效率。**
