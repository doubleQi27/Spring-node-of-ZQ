package net.biancheng.c.BeanLifecycle.BeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;


public class HelloWorldInit implements BeanPostProcessor, Ordered {

    //实例化、属性注入后，初始化前
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("AA Before : " + beanName);
        return bean;
    }

    //实例化、属性注入后，初始化后
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("AA After : " + beanName);
        return bean;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
