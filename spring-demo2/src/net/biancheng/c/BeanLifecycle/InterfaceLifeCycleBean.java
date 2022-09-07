package net.biancheng.c.BeanLifecycle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/***
 * 使用接口，实现初始化回调 和销毁回调
 */
public class InterfaceLifeCycleBean implements InitializingBean, DisposableBean {

    private static final Log LOGGER = LogFactory.getLog(InterfaceLifeCycleBean.class);

    //网站名称
    private String webName;
    //网站地址
    private String url;

    public InterfaceLifeCycleBean(String webName, String url){
        this.webName = webName;
        this.url = url;
    }

    public void setWebName(String webName) {
        this.webName = webName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "LifeCycleBean{" +
                "webName='" + webName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    /**
     * 初始化回调逻辑
     *可编写自定义操作逻辑
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info(" 调用接口：InitializingBean，方法：afterPropertiesSet，无参数");
        System.out.println(" 调用接口：InitializingBean，方法：afterPropertiesSet，无参数");
    }

    /**
     * 销毁回调逻辑
     * 可编写自定义操作逻辑
     *
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        LOGGER.info(" 调用接口：DisposableBean，方法：destroy，无参数");
        System.out.println(" 调用接口：DisposableBean，方法：destroy，无参数");
    }
}
