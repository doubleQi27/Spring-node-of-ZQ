package net.biancheng.c.BeanLifecycle.BeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class HelloWorldInit2 implements BeanPostProcessor, Ordered {

    //实例化、属性注入后，初始化前
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("AAA Before : " + beanName);
        return bean;
    }

    //实例化、属性注入后，初始化后
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("AAA After : " + beanName);
        return bean;
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
