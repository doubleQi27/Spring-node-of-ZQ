package net.biancheng.c.autowired;

import net.biancheng.c.autowired.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("autowired.xml");
        //Employee employee = context.getBean("employee", Employee.class);
        //System.out.println(employee.toString());
        //基于注解
        UserController userController = context.getBean("userController", UserController.class);
        userController.doStr();
    }
}
