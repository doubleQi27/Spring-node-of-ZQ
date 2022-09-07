package net.biancheng.c.aop.aspectJ.annotation;

import net.biancheng.c.aop.aspectJ.annotation.dao.IUserDao;
import net.biancheng.c.aop.aspectJ.annotation.dao.config.Appconfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
        IUserDao userDao = context.getBean("userDao", IUserDao.class);
        userDao.add();
        userDao.modify();
        userDao.delete();
        userDao.get();
    }
}
