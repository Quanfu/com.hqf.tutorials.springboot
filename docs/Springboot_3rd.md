#Spring boot 返回Json

我们在编写接口的时候，时常会有需求返回json数据，那么在spring boot应该怎么操作呢？主要是在class中加入注解@RestController,。

返回JSON之步骤：

   (1)编写一个实体类Demo

   (2)编写DemoController；

   (3)在DemoController加上`@RestController`和`@RequestMapping`注解；

   (4)测试

那么在浏览器访问地址： http://127.0.0.1:9090/demo/Demos 返回如下数据：

```
{
    id: 1,
    name: "Angel"
}
```

   其实Spring Boot也是引用了JSON解析包Jackson，那么自然我们就可以在Demo对象上使用Jackson提供的json属性的注解，对时间进行格式化，对一些字段进行忽略等等。