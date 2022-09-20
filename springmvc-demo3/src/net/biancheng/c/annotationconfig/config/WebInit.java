package net.biancheng.c.annotationconfig.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.Filter;


//继承 AbstractAnnotationConfigDispatcherServletInitializer 类的初始化类，代替 web.xml
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    //设置 Spring 的配置类
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }
    //设置 Spring MVC 的配置类
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }
    //为 DispatcherServlet 指定映射规则，相当于 web.xml 中配置的 url-pattern
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    //添加过滤器
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceResponseEncoding(true);
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        return new Filter[]{characterEncodingFilter, hiddenHttpMethodFilter};
    }
}
