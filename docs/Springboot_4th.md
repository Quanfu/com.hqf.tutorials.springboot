# Spring Boot热部署
在编写代码的时候，你会发现我们只是简单把打印信息改变了下，就需要重新部署，如果是这样的编码方式，那么我们估计一天下来之后就真的是打几个Hello World之后就下班了。那么如何解决热部署的问题呢？那就是 springloaded ，加入如下配置：

```
<plugin>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-maven-plugin </artifactId>
     <dependencies>
       <!--springloaded  hot deploy -->
       <dependency>
           <groupId>org.springframework</groupId>
           <artifactId>springloaded</artifactId>
           <version>1.2.4.RELEASE</version>
       </dependency>
    </dependencies>
    <executions>
       <execution>
           <goals>
               <goal>repackage</goal>
           </goals>
           <configuration>
               <classifier>exec</classifier>
           </configuration>
       </execution>
     </executions>
</plugin>

```

- 如果是使用`spring-boot:run `的话，那么到此配置结束，现在你就可以体验coding…coding的爽了。

- 如果使用的 run as – Java application的话，那么还需要做一些处理哦：

    把`spring-loader-1.2.4.RELEASE.jar`下载下来，放到项目的lib目录中，然后把IDEA的run参数里VM参数设置为：
    ```
    -javaagent:.\lib\springloaded-1.2.4.RELEASE.jar -noverify
    ```
   然后启动就可以了，这样在run as的时候，也能进行热部署了。

当然并不是所有的代码都支持热部署了，这个我自己也不是很明确，那些代码修改了可以直接不用重启查看。