package com.glodon.practice;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient     // 开启 Nacos 服务发现功能
public class SpringCLoudAlibabaProvider8001Application {

    public static void main(String[] args) {
        // SpringBoot 把 main 函数也封装了，
        // 除了 args 参数外，还需要把启动类的 class 对象传给其内部封装的 main 函数。
        SpringApplication.run(SpringCLoudAlibabaProvider8001Application.class, args);
    }

}
