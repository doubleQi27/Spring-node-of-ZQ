package net.biancheng.c.di.usual;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    private static final Log LOGGER = LogFactory.getLog(MainApp.class);

    public static void main(String[] args) {
        //获取 ApplicationContext 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        //获取名为 student 的 Bean
        Student student = context.getBean("student", Student.class);
        //获取 id 为 teacher 的 Bean
        //Teacher teacher = context.getBean("teacher", Teacher.class);
        Teacher teacher = (Teacher) context.getBean("teacher");
        //获取 id 为 employee 的 bean
        Employee employee = context.getBean("employee", Employee.class);
        //获取 id 为 tempEmployee 的 bean
        TempEmployee tempEmployee = (TempEmployee)context.getBean("tempEmployee");
        //通过日志打印学生信息
        LOGGER.info(student.toString());
        //控制台输出
        //System.out.println(student.toString());
        //System.out.println(teacher.toString());
        //System.out.println(employee.toString());
        //System.out.println(tempEmployee.toString());

        //获取bean
        Employee2 employee2 = context.getBean("employee2", Employee2.class);
        Employee3 employee3 = context.getBean("employee3", Employee3.class);
        System.out.println(employee2.toString());
        System.out.println(employee3.toString());
    }
}
