#Spring Boot Junit单元测试
Junit这种老技术，现在又拿出来说，不为别的，某种程度上来说，更是为了要说明它在项目中的重要性。

那么先简单说一下为什么要写测试用例:

 1. 可以避免测试点的遗漏，为了更好的进行测试，可以提高测试效率
 2. 可以自动测试，可以在项目打包前进行测试校验
 3. 可以及时发现因为修改代码导致新的问题的出现，并及时解决

那么本文从以下几点来说明怎么使用Junit，Junit4比3要方便很多，细节大家可以自己了解下，主要就是版本4中对方法命名格式不再有要求，不再需要继承TestCase，一切都基于注解实现。
那么Spring Boot如何使用Junit呢？

1. 加入Maven的依赖；
2. 编写测试service;
3. 编写测试类;

1. 加入Maven的依赖:
```
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
</dependency>
```

2. 编写测试service:

新建HelloService 提供测试方法：

```
import org.springframework.stereotype.Service;

@Service
publicclass HelloService {

    public String getName(){
       return"hello";
    }
}
```

3). 编写测试类：

在src/test/java下编写测试类：

```
import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kfit.App;
import com.kfit.service.HelloService;

//// SpringJUnit支持，由此引入Spring-Test框架支持！
@RunWith(SpringJUnit4ClassRunner.class)

//// 指定我们SpringBoot工程的Application启动类
@SpringApplicationConfiguration(classes = App.class)

///由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
publicclass HelloServiceTest {

    @Resource
    private HelloService helloService;

    @Test
    publicvoid testGetName(){
       Assert.assertEquals("hello",helloService.getName());
    }
}
```
这时候就可以进行测试了，右键—Run As – Junit Test。

* * *

##Junit基本注解介绍
```
//在所有测试方法前执行一次，一般在其中写上整体初始化的代码
@BeforeClass

//在所有测试方法后执行一次，一般在其中写上销毁和释放资源的代码
@AfterClass

//在每个测试方法前执行，一般用来初始化方法（比如我们在测试别的方法时，类中与其他测试方法共享的值已经被改变，为了保证测试结果的有效性，我们会在@Before注解的方法中重置数据）
@Before


//在每个测试方法后执行，在方法执行完成后要做的事情
@After


// 测试方法执行超过1000毫秒后算超时，测试将失败
@Test(timeout = 1000)


// 测试方法期望得到的异常类，如果方法执行没有抛出指定的异常，则测试失败
@Test(expected = Exception.class)


// 执行测试时将忽略掉此方法，如果用于修饰类，则忽略整个类
@Ignore(“not ready yet”)


@Test


@RunWith
```
在JUnit中有很多个Runner，他们负责调用你的测试代码，每一个Runner都有各自的特殊功能，你要根据需要选择不同的Runner来运行你的测试代码。

如果我们只是简单的做普通Java测试，不涉及Spring Web项目，你可以省略@RunWith注解，这样系统会自动使用默认Runner来运行你的代码。
