package com.glodon.practice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration    // 将类标记为配置类
public class ConfigBeans {

    @Bean    //将 RestTemplate 注入到容器中
    @LoadBalanced    //在客户端使用 RestTemplate 请求服务端时，开启负载均衡（Ribbon）
    public RestTemplate getRestTemplate() {    // 方法名 = <bean> id 属性值，返回值等于 <bean> class 属性值
        return new RestTemplate();
    }

}
