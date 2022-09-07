package net.biancheng.c.aop.aspectJ.annotation.dao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 基于 java 配置类启用 AspectJ 注解
@Configuration //表明这是一个 java 配置类
@ComponentScan(basePackages = "net.biancheng.c.aop.aspectJ.annotation") //注解扫描，basePackages 指定清楚，不然会有冲突
@EnableAspectJAutoProxy //开启 AspectJ 的自动代理
public class Appconfig {
}
