package net.biancheng.c.BeanLifecycle.BeanPostProcessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);
        System.out.println(helloWorld.getMessage());
        context.registerShutdownHook();
    }
}
