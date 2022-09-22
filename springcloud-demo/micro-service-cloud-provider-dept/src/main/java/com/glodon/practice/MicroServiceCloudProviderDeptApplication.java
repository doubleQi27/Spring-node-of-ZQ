package com.glodon.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient        // 允许本服务自动注册为 eureka 客户端
public class MicroServiceCloudProviderDeptApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCloudProviderDeptApplication.class, args);
    }

}
