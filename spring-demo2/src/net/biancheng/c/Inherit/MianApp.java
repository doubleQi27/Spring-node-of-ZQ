package net.biancheng.c.Inherit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MianApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Inherit.xml");
        //Dog dog = context.getBean("dog", Dog.class);
        //System.out.println(dog.toString());

        // 抽象类不能根据 id getBean()，会报错
        //Tree tree = context.getBean("tree", Tree.class);
        AppleTree appleTree = context.getBean("appleTree", AppleTree.class);
        System.out.println(appleTree.toString());
    }
}
