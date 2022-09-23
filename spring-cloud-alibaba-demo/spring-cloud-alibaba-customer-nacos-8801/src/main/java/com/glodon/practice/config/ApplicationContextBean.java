package com.glodon.practice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration   // 标记为配置类
public class ApplicationContextBean {

    @Bean     // 标记为容器中的 Bean。方法名对应 <bean> id，返回值对应 class
    @LoadBalanced    // 开启负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
