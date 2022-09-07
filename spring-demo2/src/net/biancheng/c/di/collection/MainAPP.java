package net.biancheng.c.di.collection;

import net.biancheng.c.di.usual.MainApp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAPP {

    private static final Log LOGGER = LogFactory.getLog(MainApp.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        JavaCollection jc = context.getBean("javaCollection", JavaCollection.class);
        //System.out.println(jc.toString());
        JavaCollection2 jc2 = context.getBean("javaCollection2", JavaCollection2.class);
        System.out.println(jc2.toString());
    }
}
