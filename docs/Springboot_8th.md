#Spring Boot 监控和管理生产环境
`spring-boot-actuator`模块提供了一个监控和管理生产环境的模块，可以使用http、jmx、ssh、telnet等拉管理和监控应用。审计（Auditing）、健康（health）、数据采集（metrics gathering）会自动加入到应用里面。

首先，写一个最基本的spring boot项目。
基于Maven的项目添加‘starter’依赖：
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

以下是所有监控描述：

|HTTP方法|路径|描述|鉴权|
|---|---|---|---|
|GET|/autoconfig|查看自动配置的使用情况，该报告展示所有auto-configuration候选者及它们被应用或未被应用的原因|true|
|GET|/configprops|显示一个所有@ConfigurationProperties的整理列表|true|
|GET|/beans|显示一个应用中所有Spring Beans的完整列表|true|
|GET |/dump |打印线程栈 |true|
|GET |/env |查看所有环境变量 |true|
|GET |/env/{name} |查看具体变量值 |true|
|GET| /health |查看应用健康指标 |false|
|GET |/info |查看应用信息 |false|
|GET |/mappings |查看所有url映射 |true|
|GET |/metrics |查看应用基本指标 |true|
|GET |/metrics/{name} |查看具体指标 |true|
|POST |/shutdown |允许应用以优雅的方式关闭（默认情况下不启用） |true|
|GET |/trace |查看基本追踪信息 |true|


###health
比如：http://localhost:8080/health
你可以得到结果
```
{
    status: "UP",
    diskSpace: {
                status: "UP",
                total: 107374174208,
                free: 14877962240,
                threshold: 10485760
                }
}
```

可以检查的其他一些情况的健康信息。下面的HealthIndicators会被Spring Boot自动配置：

DiskSpaceHealthIndicator     低磁盘空间检测
DataSourceHealthIndicator  检查是否能从DataSource获取连接
MongoHealthIndicator   检查一个Mongo数据库是否可用（up）
RabbitHealthIndicator   检查一个Rabbit服务器是否可用（up）
RedisHealthIndicator      检查一个Redis服务器是否可用（up）
SolrHealthIndicator  检查一个Solr服务器是否可用（up）



自定义当然也可以，你可以注册实现了HealthIndicator接口的Spring beans，Health响应需要包含一个status和可选的用于展示的详情。
```
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealth implements HealthIndicator {

    @Override
    public Health health() {
        int errorCode = check(); // perform some specific health check
        if (errorCode != 0) {
        return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }
}
```

##trace
访问http://localhost:8080/trace 可以看到结果，默认为最新的一些HTTP请求


##info
当执行 http://localhost:8080/info  的时候，结果什么没有
但是，在application.properties加入一些配置
```
info.app.name=ecs
info.app.version=1.0.0

info.build.artifactId=@project.artifactId@
info.build.version=@project.version@
```
执行/info就可以看到有些信息了。

/info 是用来在构建的时候，自动扩展属性的。对于Maven项目，可以通过 `@..@ `占位符引用 Maven 的’project properties’。

更多的细节和探索，需要自己看看源码和spring boot的官方文档。

