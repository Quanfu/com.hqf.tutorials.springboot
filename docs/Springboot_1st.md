##1.1 介绍

自从 structs2 出现上次的漏洞以后，对spring的关注度开始越来越浓。

以前spring开发需要配置一大堆的xml,后台spring加入了 annotaion ，使得xml配置简化了很多，当然还是有些配置需要使用xml,比如申明component scan等。

前段时间发现了spring开了一个新的 model spring boot,主要思想是降低spring的入门，使得新手可以以最快的速度让程序在spring框架下跑起来。

##1.2 Hello之New

 这个步骤很简单，相比大家都会，小编在此为了文档的完整性，稍作简单说明：

首先使用IDE（Eclipse,MyEclipse）工具新建一个Maven工程，可以是Maven Java Project,也可以是Maven Web Project,随便取一个工程名称。我使用的是MyEclipse，工程名是spring-boot-hello1。



##1.3 Hello之Maven

 第二步，在pom.xml中引入spring-boot-start-parent,spring官方的解释叫什么stater poms,它可以提供dependency management,也就是说依赖管理，引入以后在申明其它dependency的时候就不需要version了，后面可以看到。
```
<parent>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-parent</artifactId>
<version>1.3.3.RELEASE</version>
</parent>
```




##1.4 Hello之maven web

 第三步，因为我们开发的是web工程，所以需要在pom.xml中引入spring-boot-starter-web,spring官方解释说spring-boot-start-web包含了spring webmvc和tomcat等web开发的特性。
```
<dependencies>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
</dependencies>
```

##1.5 Hello之Maven Run Application

 如果我们要直接Main启动spring，那么以下plugin必须要添加，否则是无法启动的。如果使用maven 的spring-boot:run的话是不需要此配置的。（我在测试的时候，如果不配置下面的plugin也是直接在Main中运行的。）
```
<build>
<plugins>
     <plugin>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-maven-plugin </artifactId>
    </plugin>
</plugins>
</build>
```

1.6 Hello之coding

 第四步，真正的程序开始啦，我们需要一个启动类，然后在启动类申明让spring boot自动给我们配置spring需要的配置，比如：@SpringBootApplication,为了可以尽快让程序跑起来，我们简单写一个通过浏览器访问hello world字样的例子：

```
@RestController
@SpringBootApplication
publicclassApp {

@RequestMapping("/")
public String hello(){
return"Hello world!";
}

publicstaticvoid main(String[] args) {
SpringApplication.run(App.class, args);
}
}
```
> 其中@SpringBootApplication申明让spring boot自动给程序进行必要的配置，等价于以默认属性使用@Configuration，@EnableAutoConfiguration和@ComponentScan

>@RestController返回json字符串的数据，直接可以编写RESTFul的接口；



##1.7 Hello之Run

第五步，就是运行我们的Application了，我们先介绍第一种运行方式。

- 第一种方式特别简单：右键 Run As -> Java Application。之后打开浏览器输入地址：http://127.0.0.1:8080/ 就可以看到Hello world!了。
- 第二种方式右键 project – Run as – Maven build – 在Goals里输入`spring-boot:run` ,然后 Apply,最后点击 Run。



##1.8 Hello之Error

 顺利的情况下当然是皆大欢喜了，但是程序吧往往会给你开个小玩笑。那么我们要注意什么呢？主要是jdk的版本之类的，请看官方说明：
