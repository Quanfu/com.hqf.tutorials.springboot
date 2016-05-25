#Spring boot JPA - Hibernate
在说具体如何在spring boot 使用hibernate前，先抛装引玉些知识点？什么是JPA呢？

JPA全称 `Java Persistence API`. JPA通过 JDK 5.0 注解或XML描述对象－关系表的映射关系，并将运行期的实体对象持久化到数据库中。

接下里就说本文章重点了，那么怎么操作呢？

首先需要如下配置

pom.xml配置：

```
<dependency>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

```
>如果没有导入该包会报错 `spring.jpa.hibernate.naming-strategy = org.hibernate.cfg.ImprovedNamingStrategy`,另外就是注解也不能自动导入。

application.properties配置：
```
########################################################
### Java Persistence Api
########################################################
# Specify the DBMS
spring.jpa.database = MySQL
# Show or not log for each sql query
spring.jpa.show-sql = true
# Hibernate ddl auto (create, create-drop, update)
spring.jpa.hibernate.ddl-auto = update
# Naming strategy
spring.jpa.hibernate.naming-strategy = org.hibernate.cfg.ImprovedNamingStrategy
# stripped before adding them to the entity manager)
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect

```

那么就可以使用Hibernate带来的好处了，在实体类注解@Entity就会自动进行表的DDL操作了。

我们在Demo 实体 中加入注解：`@Entity`

```
@Entity//加入这个注解，Demo就会进行持久化了，在这里没有对@Table进行配置，请自行配置。
publicclass Demo {
    @Id @GeneratedValue
    private long id;//主键.
    private String name;//测试名称.

//其它代码省略.

```

这时候运行就会在数据库看到demo表了。