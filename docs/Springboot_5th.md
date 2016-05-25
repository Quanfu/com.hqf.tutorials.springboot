#Spring boot 连接 MySQL

src/main/resouces/application.properties：

```
########################################################
###datasource
########################################################
spring.datasource.url = jdbc:mysql://localhost:3306/test
spring.datasource.username = root
spring.datasource.password = root
spring.datasource.driverClassName = com.mysql.jdbc.Driver
spring.datasource.max-active=20
spring.datasource.max-idle=8
spring.datasource.min-idle=8
spring.datasource.initial-size=10

```

pom.xml配置：

```
<dependency>
       <groupId>mysql</groupId>
       <artifactId>mysql-connector-Java</artifactId>
</dependency>

```

到此相关配置就ok了，那么就可以在项目中进行测试了，我们可以新建一个class Demo进行测试，实体类创建完毕之后，我们可能需要手动进行编写建表语句，这时候我们可能就会想起hibernate的好处了。那么怎么在spring boot使用Hibernate好的特性呢？So easy,具体怎么操作，请看下篇文章之JPA – Hibernate