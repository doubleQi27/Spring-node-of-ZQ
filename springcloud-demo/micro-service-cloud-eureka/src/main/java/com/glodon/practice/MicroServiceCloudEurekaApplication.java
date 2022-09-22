package com.glodon.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer       // 开启 eureka 服务注册中心，接受微服务注册
public class MicroServiceCloudEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceCloudEurekaApplication.class, args);
    }
}
