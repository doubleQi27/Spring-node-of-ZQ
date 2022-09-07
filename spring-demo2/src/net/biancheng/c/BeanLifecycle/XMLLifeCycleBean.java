package net.biancheng.c.BeanLifecycle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 通过 XML 配置指定生命周期回调方法
 * 可编写自定义操作逻辑
 */
public class XMLLifeCycleBean {

    private static final Log LOGGER = LogFactory.getLog(XMLLifeCycleBean.class);
    //网站名称
    private String webName;
    //网站地址
    private String url;

    public void setWebName(String webName) {
        this.webName = webName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "XMLLifeCycleBean{" +
                "webName='" + webName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    /**
     * 初始化回调方法
     */
    public void init() {
        LOGGER.info("在 XML 配置中通过 init-method 属性指定初始化方法：init() 方法");
        System.out.println("在 XML 配置中通过 init-method 属性指定初始化方法：init() 方法");
        System.out.println("赵琪的自定义逻辑！");
    }

    /**
     * 销毁回调方法
     * 可编写自定义操作逻辑
     */
    public void destroy() {
        LOGGER.info("在 XML 配置中通过 destroy-method 属性指定回调方法：destroy() 方法");
        System.out.println("在 XML 配置中通过 destroy-method 属性指定回调方法：destroy() 方法");
        System.out.println("赵琪自定义的小灰灰掉");
    }
}
