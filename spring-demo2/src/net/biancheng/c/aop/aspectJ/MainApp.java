package net.biancheng.c.aop.aspectJ;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aspectJ.xml");
        IOrderDao orderDao = context.getBean("orderDao", IOrderDao.class);
        orderDao.add();
        orderDao.delete();
        orderDao.modify();
        orderDao.get();
    }
}
