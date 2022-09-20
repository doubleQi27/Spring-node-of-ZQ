package net.biancheng.c.annotationconfig.config;

import net.biancheng.c.annotationconfig.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

//创建一个配置类，代替 Spring 的配置文件，类似于在 xxx.xml 中配置一个 Bean
@Configuration
public class SpringConfig {
    //定义 User 类型的 Bean，交由 Spring 容器管理
    @Bean
    public User user(){                 // 方法名 = <bean> 标签中对应的 id 的值；返回值则对应 class 的值。
        User user = new User();
        user.setUserName("小明");
        user.setBirth(new Date());
        user.setHeight(180.0);
        return user;
    }
}
