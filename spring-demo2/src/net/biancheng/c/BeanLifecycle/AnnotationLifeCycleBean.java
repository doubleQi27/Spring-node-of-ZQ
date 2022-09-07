package net.biancheng.c.BeanLifecycle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 通过注解指定生命周期回调方法
 * 注意：代码无法运行，因为 @PostConstruct 和 @PreDestroy 已弃用
 */
public class AnnotationLifeCycleBean {
    private static final Log LOGGER = LogFactory.getLog(AnnotationLifeCycleBean.class);
    //网站名称
    private String webName;
    //网站地址
    private String url;

    public AnnotationLifeCycleBean(String webName, String url) {
        this.webName = webName;
        this.url = url;
    }

    @Override
    public String toString() {
        return "AnnotationLifeCycleBean{" +
                "webName='" + webName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    /**
     * 初始化回调方法
     */
    //@PostConstruct
    public void init() {
        LOGGER.info("通过 @PostConstruct 注解，指定初始化方法：init() 方法");
    }

    /**
     * 销毁回调方法
     */
    //@PreDestroy
    public void destroy() {
        LOGGER.info("通过 @PreDestroy 注解，指定初始化方法：destroy() 方法");
    }
}
