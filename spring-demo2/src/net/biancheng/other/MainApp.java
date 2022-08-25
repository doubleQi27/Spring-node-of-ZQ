package net.biancheng.other;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        SpecialValue sv = context.getBean("specialValue", SpecialValue.class);
        //输出
        System.out.println(sv.toString());
    }
}
