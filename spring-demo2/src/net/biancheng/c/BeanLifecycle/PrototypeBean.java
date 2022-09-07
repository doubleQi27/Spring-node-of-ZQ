package net.biancheng.c.BeanLifecycle;

public class PrototypeBean {
    private String str;

    public PrototypeBean(String str){
        this.str = str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
