package com.glodon.practice.springbootdemo.springconfig.configuration;

import com.glodon.practice.springbootdemo.springconfig.service.IPersonService;
import com.glodon.practice.springbootdemo.springconfig.service.impl.PersonServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Configuration 注解用于定义一个配置类，相当于 Spring 的配置文件
 * 配置类中包含一个或多个被 @Bean 注解的方法，该方法相当于 Spring 配置文件中的 <bean> 标签定义的组件。
 * 可以有多个 @Bean 方法从而配置多个 bean
 */
@Configuration
public class MyConfig {
    /**
     * 与 <bean id="personService" class="PersonServiceImpl"></bean> 等价
     * 该方法返回值以组件的形式添加到容器中
     * 方法名是组件 id（相当于 <bean> 标签的属性 id)
     * 返回值相当于组件类路径 class
     */
    @Bean
    public IPersonService personService() {
        System.out.println("在容器中添加了一个组件:peronService");
        return new PersonServiceImpl();
    }
}
