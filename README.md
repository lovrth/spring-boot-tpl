# tpl

> 一个基于Spring Boot & Mybatis-Plus & JWT 的模板项目

## 特性

[x️] spring boot的便捷开发模式    
[x️] 支持mybatis-plus一键生成controller,service,mapper,model          
[x️] 权限认证和授权，JWT令牌颁发  
[x️] mybatis-plus 逻辑删除、自定义分页（从0开始）   
[x️] 自定义方便的validator  
[x️] 统一异常处理，统一返回结果规范  
[x️] fastjson的消息转换，结果转换  
[x️] druid mysql 连接池  
[x️] 自定义logback配置    
[x️] 自定义banner   
[x️] 多环境配置文件    
[ ] and more ......   

## 目录结构

```bash
├── common  //基础类库
│   ├── exception  //异常相关
│   ├── interceptor  //拦截器
│   ├── mybatis  // mybatis相关
│   ├── result // 返回结果
│   ├── token  // 令牌
│   └── validator // 校验器
├── configure // 配置
│   ├── CommonConfig.java
│   └── WebConfig.java
└── v1 // v1 api 相关
    ├── controller
    ├── mapper
    ├── model
    └── service
        └── impl
```

## 使用

### 导入数据

数据库推荐使用`mysql`，如需使用其它数据库，请根据pom依赖和配置酌情更改，在mysql中新建 `tpl`数据库，
运行 `src/main/resources/tpl.sql` 数据脚本新建`user`表，方便 v1 测试。

### 运行

更改`application-dev.yml`的数据库配置，符合你使用的数据库。

直接运行 `TplApplication.java` 即可。