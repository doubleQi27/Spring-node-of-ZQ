package net.biancheng.c.BeanLifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mianApp {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        // singleton
        //建立第一个 SingletonBean Bean
        SingletonBean singletonBean1 = context.getBean("singletonBean", SingletonBean.class);
        //建立第二个 SingletonBean Bean
        SingletonBean singletonBean2 = context.getBean("singletonBean", SingletonBean.class);
        //两个 Bean 的 toString 方法返回了相同的 hashCode
        // net.biancheng.c.BeanLifecycle.SingletonBean@55fe41ea
        System.out.println(singletonBean1.toString());
        System.out.println(singletonBean2.toString());
        // == 运算符下返回值为 true，说明两个对象对应内存中同一块地址
        System.out.println(singletonBean1 == singletonBean2);

        // prototype
        PrototypeBean prototypeBean1 = context.getBean("protoTypeBean", PrototypeBean.class);
        PrototypeBean prototypeBean2 = context.getBean("protoTypeBean", PrototypeBean.class);
        PrototypeBean prototypeBean3 = context.getBean("protoTypeBean", PrototypeBean.class);
        // 三个 Bean 的 HashCode 不一样
        // == 返回 false
        // 但注入的属性值是一样的
        System.out.println(prototypeBean1.toString());
        System.out.println(prototypeBean2.toString());
        System.out.println(prototypeBean3.toString());
        System.out.println(prototypeBean1 == prototypeBean2);
        System.out.println(prototypeBean1 == prototypeBean3);
        System.out.println(prototypeBean2 == prototypeBean3);
        System.out.println(prototypeBean1.getStr());
        System.out.println(prototypeBean2.getStr());
        System.out.println(prototypeBean3.getStr());

        // 接口实现方式的 初始化调用 和 销毁调用
        InterfaceLifeCycleBean interfaceLifeCycleBean = context.getBean("interfaceLifeCycleBean", InterfaceLifeCycleBean.class);
        interfaceLifeCycleBean.afterPropertiesSet();
        interfaceLifeCycleBean.destroy();

        // XML配置实现
        XMLLifeCycleBean xmlLifeCycleBean = context.getBean("xmlLifeCycleBean", XMLLifeCycleBean.class);
    }
}
