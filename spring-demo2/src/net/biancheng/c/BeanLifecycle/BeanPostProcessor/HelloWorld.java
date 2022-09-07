package net.biancheng.c.BeanLifecycle.BeanPostProcessor;

public class HelloWorld {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 自定义初始化回调方法
     */
    public void init() {
        System.out.println("Bean 正在初始化");
    }

    /**
     * 自定义销毁回调方法
     */
    public void destroy() {
        System.out.println("Bean 将要被销毁");
    }
}
