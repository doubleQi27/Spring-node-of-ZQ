package net.biancheng.other;


public class SpecialValue {
    //设置空值 null
    private String  propertyNull;
    //注入空字符串
    private  String propertyEmpty;
    //注入特殊字符：<、>、&、"、'
    private String propertySpecial1;
    private String propertySpecial2;
    private String propertySpecial3;
    //级联属性赋值演示（可以理解为内部类的另一种属性注入方法）
    private DependBean dependBean;


    public SpecialValue(){

    }

    public String getPropertyNull() {
        return propertyNull;
    }

    public void setPropertyNull(String propertyNull) {
        this.propertyNull = propertyNull;
    }

    public String getPropertyEmpty() {
        return propertyEmpty;
    }

    public String getPropertySpecial1() {
        return propertySpecial1;
    }

    public void setPropertySpecial1(String propertySpecial1) {
        this.propertySpecial1 = propertySpecial1;
    }

    public void setPropertyEmpty(String propertyEmpty) {
        this.propertyEmpty = propertyEmpty;
    }

    public String getPropertySpecial2() {
        return propertySpecial2;
    }

    public void setPropertySpecial2(String propertySpecial2) {
        this.propertySpecial2 = propertySpecial2;
    }

    public String getPropertySpecial3() {
        return propertySpecial3;
    }

    public void setPropertySpecial3(String propertySpecial3) {
        this.propertySpecial3 = propertySpecial3;
    }

    public DependBean getDependBean() {
        return dependBean;
    }

    public void setDependBean(DependBean dependBean) {
        this.dependBean = dependBean;
    }

    @Override
    public String toString() {
        return "SpecialValue{" +
                "propertyNull=" + propertyNull +
                "propertyEmpty='" + propertyEmpty +
                "propertySpecial1='" + propertySpecial1 +
                "propertySpecial2='" + propertySpecial2 +
                "propertySpecial3='" + propertySpecial3 +
                "dependBean" + dependBean + '\'' +
                '}';
    }
}
