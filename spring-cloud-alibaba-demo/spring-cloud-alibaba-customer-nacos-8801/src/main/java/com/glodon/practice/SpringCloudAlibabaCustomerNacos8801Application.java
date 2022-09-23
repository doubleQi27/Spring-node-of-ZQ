package com.glodon.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient     // 开启 Nacos 服务发现功能
public class SpringCloudAlibabaCustomerNacos8801Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAlibabaCustomerNacos8801Application.class, args);
    }
}
