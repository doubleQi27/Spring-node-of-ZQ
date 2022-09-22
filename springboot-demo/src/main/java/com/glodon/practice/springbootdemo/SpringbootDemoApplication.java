package com.glodon.practice.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

// 可以集合的形式装配多个 Spring 配置文件
// locations = "{classpath:Beans.xml, classpath:Springbeans.xml,……}"
// @ImportResource(locations = "classpath:Beans.xml")

@SpringBootApplication
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

}
