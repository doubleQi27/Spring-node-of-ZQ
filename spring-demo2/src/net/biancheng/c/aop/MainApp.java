package net.biancheng.c.aop;

import net.biancheng.c.aop.dao.IOrderDao;
import net.biancheng.c.aop.dao.IUserDao;
import net.biancheng.c.aop.dao.impl.OrderDaoImpl;
import net.biancheng.c.aop.dao.impl.UserDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        //获取 ApplicationContext 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        //获取代理对象
        //IUserDao userDao = context.getBean("userDaoProxy", IUserDao.class);
        IUserDao userDao = context.getBean("userDao", IUserDao.class);
        //调用 UserDao 中的各个方法
        userDao.add();
        userDao.delete();
        userDao.get();
        userDao.modify();

        //获取的是代理对象
        IOrderDao orderDao = context.getBean("orderDao", IOrderDao.class);
        orderDao.add();
        orderDao.adds();
        orderDao.delete();
        orderDao.modify();
    }
}
