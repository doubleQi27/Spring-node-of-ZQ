package net.biancheng.c.log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    private static final Logger log = LoggerFactory.getLogger(MainApp.class);
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("log4j-beans.xml");
        log.info("正在从容器中获取 HelloLog4j 的 Bean");
        HelloLog4j helloLog4j = context.getBean("helloLog4j", HelloLog4j.class);
        helloLog4j.getMessage();
        log.info("代码执行完成！");
    }
}
