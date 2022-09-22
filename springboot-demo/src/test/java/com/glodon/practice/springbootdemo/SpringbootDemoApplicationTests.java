package com.glodon.practice.springbootdemo;

import com.glodon.practice.springbootdemo.hello.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest     // 测试类
class SpringbootDemoApplicationTests {

    @Autowired
    Person person;
    //IOC 容器
    @Autowired
    ApplicationContext ioc;

    @Test      // junit 单元测试
    public void testHelloService() {
        //校验 IOC 容器中是否包含组件 personService
        boolean b = ioc.containsBean("personService");
        if (b) {
            System.out.println("personService 已经添加到 IOC 容器中");
        } else {
            System.out.println("personService 没添加到 IOC 容器中");
        }
    }

    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
